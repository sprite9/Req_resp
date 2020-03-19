package com.shaojie.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");

        //获取生成的验证码
        HttpSession session = request.getSession();
        String  checkcode_session = (String) session.getAttribute("checkcode_session");

        //删除session中的验证码
        session.removeAttribute("checkcode_session");

        if(checkcode_session!=null && checkcode_session.equalsIgnoreCase(checkcode)){
            if("zhangsan".equals(username) && "123".equals(password)){
                //登陆成功
                //存储信息
                session.setAttribute("user",username);
                //重定向到success.jsp
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else {
                //登录失败mmmmmm
                request.setAttribute("login_error","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);



            }

        }else {
            //验证码错误
            request.setAttribute("cc_error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
