<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="modal fade" id="search_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalScrollableTitle">加入课程<small>&nbsp;已加入的课程将不会显示</small></h5>
            </div>
            <div class="modal-body">
                <ul class="list-group list-group-flush" id="course_list">

                </ul>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="location.reload()">Close</button>
            </div>
        </div>
    </div>
</div>
<script>

    // 加入课程
    let joinCourse = function(id) {
        if (!confirm("确认要加入吗？")) {
            return;
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/joinCourse",
            data: "id="+id,
            dataType: "json",
            type: "GET",
            success:function (data) {
                // 加入成功
                if (data.code === 200) {
                    // 删除此节点
                    $("#"+id).remove();
                } else {
                    alert(data.msg)
                }
            }
        });
    }
    // 创建节点
    let creatNode = function (data) {

        let node = $(
            '<li class="list-group-item" id='+data.id+'>' +
            '<span class="font-weight-bold">' +data.name+'</span>' +
            '<small style="margin-left: 20px">ID：' +data.number+'</small>' +
            '<small style="margin-left: 15px">' +data.teacher.nickname+'</small>' +
            '<button type="button" class="btn btn-primary float-right" data-toggle="button" aria-pressed="false" onclick="joinCourse('+data.id+')">加入</button>' +
            '</li>'
        );
        // 追加到后面
        $("#course_list").append(node);
    };


    $(function () {
        // 查找课程
        $("#btn_search").click(function () {
            // 清空
            $("#course_list").empty();

            if ($("#search").val() === "") {
                return;
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/search",
                type:"GET",
                dataType:"json",
                data:{
                    "key":$("#search").val()
                },
                success:function (data) {
                    for (let key in data.data) {
                        creatNode(data.data[key]);
                    }
                }
            });
        });
    });
</script>
