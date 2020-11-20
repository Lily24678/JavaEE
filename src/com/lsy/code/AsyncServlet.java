package com.lsy.code;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 异步请求的Servlet */
@WebServlet(urlPatterns="/AsyncServlet",asyncSupported=true)
public class AsyncServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AsyncContext context = request.startAsync(request, response);
        context.start(new MyRunnable(context));
        for(int i = 1;i<=10;i++){
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyRunnable implements Runnable{
    private AsyncContext context;
    public MyRunnable(AsyncContext context) {
        this.context = context;
    }
    @Override
    public void run() {
        for(char i='a';i<='z';i++){
            try {
                context.getResponse().getWriter().println(i);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
