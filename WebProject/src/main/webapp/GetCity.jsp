<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get City</title>
</head>


<style>

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
<h1>Info about searched city</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Country</th>
        <th>Foundation Year</th>
        <th>Square</th>
        <th>Population</th>
    </tr>

    <tr>
        <td>
            <c:out value="${requestScope.searchedCity.id}"/>
        </td>
        <td>
            <c:out value="${requestScope.searchedCity.name}"/>
        </td>
        <td>
            <c:out value="${requestScope.searchedCity.country}"/>
        </td>
        <td>
            <c:out value="${requestScope.searchedCity.foundationYear}"/>
        </td>
        <td>
            <c:out value="${requestScope.searchedCity.square}"/>
        </td>
        <td>
            <c:out value="${requestScope.searchedCity.population}"/>
        </td>
    </tr>

</table>
</body>
</html>
