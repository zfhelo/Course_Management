<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="../include/stu_bar.jsp"%>
<div class="container">
    <div class="list-group" id="list">

    </div>
</div>
</body>

<script>
    $(function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/student/paperModel",
            type:"GET",
            dataType:"json",
            success:function (data) {
                refresh(data);
            }
        })
    });
    let refresh = function(data) {
        let $list = $("#list");
        $.each(data,function (index, object) {
            let node = $('<a href="student/exam?id='+object.id+'" class="list-group-item list-group-item-action">'+object.title+'</a>');
            $list.append(node);
        })
    }
</script>
</html>
