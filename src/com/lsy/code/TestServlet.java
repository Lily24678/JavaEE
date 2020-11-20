package com.lsy.code;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
@WebServlet(urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getHeader("Content-Type"));
        Part part = req.getPart("uploadFile");
        part.getInputStream();
        System.out.println(part.getHeaders("Content-Disposition"));

        Part ee = req.getPart("ee");
        System.out.println(ee.getHeaders("Content-Disposition"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
