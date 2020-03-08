<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/4
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>菜单管理</title>
</head>
    <!-- 如果使用framest的包含页面 主页不能有body-->
    <frameset cols="250,*" border="1">
    <frame src="${lzywsgl}/sys/toMenuLeft.action" name="left">
    <frame src="${lzywsgl}/sys/toMenuRight.action" name="right">
    </frameset>
</html>
