<%--
  Created by IntelliJ IDEA.
  User: ljn
  Date: 2023/6/28
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/user" method="post">
    <input type="hidden" name="flag" value="regist">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" id="username"><span id="ts"></span></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="注册" id="submit">
            </td>
            <td>
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
<script>
    $(function (){
        $("#username").blur(function (){
            $.ajax({
                url:"<%=request.getContextPath()%>"+"/user",
                type:"post",
                data:"flag=byuser&username="+$("#username").val(),
                success:function (data){
                    var result=parseInt(data);
                    if(result>0){
                        $("#ts").html("该用户名已存在");
                        $("#submit").attr("disabled",true);
                    }else{
                        $("#ts").html("");
                        $("#submit").attr("disabled",false);
                    }
                },
                error:function (){
                    alert("error");
                }
            });
        });
    });
</script>
