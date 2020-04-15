<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cities</title>
</head>

<style>

    .container
    {
        padding: 15px;
    }

    h1
    {
        text-align: center;
    }

    th
    {
        background-color: #bc8387;
        color: white;
    }

    table
    {
        border: 1px;
        border-collapse: collapse;
        width: 100%;
        text-align: center;
        border: 1px solid black;
    }

    th, td
    {
        padding: 15px;
        border: 1px solid black;
    }

    tr:hover
    {
        background-color: #f5f5f5;
    }
</style>

<body>

<h1>Cities</h1>

<form action="${pageContext.request.contextPath}/cities" id="edit" method="post">

    <div class="container">
        Please select an action:

        <select form="edit" id="actions" name="city_action" autofocus>
            <option value="create">Create a record</option>
            <option value="read">Read the record</option>
            <option value="update">Update the record</option>
            <option value="delete">Delete the record</option>
        </select>

        <input type="submit" value="Submit">
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Country</th>
            <th>Foundation Year</th>
            <th>Square</th>
            <th>Population</th>
        </tr>
        <c:forEach items="${cities}" var="city">
            <tr>
                <td>
                    <c:out value="${city.id}"/>
                </td>
                <td>
                    <c:out value="${city.name}"/>
                </td>
                <td>
                    <c:out value="${city.country}"/>
                </td>
                <td>
                    <c:out value="${city.foundationYear}"/>
                </td>
                <td>
                    <c:out value="${city.square}"/>
                </td>
                <td>
                    <c:out value="${city.population}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
