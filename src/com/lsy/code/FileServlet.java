package com.lsy.code;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Servlet3.0注解开：发文件上传 
 */
@WebServlet(urlPatterns = {"/file"})
@MultipartConfig
public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求体中指定的的Part对象，在有@MultipartConfig时有效
        Part part = req.getPart("uploadFile");
        String header = part.getHeader("Content-Disposition");
        String fileName = header.substring(header.indexOf("filename=\"")+10,header.length()-1);
        String outDir = req.getServletContext().getRealPath("/upload");//文件上传到tomcat中的位置
        FileOutputStream os = new FileOutputStream(outDir+"/"+fileName);
        InputStream is = part.getInputStream();
        //读写字节流
        int len;
        while ((len=is.read())!=-1){
            os.write(len);
        }
        os.close();
        is.close();
        System.out.println("通过抓包分析,Content-Disposition值是:"+header+"\n客户端上传的文件名是："+fileName+"\n文件的输出目录是：outDir");
    }
}
