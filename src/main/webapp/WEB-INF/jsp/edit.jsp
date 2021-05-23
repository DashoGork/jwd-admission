<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="bundles\text"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page language="java" contentType="text/html;charset=UTF-8" %>
    \>
</head>
<body>
<div align="center">
    <form action="<%= request.getContextPath() %>/home?command=edit" method="post">
        <table style="with: 80%">
            <tr>
                <td><fmt:message key="registration.login"/>:</td>
                <td><input type="text" name="login" value="${user.login}" required/></td>
                <td output type="text"><c:out value="${user.login}"/>}</td>
            </tr>
            <tr>
                <td><fmt:message key="registration.password"/>:</td>
                <td><input type="password" name="password" placeholder="${user.password}" required/></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.name"/>:</td>
                <td><input type="text" name="name" placeholder="${user.getPersonalInformation().getFirstName()}" required></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.middlename"/>:</td>
                <td><input type="text" name="middleName" id="middleName" value="${middleName}"
                           placeholder="${user.getPersonalInformation().getMiddleName()}" required/></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.lastname"/>:</td>
                <td><input type="text" name="lastName" id="lastName" value="${lastName}" placeholder="${user.getPersonalInformation().getLastName()}"
                           required></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.passportId"/>:</td>
                <td><input type="text" name="passport_id" id="passport_id" value="${passportId}"
                           placeholder="${user.getPersonalInformation().getPassportId()}" required></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.faculty"/>:</td>
                <select name="faculty" id="faculty1" value="${faculty}">
                    <option value="1"><fmt:message key="registration.facultyMMF"/>:</option>
                    <option value="2"><fmt:message key="registration.facultyRAF"/>:</option>
                    <option value="3"><fmt:message key="registration.facultyFMO"/>:</option>
                    <option value="4"><fmt:message key="registration.facultyBIO"/>:</option>
                </select>

            </tr>
            <tr>
                <td><fmt:message key="score"/></td>
                <td><input type="number" name="score_1" id="score_1" value="${score_1}" placeholder="Enter Login"
                           required></td>
                <td><input type="number" name="score_2" id="score_2" value="${score_2}" placeholder="Enter Login"
                           required></td>
                <td><input type="number" name="score_3" id="score_3" value="${score_3}" placeholder="Enter Login"
                           required></td>
                <td><input type="number" name="score_4" id="score_4" value="${score_4}" placeholder="Enter Login"
                           required></td>
            </tr>
            <td><input type="text" name="id" value="${user.id}" required/><c:out value="${user.id}"/></td>

        </table>
        <input type="submit" name="conf"/>
    </form>
</div>
</div>
</body>
</html>
