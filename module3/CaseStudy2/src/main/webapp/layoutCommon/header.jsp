
<%--
  Created by IntelliJ IDEA.
  User: Thu Uyen
  Date: 8/30/2021
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <div class="row bg-success ">
        <div class="col-md-4 col-4  "><p class="">
            <div class="pl-4">
                <img src="/static/image/images.jpg" alt="" width="50px" height="50px">
                <p  style="text-align: left">Logo</p></div></div>
        <div class="col-md-8 col-8  "><p class="mt-3" style="text-align: right">Nguyễn Thị Thu Uyên<p></div>
    </div>
    <div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto ml-5">
                    <li class="nav-item active">
                        <a class="nav-link " href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/employee">Employee</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="/customer">Customer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="/service">Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="/contract">Contract</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link " href="/contractDetail">ContractDetail</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
</header>
