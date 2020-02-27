package com.lsy.code.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ProvinceCityServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String isProvince = req.getParameter("isProvince");
		if("1".equals(isProvince)) {
			//获取省会
		}else if("0".equals(isProvince)){
			//获取市州
		}else {
			//表明传参出错
		}
	}
}
