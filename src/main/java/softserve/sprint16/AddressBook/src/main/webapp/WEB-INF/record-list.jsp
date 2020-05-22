<%@ page import="com.softserve.itacademy.model.AddressBook" %>
<%@ page import="com.softserve.itacademy.model.NameAddressPair" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All records</title>
</head>
<body>

<%@include file="header.html" %>
<br><br>

<table border="1">
    <tr>
        <th>Number</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
        <th colspan="3">Operations</th>
    </tr>

    <%
        int indexCounter = 1;
        for (NameAddressPair nameAddressPair : (AddressBook) request.getAttribute("records")) {
    %>
    <tr>
        <td><%=indexCounter++%>
        </td>
        <td><%=nameAddressPair.getPerson().getFirstName()%>
        </td>
        <td><%=nameAddressPair.getPerson().getLastName()%>
        </td>
        <td><%=nameAddressPair.getAddress()%>
        </td>
        <td>
            <a href="/records/read?firstName=<%=nameAddressPair.getPerson().getFirstName()%>&lastName<%=nameAddressPair.getPerson().getLastName()%>">Read</a>
        </td>
        <td>
            <a href="/records/update?firstName=<%=nameAddressPair.getPerson().getFirstName()%>&lastName<%=nameAddressPair.getPerson().getLastName()%>">Update</a>
        </td>
        <td>
            <a href="/records/delete?firstName=<%=nameAddressPair.getPerson().getFirstName()%>&lastName<%=nameAddressPair.getPerson().getLastName()%>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
