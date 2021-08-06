<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/4/2021
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link  rel="stylesheet" href="Bootstrap4/css/bootstrap.css">
  </head>
  <body>
  <div class="container">
    <form method="post" action="/login">
      <div class="form-group">
        <label >Email address</label>
        <input type="text" name="username" class="form-control" >
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1">
      </div>
      <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
  </body>
</html>
