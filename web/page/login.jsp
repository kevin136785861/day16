<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/23
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>这是一个登录界面</title>
</head>
<body>
<%String msg = (String)request.getAttribute("msg");%>
<form action="${pageContext.request.contextPath}/hello">
    <input type="text" name="username">
    <input type="text" name="pwd">
    <span><%=msg%></span>
    <input type="submit" value="Submit">
</form>
</body>
</html>
