package com.mybatis.pageoffset.servlet; /**
 * @Author: nekotako
 * @Date: 2023/7/3 16:30
 */

import com.mybatis.pageoffset.mapper.UserMapper;
import com.mybatis.pageoffset.pojo.User;
import com.mybatis.pageoffset.utils.MybatisUtil;
import com.mybatis.pageoffset.utils.PageOffsetUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        SqlSession session = MybatisUtil.getSession();
        int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        int count = session.getMapper(UserMapper.class).getCount();
        PageOffsetUtil pageOffsetUtil = new PageOffsetUtil();
        //设置每页显示的条数
        pageOffsetUtil.setPageSize(5);
        //设置当前页数
        pageOffsetUtil.setCurrentPage(2);
        pageOffsetUtil.setTotalCount(count);
        if (pageIndex < 1) {
            pageOffsetUtil.setCurrentPage(1);
        } else if (pageIndex > pageOffsetUtil.getTotalPage()) {
            pageOffsetUtil.setCurrentPage(pageOffsetUtil.getTotalPage());
        } else {
            pageOffsetUtil.setCurrentPage(pageIndex);
        }
        List<User> list = session.getMapper(UserMapper.class).getAllInfo((pageOffsetUtil.getCurrentPage() - 1) * pageOffsetUtil.getPageSize(), pageOffsetUtil.getPageSize());
        pageOffsetUtil.setList(list);
        request.setAttribute("page", pageOffsetUtil);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        MybatisUtil.close(session);
    }
}
