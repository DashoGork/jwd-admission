<%--
  Created by IntelliJ IDEA.
  User: Юзер
  Date: 01.04.2021
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="bundles\text"/>
<html>
<head>
    <title>Registration</title>
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
    <form action="<%= request.getContextPath() %>/home?command=registration" method="post">
        <div class="container">
            <h1>Register</h1>
            <p>Please fill in this form to create an account.</p>
            <hr>

            <label for="login"><b><fmt:message key="registration.login"/></b></label>
            <input type="text" name="login" id="login" value="${login}" placeholder="Enter Login" required>

            <label for="password"><b><fmt:message key="registration.password"/></b></label>
            <input type="password" name="password" id="password" value="${password}"
                   placeholder="Enter password" required>

            <label for="name"><b><fmt:message key="registration.name"/></b></label>
            <input type="text" name="name" id="name" value="${name}" placeholder="Enter Name" required>

            <label for="lastName"><b><fmt:message key="registration.lastname"/></b></label>
            <input type="text" name="lastName" id="lastName" value="${lastName}" placeholder="Enter LastName"
                   required>

            <label for="middleName"><b><fmt:message key="registration.middlename"/></b></label>
            <input type="text" name="middleName" id="middleName" value="${middleName}"
                   placeholder="Enter Middle Name" required/>
            <label for="passport_id"><b><fmt:message key="registration.passportId"/></b></label>
            <input type="text" name="passport_id" id="passport_id" value="${passport_id}"
                   placeholder="Enter" required>>
            <label for="faculty"><fmt:message key="registration.faculty"/></label>
            <select name="faculty" id="faculty" value="${faculty}">
                <option value="1"><fmt:message key="registration.facultyMMF"/>:</option>
                <option value="2"><fmt:message key="registration.facultyRAF"/>:</option>
                <option value="3"><fmt:message key="registration.facultyFMO"/>:</option>
                <option value="4"><fmt:message key="registration.facultyBIO"/>:</option>
            </select>

            <label for="score_1"><b><fmt:message key="score"/></b></label>
            <input type="number" name="score_1" id="score_1" value="${score_1}" min="1" max="100"
                   placeholder="Enter Login" required></td>
            <label for="score_2"><fmt:message key="score"/></label>
            <input type="number" name="score_2" id="score_2" value="${score_2}" min="1" max="100"
                   placeholder="Enter Login" required></td>
            <label for="score_3"><fmt:message key="score"/></label>
            <input type="number" name="score_3" id="score_3" value="${score_3}" min="1" max="100"
                   placeholder="Enter Login" required></td>
            <label for="score_4"><fmt:message key="score"/></label>
            <input type="number" name="score_4" id="score_4" value="${score_4}" min="1" max="100"
                   placeholder="Enter Login" required>
            <hr>

            <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
            <button type="submit" class="registerbtn">Register</button>
        </div>

        <div class="container signin">
            <p>Already have an account? <a href="#">Sign in</a>.</p>
        </div>
    </form>
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

</div>
</body>
</html>
