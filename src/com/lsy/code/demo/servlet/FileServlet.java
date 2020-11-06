package com.lsy.code.demo.servlet;

import com.lsy.code.demo.utils.BaseMessage;
import com.lsy.code.demo.utils.MessageHandler;
import com.lsy.code.servlet.BaseServlet;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.List;

/**文件 */
@SuppressWarnings("serial")
public class FileServlet extends BaseServlet {

	/**
	 * 	下载文件到浏览器上
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void downFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = request.getParameter("filename");
		// 1. 设置Content-Type头
		response.setHeader("Content-Type", this.getServletContext().getMimeType(filename));

		// 2. 设置Content-Disposition
		// 根据浏览器的类型处理中文文件的乱码问题:
		String agent = request.getHeader("User-Agent");
		if (agent.contains("Firefox")) {
			filename = base64EncodeFileName(filename);
		} else {
			filename = URLEncoder.encode(filename, "UTF-8");
		}
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);

		// 3、设置文件输入流
		String realPath = this.getServletContext().getRealPath("/file/" + filename);
		InputStream is = new FileInputStream(realPath);

		// 4、向页面响应
		ServletOutputStream os = response.getOutputStream();
		int len = -1;
		byte[] b = new byte[1024];
		while ((len = is.read(b)) != -1) {
			os.write(b, 0, len);
		}
		is.close();
	}

	/**
	 * 上传文件到指定目录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void uploadFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path ="/home/smates";
		// 生成工厂
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// 设置缓存路径
		diskFileItemFactory.setRepository(new File("F:/Demo/file/temp/"));
		// 设置大小限制，即上传的文件大于多少的时候需要缓存
		diskFileItemFactory.setSizeThreshold(1024 * 1024 * 3);
		if (ServletFileUpload.isMultipartContent(request)) {// 检查表单enctype="multipart/form-data"
			// 创建解析类
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
			// 限制上传的文件大小
			fileUpload.setSizeMax(1024 * 1024 * 1024 * 10);
			try {
				// 解析request，得到表单项对象的集合
				List<FileItem> list = fileUpload.parseRequest(request);
				for (FileItem fileItem : list) {
					if (!fileItem.isFormField()) {// 是文件表单项
						// 获取文件名
						String fileName = fileItem.getName();
						// 文件流
						InputStream is = fileItem.getInputStream();
						path += request.getContextPath()+"/demo/upload_file";
						File destFile = new File(path);
						destFile.mkdirs();
						File file = new File(destFile, fileName);
						// 输出流
						OutputStream os = new FileOutputStream(file);
						// 使用Apache commons的工具commons-io-1.4.jar
						IOUtils.copy(is, os);
						os.close();
						is.close();
						//删除FileItemd的主体内容，删除临时文件
						fileItem.delete();

						JSONObject jsonObject = JSONObject.fromObject(MessageHandler.createMsgSuccess("文件上传成功",path+"/"+fileName));
						response.getWriter().print(jsonObject);
						return;
					}
//        			else {
//        				System.out.println(fileItem.getString());
//					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
				BaseMessage<?> message = MessageHandler.createMsgFailure(e.getMessage());
				JSONObject jsonObject = JSONObject.fromObject(message);
				response.getWriter().print(jsonObject);				
				return;
			}
		}else {
			BaseMessage<?> message = MessageHandler.createMsgFailure("表单未正确设置enctype");
			JSONObject jonObject = JSONObject.fromObject(message);
			response.getWriter().print(jonObject);
			return;
		}

	}

	public static String base64EncodeFileName(String fileName) {
		try {
			return "=?UTF-8?B?" + Base64.getEncoder().encodeToString(fileName.getBytes("UTF-8")) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
