package com.sessiondemo; /**
 * @Author: nekotako
 * @Date: 2023/6/29 14:37
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getAttribute("username").toString();
        String password = request.getAttribute("password").toString();
        if (username != null && password != null) {
            session.setAttribute("username", username);
        } else if (username == null || password == null) {
            response.sendRedirect("/error.jsp");
        }
    }
}
