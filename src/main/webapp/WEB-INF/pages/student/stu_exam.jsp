<%--学生考测验页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/stu_bar.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>exam</title>

    <link href="../../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../../css/icheck-bootstrap.min.css">
    <!--代码块-->
    <link rel="stylesheet" href="../../../codemirror-5.50.2/lib/codemirror.css">
    <script src="../../../codemirror-5.50.2/lib/codemirror.js"></script>
    <!--语法高亮-->
    <script src="../../../codemirror-5.50.2/mode/clike/clike.js"></script>


    <!--引入css文件，用以支持主题-->
    <link rel="stylesheet" href="../../../codemirror-5.50.2/theme/idea.css">

    <!--支持代码折叠-->
    <link rel="stylesheet" href="../../../codemirror-5.50.2/addon/fold/foldgutter.css"/>
    <script src="../../../codemirror-5.50.2/addon/fold/foldcode.js"></script>
    <script src="../../../codemirror-5.50.2/addon/fold/foldgutter.js"></script>
    <script src="../../../codemirror-5.50.2/addon/fold/brace-fold.js"></script>
    <script src="../../../codemirror-5.50.2/addon/fold/comment-fold.js"></script>

    <!--括号匹配-->
    <script src="../../../codemirror-5.50.2/addon/edit/matchbrackets.js"></script>

    <style>
        .line{
            margin: 40px 0 40px 0;
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
                    <form>
                        <h5>已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是( )。</h5>
                        <br/>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_1_a" name="q1" value="A"/>
                            <label for="q_1_a">A．存放读入数据项的存储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_1_b" name="q1" value="B"/>
                            <label for="q_1_b">B．存放读入数据项的存储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_1_c" name="q1" value="C"/>
                            <label for="q_1_c">C．存放读入数据项的存储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_1_d" name="q1" value="D"/>
                            <label for="q_1_d">D．存放读入数据项的存储区</label>
                        </div>
                        <hr class="line"/>
                        <h5>已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是( )。</h5>
                        <br/>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_2_a" name="q2" value="A"/>
                            <label for="q_2_a">A．存放读入数据项的存啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_2_b" name="q2" value="B"/>
                            <label for="q_2_b">B．存放读入数据项的存储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_2_c" name="q2" value="C"/>
                            <label for="q_2_c">C．存放读入数据项的存储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_2_d" name="q2" value="D"/>
                            <label for="q_2_d">D．存放读入数据项的存储区</label>
                        </div>
                        <hr class="line"/>
                        <h5>已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是( )。</h5>
                        <br/>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_3_a" name="q3" value="A"/>
                            <label for="q_3_a">A．存放读入数据项的存储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_3_b" name="q3" value="B"/>
                            <label for="q_3_b">B．存放读入数据项的存储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_3_c" name="q3" value="C"/>
                            <label for="q_3_c">C．存放读入数据项的存储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_3_d" name="q3" value="D"/>
                            <label for="q_3_d">D．存放读入数据项的存储区</label>
                        </div>
                        <hr class="line"/>
                        <h5>已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是( )。</h5>
                        <br/>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_4_a" name="q4" value="A"/>
                            <label for="q_4_a">A．存放读入数据项的存储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_4_b" name="q4" value="B"/>
                            <label for="q_4_b">B．存放读入数据项的存储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_4_c" name="q4" value="C"/>
                            <label for="q_4_c">C．存放读入数据项的存储区</label>
                        </div>
                        <div class="radio icheck-turquoise">
                            <input type="radio" id="q_4_d" name="q4" value="D"/>
                            <label for="q_4_d">D．存放读入数据项的存储区</label>
                        </div>
                        <hr class="line"/>
                    </form>
                </div>
                <!--填空题-->
                <div>
                    <h3>填空题</h3>
                    。。。
                </div>
                <!--解答题-->
                <div>
                    <h3>解答题</h3>
                    <br/>
                    <h5>1. 已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是</h5>
                    <br/>
                    <!--代码块-->
                    <textarea id="code">
public class Hello {
	public static void main(String[] args) {
    	System.out.println(hello world);
    }
}
                    </textarea>
                    <hr class="line"/>
                    <h5>1. 已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是已知函数fread的调用形式为“fread(buffer，size，count，fp)；”，其中buffer代表的是</h5>
                    <br/>
                    <!--代码块-->
                    <textarea id="code1"></textarea>
                    <hr class="line"/>


                </div>
            </div>
        </div>

        <!--时间提示-->
        <div class="col-lg-4 float-right">
            <div style="width: 300px; height: 200px; background-color: pink" class="float-right sticky-top">时间</div>
        </div>
    </div>
</div>


<script type="text/javascript">
    var editor=CodeMirror.fromTextArea(document.getElementById("code"),{
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
    var editor1=CodeMirror.fromTextArea(document.getElementById("code1"),{
        mode:"text/x-c",
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
    });


</script>


</body>
<script src="../../../js/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="../../../js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>