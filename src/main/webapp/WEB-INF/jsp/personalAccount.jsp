<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Юзер--%>
<%--  Date: 05.04.2021--%>
<%--  Time: 19:16--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%--<fmt:setBundle basename="bundles\text"/>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>UserPA</title>--%>
<%--    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--</head>--%>
<%--<body>--%>
<%--<c:if test="${users!=null}">--%>
<%--    <c:forEach var="user" items="${users}">--%>
<%--        <p><strong><fmt:message key="registration.login"/>: </strong> ${user.login}</p>--%>
<%--        <p><strong><fmt:message key="registration.password"/>: </strong> ${user.password}</p>--%>
<%--        <p><strong><fmt:message key="registration.name"/>: </strong> ${user.firstName}</p>--%>
<%--        <p><strong><fmt:message key="registration.lastname"/>:</strong> ${user.lastName}</p>--%>
<%--        <p><strong><fmt:message key="registration.middlename"/>:</strong> ${user.middleName}</p>--%>
<%--        <p><strong><fmt:message key="registration.passportId"/>:</strong> ${user.passportId}</p>--%>

<%--        <a href="?command=approve?id=${user.id}"><fmt:message key="personalAccount.Approve"/></a>--%>
<%--        <a href="?command=delete?id=${user.id}"><fmt:message key="personalAccount.Delete"/></a></td>--%>
<%--        <a href="?command=calculate"><fmt:message key="personalAccount.Calculate"/></a></td>--%>
<%--    </c:forEach>--%>
<%--</c:if>--%>
<%--<c:if test="${user!=null}">--%>

<%--    <p><strong><fmt:message key="registration.login"/>: </strong> ${user.login}</p>--%>
<%--    <p><strong><fmt:message key="registration.password"/>: </strong> ${user.password}</p>--%>
<%--    <p><strong><fmt:message key="registration.name"/>: </strong> ${user.firstName}</p>--%>
<%--    <p><strong><fmt:message key="registration.lastname"/>:</strong> ${user.lastName}</p>--%>
<%--    <p><strong><fmt:message key="registration.middlename"/>:</strong> ${user.middleName}</p>--%>
<%--    <p><strong><fmt:message key="registration.passportId"/>:</strong> ${user.passportId}</p>--%>
<%--    <p><strong><fmt:message key="score"/>: </strong> ${req.score}</p>--%>
<%--    <p><strong><fmt:message key="personalAccount.Status"/>:</strong> ${req.approved} <c:if test="${req.approved==0}">--%>
<%--        <fmt:message key="personalAccount.StatusUnderConsideration"/></c:if>--%>
<%--        <c:if test="${req.approved==1}"> <fmt:message key="personalAccount.StatusApproved"/></c:if>--%>
<%--    </p>--%>


<%--    <td><a href="?command=show_edit?id=${user.id}"><fmt:message key="personalAccount.Edit"/></a> &nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--        <a--%>
<%--                href="?command=delete?id=${user.id}"><fmt:message key="personalAccount.Delete"/></a></td>--%>
<%--</c:if>--%>


<%--</body>--%>
<%--</html>--%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="bundles\text"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="./css/normalize.css">
    <link rel="stylesheet" href="./css/style.css">
    <title>PA</title>
</head>

<body class="theme-light">
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
                <li class="menu__item"><a class="link list-item__link_gray" href=""> Registration</a></li>
                <li class="menu__item"><a class="link list-item__link_gray" href="">Sign In</a></li>
            </ul>
        </li>

    </ul>
    <div class="language-changer">
        <p>Locale:</p>
        <a href="">rus</a>
        <span>|</span>
        <a href="">eng</a>
    </div>

</header>
<main class="main">
    <c:if test="${users!=null}">
        <div class="headline">
            <div class="page-icon"></div>
            <h2>Admin's Page</h2>
        </div>
        <div class="table-wrapper">
            <table class="table">

                <thead>
                <tr>
                    <th></th>
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
                        <div class="table-row-number">1</div>
                    </td>
                    <td>
                        <div class="family">${user.lastName}</div>
                    </td>
                    <td>${user.firstName}</td>
                    <td>${user.middlName}</td>
                    <td>${user.passportId}</td>
                    <td>
                        <div class="group-buttons table-buttons">
                            <a href="?command=approve?id=${user.id}" class="button button-submit"><fmt:message
                                    key="personalAccount.Approve"/></a>
                            <a href="?command=delete?id=${user.id}" class="button button-delete"><fmt:message
                                    key="personalAccount.Delete"/></a>
                        </div>
                    </td>
                </tr>

                </tbody>
                </c:forEach>
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
                    <p>${user.firstName}</p>
                </div>
                <div class="information-row">
                    <h4><fmt:message key="registration.lastname"/>: </h4>
                    <p>${user.lastName}</p>
                </div>
                <div class="information-row">
                    <h4><fmt:message key="registration.middlename"/>: </h4>
                    <p>${user.middleName}</p>
                </div>
                <div class="information-row">
                    <h4><fmt:message key="registration.passportId"/>: </h4>
                    <p>${user.passportId}</p>
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
                <a href="?command=show_edit?id=${user.id}" class="button button-edit first-button"><fmt:message
                        key="personalAccount.Edit"/></a>
                <a href="?command=delete?id=${user.id}" class="button button-delete"><fmt:message
                        key="personalAccount.Delete"/></a>
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
