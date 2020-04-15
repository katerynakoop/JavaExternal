<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
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

<h1>Countries</h1>

<form action="${pageContext.request.contextPath}/countries" id="edit" method="post">
<div class="container">
    Please select an action:

    <select form="edit" id="actions" name="country_action" autofocus>
        <option value="create">Create a record</option>
        <option value="read">Read the record</option>
        <option value="update">Update the record</option>
        <option value="delete">Delete the record</option>
    </select>

    <input type="submit" value="Submit">
</div>

    <table>
        <tr>
            <th>Name</th>
            <th>Citizens</th>
            <th>Language</th>
        </tr>
        <c:forEach items="${countries}" var="country">
            <tr>
                <td>
                    <c:out value="${country.name}"/>
                </td>
                <td>
                    <c:out value="${country.citizenName}"/>
                </td>
                <td>
                    <c:out value="${country.language}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
