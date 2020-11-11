package com.lsy.code.demo.servlet;

import com.lsy.code.demo.dao.HeadImgDao;
import com.lsy.code.demo.dao.UserDao;
import com.lsy.code.demo.domain.HeadImg;
import com.lsy.code.demo.domain.User;
import com.lsy.code.demo.utils.BaseMessage;
import com.lsy.code.demo.utils.MessageHandler;
import com.lsy.code.demo.utils.ServletUtils;
import com.lsy.code.demo.utils.StringUtils;
import com.lsy.code.servlet.BaseServlet;
import net.sf.json.JSONObject;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
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

		UserDao userDao =  new UserDao();
		//查找用户登陆名
		String qname = userDao.findUsernameByUsername(username);
		if (StringUtils.isNotBlank(qname)) {
			massage = MessageHandler.createMsgFailure("用户已经存在，不可重复注册");
			response.getWriter().print(JSONObject.fromObject(massage));
			return;
		}
		//新增一条记录到用户表中
		String uid =  StringUtils.createStrByUUID();
		userDao.addUser(new User(uid,username,password));
		if (StringUtils.isNotBlank(headImgUrl)){
			//新增一条记录到头像表中
			int insertHeadImg = new HeadImgDao().addHeadImg(new HeadImg(StringUtils.createStrByUUID(), uid, headImgUrl));
		}

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

		//查找用户信息
		User user = new UserDao().findByUsernameAndPassword(username,password);

		if (null==user) {
			massage = MessageHandler.createMsgFailure("用户名或者登录密码错误"); 
		} else {//用户登录完成后,显示您是第x位访问的用户,您的上次访问时间是:yyyy-MM-dd.
			//登陆成功，用户数+1
			Integer count = (Integer) request.getServletContext().getAttribute("count");
			request.getServletContext().setAttribute("count",count);
			System.out.println(username+"，已登陆，是第"+count+"位。");

			Cookie lastVisit = ServletUtils.getCookie("lastVisit", request);
			if (null==lastVisit){//是第一次登陆
				request.getServletContext().setAttribute("count",count);
			}else {//不是第一次登陆
				ServletUtils.addCookie("showLastVisit", LocalDateTime.parse(lastVisit.getValue()).toString(),request,response);
			}

			ServletUtils.addCookie("username",username,request,response);
			ServletUtils.addCookie("count",""+count,request,response);
			ServletUtils.addCookie("lastVisit",LocalDateTime.now().toString(),request,response);
		}
		// 转换成JSON字符串
		JSONObject jsonObject = JSONObject.fromObject(massage);
		response.getWriter().print(jsonObject.toString());
	}
}
