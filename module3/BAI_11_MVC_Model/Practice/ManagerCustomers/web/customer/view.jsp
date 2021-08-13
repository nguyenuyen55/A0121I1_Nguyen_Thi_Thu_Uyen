<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/10/2021
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>
<p>
    <a href="/customers">Back to customer</a>
</p>
<form >
    <fieldset>

        <table class="table table-striped table-inverse table-responsive">

            <tbody>
            <tr>
                <td >Name : </td>
                <td>${customer.getName()}</td>

            </tr>

            <tr>
                <td >Email : </td>
                <td>${customer.getEmail()}"</td>
            </tr>
            <tr>
                <td >Address : </td>
                <td>${customer.getAddress()}</td>
            </tr>

            </tbody>
        </table>
    </fieldset>
</form>
</body>
</html>
