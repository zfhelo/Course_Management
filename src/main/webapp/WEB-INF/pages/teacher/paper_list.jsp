<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="../include/tea_bar.jsp"%>
<title>试题详情</title>
        <div class="container">
            <c:forEach items="${paper}" varStatus="s" step="3">
                    <div class="list-group list-group-horizontal">
                        <c:forEach items="${paper}" begin="${s.index}" end="${s.index + 2}" var="q">
                            <c:if test="${q.status == 0}" var="a">
                                <a href="teacher/paperDetails?id=${q.id}&sid=${q.user.id}" class="list-group-item list-group-item-action list-group-item-light">${q.user.nickname}</a>
                            </c:if>
                            <c:if test="${!a}">
                                <a href="teacher/paperDetails?id=${q.id}&sid=${q.user.id}" class="list-group-item list-group-item-action list-group-item-success">${q.user.nickname}</a>
                            </c:if>
                        </c:forEach>
                    </div>
            </c:forEach>
        </div>
    </body>
<script>
    let switchHide = function (id) {
        let $1 = $(id);
        var status = 0;
        if (id.checked) {
            // 显示
            status = 1;
        }
        // 更改状态
        $.ajax({
            url:"${pageContext.request.contextPath}/teacher/hide",
            data:{
                "id":$1.val(),
                "hide":status
            },
            type:"POST",
            dataType:"json",
            success:function (data) {
                // 失败
                if (data.code !== 200) {
                    alert(data.msg)
                }
            }
        })
    };

    let switchEnable = function (id) {
        let $1 = $(id);
        let status = 0;
        if (id.checked) {
            status = 1;
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/teacher/enable",
            type: "POST",
            data: {
                "id":$1.val(),
                "enable":status
            },
            dataType: "json",
            success:function (data) {
                // 失败
                if (data.code !== 200) {
                    alert(data.msg);
                }
            }

        })
    }

    let deletePaper = function (id) {
        if (!confirm("删除此试卷后将同时删除其他学员的!")) {
            return;
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/teacher/deletePaper",
            data:{
                "id":id
            },
            type:"POST",
            dataType:"json",
            success:function (data) {
                if (data.code === 200) {
                    $("#"+id).remove();
                } else {
                    alert("请稍后再试")
                }
            }
        })
    }

</script>
</html>
