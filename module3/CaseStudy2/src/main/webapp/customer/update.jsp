<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 9/1/2021
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cật Nhật Thông Tin Khách Hàng</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">

</head>
<body>
<jsp:include page="/layoutCommon/header.jsp"/>
<div class="container">

    <form class="border border-primary mt-1 p-2 rounded" method="post">
        <div class="alert alert-primary " role="alert">
            <strong>Cập Nhật thành viên</strong>
        </div>
        <div class="form-group">
            <label for="namecustomer">Họ và Tên </label>
            <input type="text" class="form-control" id="namecustomer" value="${customer.customer_name}" placeholder="Họ và Tên khách hàng" name="nameCustomer">
        </div>
        <div class="form-group">
            <label for="birthday">Ngày sinh</label>
            <input type="date" class="form-control" id="birthday" value="${customer.customer_birthday}" name="birthdayCus">
        </div>
        <div class="form-group">
            <label for="gender">Giới tính</label>
            <select class="form-control" id="gender" name="gender">
            <c:if test="${customer.customer_gender ==1}">
                <option value="1" selected>Nam</option>
                <option value="0">Nữ</option>
            </c:if>
                <c:if test="${customer.customer_gender ==0 }">
                    <option value="1" >Nam</option>
                    <option value="0" selected>Nữ</option>
                </c:if>

            </select>
        </div>
        <div class="form-group">
            <label for="idCard">Mã thẻ căn cước</label>
            <input type="number" class="form-control" value="${customer.customer_id_card}" id="idCard" name="cardCus">
        </div>
        <div class="form-group">
            <label for="phone">Số điện thoại</label>
            <input type="number" class="form-control" value="${customer.customer_phone}" id="phone" name="phoneCus">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" value="${customer.customer_email}" id="email" name="emailCus" >
        </div>
        <div class="form-group">
            <label for="address">Địa chỉ</label>
            <input type="text" class="form-control"value="${customer.customer_address}" id="address" name="addressCus">
        </div>
        <div class="form-group">
            <label for="id_type_customer">Loại khách hàng</label>
            <select class="form-control" id="id_type_customer" name="serviceCus">
                <c:forEach items="${customerTypes}" var="customerType">
                    <c:if test="${customerType.customertypeId == customer.customer_type_id}">
                        <option value="${customerType.customertypeId}" selected>${customerType.customerTypeName}</option>
                    </c:if>
                    <c:if test="${customerType.customertypeId != customer.customer_type_id}">
                        <option value="${customerType.customertypeId}" >${customerType.customerTypeName}</option>
                    </c:if>
                </c:forEach>
            </select>
            <input type="hidden" name="id" value="${customer.customer_id}">
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
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