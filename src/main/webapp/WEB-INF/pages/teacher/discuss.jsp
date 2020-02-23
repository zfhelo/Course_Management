<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="../include/tea_bar.jsp"%>
<style>
    h2{
        display:inline;
    }
    small{
        line-height: 42px
    }
</style>
<title>讨论</title>
        <!--发帖-->
        <div class="container">
            <form enctype="multipart/form-data" id="form1">
                <div class="form-group w-25" style="margin-top: 20px">
                    <label for="title">标题</label>
                    <input type="text" class="form-control" id="title" required>
                    <small id="msg1"></small>
                </div>

                <div class="form-group">
                    <label for="content">内容</label>
                    <textarea class="form-control" id="content" rows="3" required></textarea>
                </div>
                <div class="btn-group  float-right" role="group" aria-label="Basic example">
                    <button type="button" class="btn btn btn-primary" id="addImg">添加图片</button>
                    <button type="button" class="btn btn btn-primary" id="postDiscuss">发布</button>
                </div>
                <div class="form-group">
                    <a class="float-left" style="margin-right: 20px; color: red;" href="javascript:void(0);" id="deleteImg">移除</a>
                    <input type="file" class="form-control-file w-25" id="imgFile" accept="image/gif,image/jpeg,image/jpg,image/png">
                </div>
            </form>
        </div>
        <!--评论-->
        <div class="container" style="margin-top: 50px">



            <div class="accordion" id="issues">
                <!--评论部分-->
            </div>
            <!--分页-->
            <div class="float-right" style="margin-top: 10px">
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
            </div>
        </div>
    </body>

    <script>
// 发帖
        // 添加图片
        $("#addImg").click(function () {
            $("#imgFile").click();
        });
        $("#deleteImg").click(function () {
            $("#imgFile").val('');
        })
        // 上传数据
        $("#postDiscuss").click(function () {
            let $title = $("#title");
            let $content = $("#content");
            let $imgFile = $("#imgFile");

            if ($title.val() === '') {
                alert("请输入标题");
                return;
            }
            if ($content.val() === '') {
                alert("请输入正文");
                return;
            }

            let formData = new FormData($("#form1")[0]);  //创建一个forData

            // 准备数据
            if ($imgFile .val() !== '') {
                formData.append("file",$imgFile[0].files[0])
            }
            formData.append("title",$title.val());
            formData.append("content",$content.val());
            $.ajax({
                url: "${pageContext.request.contextPath}/teacher/postIssues",
                data: formData,
                type: "POST",
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function(data) {
                    if (data.code === 200) {
                        $title.val('');
                        $content.val('');
                        $imgFile.val('');
                        history.go(0);
                    }
                    $("#msg1").text(data.msg);
                }
            })

        });
