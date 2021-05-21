<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="bundles\text"/>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <%--    <link rel="stylesheet" href="./css/normalize.css">--%>
    <%--    <link rel="stylesheet" href="./css/style.css">--%>
</head>
<h1 id="landing" class="visually-hidden">Online Zoo</h1>
<header class="header">
    <a href="">
        <div class="logo header__logo"></div>
    </a>
    <ul class="menu header__menu">
        <li class="menu__item menu__item_current-page"><a class="link list-item__link_gray" href="">Personal Area</a>
        </li>
        <li class="reg-item">
            <ul class="menu ">
                <c:if test="${listOfPassed==null}">
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

<h1 align="center"> Univercity
</h1>
<c:if test="${listOfPassed==null}"><a href="?command=show_registration" align="center"><fmt:message
        key="main.registration"/></a></c:if>
<a href="?command=show_personal_account" align="center"><fmt:message key="main.PA"/></a>
<c:if test="${role==null}"><a href="?command=show_login"><fmt:message key="main.sign_in"/></a></c:if>

${login}
<c:if test="${role!=null}"><a href="?command=log_out" align="center"><fmt:message key="main.sign_out"/></a></c:if>

<main class="main">
    <div class="headline">
        <div class="page-icon"></div>
        <h2>Score Page</h2>
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
        <c:forEach var="user" items="${listOfPassedFromMMf}">
            <p><strong>MMF</strong></p>
            <p><strong><fmt:message key="registration.name"/>: </strong> ${user.firstName}</p>
            <p><strong><fmt:message key="registration.lastname"/>: </strong> ${user.lastName}</p>
            <p><strong><fmt:message key="registration.middlename"/>: </strong> ${user.middleName}</p>
            <p><strong><fmt:message key="registration.passportId"/>: </strong> ${user.passportId}</p>
        </c:forEach>
    </c:if>
    <c:if test="${listOfPassedFromRfikt!=null}">
        <c:forEach var="user" items="${listOfPassedFromRfikt}">
            <p><strong>RFIKT</strong></p>
            <p><strong><fmt:message key="registration.name"/>: </strong> ${user.firstName}</p>
            <p><strong><fmt:message key="registration.lastname"/>: </strong> ${user.lastName}</p>
            <p><strong><fmt:message key="registration.middlename"/>: </strong> ${user.middleName}</p>
            <p><strong><fmt:message key="registration.passportId"/>: </strong> ${user.passportId}</p>
        </c:forEach>
    </c:if>
    <c:if test="${listOfPassedFromFmo!=null}">
        <c:forEach var="user" items="${listOfPassedFromFmo}">
            <p><strong>FMO</strong></p>
            <p><strong><fmt:message key="registration.name"/>: </strong> ${user.firstName}</p>
            <p><strong><fmt:message key="registration.lastname"/>: </strong> ${user.lastName}</p>
            <p><strong><fmt:message key="registration.middlename"/>: </strong> ${user.middleName}</p>
            <p><strong><fmt:message key="registration.passportId"/>: </strong> ${user.passportId}</p>
        </c:forEach>
    </c:if>
    <c:if test="${listOfPassedFromBio!=null}">
        <c:forEach var="user" items="${listOfPassedFromBio}">
            <p><strong>BIO</strong></p>
            <p><strong><fmt:message key="registration.name"/>: </strong> ${user.firstName}</p>
            <p><strong><fmt:message key="registration.lastname"/>: </strong> ${user.lastName}</p>
            <p><strong><fmt:message key="registration.middlename"/>: </strong> ${user.middleName}</p>
            <p><strong><fmt:message key="registration.passportId"/>: </strong> ${user.passportId}</p>
        </c:forEach>
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

<script src="./js/index.js "></script>
</body>
</html>
