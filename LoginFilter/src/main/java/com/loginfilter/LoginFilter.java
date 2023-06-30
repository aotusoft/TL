package com.loginfilter;
/**
 * @Author: nekotako
 * @Date: 2023/6/30 9:36
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",value = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String contextPath = request.getServletContext().getContextPath();
//        request
        if (!contextPath.equals("/login.jsp") || !contextPath.equals("/login")){

        }
        chain.doFilter(request, response);
    }
}
