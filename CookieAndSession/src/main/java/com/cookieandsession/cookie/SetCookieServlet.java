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
import java.net.URLEncoder;

@WebServlet(name = "SetCookieServlet", value = "/setCookie")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Cookie name = new Cookie("name", "ZhangSan");
        Cookie age = new Cookie("age", "18");
        Cookie sex = new Cookie("sex",URLEncoder.encode("男","UTF-8"));
        name.setMaxAge(99999);
        response.addCookie(name);
        response.addCookie(age);
        response.addCookie(sex);
    }
}
