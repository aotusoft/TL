<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
<%--    使用隐藏域传入flag请求参数--%>
    <input type="hidden" name="flag" value="login">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="登录">
            </td>
            <td>
                <input type="button" value="注册" onclick='location.href=("<%=request.getContextPath()%>/register.jsp")'>
            </td>
        </tr>
    </table>
</form>
</body>
</html>