<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date,java.io.*,com.cookieandsession.cookie.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<form action="/getCookie" method="post">
    <input type="submit">
</form>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>