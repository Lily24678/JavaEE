package com.lsy.code.demo.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.lsy.code.demo.utils.StringUtils;

public class LoginServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");//响应字符流乱码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (StringUtils.isBlank(username)||StringUtils.isBlank(password)) {
			res.getWriter().write("用户名、登录密码不可为空");
		}else if(!"username".equals(username)&&!"password".equals(password)) {
			res.getWriter().write("用户名或者登录密码错误");
		}else {
			res.getWriter().write("登录成功");
		}
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
