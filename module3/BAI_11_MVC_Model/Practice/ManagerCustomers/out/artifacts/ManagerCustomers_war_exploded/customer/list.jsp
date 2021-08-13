<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/9/2021
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>
<button type="button" class="btn btn-primary mb-2" ><a class="text-dark text-decoration-none" href="/customers?action=create">Create</a></button>

<table class="table table-striped table-inverse table-responsive">
    <thead class="thead-inverse">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${requestScope["customers"]}' var="cutomer">
    <tr>
        <td><a href="/customers?action=view&id=${cutomer.getId()}">${cutomer.getName()}</a> </td>
        <td>${cutomer.getEmail()}</td>
        <td>${cutomer.getAddress()}</td>
        <td><a href="/customers?action=edit&id=${cutomer.getId()}">edit</a></td>
        <td><a href="/customers?action=delete&id=${cutomer.getId()}">delete</a></td>

    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
