<%--
  Created by IntelliJ IDEA.
  User: Юзер
  Date: 01.04.2021
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="bundles\text"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div align="center">
    <form accept-charset="UTF-8" action="<%= request.getContextPath() %>/home?command=registration" method="post">
        <table style="with: 80%">
            <tr>
                <td><fmt:message key="registration.login"/>:</td>
                <td><input type="text" name="login" id="login" value="${login}" placeholder="Enter Login" required></td>
                <td><>
            </tr>
            <tr>
                <td><fmt:message key="registration.password"/>:</td>
                <td><input type="password" name="password" id="password" value="${password}"
                           placeholder="Enter password" required/></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.name"/>:</td>
                <td><input type="text" name="name" id="name" value="${name}" placeholder="Enter Login" required></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.middlename"/>:</td>
                <td><input type="text" name="middleName" id="middleName" value="${middleName}"
                           placeholder="Enter Middle Name" required/></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.lastname"/>:</td>
                <td><input type="text" name="lastName" id="lastName" value="${lastName}" placeholder="Enter LastName"
                           required></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.passportId"/>:</td>
                <td><input type="text" name="passport_id" id="passport_id" value="${passport_id}"
                           placeholder="Enter Login" required></td>
            </tr>
            <tr>
                <td><fmt:message key="registration.faculty"/>:</td>
                <select name="faculty" id="faculty" value="${faculty}">

                    <option value="1"><fmt:message key="registration.facultyMMF"/>:</option>
                    <option value="2"><fmt:message key="registration.facultyRAF"/>:</option>
                    <option value="3"><fmt:message key="registration.facultyFMO"/>:</option>
                    <option value="4"><fmt:message key="registration.facultyBIO"/>:</option>
                </select>

            </tr>
            <tr>
                <td><fmt:message key="score"/>:</td>
                <td><input type="number" name="score_1" id="score_1" value="${score_1}" min="1" max="100"
                           placeholder="Enter Login" required></td>
                <td><input type="number" name="score_2" id="score_2" value="${score_2}" min="1" max="100"
                           placeholder="Enter Login" required></td>
                <td><input type="number" name="score_3" id="score_3" value="${score_3}" min="1" max="100"
                           placeholder="Enter Login" required></td>
                <td><input type="number" name="score_4" id="score_4" value="${score_4}" min="1" max="100"
                           placeholder="Enter Login" required></td>
            </tr>
        </table>
        <input type="submit" value="Enter"/>
    </form>


</div>
</body>
</html>
