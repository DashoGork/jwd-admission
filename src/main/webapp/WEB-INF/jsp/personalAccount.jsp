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
<c:forEach var="user" items="${user}">
<p><strong>Login:</strong> ${user.login}</p>
<p><strong>Paasword:</strong> ${user.password}</p>
<p><strong>Nmae:</strong> ${user.firstName}</p>
<p><strong>Фамилия:</strong> ${user.lastName}</p>
<p><strong>Отчество:</strong> ${user.middleName}</p>
<p><strong>Отчество:</strong> ${user.passportId}</p>


    <a href="?command=approve?id=${user.id}">Approve</a>
<td><a href="?command=show_edit?id=${user.id}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="?command=delete?id=${user.id}">Delete</a></td>
</c:forEach>
</body>
</html>
