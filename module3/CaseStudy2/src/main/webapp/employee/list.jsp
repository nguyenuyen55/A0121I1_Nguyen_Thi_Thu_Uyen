<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 9/5/2021
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">

</head>
<body>
<jsp:include page="/layoutCommon/header.jsp"/>

<div class="container">

    <h3>Quản lí Nhân viên</h3>
    <div class="row">
        <button class="btn btn-success mb-3" onclick="window.location.href='/employee?action=add'">Create</button>
        <form class="form-inline my-2 my-lg-0 ml-3" method="get" action="/employee">
            <input type="hidden" value="search" name="action">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" name="search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search</button>
        </form>
    </div>

    <table class="table table-striped table-inverse table-responsive">
        <thead class="thead-inverse">
        <tr>
            <th>id employee</th>
            <th> Name Employee</th>
            <th>BirthDay</th>
            <th>Salary</th>
            <th>Phone </th>
            <th>Address</th>
            <th>#</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td >${employee.employeeId}</td>
                <td >${employee.employeeName}</td>
                <td >${employee.dateBirthday}</td>
                <td >${employee.salary}</td>
                <td >${employee.phone}</td>
                <td >${employee.address}</td>
                <td><button class="btn btn-primary" onclick="window.location.href='/employee?action=update&id=${employee.employeeId}'" type="button">Edit</button>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal${employee.employeeId}">
                        Delete
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal${employee.employeeId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Bạn có muốn xoá không
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Không</button>
                                    <button class="btn btn-danger" onclick="window.location.href='/employee?action=delete&id=${employee.employeeId}'" type="button">Có</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </td>
            </tr>


        </c:forEach>

        </tbody>
    </table>
</div>
<jsp:include page="/layoutCommon/footer.jsp"></jsp:include>
<script rel="script" src="/static/jquery/jquery-3.5.1.min.js"></script>
<script rel="script" src="/static/jquery/popper.min.js"></script>
<script rel="script" src="/static/Bootstrap4/js/bootstrap.js"></script>
</body>
</html>
