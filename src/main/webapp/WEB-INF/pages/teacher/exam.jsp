<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/tea_bar.jsp"%>
        <div class="container">
            <div class="accordion" id="accordionExample">
                <!--自动生成-->
                <div class="card">
                    <div class="card-header" id="headingOne">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                题库中自动生成试卷
                            </button>
                        </h2>
                    </div>

                    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                        <div class="card-body">
                            <form>
                                <div class="form-group form-inline">
                                    <label for="single_num" style="margin-right: 20px">标&nbsp;&nbsp;&nbsp;&nbsp;题</label>
                                    <input class="form-control form-control-sm w-25" id="title" style="margin-right: 20px" type="text">
                                </div>
                                <div class="form-group form-inline">
                                    <label for="single_num" style="margin-right: 20px">单选题</label>
                                    <input class="form-control form-control-sm w-25" id="single_num" style="margin-right: 20px" type="text" placeholder="选择题数量">
                                    <input class="form-control form-control-sm w-25" id="grade_single" type="text" placeholder="总分值">
                                </div>
                                <div class="form-group form-inline">
                                    <label for="gap_num" style="margin-right: 20px">填空题</label>
                                    <input id="gap_num" class="form-control form-control-sm w-25" style="margin-right: 20px" type="text" placeholder="填空题题数量">
                                    <input id="grade_gap" class="form-control form-control-sm w-25" type="text" placeholder="总分值">
                                </div>
                                <div class="form-group form-inline">
                                    <label for="essay_num" style="margin-right: 20px">解答题</label>
                                    <input id="essay_num" class="form-control form-control-sm w-25" style="margin-right: 20px" type="text" placeholder="解答题题数量">
                                    <input id="grade_essay" class="form-control form-control-sm w-25" type="text" placeholder="总分值">
                                    <button class="btn btn-primary" style="margin-left: 20px" onclick="generatePaper()">生成试卷</button>
                                </div>
                                <small class="form-text text-muted">不包含请填0</small>

                            </form>
                        </div>
                    </div>
                </div>
                <!--手动生成-->
                <div class="card">
                    <div class="card-header" id="headingTwo">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                手动生成试卷
                            </button>
                        </h2>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                        <div class="card-body">

                        </div>
                    </div>
                </div>
                <!--单选题-->
                <div class="card">
                    <div class="card-header" id="heading3">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapse3" aria-expanded="false" aria-controls="collapseTwo">
                                向题库中添加单选题
                            </button>
                        </h2>
                    </div>
                    <div id="collapse3" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                        <div class="card-body">
                            <form>
                                <!--题目筛选-->
                                <div class="form-group form-inline">
                                    <input class="form-control w-10" id="single_grade" placeholder="分值"><small id="single_msg"></small>
                                </div>
                                <div class="mb-3">
                                    <textarea class="form-control" id="single_content" placeholder="题干"></textarea>
                                </div>

                                <input type="text" class="form-control" id="single_choise1"  placeholder="正确答案">
                                <input type="text" class="form-control" id="single_choise2" placeholder="干扰答案">
                                <input type="text" class="form-control" id="single_choise3"  placeholder="干扰答案">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="single_choise4"  placeholder="干扰答案">
                                    <small class="form-text text-muted">选项中无须包含ABCD</small>
                                </div>

                                <div class="btn-group  float-right" role="group" aria-label="Basic example" style="margin-bottom: 10px">
                                    <button type="button" class="btn btn btn-primary" onclick="addSingle()">添加</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!--填空题-->
                <div class="card">
                    <div class="card-header" id="heading4">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapse4" aria-expanded="false" aria-controls="collapseTwo">
                                向题库中添加填空题
                            </button>
                        </h2>
                    </div>
                    <div id="collapse4" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                        <div class="card-body">
                            <form>
                                <!--题目筛选-->
                                <div class="form-group form-inline">
                                    <input class="form-control w-10" id="gap_grade" placeholder="分值"> <small id="gap_msg"></small>
                                </div>
                                <!--添加-->

                                <div class="mb-3">
                                    <textarea class="form-control" id="gap_content" placeholder="题干"></textarea>
                                </div>

                                <div class="form-group">
                                    <input type="text" class="form-control" id="gap_answer" aria-describedby="emailHelp" placeholder="答案">
                                </div>

                                <div class="btn-group  float-right" role="group" aria-label="Basic example" style="margin-bottom: 10px">
                                    <button type="button" class="btn btn btn-primary" onclick="addGap()">添加</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!--解答题-->
                <div class="card">
                    <div class="card-header" id="heading5">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapse5" aria-expanded="false" aria-controls="collapseTwo">
                                向题库中添加解答题
                            </button>
                        </h2>
                    </div>
                    <div id="collapse5" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                        <div class="card-body">
                            <form>
                                <!--题目筛选-->
                                <div class="form-group form-inline">
                                    <input class="form-control w-10" id="essay_grade" placeholder="分值"><small id="essay_msg"></small>
                                </div>
                                <!--添加-->

                                <div class="mb-3">
                                    <textarea class="form-control" id="essay_content" placeholder="题干"></textarea>
                                </div>

                                <div class="btn-group  float-right" role="group" aria-label="Basic example" style="margin-bottom: 10px">
                                    <button type="button" class="btn btn btn-primary" onclick="addEssay()">添加</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
