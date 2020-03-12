package com.lsy.code.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsy.code.demo.domain.User;
import com.lsy.code.demo.utils.BaseMessage;
import com.lsy.code.demo.utils.CreateDataUtils;
import com.lsy.code.demo.utils.MessageHandler;
import com.lsy.code.demo.utils.ServletUtils;
import com.lsy.code.demo.utils.StringUtils;
import com.lsy.code.servlet.BaseServlet;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class UserServlet extends BaseServlet {

	public String regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");// 响应字符流乱码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<User> list = CreateDataUtils.getRegistedUsers();
		list.add(new User(username, password));
		//清空登录信息
		Cookie cookie = ServletUtils.getCookie("username", request);
		ServletUtils.removeCookie(cookie, request, response);
		return "/login.html";
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "/index.html";
	}

	/**
	 * 登录校验
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void checkUserLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String autologin = request.getParameter("autologin");
		String persis = request.getParameter("persis");

		BaseMessage<?> massage = MessageHandler.createMsgSuccess("登录成功");
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			massage = MessageHandler.createMsgFailure("用户名、登录密码不可为空");
		} else if (CreateDataUtils.isExist(username, password) == 0) {
			massage = MessageHandler.createMsgFailure("用户名或者登录密码错误");
		} else {
			ServletUtils.addCookie("username", username, request,response);
			if (StringUtils.isNotBlank(persis))
				ServletUtils.addCookie("username", username + "-" + password, request,response);
			if (StringUtils.isNotBlank(autologin))
				ServletUtils.addCookie("username", username + "-" + password + "-" + autologin, request,response);
		}
		// 转换成JSON字符串
		JSONObject jsonObject = JSONObject.fromObject(massage);
		response.getWriter().print(jsonObject.toString());
	}

	/**
	 * 登录用户名校验
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void checkNameLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		BaseMessage<?> massage = MessageHandler.createMsgSuccess("用户名正确");
		if (CreateDataUtils.isExist(username) == 0)
			massage = MessageHandler.createMsgFailure("用户名不正确");
		// 转换成JSON字符串
		JSONObject jsonObject = JSONObject.fromObject(massage);
		response.getWriter().print(jsonObject.toString());
	}

	/**
	 * 注册用户名校验
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void checkNameRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		BaseMessage<?> massage = MessageHandler.createMsgSuccess("用户名正确");
		if (CreateDataUtils.isExist(username) == 1)
			massage = MessageHandler.createMsgFailure("用户名已经存在");
		// 转换成JSON字符串
		JSONObject jsonObject = JSONObject.fromObject(massage);
		response.getWriter().print(jsonObject.toString());
	}

}
