<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/5/2021
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="Bootstrap4/css/bootstrap.css"/>

  </head>
  <body>
  <div class="container">
<form action="/Translate_basic_war_exploded/translate" method="post">
  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="Enter words want find" aria-label="Enter words want find" aria-describedby="button-addon2" name="search">
    <div class="input-group-append">
      <input class="btn btn-outline-secondary bg-warning" type="submit" value="Search" id="button-addon2" />
    </div>
  </div>
</form>
  </div>
  </body>
</html>
