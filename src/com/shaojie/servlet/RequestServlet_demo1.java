package com.shaojie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestServlet_demo1")
public class RequestServlet_demo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求方式：GET
        String method = request.getMethod();
        System.out.println(method);
        //2.获取虚拟目录   (**)
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3.获取servlet路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4.获取请求参数
        String queryString = request.getQueryString();
        System.out.println(queryString);

        //5.获取请求ULI   (***)
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);


        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        //6.获取协议及版本
        int remotePort = request.getRemotePort();
        System.out.println(remotePort);
        //7获取客户机的IP地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);


    }
}
