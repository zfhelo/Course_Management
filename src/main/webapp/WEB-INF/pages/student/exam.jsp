<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--学生考测验页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="${pageContext.request.contextPath}\">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
    <link rel="stylesheet" href="css/icheck-bootstrap.min.css">

    <!--代码块-->
    <link rel="stylesheet" href="codemirror-5.50.2/lib/codemirror.css">
    <script src="codemirror-5.50.2/lib/codemirror.js"></script>
    <!--语法高亮-->
    <script src="codemirror-5.50.2/mode/clike/clike.js"></script>
    <!--引入css文件，用以支持主题-->
    <link rel="stylesheet" href="codemirror-5.50.2/theme/idea.css">

    <!--支持代码折叠-->
    <link rel="stylesheet" href="codemirror-5.50.2/addon/fold/foldgutter.css"/>
    <script src="codemirror-5.50.2/addon/fold/foldcode.js"></script>
    <script src="codemirror-5.50.2/addon/fold/foldgutter.js"></script>
    <script src="codemirror-5.50.2/addon/fold/brace-fold.js"></script>
    <script src="codemirror-5.50.2/addon/fold/comment-fold.js"></script>

    <!--括号匹配-->
    <script src="codemirror-5.50.2/addon/edit/matchbrackets.js"></script>


    <link href='http://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'>
    <link rel='stylesheet prefetch'  href="css/csshake.min.css">
    <style type="text/css">
        /* clock */
        .clock{width:360px;height:120px;color:#d96457;font-family:"Lato", sans-serif;}
        .clock div{border-radius:6px;width:96px;height:80px;line-height:80px;text-align:center;font-size:60px;margin:0px 5px;}
    </style>

    <style>
        .line{
            margin: 40px 0 40px 0;
        }
        .gap{
            border-bottom: 1px solid #000;
            border-top: 0px;
            border-left: 0px;
            border-right: 0px;
            background: #f4f4f4;
        }
    </style>



</head>
<body style="background-color: #f4f4f4">
    <!--答题主体-->
    <div class="container">

        <div class="row">
            <div class="col-lg-8">
                <div class="float-left" style="margin-top: 20px">
                    <!--单选题-->
                    <div>
                        <h3>单选题</h3>
                        <br/>

                        <c:forEach items="${paper.singleQuestions}" var="q">
                            <h5>${q.content}</h5>
                            <br/>
                            <div class="radio icheck-turquoise">
                                <input type="radio" id="l_1_${q.id}" name="s_${q.id}" value="${q.choise1}"/>
                                <label for="l_1_${q.id}">${q.choise1}</label>
                            </div>
                            <div class="radio icheck-turquoise">
                                <input type="radio" id="l_2_${q.id}" name="s_${q.id}" value="${q.choise2}"/>
                                <label for="l_2_${q.id}">${q.choise2}</label>
                            </div>
                            <div class="radio icheck-turquoise">
                                <input type="radio" id="l_3_${q.id}" name="s_${q.id}" value="${q.choise3}"/>
                                <label for="l_3_${q.id}">${q.choise3}</label>
                            </div>
                            <div class="radio icheck-turquoise">
                                <input type="radio" id="l_4_${q.id}" name="s_${q.id}" value="${q.choise4}"/>
                                <label for="l_4_${q.id}">${q.choise4}</label>
                            </div>
                            <hr class="line"/>
                        </c:forEach>

                    </div>
                    <!--填空题-->
                    <div>
                        <h3>填空题</h3>
                        <br/>
                        <form>
                            <c:forEach items="${paper.gapFillings}" var="q">
                                <h5>${q.content}</h5>
                                答案：<input type="text" class="gap" name="g_${q.id}" value="${q.userAnswer}"/>
                                <hr class="line"/>
                            </c:forEach>
                        </form>
                    </div>
                    <!--解答题-->
                    <div>
                        <h3>解答题</h3>
                        <br/>
                        <c:forEach items="${paper.essayQuestions}" var="q">
                            <h5>${q.content}</h5>
                            <br/>
                            <!--代码块-->
                                <textarea id="e_${q.id}">${q.userAnswer}</textarea>
                                <hr class="line"/>
                        </c:forEach>
                    </div>

                </div>
                <button type="button" class="btn btn-primary float-right w-25" onclick="commit(${paper.id})">提交</button>
            </div>

            <!--时间提示-->
            <div class="col-lg-4 float-right">
                <div class="float-right sticky-top">
                    <div class='clock'>
                        <div class='h shake shake-slow'></div>
                        <div class='m shake shake-slow'></div>
                        <div class='s shake shake-slow'></div>
                    </div>
                    <span id="msg" class="float-right" style="margin-top: 20px"></span>
                </div>
            </div>
        </div>
    </div>
    <script src="https://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="js/index.js"></script>
    <script src="js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script type="text/javascript">
// 初始化

        // 单选题设置点击事件并显示之前的答案
        <c:forEach items="${paper.singleQuestions}" var="q">
        // 显示之前选择的
        $("input[name='s_${q.id}'][value='${q.userAnswer}']").attr("checked", "true");

        $("input[name='s_${q.id}']").click(function () {
            let $s = $(this);
            if ($s.is(':checked')) {
                updateQue(${q.id}, $s.val(), 'single');
            }
        });
        </c:forEach>

        // 填空题
        <c:forEach items="${paper.gapFillings}" var="q">
            $("input[name='g_${q.id}']").blur(function () {
                let $s = $(this);
                updateQue(${q.id}, $s.val(),'gap');
            });
        </c:forEach>

        // 解答题代码块生成
        <c:forEach items="${paper.essayQuestions}" var="q">
                var editor_${q.id}=CodeMirror.fromTextArea(document.getElementById("e_${q.id}"),{
                    mode:"text/x-java",
                    // 显示行号
                    lineNumbers:true,
                    // 主题
                    theme:"idea",
                    // 代码折叠
                    lineWrapping:true,
                    foldGutter: true,
                    gutters:["CodeMirror-linenumbers", "CodeMirror-foldgutter"],
                    // 括号匹配
                    matchBrackets:true,
                    // 智能提示
                    extraKeys:{"Ctrl-Space":"autocomplete"}//ctrl-space唤起智能提示
                });
                editor_${q.id}.setSize('700px','500px');
                // 离焦事件
                editor_${q.id}.on("blur",function () {
                    updateQue(${q.id}, editor_${q.id}.getValue(),'essay');
                })
        </c:forEach>

// 写入数据到服务器
        // 答案上传
        let updateQue = function (id, answer, type) {
            $("#msg").text("保存中...");
            // 将所选的题目发送到服务器
            $.ajax({
                url:"${pageContext.request.contextPath}/"+type+"/update",
                data:{
                    "id":id,
                    "answer":answer,
                    "pid":${paper.id},
                    "mid":${paper.mid}
                },
                type:"POST",
                dataType:"json",
                success:function (data) {
                    $("#msg").text(data.msg);
                }
            })
        };

        let commit = function (id) {
            $.ajax({
                url:"${pageContext.request.contextPath}/commitPaper",
                type: "POST",
                data: {
                    "id":id,
                },
                dataType: "json",
                success:function (data) {
                    $("#msg").text(data.msg)
                }
            })
        }
    </script>
</body>
</html>