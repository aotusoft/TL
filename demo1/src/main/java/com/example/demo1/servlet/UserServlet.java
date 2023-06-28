package com.example.demo1.servlet;

import com.example.demo1.dao.UserDao;
import com.example.demo1.dao.UserDaoImpl;
import com.example.demo1.entity.User;
import com.example.demo1.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //区分功能的参数
        String flag = request.getParameter("flag");

        //登录
        if (flag.equals("login")) {
            //获取用户名密码
            String username = request.getParameter("username");
            String pwd = request.getParameter("password");
            int count = userDao.login(username, pwd);
            if (count > 0) {
                request.getRequestDispatcher("/user?flag=list").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
            //列表显示
        } else if (flag.equals("list")) {
            List<User> userList=userDao.list();
            request.setAttribute("userlist", userList);
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
            //验证用户是否存在
        } else if (flag.equals("byuser")) {
            String username = request.getParameter("username");
            String s = userDao.byUserName(username);
            response.getWriter().write(s);
            //注册
        } else if (flag.equals("regist")) {
            //获取用户名密码
            String username = request.getParameter("username");
            String pwd = request.getParameter("password");
            int count = userDao.regist(username,pwd);
            if (count > 0) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
            //删除
        } else if (flag.equals("del")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int count = userDao.del(id);
            if (count > 0) {
                request.getRequestDispatcher("/user?flag=list").forward(request, response);
            }
        }
    }
}
