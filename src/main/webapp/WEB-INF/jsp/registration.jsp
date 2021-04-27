<%--
  Created by IntelliJ IDEA.
  User: Юзер
  Date: 01.04.2021
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div align="center">
    <form action="<%= request.getContextPath() %>/registration" method="post">
        <table style="with: 80%">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"  id="login" value="${login}" placeholder="Enter Login" required></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"  id="password" value="${password}"placeholder="Enter password" required/></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"  id="name" value="${name}" placeholder="Enter Login" required></td>
            </tr>
            <tr>
                <td>Middle Name</td>
                <td><input type="text" name="middleName"  id="middleName" value="${middleName}" placeholder="Enter Middle Name" required/></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName"  id="lastName" value="${lastName}"placeholder="Enter LastName" required></td>
            </tr>
            <tr>
                <td>Passport Id</td>
                <td><input type="text" name="passport_id"  id="passport_id" value="${passport_id}" placeholder="Enter Login" required></td>
            </tr>
            <tr>
                <td>Faculty</td>
                <select name="faculty" id="faculty" value="${faculty}">

                    <option value="1">MMF</option>
                    <option value="2">FIZ</option>
                    <option value="3">Black</option>

                </select>

            </tr>
            <tr>
                <td>Score</td>
                <td><input type="number" name="score_1"  id="score_1" value="${score_1}" placeholder="Enter Login" required></td>
                <td><input type="number" name="score_2"  id="score_2" value="${score_2}" placeholder="Enter Login" required></td>
                <td><input type="number" name="score_3"  id="score_3" value="${score_3}" placeholder="Enter Login" required></td>
                <td><input type="number" name="score_4"  id="score_4" value="${score_4}" placeholder="Enter Login" required></td>
            </tr>
        </table>
        <input type="submit" value="Enter" />
    </form>


</div>
</body>
</html>
