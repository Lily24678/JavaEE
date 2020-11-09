package com.lsy.code.demo.wrapper;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyGenericEncoding extends HttpServletRequestWrapper {
    private HttpServletRequest request;

    public MyGenericEncoding(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    /**
     * 装饰者模式：处理中文乱码
     */
    @Override
    public String getParameter(String name) {
        String method = request.getMethod();
        if ("get".equalsIgnoreCase(method)) {//在get请求下tomcat8不需要做中文乱码处理，tomcat7需要做中文乱码处理
//            String value = null;
//             value = new String(request.getParameter(name).getBytes("ISO-8859-1"), "UTF-8");
//             return value;
            return request.getParameter(name);
        } else if ("post".equalsIgnoreCase(method)) {
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return request.getParameter(name);
    }

}
