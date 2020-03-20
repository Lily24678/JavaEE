package com.lsy.code.demo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lsy.code.database.DBCPUtils;
import com.lsy.code.demo.domain.User;
import com.lsy.code.demo.utils.BaseMessage;
import com.lsy.code.demo.utils.MessageHandler;
import com.lsy.code.demo.utils.ServletUtils;
import com.lsy.code.demo.utils.StringUtils;
import com.lsy.code.servlet.BaseServlet;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class UserServlet extends BaseServlet {

	public String regist(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		response.setContentType("text/html;charset=UTF-8");// 响应字符流乱码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//新增一条记录到用户表中
		Connection connection = DBCPUtils.getConnection();
		QueryRunner q = new QueryRunner();
		String sql = "insert into user(uid,username,password) values(?,?,?)";
		q.insert(sql, new BeanHandler<User>(User.class),UUID.randomUUID().toString().replaceAll("-", ""), username,password);
		connection.close();
		//清空登录信息
		Cookie cookie = ServletUtils.getCookie("username", request);
		ServletUtils.removeCookie(cookie, request, response);
		return "/demo/login.html";
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "/demo/index.html";
	}

	/**
	 * 登录校验
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws SQLException 
	 */
	public void checkUserLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String autologin = request.getParameter("autologin");
		String persis = request.getParameter("persis");

		Connection connection = DBCPUtils.getConnection();
		String sql = "SELECT * FROM user WHERE username=? and password=?";
		QueryRunner q = new QueryRunner();
		User user = q.query(connection, sql, new BeanHandler<User>(User.class), username,password);
		connection.close();
		
		BaseMessage<?> massage = MessageHandler.createMsgSuccess("登录成功");
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			massage = MessageHandler.createMsgFailure("用户名、登录密码不可为空");
		}else if (StringUtils.isBlank(user.getName())&&StringUtils.isBlank(user.getPassword())) { 
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
	 * @throws SQLException 
	 */
	public void checkNameLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String username = request.getParameter("username");
		BaseMessage<?> massage = MessageHandler.createMsgSuccess("用户名正确");
		
		Connection connection = DBCPUtils.getConnection();
		String sql = "SELECT username FROM user WHERE username=?";
		QueryRunner q = new QueryRunner();
		String qname = q.query(connection, sql, new BeanHandler<String>(String.class), username);
		connection.close();
		
		if (StringUtils.isBlank(qname))
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
	 * @throws SQLException 
	 */
	public void checkNameRegist(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String username = request.getParameter("username");
		BaseMessage<?> massage = MessageHandler.createMsgSuccess("用户名正确");
		
		Connection connection = DBCPUtils.getConnection();
		String sql = "SELECT username FROM user WHERE username=?";
		QueryRunner q = new QueryRunner();
		String qname = q.query(connection, sql, new BeanHandler<String>(String.class), username);
		connection.close();
		
		if (StringUtils.isNotBlank(qname))
			massage = MessageHandler.createMsgFailure("用户名已经存在");
		// 转换成JSON字符串
		JSONObject jsonObject = JSONObject.fromObject(massage);
		response.getWriter().print(jsonObject.toString());
	}

}
