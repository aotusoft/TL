<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
    today(Default) <fmt:formatDate value="${today}"><br>
    today(Default) <fmt:formatDate value="${today}" type="date"><br>
    today(Default) <fmt:formatDate value="${today}" type="time"><br>
    today(Default) <fmt:formatDate value="${today}" dateStyle="short"><br>
    today(Default) <fmt:formatDate value="${today}" dateStyle="medium"><br>
    today(Default) <fmt:formatDate value="${today}" dateStyle="long"><br>
    today(Default) <fmt:formatDate value="${today}" pattern="yyyy-MM-dd hh:mm:ss SSS"><br>
</body>
</html>