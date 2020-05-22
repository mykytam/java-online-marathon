<%@ page import="com.softserve.itacademy.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show info about User</title>
</head>

<body>

<%@include file="header.html" %>
<br><br>
<%
    User user = (User) request.getAttribute("user");
%>
<p>Id:<%=user.getId()%>
</p>
<p>Username:<%=user.getUsername()%>
</p>
<p>Password:<%=user.getPassword()%>
</p>

</body>
</html>