<script>

    // 生成试卷
    let title = $("#title");

    let single_num = $("#single_num");
    let grade_single = $("#grade_single");

    let gap_num = $("#gap_num");
    let grade_gap = $("#grade_gap");

    let essay_num = $("#essay_num");
    let grade_essay = $("#grade_essay");

    let generatePaper = function() {

    };


    // 添加单选题
    let single_grade = $("#single_grade");
    let single_content = $("#single_content");
    let single_choise1 = $("#single_choise1");
    let single_choise2 = $("#single_choise2");
    let single_choise3 = $("#single_choise3");
    let single_choise4 = $("#single_choise4");
    let single_msg = $("#single_msg");

    let addSingle = function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/single/add",
            type:"POST",
            dataType:"json",
            data:{
                "content":single_content.val(),
                "grade":single_grade.val(),
                "answer":single_choise1.val(),
                "choise1":single_choise1.val(),
                "choise2":single_choise2.val(),
                "choise3":single_choise3.val(),
                "choise4":single_choise4.val(),
            },
            success:function (data) {
                if (data.code === 200) {
                    single_grade.val("");
                    single_content.val("");
                    single_choise1.val("");
                    single_choise2.val("");
                    single_choise3.val("");
                    single_choise4.val("");
                }
                // 提示信息
                single_msg.text(data.msg);
            }

        });
    }

    // 添加填空题
    let gap_grade = $("#gap_grade");
    let gap_answer = $("#gap_answer");
    let gap_content = $("#gap_content");
    let gap_msg = $("#gap_msg");

    let addGap = function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/gap/add",
            data: {
                "grade":gap_grade.val(),
                "content":gap_content.val(),
                "answer":gap_answer.val()
            },
            type: "POST",
            dataType: "json",
            success:function (data) {
                if (data.code === 200) {
                    gap_grade.val("");
                    gap_answer.val("");
                    gap_content.val("");
                }
                gap_msg.text(data.msg);
            }
        });
    }

    // 添加解答题
    let essay_content = $("#essay_content");
    let essay_grade = $("#essay_grade");
    let essay_msg = $("#essay_msg");

    let addEssay = function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/essay/add",
            data:{
                "content":essay_content.val(),
                "grade":essay_grade.val()
            },
            type:"POST",
            dataType:"json",
            success:function (data) {
                if (data.code === 200) {
                    essay_grade.val("");
                    essay_content.val("");
                }
                essay_msg.text(data.msg);
            }
        })
    }
</script>
</html>
