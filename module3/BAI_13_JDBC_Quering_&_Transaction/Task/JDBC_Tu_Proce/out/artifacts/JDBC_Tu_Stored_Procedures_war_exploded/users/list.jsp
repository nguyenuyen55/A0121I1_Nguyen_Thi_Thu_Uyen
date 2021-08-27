<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/24/2021
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>
<header><nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="col-md-8 ">
    <a class="navbar-brand" href="#">Navbar</a>
    </div>
    <div class="col-md-8 ">
        <form class="form-inline my-2 my-lg-0">
            <input type="hidden" value="search" name="action">
            <input class="form-control mr-sm-2" type="number"  placeholder="Search" name="searchId" aria-label="Search" required>
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav></header>
<button class="btn btn-success" onclick="window.location.href='/users?action=create'" >Create</button>
<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>country</th>
        <th>#</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${usersId != null}">
        <tr>
            <td scope="row">${usersId.getId()}</td>
            <td>${usersId.name}</td>
            <td>${usersId.email}</td>
            <td>${usersId.country}</td>
            <td>
                <button class="btn btn-primary" onclick="window.location.href='/users?action=update&id=${usersId.id}'">Edit</button>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal${usersId.id}">
                    Delete
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal${usersId.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel${usersId.id}">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <b>Bạn có muốn xoá nó ${usersId.id}không ?</b>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Không</button>
                                <button class="btn btn-danger" onclick="window.location.href='/users?action=delete&id=${usersId.id}'">Có</button>
                            </div>
                        </div>
                    </div>
                </div>


            </td>
        </tr>
    </c:if>
<c:if test="${users != null}">
    <c:forEach var="user" items="${users}">
    <tr>
        <td scope="row">${user.getId()}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.country}</td>
        <td>
            <button class="btn btn-primary" onclick="window.location.href='/users?action=update&id=${user.id}'">Edit</button>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal${user.id}">
                Delete
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal${user.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                          <b>Bạn có muốn xoá nó ${user.id}không ?</b>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Không</button>
                            <button class="btn btn-danger" onclick="window.location.href='/users?action=delete&id=${user.id}'">Có</button>
                        </div>
                    </div>
                </div>
            </div>


        </td>
    </tr>
    </c:forEach></c:if>
    </tbody>
</table>
<!-- script-->
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/jquery/popper.min.js"></script>
<script src="/static/Bootstrap4/js/bootstrap.js"></script>
</body>
</html>
