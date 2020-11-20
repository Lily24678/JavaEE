package com.lsy.code.servlet;

import com.lsy.code.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


/**
 * 通用的Servlet
 */
@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		Class<? extends BaseServlet> clazz = this.getClass();
		try {
			Method method = clazz.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
			String path = (String) method.invoke(this, request,response);
			if(StringUtil.isNotBlank(path)) {
//				request.getRequestDispatcher(path).forward(request, response);//转发
				response.sendRedirect(path);//重定向
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
