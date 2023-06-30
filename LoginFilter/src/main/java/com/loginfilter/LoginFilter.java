package com.loginfilter;
/**
 * @Author: nekotako
 * @Date: 2023/6/30 9:36
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", value = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String contextPath = request.getServletContext().getContextPath();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        if (servletPath.equals("/index.jsp") || servletPath.equals("/login")) {
            resp.sendRedirect(req.getContextPath() + "/ERROR-URL.jsp");
            return;
        } else {
            if (req.getSession().getAttribute("username") == null) {
                chain.doFilter(request, response);
                return;
            } else {
//                response.getWriter().println("NO SESSION");
                resp.sendRedirect(req.getContextPath() + "/NO-SESSION.jsp");
            }
        }
        chain.doFilter(request, response);
    }
}
