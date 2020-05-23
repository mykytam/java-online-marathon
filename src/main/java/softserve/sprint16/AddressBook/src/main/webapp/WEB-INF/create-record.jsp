<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create record</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body class="container">
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
            <div class="input-group flex-nowrap" style="width: 25rem;">
                <div class="input-group-prepend">
                    <span class="input-group-text">First Name</span>
                </div>
                <input type="text" id="firstName" name="firstName" class="form-control"
                       aria-describedby="addon-wrapping">
            </div>
        </tr>
        <tr>
            <div class="input-group flex-nowrap mt-3" style="width: 25rem;">
                <div class="input-group-prepend">
                    <span class="input-group-text">Last Name</span>
                </div>
                <input type="text" id="lastName" name="lastName" class="form-control" aria-describedby="addon-wrapping">
            </div>
        </tr>
        <tr>
            <div class="input-group flex-nowrap mt-3" style="width: 25rem;">
                <div class="input-group-prepend">
                    <span class="input-group-text">Address</span>
                </div>
                <input type="text" id="address" name="address" class="form-control" aria-describedby="addon-wrapping">
            </div>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create record" class="btn btn-success mt-3">
            </td>
            <td>
                <input type="reset" value="Clear" class="btn btn-danger mt-3">
            </td>
        </tr>

    </table>
</form>

</body>
</html>
