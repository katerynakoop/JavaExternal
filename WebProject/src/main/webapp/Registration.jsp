<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
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

    .registerbtn
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

    .registerbtn:hover
    {
        opacity:1;
    }

    a
    {
        color: cornflowerblue;
    }

</style>

<body>

<form action="${pageContext.request.contextPath}/registration" method="post">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" id="username" name="username" required>

        <label for="firstname"><b>Firstname</b></label>
        <input type="text" placeholder="Enter Firstname"  id="firstname" name="firstname" required>

        <label for="lastname"><b>Lastname</b></label>
        <input type="text" placeholder="Enter Lastname" id="lastname" name="lastname" required>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" id="email" name="email" required>

        <label for="phone-number"><b>Phone Number</b></label>
        <input type="text" placeholder="Enter Phone Number" id="phone-number" name="phoneNum" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" id="password" name="password" required>

        <hr>

        <button type="submit" class="registerbtn">Register</button>
    </div>
</form>

</body>
</html>