package com.shaojie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/Requestdemo3")
public class Requestdemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post请求方式会出现中文乱码的情况，get不会出现

        response.setCharacterEncoding("utf-8");//设置流编码方式


        //1.直接根据name获取值
        String username = request.getParameter("username");

        //2现获取所有的name，再根据name获取值
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String name1 = request.getParameter(name);
            System.out.println(name1);
        }


        //3.根据name获取值，用于多个值以数组形式
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        //4.获取所有的name以及对应的值
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keysets = parameterMap.keySet();
        for (String keyset : keysets) {
            String[] values = parameterMap.get(keyset);
            for (String value : values) {
                System.out.println(value);
                System.out.println("______________");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //如果get请求方法与post方法一致，则可以直接调用doPost()方法
        this.doPost(request,response);
    }
}
