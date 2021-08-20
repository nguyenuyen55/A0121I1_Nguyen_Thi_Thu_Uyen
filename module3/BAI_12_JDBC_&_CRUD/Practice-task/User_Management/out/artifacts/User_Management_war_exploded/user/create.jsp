<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/18/2021
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Users</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>
<div class="container">
<form class="align-content-center border p-4 mt-4" method="post">
    <div class="form-group">
        <label >Name</label>
        <input type="text" class="form-control" name="name" >
    </div>
    <div class="form-group">
        <label >Email address</label>
        <input type="text" class="form-control" name="email" >
    </div><div class="form-group">
        <label >Country</label>
        <input type="text" class="form-control" name="country">
    </div>

    <button type="submit" class="btn btn-success">Submit</button>
</form>
</div>
</body>
</html>
