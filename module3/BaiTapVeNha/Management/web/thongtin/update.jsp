<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/28/2021
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Cap Nhat</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body><div class="container">
    <button class="btn btn-primary " onclick="window.location.href='/thongtin'">Quay về</button>
<form method="post">

    <table class="table">
        <tbody>

        <tr>
            <th>ngay to chuc</th>
            <td>   <input type="date" class="form-control" id="name" name="ngayToChuc" value="${thongtin.getNgayToChuc()}" > </td>
        </tr>
        <tr>
            <th>Ten co dau</th>
            <td>   <input type="text" class="form-control" name="tenCoDau" value="${thongtin.tenCoDau}"> </td>
        </tr>
        <tr>
            <th>ten chu re</th>
            <td>   <input type="text" class="form-control"  name="tenChuRe" value="${thongtin.tenChuRe}" > </td>
        </tr>
        <tr>
            <th>so luong</th>
            <td>   <input type="number" class="form-control"  name="soLuongBan" value="${thongtin.soLuongBan}"> </td>
        </tr>

        <tr>
            <th>don gia</th>
            <td>   <input type="number" class="form-control"  name="donGia" value="${thongtin.donGia}"> </td>
        </tr>
        <tr>
            <th>dich vu di kiem</th>
            <td>
                <select class="form-control" name="dichVuDiKem" >
                    <c:forEach items="${dichVus}" var="dichVu">
                        <c:if test="${dichVu.id_DichVu == thongtin.getDichVuDiKem()}">
                            <option selected value="${dichVu.id_DichVu}">${dichVu.tenDichVu}</option>
                        </c:if>
                        <c:if test="${dichVu.id_DichVu != thongtin.getDichVuDiKem()}">
                            <option value="${dichVu.id_DichVu}">${dichVu.tenDichVu}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <th>tien no dat coc</th>
            <td>   <input type="number" class="form-control" name="tienNoDatCoc" value="${thongtin.tenNoDatCoc}"> </td>
        </tr>
        <tr>
            <th>tien no thanh toan</th>
            <td>   <input type="number" class="form-control"  name="TienNoThanhToan" value="${thongtin.tienNoThanhToan}"> </td>
        </tr>
        <tr>
            <th>ngay dat coc</th>
            <td>   <input type="date" class="form-control"name="ngayDatCoc" value="${thongtin.ngayDatCoc}"> </td>
        </tr>
        <tr>
            <th>ngay thanh toan</th>
            <td>   <input type="date" class="form-control"  name="NgayThanhToan" value="${thongtin.ngayThanhToan}"> </td>
        </tr>
        <tr>
            <th>ghi chu</th>
            <td>   <input type="text" class="form-control"name="ghichu" value="${thongtin.ghiChu}" > </td>
        </tr>
        <tr>
            <th>trang thai</th>
            <td>   <input type="text" class="form-control"  name="trangThai" value="${thongtin.trangThai}" > </td>
        </tr>
        <tr>
            <td>
                <button class="btn-success btn" type="submit">Cập Nhật</button>
            </td>
        </tr>
        </tbody>
    </table>
</form></div>
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
