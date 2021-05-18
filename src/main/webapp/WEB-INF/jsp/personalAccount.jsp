<%--
  Created by IntelliJ IDEA.
  User: Юзер
  Date: 05.04.2021
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="bundles\text"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPA</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<c:if test="${users!=null}">
    <c:forEach var="user" items="${users}">
        <p><strong><fmt:message key="registration.login"/>: </strong> ${user.login}</p>
        <p><strong><fmt:message key="registration.password"/>: </strong> ${user.password}</p>
        <p><strong><fmt:message key="registration.name"/>: </strong> ${user.firstName}</p>
        <p><strong><fmt:message key="registration.lastname"/>:</strong> ${user.lastName}</p>
        <p><strong><fmt:message key="registration.middlename"/>:</strong> ${user.middleName}</p>
        <p><strong><fmt:message key="registration.passportId"/>:</strong> ${user.passportId}</p>

        <a href="?command=approve?id=${user.id}"><fmt:message key="personalAccount.Approve"/></a>
        <a href="?command=delete?id=${user.id}"><fmt:message key="personalAccount.Delete"/></a></td>
        <a href="?command=calculate"><fmt:message key="personalAccount.Calculate"/></a></td>
    </c:forEach>
</c:if>
<c:if test="${user!=null}">

    <p><strong><fmt:message key="registration.login"/>: </strong> ${user.login}</p>
    <p><strong><fmt:message key="registration.password"/>: </strong> ${user.password}</p>
    <p><strong><fmt:message key="registration.name"/>: </strong> ${user.firstName}</p>
    <p><strong><fmt:message key="registration.lastname"/>:</strong> ${user.lastName}</p>
    <p><strong><fmt:message key="registration.middlename"/>:</strong> ${user.middleName}</p>
    <p><strong><fmt:message key="registration.passportId"/>:</strong> ${user.passportId}</p>
    <p><strong><fmt:message key="score"/>: </strong> ${req.score}</p>
    <p><strong><fmt:message key="personalAccount.Status"/>:</strong> ${req.approved} <c:if test="${req.approved==0}">
        <fmt:message key="personalAccount.StatusUnderConsideration"/></c:if>
        <c:if test="${req.approved==1}"> <fmt:message key="personalAccount.StatusApproved"/></c:if>
    </p>


    <td><a href="?command=show_edit?id=${user.id}"><fmt:message key="personalAccount.Edit"/></a> &nbsp;&nbsp;&nbsp;&nbsp;
        <a
                href="?command=delete?id=${user.id}"><fmt:message key="personalAccount.Delete"/></a></td>
</c:if>


</body>
</html>
