package com.shaojie.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextdemo1")
public class ServletContextdemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletcontext
        //1.通过request获取
        ServletContext context1 = request.getServletContext();
        //2.直接获取
        ServletContext context2 = this.getServletContext();
        System.out.println(context1==context2);

        //域对象 共享数据
        //ServletContext 下设置的域可以在整个服务器（全局）共享
        context1.setAttribute("msg","hahah");

        //获取文件的真实路径
        //根目录（Req_resp）下的文件直接写文件名
        String realPath1 = context1.getRealPath("/WEB-INF/b.txt");//WEB-INF下的文件
        System.out.println(realPath1);
        String realPath = context1.getRealPath("/WEB-INF/classes/a.txt");//src下的文件
        System.out.println(realPath);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
