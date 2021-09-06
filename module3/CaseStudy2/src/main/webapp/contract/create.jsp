<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 9/5/2021
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">

</head>
<body>
<jsp:include page="/layoutCommon/header.jsp"/>
<div class="container">
    <form class="border border-primary mt-1 p-2 rounded" method="post">
        <div class="alert alert-primary " role="alert">
            <strong>Create Contract</strong>
        </div>
        <div class="form-group">
            <label for="dateStart">Date Start </label>
            <input type="date" class="form-control" id="dateStart" placeholder="mm/dd/yyyy" name="dateStart">
        </div>
        <div class="form-group">
            <label for="dateEnd">Date End</label>
            <input type="date" class="form-control" id="dateEnd" placeholder="mm/dd/yyyy" name="dateEnd">
        </div>
        <div class="form-group">
            <label for="deposit">Deposit </label>
            <input type="number" class="form-control" id="deposit" name="deposit" >
        </div>
        <div class="form-group">
            <label for="total">Total</label>
            <input type="number" class="form-control" id="total" name="total">
        </div>

        <div class="form-group">
            <label for="id_employee">id employee</label>
            <select class="form-control" id="id_employee" name="idemployee">
                    <option value="1" selected>Thang</option>
                    <option value="2">Chinh</option>
                    <option value="3">Hang</option>
            </select>
        </div>
        <div class="form-group">
            <label for="idcustomer">id customer</label>
            <select class="form-control" id="idcustomer" name="idcustomer">
                <option value="113" selected>nguyen bich tien</option>
                <option value="114">le huu ha</option>
                <option value="115">nguyen dang hoa thien</option>
            </select>
        </div>
        <div class="form-group">
            <label for="idservice">id customer</label>
            <select class="form-control" id="idservice" name="idservice">
                <option value="1" selected> vollu</option>
                <option value="100">room</option>
                <option value="101">service</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary"> Create </button>
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
