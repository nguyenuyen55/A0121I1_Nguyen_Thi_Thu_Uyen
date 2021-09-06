<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 9/5/2021
  Time: 8:07 PM
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

    <h3>Quản lí Hợp đồng</h3>
    <div class="row">
        <button class="btn btn-success mb-3" onclick="window.location.href='/contract?action=add'">Create</button>

    </div>

    <table class="table table-striped table-inverse table-responsive">
        <thead class="thead-inverse">
        <tr>
            <th>id contract</th>
            <th> Start Date</th>
            <th> End Date</th>
            <th> Deposit</th>
            <th> Total</th>
            <th> Employee id</th>
            <th> customer id</th>
            <th> service id</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contracts}" var="contract">
            <tr>
                <td >${contract.contacId}</td>
                <td >${contract.dateStart}</td>
                <td >${contract.dateEnd}</td>
                <td >${contract.deposit}</td>
                <td >${contract.contractTotal}</td>
                <td >${contract.employeeId}</td>
                <td >${contract.customerId}</td>
                <td >${contract.serviceId}</td>
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

