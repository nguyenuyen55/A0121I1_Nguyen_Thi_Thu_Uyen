<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/31/2021
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
<link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">
<style>
    .table th {
        text-align: center;
    }
    .table td{
        text-align: center;
    }

</style>

</head>
<body>
<jsp:include page="/layoutCommon/header.jsp"/>
<div class="container " >

<%--<jsp:include page="/layoutCommon/contentLeft.jsp"></jsp:include>--%>
        <div class="content col-sm-12 ">
            <h3>Quản lí khách hàng</h3>
            <div class="row">
            <button class="btn btn-success mt-2 mb-2 ml-3 " type="button" onclick="window.location.href='/customer?action=addCustomer'">Create</button>
            <form class="form-inline my-2 my-lg-0 ml-3" method="get" action="/customer">
                <input type="hidden" value="searchCus" name="action">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" name="search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Search</button>
            </form>
            </div>
            <table class="table table-striped table-bordered" style="width:100%">
    <thead>
    <tr>
    <th>id</th>
    <th>kiểu khách hàng</th>
    <th>Tên khách hàng</th>
    <th>Ngày sinh</th>
    <th>Giới Tính</th>
    <th>Cmnd</th>
    <th>Số Điện Thoại</th>
    <th>Email</th>
    <th>Địa Chỉ</th>
        <th>#</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.customer_id}</td>
            <td>${customer.customer_type_id}</td>
            <td>${customer.customer_name}</td>
            <td>${customer.customer_birthday}</td>
            <td><c:if test="${customer.customer_gender == 1}">
                <c:out value="Nam"></c:out>
            </c:if>
                <c:if test="${customer.customer_gender == 0}">
                    <c:out value="Nữ"></c:out>
                </c:if>

            </td>
            <td>${customer.customer_id_card}</td>
            <td>${customer.customer_phone}</td>
            <td>${customer.customer_email}</td>
            <td>${customer.customer_address}</td>
            <td><button class="btn btn-primary" onclick="window.location.href='/customer?action=updateCustomer&id=${customer.customer_id}'" type="button">Edit</button>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal${customer.customer_id}">
               Delete
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal${customer.customer_id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                            <button class="btn btn-danger" onclick="window.location.href='/customer?action=deleteCustomer&id=${customer.customer_id}'" type="button">Có</button>
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
</div>
<jsp:include page="/layoutCommon/footer.jsp"></jsp:include>
<script rel="script" src="/static/jquery/jquery-3.5.1.min.js"></script>
<script rel="script" src="/static/jquery/popper.min.js"></script>
<script rel="script" src="/static/Bootstrap4/js/bootstrap.js"></script>
    </body>
</html>
