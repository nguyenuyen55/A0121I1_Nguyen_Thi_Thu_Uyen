<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 9/5/2021
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Contract Detail</title>
    <link rel="stylesheet" href="/static/Bootstrap4/css/bootstrap.css">

</head>
<body>
<jsp:include page="/layoutCommon/header.jsp"/>
<div class="container">
    <form class="border border-primary mt-1 p-2 rounded" method="post">
        <div class="alert alert-primary " role="alert">
            <strong>Create Contract Detail</strong>
        </div>

        <div class="form-group">
            <label for="idContract">id contract</label>
            <select class="form-control" id="idContract" name="idContract">
                <option value="440" selected>440</option>
                <option value="441">441</option>
                <option value="442">442</option>
            </select>
        </div>
        <div class="form-group">
            <label for="idservice">id Service attach</label>
            <select class="form-control" id="idservice" name="idservice">
                <option value="330" selected>massage</option>
                <option value="331">karake</option>
                <option value="332">Food</option>
            </select>
        </div>

        <div class="form-group">
            <label for="quantity">Quantity</label>
            <input type="number" class="form-control" id="quantity" name="quantity">
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

