<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<%@include file="header.html" %>
<br><br>
<%
    String fName = request.getParameter("firstName");
    String lName = request.getParameter("lastName");
%>
<h2>Person with name <%=fName%> and last name <%=lName%> not found in Address Book!</h2>


</body>
</html>
