<%@ page import="service.IServiceThongtin" %>
<%@ page import="service.ImIServiceUser" %>
<%@ page import="bean.DichVu" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/27/2021
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h3 style="text-align: center">Quản lý Thông Tin Tiệc Cưới</h3>
<button type="button" name="" onclick="window.location.href='/thongtin?action=create'" id="" class="btn btn-primary">Đăng kí</button>

<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>ngay to chuc</th>
        <th>Ten co dau</th>
        <th>ten chu re</th>
        <th>so luong</th>
        <th>don gia</th>
        <th>dich vu di kiem</th>
        <th>tien no dat coc</th>
        <th>tien no thanh toan</th>
        <th>ngay dat coc</th>
        <th>ngay thanh toan</th>
        <th>trang thai</th>
        <th>#</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${thongtins}" var="thongtin">
    <tr>

        <td >${thongtin.id}</td>
        <td>${thongtin.getNgayToChuc()}</td>
        <td>${thongtin.tenCoDau}</td>
        <td>${thongtin.tenChuRe}</td>
        <td>${thongtin.soLuongBan}</td>
        <td>${thongtin.donGia}</td>
        <td>
        <c:set var="myTest" value="${thongtin.getDichVuDiKem()}"/>
        <% int id = (int) pageContext.getAttribute("myTest"); %>
        <%
            IServiceThongtin iServiceThongtin = new ImIServiceUser();
            DichVu dv= iServiceThongtin.selectByIdDicVu(id);
            out.print(dv.getTenDichVu());
        %>     </td>
        <td>${thongtin.tenNoDatCoc}</td>
        <td>${thongtin.tienNoThanhToan}</td>
        <td>${thongtin.ngayDatCoc}</td>
        <td>${thongtin.ngayThanhToan}</td>
        <td>${thongtin.trangThai}</td>
        <td>
            <button class="btn btn-primary" onclick="window.location.href='/thongtin?action=update&id=${thongtin.id}'">Sửa</button>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal${thongtin.id}">
             Xoá
            </button>
            <!-- Modal -->
            <div class="modal fade" id="exampleModal${thongtin.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel${thongtin.id}">Modal title</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <b>Bạn có muốn xoá thông tin của cô dâu ${thongtin.tenCoDau} và chú rễ ${thongtin.tenChuRe} có ${thongtin.id} không ?</b>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Không</button>
                            <button class="btn btn-danger" onclick="window.location.href='/thongtin?action=delete&id=${thongtin.id}'">Có</button>
                        </div>
                    </div>
                </div>
            </div>
            <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModalx${thongtin.id}">
               Xem
            </button>
            <!-- Modal -->
            <div class="modal fade" id="exampleModalx${thongtin.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabelx${thongtin.id}">Xem chi tiết</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <table class="table">
                                <tbody>

                                <tr>
                                    <th>ngay to chuc</th>
                                    <td>   <input type="date" class="form-control" id="name" name="ngayToChuc" value="${thongtin.getNgayToChuc()}" readonly> </td>
                                </tr>
                                <tr>
                                    <th>Ten co dau</th>
                                    <td>   <input type="text" class="form-control" name="tenCoDau" value="${thongtin.tenCoDau}" readonly> </td>
                                </tr>
                                <tr>
                                    <th>ten chu re</th>
                                    <td>   <input type="text" class="form-control"  name="tenChuRe" value="${thongtin.tenChuRe}" readonly> </td>
                                </tr>
                                <tr>
                                    <th>so luong</th>
                                    <td>   <input type="number" class="form-control"  name="soLuongBan" value="${thongtin.soLuongBan}" readonly> </td>
                                </tr>

                                <tr>
                                    <th>don gia</th>
                                    <td>   <input type="number" class="form-control"  name="donGia" value="${thongtin.donGia}" readonly> </td>
                                </tr>
                                <tr>
                                    <th>dich vu di kiem</th>
                                    <td>
                                        <select class="form-control" name="dichVuDiKem" readonly>
                                            <c:forEach items="${dichVus}" var="dichVu">
                                                <c:if test="${dichVu.id_DichVu == thongtin.getDichVuDiKem()}">
                                                    <option selected value="${dichVu.id_DichVu}">${dichVu.tenDichVu}</option>
                                                </c:if>
                                                <c:if test="${dichVu.id_DichVu != thongtin.getDichVuDiKem()}">
                                                    <option disabled value="${dichVu.id_DichVu}">${dichVu.tenDichVu}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>

                                <tr>
                                    <th>tien no dat coc</th>
                                    <td>   <input type="number" class="form-control" name="tienNoDatCoc" value="${thongtin.tenNoDatCoc}" readonly> </td>
                                </tr>
                                <tr>
                                    <th>tien no thanh toan</th>
                                    <td>   <input type="number" class="form-control"  name="TienNoThanhToan" value="${thongtin.tienNoThanhToan}" readonly> </td>
                                </tr>
                                <tr>
                                    <th>ngay dat coc</th>
                                    <td>   <input type="date" class="form-control"name="ngayDatCoc" value="${thongtin.ngayDatCoc}" readonly> </td>
                                </tr>
                                <tr>
                                    <th>ngay thanh toan</th>
                                    <td>   <input type="date" class="form-control"  name="NgayThanhToan" value="${thongtin.ngayThanhToan}" readonly> </td>
                                </tr>
                                <tr>
                                    <th>ghi chu</th>
                                    <td>   <input type="text" class="form-control"name="ghichu" value="${thongtin.ghiChu}" readonly> </td>
                                </tr>
                                <tr>
                                    <th>trang thai</th>
                                    <td>   <input type="text" class="form-control"  name="trangThai" value="${thongtin.trangThai}" readonly > </td>
                                </tr>

                                </tbody>
                            </table>


                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">ok</button>

                        </div>
                    </div>
                </div>
            </div>



        </td>

    </tr>
    </c:forEach>
    </tbody>
</table>





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
