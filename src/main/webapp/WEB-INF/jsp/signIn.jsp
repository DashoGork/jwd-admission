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
    <form action="<%= request.getContextPath() %>/home?command=login" method="post">
        <table style="with: 80%">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" required/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" required/></td>
            </tr>
        </table>

        <input type="submit"  name="conf" />
    </form>


</div>
</body>
</html>

