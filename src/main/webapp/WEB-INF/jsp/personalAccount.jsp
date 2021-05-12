<%--
  Created by IntelliJ IDEA.
  User: Юзер
  Date: 05.04.2021
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPA</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<c:if test="${users!=null}">
<c:forEach var="user" items="${users}">
<p><strong>Login:</strong> ${user.login}</p>
<p><strong>Password:</strong> ${user.password}</p>
<p><strong>Name:</strong> ${user.firstName}</p>
<p><strong>Фамилия:</strong> ${user.lastName}</p>
<p><strong>Отчество:</strong> ${user.middleName}</p>
<p><strong>Отчество:</strong> ${user.passportId}</p>

    <a href="?command=approve?id=${user.id}">Approve</a>
    <a href="?command=delete?id=${user.id}">Delete</a></td>
    <a href="?command=calculate">Calculate</a></td>
</c:forEach>
</c:if>
<c:if test="${user!=null}">

        <p><strong>Login:</strong> ${user.login}</p>
        <p><strong>Password:</strong> ${user.password}</p>
        <p><strong>Name:</strong> ${user.firstName}</p>
        <p><strong>Фамилия:</strong> ${user.lastName}</p>
        <p><strong>Отчество:</strong> ${user.middleName}</p>
        <p><strong>Отчество:</strong> ${user.passportId}</p>
    <p><strong>Количество баллов:</strong> ${req.score}</p>
    <p><strong>Статус заявки:</strong> ${req.approved}</p>



    <td><a href="?command=show_edit?id=${user.id}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="?command=delete?id=${user.id}">Delete</a></td>
</c:if>


</body>
</html>
