package com.lsy.code.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsy.code.demo.utils.BaseMassage;
import com.lsy.code.demo.utils.MassageHandler;
import com.lsy.code.demo.utils.StringUtils;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");//响应字符流乱码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (StringUtils.isBlank(username)||StringUtils.isBlank(password)) {
			resp.getWriter().write("用户名、登录密码不可为空");
		}else if(!"username".equals(username)&&!"password".equals(password)) {
			resp.getWriter().write("用户名或者登录密码错误");
		}else {
			resp.sendRedirect("/JavaEE/file.html");//重定向
			//req.getRequestDispatcher("/file.html").forward(req, resp);//转发
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");//响应字符流乱码
		String username = req.getParameter("username");
		BaseMassage<?> massage = MassageHandler.createMsgFailure("用户名不正确");
		//转换成JSON字符串
		JSONObject jsonObject = JSONObject.fromObject(massage);
		XMLSerializer xmlSerializer = new XMLSerializer();
		String xml = xmlSerializer.write(jsonObject);
		if(!"username".equals(username))resp.getWriter().print(xml);
		
	}

}
