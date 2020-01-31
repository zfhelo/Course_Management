<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--课程的管理--%>
<div class="modal fade" id="manager_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalScrollableTitle">管理课程</h5>
            </div>
            <div class="modal-body">
                <ul class="list-group list-group-flush" id="course_list_select">
                </ul>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="location.reload()">Close</button>
            </div>
        </div>
    </div>
</div>
<script>
    // 移除课程
    let removeCourseStu = function (data) {
        if (!confirm("确认要移除吗！")) {
            return;
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/student/removeCourse",
            dataType: "json",
            data: {
                "id":data
            },
            type: "POST",
            success:function (response) {
                // 删除成功
                if (response.code === 200) {
                    // 移除被删除节点
                    $("#"+data).remove();
                }
            }
        });
    }

    let removeCourseTea = function (data) {
        if (!confirm("确认要移除吗！")) {
            return;
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/teacher/removeCourse",
            dataType: "json",
            data: {
                "id":data
            },
            type: "POST",
            success:function (response) {
                // 删除成功
                if (response.code === 200) {
                    // 移除被删除节点
                    $("#"+data).remove();
                }
            }
        });
    }

    // 创建节点
    let creatNodeSelectStu = function (identity, data) {
        let node = $(
            '<li class="list-group-item" id='+data.id+'>' +
            '<span class="font-weight-bold">' +data.name+'</span>' +
            '<small style="margin-left: 20px">ID：' +data.number+'</small>' +
            '<small style="margin-left: 15px">' +data.teacher.nickname+'</small>' +
            '<button type="button" class="btn btn-primary float-right" onclick="removeCourseStu('+data.id+')">移除</button>' +
            '</li>'
        );
        // 追加到后面
        $("#course_list_select").append(node);
    };

    // 创建节点
    let creatNodeSelectTea = function (identity, data) {
        let node = $(
            '<li class="list-group-item" id='+data.id+'>' +
            '<span class="font-weight-bold">' +data.name+'</span>' +
            '<small style="margin-left: 20px">ID：' +data.number+'</small>' +
            '<small style="margin-left: 15px">' +data.teacher.nickname+'</small>' +
            '<button type="button" class="btn btn-primary float-right" onclick="removeCourseTea('+data.id+')">移除</button>' +
            '</li>'
        );
        // 追加到后面
        $("#course_list_select").append(node);
    };

    // 查询课程
    let manger = function (identity) {
        // 清空
        $("#course_list_select").empty();
        $.ajax({
            url:"${pageContext.request.contextPath}/"+identity.toString()+"/selectCourse",
            type:"GET",
            dataType:"json",
            success:function (data) {
                // 成功
                if (data.code === 200) {
                    for (let key in data.data) {
                        if ("teacher" === identity) {
                            creatNodeSelectTea(identity,data.data[key]);
                        } else {
                            creatNodeSelectStu(identity,data.data[key]);
                        }
                    }
                }
            }
        });
    }
</script>
