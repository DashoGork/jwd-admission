<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="bundles\text"/>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        <%@include file="WEB-INF/css/style.css" %>
    </style>
    <style>
        <%@include file="WEB-INF/css/normalize.css" %>
    </style>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
</head>
<h1 id="landing" class="visually-hidden">Univercity</h1>
<header class="header">
    <a href="">
        <div class="logo header__logo"></div>
    </a>
    <ul class="menu header__menu">
        <li class="menu__item menu__item_current-page"><a class="link list-item__link_gray"
                                                          href="?command=show_personal_account"><fmt:message
                key="main.PA"/></a>
        </li>
        <li class="reg-item">
            <ul class="menu ">
                ${login}
                <c:if test="${!calculated}">
                    <li class="menu__item"><a class="link list-item__link_gray" href="?command=show_registration">
                        <fmt:message key="main.registration"/></a></li>
                </c:if>
                <c:if test="${role==null}">
                    <li class="menu__item"><a class="link list-item__link_gray" href="?command=show_login"><fmt:message
                            key="main.sign_in"/></a></li>
                </c:if>
                <c:if test="${role!=null}">
                    <li class="menu__item"><a href="?command=log_out" align="center"><fmt:message
                            key="main.sign_out"/></a></li>
                </c:if>
            </ul>
        </li>

    </ul>
    <div class="language-changer">
        <p>Locale:</p>
        <a href="?command=language?id=ru">Rus</a>
        <span>|</span>
        <a href="?command=language?id=en">Eng</a>
    </div>
</header>
<body>

<main class="main">
    <div class="headline">
        <div class="page-icon"></div>
        <h2>Univercity</h2>
    </div>
    <div class="table-wrapper">
        <table class="table">
            <thead>
            <tr>
                <th class="table-head-item">
                    <div class="thead-title"><fmt:message key="registration.faculty"/></div>
                </th>
                <th class="table-head-item">
                    <div class="thead-title"><fmt:message key="subject"/></div>
                </th>
                <th class="table-head-item">
                    <div class="thead-title"><fmt:message key="subject"/></div>
                </th>
                <th class="table-head-item">
                    <div class="thead-title"><fmt:message key="subject"/></div>
                </th>
                <th class="table-head-item">
                    <div class="thead-title"><fmt:message key="numberOfStudents"/></div>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="faculty" items="${allFaculties}">
                <tr>
                    <td><c:out value="${faculty.name}"/></td>
                    <td><c:out value="${faculty.subjects[0].getName()}"/></td>
                    <td><c:out value="${faculty.subjects[1].getName()}"/></td>
                    <td><c:out value="${faculty.subjects[2].getName()}"/></td>
                    <td>
                        <c:out value="${faculty.numberOfStudents}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <c:if test="${listOfPassedFromMMf!=null}">
        <div class="table-wrapper">
            <table class="table">
                <p><strong>MMF</strong></p>
                <thead>
                <tr>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.name"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.lastname"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.middlename"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.passportId"/></div>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${listOfPassedFromMMf}">
                    <tr>
                        <td><c:out value="${user.getPersonalInformation().getFirstName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getLastName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getMiddleName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getPassportId()}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

    <c:if test="${listOfPassedFromRfikt!=null}">
        <div class="table-wrapper">
            <table class="table">
                <p><strong>RFIKT</strong></p>
                <thead>
                <tr>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.name"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.lastname"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.middlename"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.passportId"/></div>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${listOfPassedFromRfikt}">
                    <tr>
                        <td><c:out value="${user.getPersonalInformation().getFirstName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getLastName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getMiddleName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getPassportId()}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

    <c:if test="${listOfPassedFromFmo!=null}">
        <div class="table-wrapper">
            <table class="table">
                <p><strong>FMO</strong></p>
                <thead>
                <tr>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.name"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.lastname"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.middlename"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.passportId"/></div>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${listOfPassedFromFmo}">
                    <tr>
                        <td><c:out value="${user.getPersonalInformation().getFirstName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getLastName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getMiddleName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getPassportId()}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

    <c:if test="${listOfPassedFromBio!=null}">
        <div class="table-wrapper">
            <table class="table">
                <p><strong>BIO</strong></p>
                <thead>
                <tr>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.name"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.lastname"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.middlename"/></div>
                    </th>
                    <th class="table-head-item">
                        <div class="thead-title"><fmt:message key="registration.passportId"/></div>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${listOfPassedFromBio}">
                    <tr>
                        <td><c:out value="${user.getPersonalInformation().getFirstName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getLastName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getMiddleName()}"/></td>
                        <td><c:out value="${user.getPersonalInformation().getPassportId()}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
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
