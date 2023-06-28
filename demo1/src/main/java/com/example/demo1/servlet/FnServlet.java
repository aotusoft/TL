package com.example.demo1.servlet; /**
 * @Author: nekotako
 * @Date: 2023/6/28 10:25
 */

import java.io.IOException;

@WebServlet(name = "FnServlet", value = "/fn")
public class FnServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/fn.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
