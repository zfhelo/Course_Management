<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="../include/navs.jsp"%>
<title>首页</title>
<link href="css/index.css" rel="stylesheet">
<!--搜索框-->
    <div class="container">
        <div style="margin-top: 15px">
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="课程号" aria-label="Search" id="search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="button" data-toggle="modal" data-target="#search_modal" id="btn_search">查找</button>
                <button class="btn btn-outline-success my-2 my-sm-0 my_btn" style="margin-left: 10px" type="button" data-toggle="modal" data-target="#manager_modal" id="btn_manager" onclick="manger('student')">管理课程</button>
            </form>
        </div>
        <!--管理modal-->
        <%@include file="../include/manager_modal.jsp"%>
        <!-- search弹出框 -->
        <%@include file="../include/search_modal.jsp"%>
    </div>

<!--主体-->
    <div class="container" style="margin-top: 20px">
        <div class="container main float-left">
            <div align="left" class="label">我的课程</div>
                <hr style=" border-top:outset #009933; margin-top: 0px"/>
            <!-- 课程 -->
            <c:forEach items="${STUDENT.courses}" var="course">
                <div class="card float-left card_width shadow-lg bg-white rounded">
                    <img src="${course.image}" class="card-img-top course_cover" alt="">
                    <div class="card-body">
                        <h5 class="card-title">${course.name}</h5>
                        <p class="card-text">ID：${course.id}</p>
                        <a href="student/member?id=${course.id}" class="btn btn-primary">进入课程</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>