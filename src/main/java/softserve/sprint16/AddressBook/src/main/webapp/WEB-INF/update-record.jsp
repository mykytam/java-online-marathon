<%@ page import="com.softserve.itacademy.model.NameAddressPair" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update record</title>
</head>
<body>
<%@include file="header.html" %>
<br><br>
<form action="/records/update" method="post">

    <%
        NameAddressPair nameAddressPair = (NameAddressPair) request.getAttribute("recordToUpdate");
        String fName = nameAddressPair.getPerson().getFirstName();
        String lName = nameAddressPair.getPerson().getLastName();
        String address = nameAddressPair.getAddress();
    %>

    <table>
        <table>
            <tr>
                <td>
                    <label for="firstName">First name: </label>
                </td>
                <td>
                    <input id="firstName" name="firstName" type="text" value="<%=fName%>">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="lastName">Last name: </label>
                </td>
                <td>
                    <input id="lastName" name="lastName" type="text" value="<%=lName%>">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="address">Address: </label>
                </td>
                <td>
                    <input id="address" name="address" type="text" value="<%=address%>">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Update record">
                </td>
                <td>
                    <input type="reset" value="Clear">
                </td>
            </tr>

        </table>


</form>
</body>
</html>
