<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create record</title>
</head>
<body>
<%@include file="header.html" %>
<br><br>

<%
    String error = request.getParameter("error");
    if (error != null) {
        out.println("<p>A record with a given key already exists in the Address Book!</p>");
    }
%>
<form action="/records/create" method="post">
    <table>
        <tr>
            <td>
                <label for="firstName">First name: </label>
            </td>
            <td>
                <input id="firstName" name="firstName" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <label for="lastName">Last name: </label>
            </td>
            <td>
                <input id="lastName" name="lastName" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <label for="address">Address: </label>
            </td>
            <td>
                <input id="address" name="address" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create record">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>

    </table>
</form>

</body>
</html>
