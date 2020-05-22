<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new User</title>
</head>
<body>

<%@include file="header.html"%>
<br><br>
<form action="/users/create" method="post">
    <table>
        <tr>
            <td>
                <label for="username">Username: </label>
            </td>
            <td>
                <input id="username" name="username" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Password: </label>
            </td>
            <td>
                <input id="password" name="password" type="password">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
