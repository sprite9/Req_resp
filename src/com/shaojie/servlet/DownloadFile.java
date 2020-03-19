package com.shaojie.servlet;

import com.shaojie.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

import static javax.swing.text.html.HTML.Tag.I;

@WebServlet("/downloadfile")
public class DownloadFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数（文件名称）
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件目录
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/imgs/" + filename);
        System.out.println(filename);
        System.out.println(realPath);


        //2.2用字节流关联
        FileInputStream fis= new FileInputStream(realPath);
        //3设置response的响应头
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);

        //解决中文文件名问题
        String agent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);


        response.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流的数据写到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff=new byte[1024*8];
        int len=0;
        while ((len=fis.read(buff)) !=-1){
            outputStream.write(buff,0,len);
        }
        fis.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
