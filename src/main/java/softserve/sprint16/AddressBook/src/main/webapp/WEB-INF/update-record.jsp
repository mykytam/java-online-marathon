<%@ page import="com.softserve.itacademy.model.NameAddressPair" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update record</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body class="container">
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
        <tr>
            <div class="input-group flex-nowrap" style="width: 25rem;">
                <div class="input-group-prepend">
                    <span class="input-group-text">First Name</span>
                </div>
                <input type="text" id="firstName" name="firstName" class="form-control"
                       aria-describedby="addon-wrapping" value="<%=fName%>">
                <input type="hidden" value="<%=fName%>" name="oldFirstName" id="oldFirstName">
            </div>
        </tr>
        <tr>
            <div class="input-group flex-nowrap mt-3" style="width: 25rem;">
                <div class="input-group-prepend">
                    <span class="input-group-text">Last Name</span>
                </div>
                <input type="text" id="lastName" name="lastName" class="form-control" aria-describedby="addon-wrapping"
                       value="<%=lName%>">
                <input type="hidden" value="<%=lName%>" name="oldLastName" id="oldLastName">
            </div>
        </tr>
        <tr>
            <div class="input-group flex-nowrap mt-3" style="width: 25rem;">
                <div class="input-group-prepend">
                    <span class="input-group-text">Address</span>
                </div>
                <input type="text" id="address" name="address" class="form-control" aria-describedby="addon-wrapping"
                       value="<%=address%>">
            </div>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update record" class="btn btn-success mt-3">
            </td>
            <td>
                <input type="reset" value="Clear" class="btn btn-danger mt-3">
            </td>
        </tr>

    </table>

</form>
</body>
</html>
