package com.mybatis.pageoffset.servlet; /**
 * @Author: nekotako
 * @Date: 2023/7/3 16:59
 */


import com.mybatis.pageoffset.mapper.UserMapper;
import com.mybatis.pageoffset.pojo.User;
import com.mybatis.pageoffset.utils.MybatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ParamsServlet", value = "/query")
public class ParamsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        if(!"".equals(id)){
            user.setId(Long.parseLong(id));
        }
        user.setUsername(username);
        user.setPassword(password);
        List<User> list = MybatisUtil.getSession().getMapper(UserMapper.class).getInfoByParams(user);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/query.jsp").forward(request,response);
    }
}
