<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>orange | 登录</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport"/>
    <link rel="icon" href="https://open.sojson.com/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="https://open.sojson.com/favicon.ico"/>
    <!-- CSS -->
    <link rel="stylesheet" href="http://open.sojson.com/itboy/js/itboy/app/reset.css">
    <link rel="stylesheet" href="http://open.sojson.com/itboy/js/itboy/app/supersized.css">
    <link rel="stylesheet" href="http://open.sojson.com/itboy/js/itboy/app/style.css"/>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://static.supportfolios.com/js/www/html5shiv.js"></script>
    <![endif]-->
    <style>
        canvas {
            position: fixed;
            top: 0px;
            left: 0px;
        }
    </style>
</head>
<body id="body">
<div class="page-container">
    <h1>Login</h1>
    <form id="_form" action="" method="post">
        <input type="text" name="account" class="username" placeholder="Account">
        <input type="password" name="password" class="password" placeholder="Password">
        <div style="text-align: left; margin-left: 10px;">
            <label><input type="checkbox" checked="checked" id="rememberMe"
                          style="width: 10px; height: 10px;">记住我</label>
        </div>
        <button type="button" id="login">登录</button>
        <button type="button" id="register" class="register">Register</button>
        <div class="connect">
            <p>有问题请这样解决:</p>
            <p>
                <a class="" style="width: auto; color: rgb(255, 255, 255);" target="_blank"
                   href="http://www.sojson.com/shiro">点我看本项目介绍</a>
                <a class="" style="width: auto; color: rgb(255, 255, 255);" target="_blank"
                   href="http://jq.qq.com/?_wv=1027&k=YpqCNd">交流</a>
            </p>
        </div>

        <div class="error"><span>+</span></div>
    </form>
</div>
</body>
</html>