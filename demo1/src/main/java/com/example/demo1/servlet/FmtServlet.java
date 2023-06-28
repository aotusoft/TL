package com.example.demo1.servlet;

import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "FmtServlet", value = "/fmt")
public class FmtServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("date", new Date());
        request.setAttribute("n",1234567.123);
        request.setAttribute("p",1234567.123);
        request.getRequestDispatcher("/fmt.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}