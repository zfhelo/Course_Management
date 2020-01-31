<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
    <span class="navbar-brand" href="">Welcome！</span>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <c:if test="${STUDENT != null}">
                    <a class="nav-link" href="student/index">首页 <span class="sr-only">(current)</span></a>
                </c:if>
                <c:if test="${TEACHER != null}">
                    <a class="nav-link" href="teacher/index">首页 <span class="sr-only">(current)</span></a>
                </c:if>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle disabled" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    资源库
                </a>
                <div class="dropdown-menu" aria-labelledby="navbar  DropdownMenuLink">
                    <a class="dropdown-item" href="#">数据结构</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <img src="images/web/学习中心.svg" class="rounded-circle" style="height: 40px; width: 40px"/>
        <a class="nav-link text-black-50" href="#">个人中心</a>
        <a class="nav-link text-black-50" href="#">退出</a>
    </div>
</nav>