<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <style type="text/css">
        .content {
            width: 643px;
            margin: 200px auto;
            text-align: center;
        }

        input[type='text'] {
            width: 530px;
            height: 40px;
            font-size: 14px;
        }

        input[type='button'] {
            width: 100px;
            height: 46px;
            background: #38f;
            border: 0;
            color: #fff;
            font-size: 15px
        }

        .show {
            position: absolute;
            width: 535px;
            height: 100px;
            border: 1px solid #999;
            border-top: 0;
            display: none;
        }
    </style>
    <script src="jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="content">
    <img alt="" src="img/logo.png"><br/><br/>
    <input type="text" id="word" name="word">
    <input type="button" value="搜索一下">
    <div class="show" id="show"></div>
</div>
</body>
<script>
    $(function () {
        $("#word").keyup(function () {
            var word=$(this).val();
            if (word){
                $.ajax({
                    url:"SearchServlet",
                    data:{word:word},
                    dataType:"json",
                    success:function (result) {
                        if ($("#show").children("div").length<1){
                            if (result.length>0){
                                for (var user3 of result){
                                    $(".show").append("<div>"+user3.name+"</div>");
                                }
                                $(".show").show();
                            }
                        }
                    },
                    error:function () {
                        alert("服务器忙...");
                    }
                });
            }else {
                $("#show").empty();
                $("#show").hide();

            }
        });
    });
</script>
</html>
