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

    .gotodb
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

    .gotodb:hover
    {
        opacity:1;
    }

</style>

<head>
    <title>Database Info</title>
</head>

<body>
    <div class="wrapper">
    <h1>Cities and Countries Info</h1>

        <button type="button" class="gotodb">
            <a href="${pageContext.request.contextPath}/cities">Show info about cities</a>
        </button>

        <button type="button" class="gotodb">
            <a href="${pageContext.request.contextPath}/countries">Show info about countries</a>
        </button>

        <img src="pics/map.jpg" alt="WorldMap" width=60% height=70% align="middle">

    </div>
</body>
</html>
