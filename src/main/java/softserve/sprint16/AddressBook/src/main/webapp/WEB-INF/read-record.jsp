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
    NameAddressPair nameAddressPair = (NameAddressPair) request.getAttribute("record");
    String fName = nameAddressPair.getPerson().getFirstName();
    String lName = nameAddressPair.getPerson().getLastName();
    String address = nameAddressPair.getAddress();

%>
<p>First Name: <%=fName%>
</p>
<p>Last Name: <%=lName%>
</p>
<p>Address: <%=address%>
</p>


</body>
</html>
