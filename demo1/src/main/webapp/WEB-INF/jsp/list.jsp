<%--
  Created by IntelliJ IDEA.
  User: ljn
  Date: 2023/6/28
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>用户名</td>
            <td>操作</td>
        </tr>
        <c:forEach var="user" items="${userlist}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>
                    <a href="<%=request.getContextPath()%>/user?flag=del&id=${user.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
