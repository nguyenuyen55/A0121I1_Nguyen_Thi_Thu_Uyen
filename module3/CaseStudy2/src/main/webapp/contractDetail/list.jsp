<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 9/5/2021
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Contract Detail</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
</head>
<body>

<jsp:include page="/layoutCommon/header.jsp"/>

<div class="container">

    <h3>Quản lí Hợp đồng</h3>
    <div class="row">
        <button class="btn btn-success mb-3" onclick="window.location.href='/contractDetail?action=add'">Create</button>

    </div>

    <table class="table table-striped table-inverse table-responsive">
        <thead class="thead-inverse">
        <tr>
            <th>id contract detail</th>
            <th> id contract</th>
            <th> attach service id</th>
            <th> quantity</th>

        </tr>
        </thead>

        <tbody>
        <c:forEach items="${contracts}" var="contract">
            <tr>
                <td >${contract.idDetail}</td>
                <td >${contract.contractId}</td>
                <td >${contract.serviceid}</td>
                <td >${contract.quantity}</td>
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

