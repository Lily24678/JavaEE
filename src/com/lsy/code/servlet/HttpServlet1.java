package com.lsy.code.servlet;

import com.lsy.code.listener.Bean1;
import com.lsy.code.listener.Bean2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/servlet2"})
public class HttpServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Bean1 bean1 = new Bean1();
		bean1.setName("bean1");
		session.setAttribute("bean1", bean1);
		
		Bean2 bean2 = (Bean2) session.getAttribute("bean2");//反序列化到内存
		System.out.println(bean2.getName());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Bean2 bean2 = new Bean2();
		bean2.setName("bean2");
		session.setAttribute("bean2", bean2);
		session.invalidate();
	}
}
