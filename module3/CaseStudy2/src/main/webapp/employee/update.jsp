<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 9/5/2021
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>

<jsp:include page="/layoutCommon/header.jsp"/>
<div class="container">

    <form class="border border-primary mt-1 p-2 rounded" method="post">
        <div class="alert alert-primary " role="alert">
            <strong>Update Employee</strong>
        </div>
        <div class="form-group">
            <label for="nameEmployee">Name Employee</label>
            <input type="text" class="form-control" id="nameEmployee" placeholder="Enter Name Employee" value="${employee.employeeName}" name="nameEmployee">
        </div>
        <div class="form-group">
            <label for="birthDay">BirthDay</label>
            <input type="date" class="form-control" id="birthDay" placeholder="dd/mm/yyyy" value="${employee.dateBirthday}" name="birthDay">
        </div>
        <div class="form-group">
            <label for="idcard">Id Card</label>
            <input type="number" class="form-control" id="idcard" placeholder="Enter number Id Card" value="${employee.idCard}" name="idCard">
        </div>
        <div class="form-group">
            <label for="salary">Salary</label>
            <input type="number" class="form-control" id="salary" placeholder="Enter Number Salary" value="${employee.salary}"name="salary">
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="number" class="form-control" id="phone" value="${employee.phone}" name="phone" >
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email"  value="${employee.email}" name="email">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" placeholder="Enter address" value="${employee.address}" name="address">
        </div>
        <div class="form-group">
            <label for="position">Position</label>
            <select class="form-control" id="position" name="positionId">

                <option value="1" ${employee.postionId ==1 ?"selected":""} >Lễ tân</option>
                <option value="2"  ${employee.postionId ==2 ?"selected":""} >Phục vụ</option>
                <option value="3"  ${employee.postionId ==3 ?"selected":""} >Chuyên viên</option>
                <option value="4"  ${employee.postionId ==4 ?"selected":""} >Giám sát</option>
                <option value="5"  ${employee.postionId ==5 ?"selected":""} >Quản lí</option>
                <option value="6"  ${employee.postionId ==6 ?"selected":""} >Giám đốc</option>
            </select>
        </div>
        <div class="form-group">
            <label for="educationId">Education degree</label>
            <select class="form-control" id="educationId" name="educationId">
                <option value="1"  ${employee.educationId ==1 ?"selected":""} >Trung cấp</option>
                <option value="2" ${employee.educationId ==2 ?"selected":""} >Cao Đẳng</option>
                <option value="3" ${employee.educationId ==3 ?"selected":""} >Đại Học</option>
                <option value="4" ${employee.educationId ==4 ?"selected":""} >Sau Đại Học</option>
            </select>
        </div>
        <div class="form-group">
            <label for="division">Division</label>
            <select class="form-control" id="division" name="division">
                <option value="1" ${employee.divisionId ==1 ?"selected":""} >Sale-Marketin</option>
                <option value="2" ${employee.divisionId ==2 ?"selected":""}>Hành chính</option>
                <option value="3" ${employee.divisionId ==3 ?"selected":""}>Phục vụ</option>
                <option value="4" ${employee.divisionId ==4 ?"selected":""}>Quản lí</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
<jsp:include page="/layoutCommon/footer.jsp"></jsp:include>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
