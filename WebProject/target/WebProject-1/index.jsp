<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>

    h1
    {
        text-align: center;
    }

    .wrapper
    {
        text-align: center;
    }

    a
    {
        text-decoration: none;
        color: white;
        font-size: 120%;
    }

    .btn
    {
        position: center;
        align-content: center;
        text-align: center;
        background-color: #bc8387;
        color: white;
        padding: 16px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 60%;
        opacity: 0.9;
    }

    .btn:hover
    {
        opacity:1;
    }

</style>

<head>
    <title>Home</title>
</head>

<body>
<div class="wrapper">
    <h1>Cities and Countries Info</h1>

    <button type="button" class="btn">
        <a href="${pageContext.request.contextPath}/registration">Register</a>
    </button>

    <button type="button" class="btn">
        <a href="${pageContext.request.contextPath}/login">Log in</a>
    </button>
</div>

<img src="pics/homepic.jpg" alt="City" width=100% height=75% align="middle">

</body>
</html>