package com.lsy.code.demo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsy.code.demo.domain.HeadImg;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lsy.code.demo.domain.User;
import com.lsy.code.demo.utils.BaseMessage;
import com.lsy.code.demo.utils.DBCPUtils;
import com.lsy.code.demo.utils.MessageHandler;
import com.lsy.code.demo.utils.ServletUtils;
import com.lsy.code.demo.utils.StringUtils;
import com.lsy.code.servlet.BaseServlet;

import net.sf.json.JSONObject;
/**用户 */
@SuppressWarnings("serial")
public class UserServlet extends BaseServlet {

	/**
	 * 注册校验
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws SQLException
	 */
	public void checkUserRegist(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String headImgUrl = request.getParameter("headImgUrl");
		BaseMessage<?> massage = MessageHandler.createMsgSuccess("注册成功");
		Connection connection = DBCPUtils.getConnection();
		QueryRunner q = new QueryRunner();

		//查找用户登陆名
		String qname = q.query(connection, "SELECT username FROM user WHERE username=?", new ScalarHandler<String>(), username);
		if (StringUtils.isNotBlank(qname)) {
			massage = MessageHandler.createMsgFailure("用户已经存在，不可重复注册");
			response.getWriter().print(JSONObject.fromObject(massage));
			return;
		}
		//新增一条记录到用户表中
		String uid =  StringUtils.createStrByUUID();
		int insertUser =  q.update(connection, "insert into user(uid,username,password) values(?,?,?)", uid, username, password);
		//新增一条记录到头像表中
		int insertHeadImg = q.update(connection, "insert into head_img(hid,uid,url) values(?,?,?)", StringUtils.createStrByUUID(), uid, headImgUrl);

		if (0==insertHeadImg){//用户未成功绑定头像
			connection.rollback();
			massage = MessageHandler.createMsgFailure("头像上传失败，请重新上传图片并重新提交表单。");
		}
		DBCPUtils.close(connection);

		//清空登录信息
		Cookie cookie = ServletUtils.getCookie("username", request);
		ServletUtils.removeCookie(cookie, request, response);
		response.getWriter().print(JSONObject.fromObject(massage));
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
		BaseMessage<?> massage = MessageHandler.createMsgSuccess("登录成功");
		Connection connection = DBCPUtils.getConnection();
		QueryRunner q = new QueryRunner();

		//查找用户信息
		String sql = "SELECT * FROM user WHERE username=? and password=?";
		User user = q.query(connection, sql, new BeanHandler<User>(User.class), username,password);
		connection.close();

		if (null==user) {
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
}
