<%--资源分享页--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/navs.jsp"%>
<!DOCTYPE html>
    <head>
        <title>Title</title>

        <link href="../../../css/bootstrap.min.css" rel="stylesheet">
        <style>
            .download {
                margin-right: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container" style="display: none">
            <div class="row">
                <div class="col-lg-6">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <span>数据结构</span>
                            <a class="float-right download" href="#">删除</a>
                            <a class="float-right download" href="#">下载</a>
                        </li>
                        <li class="list-group-item">
                            <span>数据结构</span>
                            <a class="float-right download" href="#">删除</a>
                            <a class="float-right download" href="#">下载</a>
                        </li>
                        <li class="list-group-item">
                            <span>数据结构</span>
                            <a class="float-right download" href="#">删除</a>
                            <a class="float-right download" href="#">下载</a>
                        </li>
                    </ul>
                </div>
                <div class="col-lg-6">
                    <form>
                        <div class="btn-group  float-right" role="group" aria-label="Basic example">
                            <button type="button" class="btn btn btn-primary">添加附件</button>
                            <button type="button" class="btn btn btn-primary">上传</button>
                        </div>

                        <!--添加文件最多支持3个-->
                        <div class="form-group">
                            <span class="float-left" style="margin-right: 20px; color: red">删除</span>
                            <input type="file" class="form-control-file w-25" id="exampleFormControlFile1">
                            <span class="float-left" style="margin-right: 20px; color: red">删除</span>
                            <input type="file" class="form-control-file w-25" id="exampleFormControlFile2">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="../../../js/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="../../../js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
