<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport"/>
    <link rel="stylesheet" href="system/css/reset.css" type="text/css">
    <link rel="stylesheet" href="system/css/supersized.css" type="text/css">
    <link rel="stylesheet" href="system/css/style.css" type="text/css">
</head>
<body id="body">
<div class="page-container">
    <h1>Login</h1>
    <form id="_form" action="" method="post">
        <input type="text" name="account" class="username" placeholder="用户名">
        <input type="password" name="password" class="password" placeholder="密码">
        <div style="text-align: left; margin-left: 10px;">
            <label>
                <input type="checkbox" checked="checked" id="rememberMe" style="width: 10px; height: 10px;">记住我
            </label>
        </div>
        <button type="button" id="login">登录</button>
        <button type="button" id="register" class="register">注册</button>
    </form>
</div>
</body>
</html>