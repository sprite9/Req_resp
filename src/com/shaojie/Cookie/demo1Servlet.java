package com.shaojie.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo1Servlet")
public class demo1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.ch创建cookie对象
        Cookie cookie = new Cookie("msg","hello");
        cookie.setMaxAge(20);//持久化到硬盘中，20秒后删除cookie（正数：持久化到硬盘； 0：删除cookie信息 ；负数：浏览器关闭，则删除cookie信息）

        //2.发送cookie
        response.addCookie(cookie);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
