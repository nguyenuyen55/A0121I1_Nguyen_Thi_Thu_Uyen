
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/9/2021
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>
<h1>Deleting customer</h1>
<p>
    <a href="/customers">Back to customer</a>
</p>
<form method="post">
    <h3>ARE YOU SURE ?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table class="table table-striped table-inverse table-responsive">
            <tbody>
            <tr>
                <td>Name :</td>
                <td>${customer.getName()}</td>

            </tr>
            <tr>
                <td>Gmail :</td>
                <td>${customer.getGmail()}</td>

            </tr>
            <tr>
                <td>Address :</td>
                <td>${customer.getAddress()}</td>

            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="/customers">Back to customer</a></td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>
</body>
</html>
