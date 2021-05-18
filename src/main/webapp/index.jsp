<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<c:if test="${not empty param.language}">--%>
<%--    <c:set var="language" value="${param.language}" scope="session"/>--%>
<%--</c:if>--%>
<%--<fmt:setLocale value="${language}" />--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="bundles\text"/>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>

</head>
<body>
<h1 align="center"> Univercity
</h1>
<a href="?command=language?id=en" align="center">English</a>
<a href="?command=language?id=ru" align="center">Русский</a>
<a href="?command=show_registration" align="center"><fmt:message key="main.registration"/></a>
<a href="?command=show_personal_account" align="center"><fmt:message key="main.PA"/></a>
<c:if test="${role==null}"><a href="?command=show_login"><fmt:message key="main.sign_in"/></a></c:if>

${login}
<c:if test="${role!=null}"><a href="?command=log_out" align="center"><fmt:message key="main.sign_out"/></a></c:if>

<table class="table table-bordered">
    <thead>
    <tr>
        <th><fmt:message key="registration.faculty"/></th>
        <th><fmt:message key="subject"/></th>
        <th><fmt:message key="subject"/></th>
        <th><fmt:message key="subject"/></th>
        <th><fmt:message key="numberOfStudents"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="faculty" items="${allFaculties}"
    >
    <tr>
        <td>
            <c:out value="${faculty.name}"/>
        </td>
        <td>
            <c:out value="${faculty.subjects[0].getName()}"/>
        </td>
        <td>
            <c:out value="${faculty.subjects[1].getName()}"/>
        </td>
        <td>
            <c:out value="${faculty.subjects[2].getName()}"/>
        </td>
        <td>
            <c:out value="${faculty.numberOfStudents}"/>
        </td>
    </tr>
    </c:forEach>

    <c:if test="${listOfPassed!=null}">
    <c:forEach var="user" items="${listOfPassed}">
    <p><strong><fmt:message key="registration.name"/>: </strong> ${user.firstName}</p>
    <p><strong><fmt:message key="registration.lastname"/>: </strong> ${user.lastName}</p>
    <p><strong><fmt:message key="registration.middlename"/>: </strong> ${user.middleName}</p>
    <p><strong><fmt:message key="registration.passportId"/>: </strong> ${user.passportId}</p>
    </c:forEach>
    </c:if>
</body>
</html>
