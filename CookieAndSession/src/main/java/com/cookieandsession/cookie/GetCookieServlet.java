package com.cookieandsession.cookie; /**
 * @Author: nekotako
 * @Date: 2023/6/29 10:15
 */


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "GetCookieServlet", value = "/getCookie")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies){
            response.getWriter().println(c.getName()+"-----"+ URLDecoder.decode(c.getValue(),"UTF-8")+"</br>");
        }
    }
}
