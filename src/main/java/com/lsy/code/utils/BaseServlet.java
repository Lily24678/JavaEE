package com.lsy.code.utils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String methodName = req.getParameter("method");
        if (StringUtils.isBlank(methodName)) {
            resp.getWriter().println("method参数为空");
            return;
        }
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            String path = (String) method.invoke(this, req, resp);
            if (StringUtils.isNotBlank(path)) req.getRequestDispatcher(path).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
