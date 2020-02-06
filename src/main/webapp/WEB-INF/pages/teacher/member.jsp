<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/tea_bar.jsp"%>

        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <ul class="list-group list-group-flush">
                        <c:forEach items="${MEMBER}" var="m">
                            <li class="list-group-item" id="${m.id}">
                                ${m.nickname}
                                <button type="button" class="btn btn-link float-right" onclick="removeMember(${m.id})" style="padding: 0px">移除</button>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </body>
<script>
    // 移除成员
    let removeMember = function (id) {
        if (!confirm("你确定要移除该学员吗！")) {
            return;
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/teacher/removeMember",
            data:{
                "sid":id
            },
            dataType:"json",
            type:"POST",
            success:function (data) {
                // 成功删除该节点
                if (data.code === 200) {
                    $("#"+id).remove();
                }
            }
        });
    }
</script>
</html>
