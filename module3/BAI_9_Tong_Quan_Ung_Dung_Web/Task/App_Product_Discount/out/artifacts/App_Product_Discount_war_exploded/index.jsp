<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/5/2021
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>$Title$</title>
    <link rel="stylesheet" href="Bootstrap4/css/bootstrap.css">
  </head>
  <body>
  <div class="container ">
  <form action="/App_Product_Discount_war_exploded/display_Discount" method="post">
    <div class="form-group">
      <label >Product Description</label>
      <input type="text" class="form-control" name="description">

    </div>
    <div class="form-group">
      <label >List Price híhish hí hí</label>
      <input type="text" class="form-control" name="listPrice">
    </div>
    <div class="form-group">
      <label >Discount Percent</label>
      <input type="text" class="form-control" name="Discount_Percent" >
    </div>

    <button type="submit" class="btn btn-primary">Calculate Discount </button>
  </form>
  </div>
  </body>
</html>
