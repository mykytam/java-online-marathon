<%@ page import="com.softserve.itacademy.model.AddressBook" %>
<%@ page import="com.softserve.itacademy.model.NameAddressPair" %>
<%@ page import="static com.softserve.itacademy.model.SortOrder.ASC" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All records</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body class="container">

<%@include file="header.html" %>
<br><br>
<p>Sort by: <a href="/records/list?sort=asc">Ascending</a> or <a href="/records/list?sort=desc">Descending</a></p>

<table class="table">
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
            String fName = nameAddressPair.getPerson().getFirstName();
            String lName = nameAddressPair.getPerson().getLastName();
            String address = nameAddressPair.getAddress();
    %>
    <tr>
        <td><%=indexCounter++%>
        </td>
        <td><%=fName%>
        </td>
        <td><%=lName%>
        </td>
        <td><%=address%>
        </td>
        <td>
            <a href="/records/read?firstName=<%=fName%>&lastName=<%=lName%>">Read</a>
        </td>
        <td>
            <a href="/records/update?firstName=<%=fName%>&lastName=<%=lName%>">Update</a>
        </td>
        <td>
            <a href="/records/delete?firstName=<%=fName%>&lastName=<%=lName%>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
