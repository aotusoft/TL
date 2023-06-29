package com.filterdemo; /**
 * @Author: nekotako
 * @Date: 2023/6/29 15:28
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter",value = "/index.jsp")
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("开始处理");
        chain.doFilter(request, response);
        System.out.println("结束处理");
    }
}
