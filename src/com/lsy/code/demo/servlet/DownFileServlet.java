package com.lsy.code.demo.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

@SuppressWarnings("serial")
public class DownFileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filename = req.getParameter("filename");
		//1. 设置Content-Type头
		resp.setHeader("Content-Type", this.getServletContext().getMimeType(filename));
		
		//2. 设置Content-Disposition
        //根据浏览器的类型处理中文文件的乱码问题:
        String agent = req.getHeader("User-Agent");
        if (agent.contains("Firefox")) {
              filename = base64EncodeFileName(filename);
        } else {
              filename = URLEncoder.encode(filename, "UTF-8");
        }
		resp.setHeader("Content-Disposition", "attachment;filename=" + filename);
		
		//3、设置文件输入流
		String realPath = this.getServletContext().getRealPath("/file/"+filename);
		InputStream is=new FileInputStream(realPath);
		
		//4、向页面响应
		ServletOutputStream os = resp.getOutputStream();
		int len=-1;
		byte[] b=new byte[1024];
		while ((len=is.read(b))!=-1) {
			os.write(b,0,len);
		}
		is.close();
	}
	
	
	public static String base64EncodeFileName(String fileName) {
		Base64 base64Encoder = new Base64();
		try {
            return "=?UTF-8?B?"
                    + new String(base64Encoder.encode(fileName
                            .getBytes("UTF-8"))) + "?=";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
