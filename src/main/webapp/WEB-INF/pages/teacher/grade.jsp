<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/tea_bar.jsp"%>
<title>成绩表</title>
<div class="container">

    <table class="table table-striped">
        <thead>
        <tr>
            <th>姓名</th>
            <th>平时分</th>
            <th>总成绩</th>
            <th>编辑</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${grade}" var="g">
            <tr>
                <td id="name${g.id}">${g.student.nickname}</td>
                <td id="regularGrade${g.id}">${g.regularGrade}</td>
                <td id="finalGrade${g.id}">${g.finalGrade}</td>
                <td onclick="editor(${g.id})" data-toggle="modal" data-target="#staticBackdrop"><button class="btn btn-link">编辑</button> </td>
                <input type="hidden" id="${g.id}" value="${g.student.id}"/>
            </tr>
        </c:forEach>
        </tbody>
    </table>




    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-inline">
                        <label for="regularGrade">平时分</label>
                        <input type="text" class="form-control" id="regularGrade"/>
                    </div>
                    <div class="form-inline">
                        <label for="finalGrade">成绩</label>
                        <input type="text" class="form-control" id="finalGrade"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal" id="cancel" >取消</button>
                    <button type="button" class="btn btn-primary" onclick="a()">保存</button>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
<script>
    let id;
    let editor = function (a) {
        id = a;
    };
    let a = function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/teacher/editGrade",
            type:"POST",
            data:{
                "id":id,
                "sid":$("#"+id).val(),
                "regularGrade":$("#regularGrade").val(),
                "finalGrade":$("#finalGrade").val(),
            },
            dataType:"json",
            success:function (data) {
                if (data.code === 200) {
                    $("#regularGrade"+id).text($("#regularGrade").val());
                    $("#finalGrade"+id).text($("#finalGrade").val());
                    $("#cancel").click();
                    $("#regularGrade").val('');
                    $("#finalGrade").val('');
                } else {
                    alert(data.msg)
                }
            }
        })
    }
</script>
</html>
