package com.shaojie.session;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/*
    制作简单二维码
 */

@WebServlet("/checkcodedemo")
public class CheckCodeDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=200;
        int height=50;
        //1.创建一个对象
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1填充背景色
        Graphics ga=bufferedImage.getGraphics();//画笔对象
        ga.setColor(Color.pink);//颜色设置
        ga.fillRect(0,0,width,height);
        //2.2画边框
        ga.setColor(Color.BLUE);
        ga.drawRect(0,0,width-1,height-1);
        //2.3随机生成字母或数字
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random ran=new Random();

        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <=4 ; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            ga.drawString(ch+"",width/5*i,height/2);
        }


        String checkcode_session=sb.toString();
        request.getSession().setAttribute("checkcode_session",checkcode_session);


        //2.4划线
        ga.setColor(Color.GREEN);
        for (int i = 0; i <5 ; i++) {

        int x1=ran.nextInt(width);
        int y1=ran.nextInt(height);
        int x2=ran.nextInt(width);
        int y2=ran.nextInt(height);
        ga.drawLine(x1,y1,x2,y2);
        }

        //3.将图片输出到页面展示
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());


    }
}