// 加载帖子
        $(function () {
            findPage(1)
        });

        let findPage = function (page) {
            $.ajax({
                url:"${pageContext.request.contextPath}/issues/findPage",
                type:"POST",
                datatype: "json",
                data:{
                    "page":page
                },
                success:function (data) {
                    // 刷新页码
                    refreshIndex(data);
                    // 更新数据
                    refreshIssues(data.list)
                }
            });
        };


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

        let addImage = function (id) {
            $("#img"+id).click();
        };
        let deleteImage = function (id) {
            $("#img"+id).val('');
        };

        // 更新数据
        let refreshIssues = function(data) {
            // 清空数据
            let $issues = $("#issues");
            $issues.empty();
            $.each(data, function (index,object) {
                let node = $('                <div class="card">' +
                    '                    <div class="card-header" id="headingOne">' +
                    '                        <h2 class="mb-0">' +
                    '                            <button class="btn btn-link text-left" type="button" data-toggle="collapse" data-target="#i_'+object.id+'" aria-expanded="true" aria-controls="collapseOne" onclick="pullComment('+object.id+', 1)">' +
                    '                                '+object.title+
                    '                            </button>' +
                    '                        </h2>' +
                    '                        <small class="float-right">'+object.nickname+'('+object.localeTime+')</small>' +
                    '                    </div>' +
                    '                    <div id="i_'+object.id+'" class="collapse" aria-labelledby="headingOne" data-parent="#issues">' +
                    '                        <div class="card-body">' +object.content+
                    '                            <br/>' +
                    '                            <div id="def'+object.id+'"></div>' +
                    '                        </div>' +

                    '                        <div class="card-body">' +
                    '                                <div class="mb-3">' +
                    '                                    <textarea class="form-control" id="con'+object.id+'" placeholder="发表你的想法"></textarea>\n' +
                    '                                </div>' +
                    '                                <div class="btn-group  float-right" role="group" aria-label="Basic example">' +
                    '                                    <button type="button" class="btn btn btn-primary" onclick="addImage('+object.id+')">添加图片</button>' +
                    '                                    <button type="button" class="btn btn btn-primary" onclick="postComment('+object.id+')">发布</button>' +
                    '                                </div>' +
                    '                                <div class="form-group">' +
                    '                                    <a class="float-left" style="margin-right: 20px; color: red;" onclick="deleteImage('+object.id+')" href="javascript:void(0);">移除</a>' +
                    '                                    <input type="file" class="form-control-file w-25" accept="image/gif,image/jpeg,image/jpg,image/png" id="img'+object.id+'"/>' +
                    '                                </div>' +
                    '                        </div>' +
                    '                        <hr style="margin-top: 30px; margin-bottom: 0"/>' +

                        '                    <div id="div'+object.id+'">' +
                    '                        </div>'+

                    '<nav aria-label="Page navigation example">' +
                    '  <ul class="pagination pagination-sm float-right" id="commentPage'+object.id+'">' +
                    '  </ul>' +
                    '</nav>' +

                    '                    </div>' +
                    '                </div>');
                $issues.append(node);
                if (object.path != null) {
                    $("#def"+object.id).append($('<img src="'+object.path+'">'))
                }
            })
        };
        // 发送评论
        let postComment = function (id) {
            let $img = $("#img"+id);
            let $content = $("#con"+id);

            if ($content.val() === '') {
                alert("请输入内容");
                return;
            }
            let formData = new FormData();  //创建一个forData

            // 准备数据
            if ($img .val() !== '') {
                formData.append("file", $img[0].files[0])
            }
            formData.append("content", $content.val());
            formData.append("iid", id);

            $.ajax({
                url: "${pageContext.request.contextPath}/teacher/postComment",
                data: formData,
                type: "POST",
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function(data) {
                    if (data.code === 200) {
                        $content.val('');
                        $img.val('');
                        // 添加评论
                        let $commentDiv = $("#div"+id);
                        // 创建节点
                        let node = $('                    <div class="card-body">' +
                            '                                <span class="font-weight-bolder">'+data.data.comment.nickname+'</span>\n' +
                            '                                <p style="margin-top: 15px">'+data.data.comment.content+'</p>' +
                            '                                <div class="row" id="abc'+data.data.comment.id+'">' +
                            '                                </div>' +
                            '                               <small class="float-right">('+data.data.comment.localeTime+')</small>'+
                            '                            </div>' +
                            '                            <hr style="margin: 0"/>');
                        $commentDiv.prepend(node);
                        if (data.data.comment.path != null) {
                            $("#abc"+data.data.comment.id).append($('<img src="'+data.data.comment.path+'">'));
                        }


                    }
                }
            });
        }
        // 请求评论
        let pullComment = function (id, page) {
            $.ajax({
                url:"${pageContext.request.contextPath}/comment/findPage",
                datatype: "json",
                type:"POST",
                data: {
                    "id":id,
                    "page":page
                },
                success:function(data){
                    // 刷新页码
                    refreshCommentIndex(id, data);
                    // 更新数据
                    refreshComment(id, data.list)
                }
            })
        }

        // 刷新评论区页码
        let refreshCommentIndex = function(id, data) {
            // 当前页
            let now = data.pageNum;

            $(".b").remove();
            let $ul = $("#commentPage"+id);
            $.each(data.navigatepageNums,function (index,object) {
                let node;
                if (object === now) {
                    node = $('<li class="page-item b active"><a class="page-link" href="javascript:void(0);">'+object+'</a></li>')
                } else {
                    node = $('<li class="page-item b"><a class="page-link" href="javascript:void(0);" onclick="pullComment('+id+','+object+')">'+object+'</a></li>')
                }
                $ul.append(node);
            })
        };

            // 更新评论区
            let refreshComment = function(id, data) {
                // 清空数据
                let $commentDiv = $("#div"+id);
                $commentDiv.empty();
                $.each(data, function (index,object) {
                    let node = $('                    <div class="card-body">' +
                        '                                <span class="font-weight-bolder">'+object.nickname+'</span>\n' +
                        '                                <p style="margin-top: 15px">'+object.content+'</p>' +
                        '                                <div class="row" id="abc'+object.id+'">' +
                        '                                </div>' +
                        '                            </div>' +
                        '                               <small class="float-right">('+object.localeTime+')</small>'+
                        '                            <hr style="margin: 0"/>');
                    $commentDiv.append(node);
                    if (object.path != null) {
                        $("#abc"+object.id).append($('<img src="'+object.path+'">'));
                    }
                });
            };

    </script>
</html>
