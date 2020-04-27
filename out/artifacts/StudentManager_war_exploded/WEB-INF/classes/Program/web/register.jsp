<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page import="smallsix.UsersDAO" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>注册结果</title>
    <link rel="stylesheet" href="CSS/Clear.css">
    <style>
        div{
            width: 200px;
            height: 100px;
            margin: 100px auto;
            position: relative;
        }
        #a{
            width: 100px;
            height: 40px;
            position: absolute;
            top: 50%;
            margin-top: -20px;
            left: 50%;
            margin-left: -50px;
            font-size: 16px;
            text-align: center;
            line-height: 40px;
        }
    </style>
</head>

<body>
<div>
    <a href="" id="a">确定</a>
</div>
<script>
    window.onload = function () {
        var p = document.getElementsByTagName("p")[0];
        var a = document.getElementById("a");

        if (<%=UsersDAO.register(request.getParameter("username"),request.getParameter("password"))
    %>) {
            // p.innerText = '注册成功！';
            alert("注册成功");
            window.location.href = "index.jsp";

        } else {
            // p.innerText = '注册失败，请重新注册！';
            alert("注册失败，请重新注册！");
            window.location.href = "index.jsp";
        }
    }
</script>

</body>
</html>
