<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read Record</title>
</head>


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

    .submitbtn
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

    .submitbtn:hover
    {
        opacity:1;
    }

    a
    {
        color: cornflowerblue;
    }

</style>

<body>

<c:set var = "object" scope = "request" value = "${requestScope.obj}"/>

<c:choose>
    <c:when test ="${object == 'city'}">

        <form action="${pageContext.request.contextPath}/get-city" method="get">
            <div class="container">
                <h1>Get info about city</h1>
                <p>Enter city's id please: </p>
                <hr>

                <label for="cityId"><b>City's ID</b></label>
                <input type="text" placeholder="Enter city's id you search" id="cityId" name="cityId" required>

                <hr>

                <button type="submit" class="submitbtn">Get info</button>
            </div>
        </form>
    </c:when>

    <c:when test="${object == 'country'}">
        <form action="${pageContext.request.contextPath}/get-country" method="get">
            <div class="container">
                <h1>Get info about country</h1>
                <p>Enter country's name please: </p>

                <hr>
                <label for="countryName"><b>Name</b></label>
                <input type="text" placeholder="Enter country's name" id="countryName" name="countryName" required>
                <hr>

                <button type="submit" class="submitbtn">Get info</button>
            </div>
        </form>
    </c:when>

</c:choose>

</body>
</html>
