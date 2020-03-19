package com.shaojie.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    /*
    字节流
    */
@WebServlet("/Responsedemo2")
public class Responsedemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //设置编码
        response.setContentType("text/html;charset=utf-8");
        //获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
       //输出数据
        outputStream.write("你好，字节流".getBytes());

    }
}
