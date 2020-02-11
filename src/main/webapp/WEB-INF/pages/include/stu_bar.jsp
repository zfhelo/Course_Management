<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="navs.jsp"%>
<!--图片-->
<div class="container-fluid">
    <img src="images/web/background.jpg" style="width: 100%; height: 120px">
</div>

<!--导航栏-->
<div class="container">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link" href="student/member" id="member">成员</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="student/resources" id="resources">资源</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="student/paper" id="paper">试题</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="student/discuss" id="discuss">讨论</a>
        </li>
    </ul>
</div>
<script>
    $(function () {
        // 设置为活动
        $("#${BAR_INDEX}").addClass("active");
        // 禁止点击
        $("#${BAR_INDEX}").prop("href","javascript:volid(0);");
    });
</script>