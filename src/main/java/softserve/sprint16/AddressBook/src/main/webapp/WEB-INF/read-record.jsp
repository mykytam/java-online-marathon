<%@ page import="com.softserve.itacademy.model.NameAddressPair" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read record</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body class="container">

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
