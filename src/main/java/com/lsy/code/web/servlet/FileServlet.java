package com.lsy.code.web.servlet;

import com.lsy.code.utils.FIleUtils;
import com.lsy.code.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.net.URLEncoder;
import java.util.Base64;

@MultipartConfig
public class FileServlet extends HttpServlet {
    /**
     * upload file
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(header.indexOf("filename=\"") + 10, header.length() - 1);
        if (StringUtils.isBlank(filename))return;
        String toFilename = StringUtils.createStrByUUID() + StringUtils.string2HexString(filename);
        part.write(FIleUtils.uploadfileDir + toFilename);
        resp.getWriter().print(toFilename);
    }

    /**
     * download file
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        System.out.println(filename);
        FileInputStream is = new FileInputStream(FIleUtils.downloadfileDir + filename);
        ServletOutputStream os = resp.getOutputStream();
        // 根据浏览器的类型处理中文文件的乱码问题:
        String agent = req.getHeader("User-Agent");

        if (agent.contains("Firefox")) {
            filename = base64EncodeFileName(filename);
        } else {
            filename = URLEncoder.encode(filename, "UTF-8");
        }
        resp.setHeader("Content-Disposition", "attachment;filename=" + filename);
        int len;
        while ((len=is.read())!=-1){
            os.write(len);
        }
        os.close();
        is.close();
    }

    private static String base64EncodeFileName(String fileName) {
        try {
            return "=?UTF-8?B?" + Base64.getEncoder().encodeToString(fileName.getBytes("UTF-8")) + "?=";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
