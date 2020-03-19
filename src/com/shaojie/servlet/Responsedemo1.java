package com.shaojie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Responsedemo1")
public class Responsedemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        解决乱码问题
         */
        //获取流对象之前，可以设置流的编码，（"GBK"）
        //response.setCharacterEncoding("GBK");
        //告诉浏览器，服务器发送的消息体数据的编码方式，建议浏览器使用该编码
        response.setHeader("content-type","text/html;charset=utf-8");

        //简单形式设置编码
        //response.setContentType("text/html;charset=utf-8");

        //获取字符输出流
        PrintWriter writer = response.getWriter();
        //输出数据
        writer.write("hello response");
        writer.write("你好，response");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
