package com.shaojie.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/demo3Servlet")
public class demo3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag=false;
        if(cookies!=null && cookies.length !=0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("LastName".equals(name)){//不是第一次访问
                    flag=true;
                    //响应数据
                    String value = cookie.getValue();
                    String value1 = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间是："+value1+"</h1>");

                    //重新设置cookie的value
                    Date date = new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                    String str_date=sdf.format(date);
                    str_date=URLEncoder.encode(str_date,"utf-8");//编码
                    cookie.setValue(str_date);
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);

                }
            }
        }
        if(cookies==null || cookies.length==0 || flag==false){

            response.getWriter().write("<h1>您好，欢迎首次访问！</h1>");

            //重新设置cookie的value
            Date date = new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
            String str_date=sdf.format(date);
            str_date=URLEncoder.encode(str_date,"utf-8");//编码
            Cookie cookie = new Cookie("LastName",str_date);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
