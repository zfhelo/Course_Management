<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/navs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Title</title>
        <link href="../../../css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <!--发帖-->
        <div class="container">
            <form>
                <div class="form-group w-25" style="margin-top: 20px">
                    <label for="exampleInputEmail1">标题</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>

                <div class="form-group">
                    <label for="exampleFormControlTextarea1">内容</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>
                <div class="btn-group  float-right" role="group" aria-label="Basic example">
                    <button type="button" class="btn btn btn-primary">添加附件</button>
                    <button type="button" class="btn btn btn-primary">发布</button>
                </div>
                <div class="form-group">
                    <span class="float-left" style="margin-right: 20px; color: red">删除</span>
                    <input type="file" class="form-control-file w-25" id="exampleFormControlFile11">
                    <span class="float-left" style="margin-right: 20px; color: red">删除</span>
                    <input type="file" class="form-control-file w-25" id="exampleFormControlFile21">
                </div>
            </form>
        </div>
        <!--评论-->
        <div class="container" style="margin-top: 50px">
            <!--查找-->
            <div style="margin-bottom: 20px">
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="标题" aria-label="Search">
                    <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">搜索</button>
                </form>
            </div>

            <div class="accordion" id="accordionExample">
                <!--评论部分-->
                <div class="card">
                    <div class="card-header" id="headingOne">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                快速排序详解
                            </button>
                        </h2>
                    </div>

                    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                        <div class="card-body">
                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                            <br/>
                            <img src="../../../images/web/cover.png">
                        </div>
                        <!--写评论-->
                        <div class="card-body">
                            <form>
                                <div class="mb-3">
                                    <textarea class="form-control" id="validationTextarea" placeholder="发表你的想法" required></textarea>
                                </div>

                                <div class="btn-group  float-right" role="group" aria-label="Basic example">
                                    <button type="button" class="btn btn btn-primary">添加附件</button>
                                    <button type="button" class="btn btn btn-primary">发布</button>
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
                        <hr style="margin-top: 30px; margin-bottom: 0"/>
                        <!--评论-->
                        <div class="card-body">
                            <img src="../../../images/web/学习中心.svg" style="width: 40px">
                            <span class="font-weight-bolder">郑海锋</span>
                            <p style="margin-top: 30px">666</p>
                            <div class="row">
                                <img src="../../../images/web/cover.png">
                            </div>
                        </div>

                        <hr style="margin: 0"/>
                        <div class="card-body">
                            你真菜
                            <div class="row">
                                <img src="../../../images/web/code.PNG">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header" id="headingTwo">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                Collapsible Group Item #2
                            </button>
                        </h2>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                        <div class="card-body">
                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header" id="headingThree">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                Collapsible Group Item #3
                            </button>
                        </h2>
                    </div>
                    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                        <div class="card-body">
                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                        </div>
                    </div>
                </div>
            </div>
            <!--分页-->
            <div class="float-right" style="margin-top: 10px">
                <nav aria-label="...">
                    <ul class="pagination">
                        <li class="page-item disabled">
                            <span class="page-link">首页</span>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item active" aria-current="page">
                  <span class="page-link">
                    2
                    <span class="sr-only">(current)</span>
                  </span>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">尾页</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </body>
    <script src="../../../js/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="../../../js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
