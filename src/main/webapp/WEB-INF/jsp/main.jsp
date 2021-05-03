<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<h1 align="center"> Univercity
</h1>
<br/>
<a href="?command=show_login">Sign In</a>
<a href="?command=show_registration">Registration</a>
<a href="?command=show_personal_account">PA</a>

<a href="home">FC</a>
${login}
${role}

<a href="">List of All</a>

<table class="table table-bordered">
    <thead>
    <tr>
        <th>login</th>
        <th>password</th>
        <th>Email</th>
        <th>Country</th>
        <th>Actions</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <!--   for (Todo todo: todos) {  -->
    <c:forEach var="faculty" items="${allFaculties}"
    >
    <tr>
        <td>
            <c:out value="${faculty.name}" />
        </td>
        <td>
            <c:out value="${faculty.subjectIds[0]}" />
        </td>
        <td>
            <c:out value="${faculty.subjectIds[1]}" />
        </td>
        <td>
            <c:out value="${faculty.subjectIds[2]}" />
        </td>
        <td>
            <c:out value="${faculty.numberOfStudents}" />
        </td>
    </tr>
    </c:forEach>
</body>
</html>
