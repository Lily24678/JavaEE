package com.lsy.code.demo.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsy.code.demo.utils.BaseMassage;
import com.lsy.code.demo.utils.MassageHandler;
import com.lsy.code.demo.utils.StringUtils;
import com.lsy.code.servlet.BaseServlet;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class UserServlet extends BaseServlet {
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");//响应字符流乱码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (StringUtils.isBlank(username)||StringUtils.isBlank(password)) {
			response.getWriter().write("用户名、登录密码不可为空");
		}else if(!"username".equals(username)&&!"password".equals(password)) {
			response.getWriter().write("用户名或者登录密码错误");
		}else {
			response.sendRedirect("/JavaEE/file.html");//重定向
			//req.getRequestDispatcher("/file.html").forward(req, resp);//转发
		}		
	}

	public void checkName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");//响应字符流乱码
		String username = request.getParameter("username");
		BaseMassage<?> massage = MassageHandler.createMsgSuccess("用户名正确");
		if(!"username".equals(username))massage = MassageHandler.createMsgFailure("用户名不正确");
		
		//转换成JSON字符串
		JSONObject jsonObject = JSONObject.fromObject(massage);
		response.getWriter().print(jsonObject.toString());	
	}

}
