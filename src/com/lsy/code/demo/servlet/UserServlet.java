package com.lsy.code.demo.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsy.code.demo.utils.BaseMassage;
import com.lsy.code.demo.utils.CreateDataUtils;
import com.lsy.code.demo.utils.MassageHandler;
import com.lsy.code.demo.utils.StringUtils;
import com.lsy.code.servlet.BaseServlet;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class UserServlet extends BaseServlet {
	
	public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BaseMassage<?> massage = MassageHandler.createMsgSuccess("注册成功");
		if(CreateDataUtils.isExist(username)==1) {
			massage = MassageHandler.createMsgFailure("用户名已经存在");
			//转换成JSON字符串
			JSONObject jsonObject = JSONObject.fromObject(massage);
			response.getWriter().print(jsonObject.toString());
//			return "";
		}
		
//		return "/index.html";
	}
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @throws IOException
	 */
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

	/**
	 * 登录用户名校验
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void checkNameLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");//响应字符流乱码
		String username = request.getParameter("username");
		BaseMassage<?> massage = MassageHandler.createMsgSuccess("用户名正确");
		if(!"username".equals(username))massage = MassageHandler.createMsgFailure("用户名不正确");
		
		//转换成JSON字符串
		JSONObject jsonObject = JSONObject.fromObject(massage);
		response.getWriter().print(jsonObject.toString());	
	}
	/**
	 * 注册用户名校验
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void checkNameRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");//响应字符流乱码
		String username = request.getParameter("username");
		BaseMassage<?> massage = MassageHandler.createMsgSuccess("用户名正确");
		if(CreateDataUtils.isExist(username)==1)massage = MassageHandler.createMsgFailure("用户名已经存在");
		//转换成JSON字符串
		JSONObject jsonObject = JSONObject.fromObject(massage);
		response.getWriter().print(jsonObject.toString());	
	}

}
