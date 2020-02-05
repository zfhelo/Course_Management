<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="../include/tea_bar.jsp"%>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" crossorigin="anonymous">
<link href="fileinput/themes/explorer-fas/theme.css" media="all" rel="stylesheet" type="text/css"/>
<link href="fileinput/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

<script src="fileinput/js/fileinput.js" type="text/javascript"></script>

<script src="fileinput/themes/fas/theme.js" type="text/javascript"></script>
<script src="fileinput/themes/explorer-fas/theme.js" type="text/javascript"></script>

        <div class="container">
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
                        <div class="file-loading">
                            <input id="input-701" name="file" type="file" multiple=true class="file-loading">
                        </div>
                        <script>
                            $("#input-701").fileinput({
                                theme: "fas",
                                uploadUrl: "${pageContext.request.contextPath}/teacher/get",
                                maxFileCount: 3 , // 最大
                                uploadAsync: false,
                                hideThumbnailContent: true // hide image, pdf, text or other content in the thumbnail preview
                            });


                            $('#input-701').on('filebatchpreupload', function(event, data, previewId, index) {
                                var form = data.form, files = data.files, extra = data.extra,
                                    response = data.response, reader = data.reader;
                                //$('##input-701').fileinput('cancel');
                            });
                        </script>

                </div>
            </div>
        </div>
    </body>
</html>
