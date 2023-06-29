package com.day.day03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;



@WebServlet(name = "FmtServlet", value = "/fmt")
public class FmtServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("today", new Date());
        request.setAttribute("n",1234567.123);
        request.setAttribute("p",1234567.123);
        request.getRequestDispatcher("/fmt.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}