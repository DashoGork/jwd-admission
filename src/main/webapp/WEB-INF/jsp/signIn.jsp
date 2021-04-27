<%--
  Created by IntelliJ IDEA.
  User: Юзер
  Date: 05.04.2021
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<div align="center">
    <form action="<%= request.getContextPath() %>/signIn" method="post">
        <table style="with: 80%">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"  id="login" value="${login}" required></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"  id="password" value="${password}" required/></td>
            </tr>
        </table>
        <input type="submit" value="Enter" />
    </form>


</div>
</body>
</html>

