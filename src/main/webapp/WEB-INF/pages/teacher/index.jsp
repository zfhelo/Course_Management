<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/navs.jsp"%>
<title>首页</title>
<link href="css/index.css" rel="stylesheet">

<!--搜索-->
<div class="container">
    <div style="margin-top: 15px">
        <div class="form-inline my-2 my-lg-0">
            <form>
                <button type="button" class="btn btn-outline-success my-2 my-sm-0 my_btn" style="margin-left: 10px" data-toggle="modal" data-target="#manager_modal" id="btn_manager" onclick="manger('teacher')">管理课程</button>
                <button type="button" class="btn btn-outline-success my-2 my-sm-0 my_btn" style="margin-left: 10px"  data-toggle="modal" data-target="#create_course_modal">创建课程</button>
            </form>

        </div>
    </div>
    <!--管理modal-->
    <%@include file="../include/manager_modal.jsp"%>
    <!-- 创建课程modal -->
    <div class="modal fade" id="create_course_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">创建课程</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-inline">
                            <label class="w-25" for="name">名称</label>
                            <input type="text" class="form-control" id="name">
                            <small id="create_courser_success" style="color: green"></small>
                        </div>
                        <div class="form-inline">
                            <label class="w-25" for="number">课程号</label>
                            <input type="text" class="form-control" id="number">
                            <small style="color: red" id="create_courser_error"></small>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="location.reload()">关闭</button>
                    <button type="button" class="btn btn-primary" id="btn_create_course">创建</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!--展示课程-->
<div class="container" style="margin-top: 20px">
    <div class="container main float-left">
        <div align="left" class="label">我的课程</div>
        <hr style=" border-top:outset #009933; margin-top: 0px"/>
        <!-- 课程 -->
        <c:forEach items="${TEACHER.courses}" var="course">
            <div class="card float-left card_width">
                <img src="${course.image}" class="card-img-top course_cover" alt="图片">
                <div class="card-body">
                    <h5 class="card-title">${course.name}</h5>
                    <p class="card-text">ID：${course.number}</p>
                    <a href="teacher/member?id=${course.id}" class="btn btn-primary">进入课程</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
    <script>
        $(function () {
            // 创建课程
            $("#btn_create_course").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/createCourse",
                    type:"POST",
                    dataType:"json",
                    data:{
                        "number":$("#number").val(),
                        "name":$("#name").val(),
                        "tid":${TEACHER.id}
                    },
                    success:function (data) {
                        if (data.code === 200) {
                            $("#create_courser_success").text(data.msg);
                            $("#create_courser_error").text("");
                        } else {
                            // 创建失败
                            $("#create_courser_error").text(data.msg);
                            $("#create_courser_success").text("");
                        }
                    }
                });
            });
        })
    </script>
</html>