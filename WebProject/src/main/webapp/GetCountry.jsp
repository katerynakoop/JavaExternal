<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get Country</title>
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
<h1>Info about searched country</h1>

<table>
    <tr>
        <th>Name</th>
        <th>Citizen Name</th>
        <th>Language</th>
    </tr>

    <tr>
        <td>
            <c:out value="${requestScope.searchedCountry.name}"/>
        </td>
        <td>
            <c:out value="${requestScope.searchedCountry.citizenName}"/>
        </td>
        <td>
            <c:out value="${requestScope.searchedCountry.language}"/>
        </td>
    </tr>

</table>
</body>
</html>
