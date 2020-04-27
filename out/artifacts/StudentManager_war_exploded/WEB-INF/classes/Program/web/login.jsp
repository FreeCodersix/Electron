<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page import="smallsix.UsersDAO" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>登录结果</title>
    <link rel="stylesheet" href="CSS/Clear.css">
    <style>
        div{
            width: 300px;
            height: 150px;
            margin: 100px auto;
            position: relative;
        }
        span{
            display: inline-block;
            width: 100px;
            height: 40px;
            line-height: 40px;
            margin-left: 50px;
        }
        #button{
            width: 80px;
            height: 40px;
            text-align: center;
            line-height: 40px;
            position: absolute;
            bottom: 0;
            left: 50%;
            margin-left: -40px;
        }
        p{
            width: 240px;
            position: absolute;
            bottom: 50px;
            left: 50%;
            margin-left: -120px;
            text-align: center;
        }
        a{
            font-size: 16px;
            color: black;
        }
    </style>
</head>

<body>
<div>
    <span>用户名:</span><%=request.getParameter("username")%><br/>
    <span>密码:</span><%=request.getParameter("password")%><br/>
    <p id="p"></p>
    <%--暂定为死链接--%>
    <button id="button"><a href="" id="a">确定</a></button>
</div>
<script>
    window.onload = function () {
        var p = document.getElementById("p");
        var a = document.getElementById("a");
        if (<%=UsersDAO.check(request.getParameter("username"), request
							.getParameter("password"))%>) {
            p.innerText = '登录成功！';
            p.style.color = 'green';
            a.href = 'index.jsp';
        } else {
            p.innerText = '用户名或密码错误，请重新输入！';
            p.style.color = 'red';
            a.href = 'index.jsp';
        }
    }
</script>

</body>
</html>
