<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/10/2021
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List products</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
<style>
    /*table th , table td{*/
    /*    width: 100px;*/
    /*}*/
</style>
</head>
<body>
<%--<body>--%>

<%--<header>--%>
<%--    <nav class="navbar navbar-expand-md navbar-dark"--%>
<%--         style="background-color: blue">--%>
<%--        <div>--%>
<%--            <a href="https://www.xadmin.net" class="navbar-brand"> User--%>
<%--                Management Application </a>--%>
<%--        </div>--%>

<%--        <ul class="navbar-nav">--%>
<%--            <li><a href="<%=request.getContextPath()%>/list"--%>
<%--                   class="nav-link">Users</a></li>--%>
<%--        </ul>--%>
<%--    </nav>--%>
<%--</header>--%>
<%--<br>--%>

<%--<div class="row">--%>
<%--    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->--%>

<%--    <div class="container">--%>
<%--        <h3 class="text-center">List of Users</h3>--%>
<%--        <hr>--%>
<%--        <div class="container text-left">--%>

<%--            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add--%>
<%--                New User</a>--%>
<%--        </div>--%>
<%--        <br>--%>
<%--        <table class="table table-bordered">--%>
<%--            <thead>             --%>
<%--            <tr>--%>
<%--                <th>ID</th>--%>
<%--                <th>Name</th>--%>
<%--                <th>Email</th>--%>
<%--                <th>Country</th>--%>
<%--                <th>Actions</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>

<%--            <c:forEach var="user" items="${listUser}">--%>

<%--                <tr>--%>
<%--                    <td><c:out value="${user.id}" /></td>--%>
<%--                    <td><c:out value="${user.name}" /></td>--%>
<%--                    <td><c:out value="${user.email}" /></td>--%>
<%--                    <td><c:out value="${user.country}" /></td>--%>
<%--                    <td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>--%>
<%--                        &nbsp;&nbsp;&nbsp;&nbsp; <a--%>
<%--                                href="delete?id=<c:out value='${user.id}' />">Delete</a></td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>

<%--            </tbody>--%>

<%--        </table>--%>
<%--    </div>--%>
<%--</div>--%>
</body>



<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: green">
        <div>
            <a href="#" class="navbar-brand">
                Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/products"
                   class="nav-link">Products</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container ">

    <div class="row">
        <div class="col-lg-1 ">
        <button type="button" class="btn btn-success mb-2" onclick="window.location.href='/products?action=create'" >Create</button>
        </div>

        <div class="col-lg-10  ">
            <form method="get">

        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2" name="search" id="search">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" onclick="window.location.href='/products?action=search&namesearch='+document.getElementById('search').value" type="button">Button</button>
            </div>
        </div>
            </form>
        </div>
        </form>
    </div>
    <table class="table text-center">

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Producer</th>
            <th>Tháo tác</th>
        </tr>

        <tbody>
        <c:if test="${message != null}">
            <script>
                window.alert("${message}")
            </script>
        </c:if>
        <c:forEach items="${products}" var="product">
            <tr>
                <td >${product.getIdProduct()}</td>
                <td>${product.getNameProduct()}</td>
                <td>${product.getDescription()}</td>
                <td>${product.getPriceProduct()}</td>
                <td>${product.getProducer()}</td>
                <td >
                    <button type="button" onclick="window.location.href='/products?action=update&id=${product.getIdProduct()}'" class="btn btn-info">Edit</button>
                    <button type="button" onclick="window.location.href='/products?action=delete&id=${product.getIdProduct()}'" class="btn btn-danger">Delete</button>
                    <button type="button" onclick="window.location.href='/products?action=view&id=${product.getIdProduct()}'" class="btn btn-warning">View</button>

            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


</body>
</html>
