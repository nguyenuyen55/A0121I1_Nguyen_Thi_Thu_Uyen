<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/18/2021
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Users</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>

<div class="container">
    <a href="/users">Quay về</a>
    <c:if test="${message != null}">
        <div class="alert alert-success" role="alert">
        ${message}
        </div>

    </c:if>
    <form class="align-content-center border p-4 mt-4" method="post">
        <div class="form-group">
            <label >Name</label>
            <input type="text" class="form-control" name="name" value="${name}" >
        </div>
        <div class="form-group">
            <label >Email address</label>
            <input type="text" class="form-control" name="email" value="${email}" >
        </div><div class="form-group">
        <label >Country</label>
        <input type="text" class="form-control" name="country" value="${country}">
    </div>
        <input type="text" hidden  name="id" value="${id}">
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>
