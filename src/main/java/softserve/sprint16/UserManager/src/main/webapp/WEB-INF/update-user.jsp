<%@ page import="com.softserve.itacademy.User" %>
<html>
<head>
    <title>Update existing user</title>
</head>
<body>
<%@include file="header.html" %>
<br><br>
<form action="/users/update" method="post">

    <%
        User user = (User) request.getAttribute("user");
    %>

    <table>
        <tr>
            <td>
                <label for="id">Id: </label>
            </td>
            <td>
                <input type="text" id="id" name="id" value="<%=user.getId()%>" disabled>
            </td>
        </tr>
        <tr>
            <td>
                <label for="username">Username: </label>
            </td>
            <td>
                <input id="username" name="username" type="text" value="<%=user.getUsername()%>">
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Password: </label>
            </td>
            <td>
                <input id="password" name="password" type="password" value="<%=user.getPassword()%>">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
