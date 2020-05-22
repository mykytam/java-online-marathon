<%@ page import="com.softserve.itacademy.model.AddressBook" %>
<%@ page import="com.softserve.itacademy.model.NameAddressPair" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read record</title>
</head>
<body>

<%@include file="header.html" %>
<br><br>
<%
    for (NameAddressPair nameAddressPair : (AddressBook) request.getAttribute("records")) {
%>
<p>First Name:<%=nameAddressPair.getPerson().getFirstName()%>
</p>
<p>Last Name:<%=nameAddressPair.getPerson().getLastName()%>
</p>
<p>Address:<%=nameAddressPair.getAddress()%>
</p>

</body>
</html>
