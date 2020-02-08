<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="../include/stu_bar.jsp"%>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" crossorigin="anonymous">
<link href="fileinput/themes/explorer-fas/theme.css" media="all" rel="stylesheet" type="text/css"/>
<link href="fileinput/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>

<script src="fileinput/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

<script src="fileinput/js/fileinput.js" type="text/javascript"></script>

<script src="fileinput/themes/fas/theme.js" type="text/javascript"></script>
<script src="fileinput/js/locales/zh.js" type="text/javascript"></script>
<script src="fileinput/themes/explorer-fas/theme.js" type="text/javascript"></script>


<script src="fileinput/piexif.min.js" type="text/javascript"></script>
<script src="fileinput/sortable.min.js" type="text/javascript"></script>
<script src="fileinput/purify.min.js" type="text/javascript"></script>
<script src="fileinput/popper.min.js"></script>


<div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <ul class="list-group list-group-flush" id="content"></ul>
                </div>
                <div class="col-lg-4">
                    <div class="sticky-top">
                        <div class="form-group form-inline" style="margin-top: 10px">
                            <input type="text" id="title" class="form-control mx-sm-3" placeholder="描述">
                        </div>
                        <div class="file-loading">
                            <input id="input-701" name="file" type="file" multiple=true class="file-loading">
                        </div>

                        <nav aria-label="Page navigation example" style="margin-top: 50px">
                            <ul class="pagination" id="pages">
                                <li class="page-item">
                                    <a class="page-link" href="javascript:void(0);" aria-label="Previous" onclick="findPage(1)">
                                        <span aria-hidden="true">首页</span>
                                    </a>
                                </li>


                                <li class="page-item" id = "next">
                                    <a class="page-link" href="javascript:void(0);" aria-label="Next" id="finally">
                                        <span aria-hidden="true">尾页</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                        <nav aria-label="Page navigation example" style="margin-top: 20px">
                            <ul class="pagination">
                                <li class="page-item active b"><a class="page-link" href="javascript:void(0);" onclick="toogle('student')">学生资源</a></li>
                                <li class="page-item b"><a class="page-link" href="javascript:void(0);" onclick="toogle('teacher')">教师资源</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </body>

<script>
    // 全局变量
    var identify = "student";

    // 切换
    let toogle = function(a) {
        identify = a;
        $(".b").toggleClass("active");
        findPage(1);
    }

    // 数据
    let $content = $("#content");
    $(function () {
        findPage(1);
    });

    // 刷新页码
    let refreshIndex = function(data) {
        // 当前页
        let now = data.pageNum;
        $("#finally").attr("onclick","findPage("+data.pages+")");
        let $next = $("#next");
        $(".a").remove();

        $.each(data.navigatepageNums,function (index,object) {
            let node;
            if (object === now) {
                node = $('<li class="page-item a active"><a class="page-link" href="javascript:void(0);">'+object+'</a></li>')
            } else {
                node = $('<li class="page-item a"><a class="page-link" href="javascript:void(0);" onclick="findPage('+object+')">'+object+'</a></li>')
            }
            $next.before(node);
        })
    };

    // 更新数据
    let refreshResource = function(data) {
        $content.empty();
        let node;
        $.each(data, function (index,object) {
            // 判断是否可以删除
            if (identify === 'teacher' || (object.sid !== ${STUDENT.id})) {
                node = $('                        <li class="list-group-item" style="margin-bottom: 3px;" id="'+object.id+'">\n' +
                    '                            <span >'+object.title+'</span>\n' +
                    '                            <a class="btn btn-link float-right" style="padding: 0px" href="'+identify+'/download?id='+object.id+'">下载</a>\n' +
                    '                            <small class="float-right" style="margin-right: 20px;">'+object.nickname+'('+object.localeTime+')</small>\n' +
                    '                        </li>');
            } else {
                node = $('                        <li class="list-group-item" style="margin-bottom: 3px;" id="'+object.id+'">\n' +
                    '                            <span >'+object.title+'</span>\n' +
                    '                            <a class="btn btn-link float-right" style="padding: 0px" href="'+identify+'/download?id='+object.id+'">下载</a>\n' +
                    '                            <button type="button" class="btn btn-link float-right" style="margin-right: 20px; padding: 0px;" onclick="deleteResources('+object.id+')">删除</button>\n' +
                    '                            <small class="float-right" style="margin-right: 20px;">'+object.nickname+'('+object.localeTime+')</small>\n' +
                    '                        </li>');
            }
            $content.append(node);
        })
    };
    // 跳转页面
    let findPage = function (page) {
        $.ajax({
            url:"${pageContext.request.contextPath}/"+identify+"/findPage",
            type:"POST",
            datatype: "json",
            data:{
                "page":page
            },
            success:function (data) {
                // 刷新页码
                refreshIndex(data);
                // 更新数据
                refreshResource(data.list)
            }
        });
    };
    // 删除资源
    let deleteResources = function(id) {
        if (!confirm("确定要删除吗?")) {
            return;
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/student/deleteStuResources",
            type: "POST",
            datatype: "json",
            data: {
               "id":id,
                "sid":${STUDENT.id}
            },
            success:function (data) {
                if (data.code === 200) {
                    $("#"+id).remove();
                }
            }
        });
    };

    // 下载资源
    let download = function(id) {
        $.ajax({
            url:"${pageContext.request.contextPath}/"+identify+"/download",
            type: "POST",
            data: {
                "id":id,
            },
        });
    };



    // 文件上传
    $("#input-701").fileinput({
        language: 'zh',
        theme: "fas",
        uploadUrl: "${pageContext.request.contextPath}/student/upload",
        maxFileCount: 1 , // 最大上传数量
        uploadAsync: true, // 异步上传
        hideThumbnailContent: true, // hide image, pdf, text or other content in the thumbnail preview
        uploadExtraData: function() {   //额外参数 返回json数组
            return {
                'title':$("#title").val()
            };
        }
    }).on("filebatchuploadcomplete", function() {// 成功回掉
        setTimeout(" $('#input-701').fileinput('clear');\n" +
            "        $(\"#title\").val('');",2000)

    }).on('filebatchpreupload', function() { // 上传开始前触发
        if ($("#title").val() === "") {
            alert("请输入标题");
            $('##input-701').fileinput('cancel');
        }
    });
</script>
</html>
