<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="bundles\text"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <style>
        <%@include file="../css/normalize.css" %>
    </style>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <title>PA</title>
</head>
<body class="theme-light">
<header class="header">
    <a href="">
        <div class="logo header__logo"></div>
    </a>
    <div class="language-changer">
        <p>Locale:</p>
        <a href="?command=language?id=ru">Rus</a>
        <span>|</span>
        <a href="?command=language?id=en">Eng</a>
    </div>
</header>
<main class="main">
    <c:if test="${users!=null}">
        <div class="headline">
            <div class="page-icon"></div>
            <h2>Admin's Page</h2>
        </div>
<%--        tut--%>
        <c:if test="${!calculated}">

            <a href="?command=calculate" class="button button-calc button-submit"><fmt:message
                    key="personalAccount.Calculate"/></a>
        </c:if>
        <%--        tut--%>
        <div class="table-wrapper">
            <table class="table">
                <thead>
                <tr>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.lastname"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.name"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.middlename"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.passportId"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="personalAccount.Approve"/>/<fmt:message
                                key="personalAccount.Delete"/></div>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>
                            <div class="family">${user.getPersonalInformation().getLastName()}</div>
                        </td>
                        <td>${user.getPersonalInformation().getFirstName()}</td>
                        <td>${user.getPersonalInformation().getMiddleName()}</td>
                        <td>${user.getPersonalInformation().getPassportId()}</td>
                        <td>
                            <div class="group-buttons table-buttons">
                                <c:if test="${!calculated}">
                                <a href="?command=approve?id=${user.id}" class="button button-submit"><fmt:message
                                        key="personalAccount.Approve"/></a>
                                <a href="?command=delete?id=${user.id}" class="button button-delete"><fmt:message
                                        key="personalAccount.Delete"/></a>
                                </c:if>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
    <c:if test="${user!=null}">
        <div class="headline">
            <div class="page-icon"></div>
            <h2>Personal Account</h2>
        </div>
        <div class="card-wrapper">
            <div class="card information-card">
                <h3 class="information-title">Personal info</h3>
                <div class="information-row">
                    <h4><fmt:message key="registration.login"/>:</h4>
                    <p> ${user.login}</p>
                </div>
                <div class="information-row">
                    <h4><fmt:message key="registration.password"/>:</h4>
                    <p>${user.password}</p>
                </div>
                <div class="information-row">
                    <h4><fmt:message key="registration.name"/>: </h4>
                    <p>${user.getPersonalInformation().getFirstName()}</p>
                </div>
                <div class="information-row">
                    <h4><fmt:message key="registration.lastname"/>: </h4>
                    <p>${user.getPersonalInformation().getLastName()}</p>
                </div>
                <div class="information-row">
                    <h4><fmt:message key="registration.middlename"/>: </h4>
                    <p>${user.getPersonalInformation().getMiddleName()}</p>
                </div>
                <div class="information-row">
                    <h4><fmt:message key="registration.passportId"/>: </h4>
                    <p>${user.getPersonalInformation().getPassportId()}</p>
                </div>
                <div class="information-row">
                    <h4><fmt:message key="score"/>: </h4>
                    <p>${req.score}</p>
                </div>
                <div class="card-status">
                    <h4><fmt:message key="personalAccount.Status"/>: </h4>
                    <p><c:if test="${req.approved==0}">
                        <fmt:message key="personalAccount.StatusUnderConsideration"/></c:if>
                        <c:if test="${req.approved==1}">
                            <fmt:message key="personalAccount.StatusApproved"/></c:if>
                    </p>
                </div>
            </div>
            <div class="group-buttons card-buttons">

                <c:if test="${!calculated}">
                    <c:if test="${req.approved==0}">
                <a href="?command=show_edit?id=${user.id}" class="button button-edit first-button"><fmt:message
                        key="personalAccount.Edit"/></a>
                    </c:if>
                <a href="?command=delete?id=${user.id}" class="button button-delete"><fmt:message
                        key="personalAccount.Delete"/></a>
                </c:if>
            </div>
        </div>
    </c:if>
</main>
<footer class="footer">
    <div class="footer-container">
        <div class="footer__logo-section">
            <a href="#">
                <div class="logo footer__logo"></div>
            </a>
        </div>
        <a class="github" href="#" target="_blank" rel="noopener noreferrer">github</a>
        </a>
    </div>
</footer>
</body>
</html>