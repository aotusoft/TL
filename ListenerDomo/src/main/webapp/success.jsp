<%--
  Created by IntelliJ IDEA.
  User: 荣耀
  Date: 2023/6/30
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  登录成功，当前用户为<%= request.getSession().getAttribute("username")%>
</body>
</html>
