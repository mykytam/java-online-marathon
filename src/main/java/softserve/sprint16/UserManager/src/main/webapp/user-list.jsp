<%@ page import="com.softserve.itacademy.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Password</th>
        <th colspan="3">Operations</th>
    </tr>

    <%
        for (User user : (List<User>) request.getAttribute("users")) {
    %>
    <tr>
        <td><%=user.getId()%>
        </td>
        <td><%=user.getUsername()%>
        </td>
        <td><%=user.getPassword()%>
        </td>
        <td>
            <a href="/users/read?id=<%=user.getId()%>">Read</a>
        </td>
        <td>
            <a href="/users/update?id=<%=user.getId()%>">Update</a>
        </td>
        <td>
            <a href="/users/delete?id=<%=user.getId()%>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>