<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<%@ page contentType="text/html" %>

<style>
    {box-sizing: border-box}

    h1
    {
        text-align: center;
    }

    .container
    {
        padding: 16px;
    }

    input[type=text], input[type=password]
    {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }

    input[type=text]:focus, input[type=password]:focus
    {
        background-color: #ddd;
        outline: none;
    }

    hr
    {
        border: 1px solid #f1f1f1;
        margin-bottom: 25px;
    }

    .loginbtn
    {
        background-color: #bc8387;
        color: white;
        padding: 16px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }

    .loginbtn:hover
    {
        opacity:1;
    }

</style>

<body>

<form action="${pageContext.request.contextPath}/login" method="post">
    <div class="container">
        <h1>Login</h1>
        <p>Please fill in this form to login.</p>

        <hr>
        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" id="username" name="username" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" id="password" name="password" required>
        <hr>

        <button type="submit" class="loginbtn">Log in</button>
    </div>
</form>

</body>
</html>