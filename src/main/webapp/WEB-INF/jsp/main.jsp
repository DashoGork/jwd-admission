<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--    <c:set var="language" value="${RU}"  />--%>
<%--    <fmt:setLocale value="${rus_RU}" />--%>
<%--    <fmt:setBundle basename="src/main/resources/text_ru_RU.properties" />--%>

</head>
<body>
<h1 align="center"> Univercity
</h1>
<%--<form>--%>
<%--    <select id="language" name="language" onchange="submit()">--%>
<%--        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>--%>
<%--        <option value="nl" ${language == 'ru' ? 'selected' : ''}>Русский</option>--%>
<%--    </select>--%>
<%--</form>--%>
<br/>
<a href="?command=show_login" align="center" <fmt:message key="main.sign_in" />:></a>
<a href="?command=show_registration" align="center"><fmt:message key="main.registration" />:</a>
<a href="?command=show_personal_account" align="center">PA</a>
${login}

<c:if test="${listOfPassed!=null}">
    <c:forEach var="user" items="${listOfPassed}">
        <p><strong>Name:</strong> ${user.firstName}</p>
        <p><strong>Фамилия:</strong> ${user.lastName}</p>
        <p><strong>Отчество:</strong> ${user.middleName}</p>
        <p><strong>Номер паспорта:</strong> ${user.passportId}</p>
    </c:forEach>
</c:if>

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
