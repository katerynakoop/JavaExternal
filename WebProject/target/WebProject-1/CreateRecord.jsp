<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Record</title>
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

        <form action="${pageContext.request.contextPath}/create-city" method="post">
            <div class="container">
                <h1>Create a new record</h1>
                <p>Fill in info about city please: </p>
                <hr>

                <label for="cityName"><b>Name</b></label>
                <input type="text" placeholder="Enter city's name" id="cityName" name="cityName" required>

                <label for="country"><b>Country</b></label>
                <input type="text" placeholder="Enter city's country " id="country" name="country" required>

                <label for="foundationYear"><b>Foundation Year</b></label>
                <input type="text" placeholder="Enter city's foundation year"  id="foundationYear" name="foundationYear" required>

                <label for="square"><b>Square</b></label>
                <input type="text" placeholder="Enter city's square" id="square" name="square" required>

                <label for="population"><b>Population</b></label>
                <input type="text" placeholder="Enter city's population" id="population" name="population" required>

                <hr>

                <button type="submit" class="submitbtn">Create</button>
            </div>
        </form>
    </c:when>

    <c:when test="${object == 'country'}">
        <form action="${pageContext.request.contextPath}/create-country" method="post">
            <div class="container">
                <h1>Create a new record</h1>
                <p>Fill in info about country please: </p>
                <hr>
                <label for="name"><b>Name</b></label>
                <input type="text" placeholder="Enter country's name" id="name" name="name" required>

                <label for="citizenName"><b>Citizen name</b></label>
                <input type="text" placeholder="Enter citizen's name " id="citizenName" name="citizenName" required>

                <label for="language"><b>Language</b></label>
                <input type="text" placeholder="Enter country's official language"  id="language" name="language" required>

                <hr>

                <button type="submit" class="submitbtn">Create</button>
            </div>
        </form>
    </c:when>

</c:choose>

</body>
</html>
