<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body class="container">
<%@include file="header.html" %>
<br><br>
<%
    String fName = request.getParameter("firstName");
    String lName = request.getParameter("lastName");
%>
<h3>Error 404 :(</h3>
<h3>Person with name <%=fName%> and last name <%=lName%> not found in Address Book!</h3>


</body>
</html>
