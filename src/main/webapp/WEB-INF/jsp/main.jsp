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
        <th>Факультет</th>
        <th>Предмет</th>
        <th>Предмет</th>
        <th>Предмет</th>
        <th>Набор</th>
    </tr>
    </thead>
    <tbody>

    <c:if test="${allFaculties==null? ShowMainPageCommand(): 2}"></c:if>
    <c:forEach var="faculty" items="${allFaculties}"
    >
    <tr>
        <td>
            <c:out value="${faculty.name}" />
        </td>
        <td>
            <c:out value="${faculty.subjects[0].getName()}" />
        </td>
        <td>
            <c:out value="${faculty.subjects[1].getName()}" />
        </td>
        <td>
            <c:out value="${faculty.subjects[2].getName()}" />
        </td>
        <td>
            <c:out value="${faculty.numberOfStudents}" />
        </td>
    </tr>
    </c:forEach>

    <c:if test="${listOfPassed!=null}">
    <c:forEach var="user" items="${listOfPassed}">
    <p><strong>Name:</strong> ${user.firstName}</p>
    <p><strong>Фамилия:</strong> ${user.lastName}</p>
    <p><strong>Отчество:</strong> ${user.middleName}</p>
    <p><strong>Номер паспорта:</strong> ${user.passportId}</p>
    </c:forEach>
    </c:if>
</body>
</html>
