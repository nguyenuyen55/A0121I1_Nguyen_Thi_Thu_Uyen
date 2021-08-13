<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/9/2021
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>
<h1>Deleting customer</h1>
<p>
    <a href="/customers">Back to customer</a>
</p>
<form method="post">
    <fieldset>
        <legend>ARE YOU SURE ?</legend>
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
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>
</body>
</html>
