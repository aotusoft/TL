package com.day.day03;

import java.io.*;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "FmtServlet", value = "/fmt")
public class FmtServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("date", new Date());
        request.setAttribute("n",1234567.123);
        request.setAttribute("p",1234567.123);
        request.getRequestDispatcher("/fmt.jsp").forward(request,response);

    }

    public void destroy() {
    }
}