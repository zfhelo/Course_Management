<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/tea_bar.jsp"%>
<title>试题管理</title>
        <div class="container">
            <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <small>tips：隐藏后学生将无法查看到此试卷，关闭允许提交后学生将无法更新已提交的数据</small>
                    </li>
                    <c:forEach items="${model_papers}" var="paper">

                        <li class="list-group-item" id="${paper.id}">
                            <span>${paper.title}</span>
                            <small style="line-height: 38px">(提交人数：${paper.commit}/${paper.member})</small>

                            <button type="button" class="btn btn-link float-right" onclick="deletePaper(${paper.id})">删除</button>


                            <div class="custom-control custom-checkbox float-right" style="margin-top: 7px;margin-left: 10px">
                                <c:if test="${paper.hide == 1}">
                                    <input type="checkbox" class="custom-control-input" id="_${paper.id}" value="${paper.id}" checked onclick="switchHide(this)">
                                </c:if>
                                <c:if test="${paper.hide == 0}">
                                    <input type="checkbox" class="custom-control-input" id="_${paper.id}" value="${paper.id}" onclick="switchHide(this)">
                                </c:if>
                                <label class="custom-control-label" for="_${paper.id}">隐藏</label>
                            </div>

                            <div class="custom-control custom-checkbox float-right" style="margin-top: 7px;margin-left: 10px">
                                <c:if test="${paper.enable == 1}">
                                    <input type="checkbox" class="custom-control-input" id="__${paper.id}" value="${paper.id}" checked onclick="switchEnable(this)">
                                </c:if>

                                <c:if test="${paper.enable == 0}">
                                    <input type="checkbox" class="custom-control-input" id="__${paper.id}" value="${paper.id}" onclick="switchEnable(this)">
                                </c:if>
                                <label class="custom-control-label" for="__${paper.id}">允许提交</label>
                            </div>

                            <a  class="btn btn-link float-right" href="detailPaper?id=${paper.id}">查看详情</a>
                        </li>
                    </c:forEach>
            </ul>
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
