<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 9/3/2021
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Service</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>
<jsp:include page="/layoutCommon/header.jsp"/>
<div class="container">
<button class="btn btn-success mb-3" onclick="window.location.href='/service?action=addService'">Create</button>
<table class="table table-striped table-inverse table-responsive">
    <thead class="thead-inverse">
    <tr>
        <th>id service</th>
        <th> Service Name</th>
        <th>dien tich</th>
        <th>so nguoi o</th>
        <th>kieu thue</th>
        <th>loai service</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${services}" var="service">
        <tr>
            <td >${service.service_id}</td>
            <td >${service.service_name}</td>
            <td >${service.service_area}</td>
            <td >${service.rent_id}</td>
            <td >${service.service_people}</td>
            <td >${service.service_type_id}</td>
        </tr>


    </c:forEach>

    </tbody>
</table>
</div>
<jsp:include page="/layoutCommon/footer.jsp"></jsp:include>

</body>
</html>
