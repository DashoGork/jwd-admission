<html>
<head>
    <title>Title</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<div align="center" action="<%= request.getContextPath() %>/edit" method="get">
    <c:if test="${user != null}"> ffffffffff</c:if>
    <p><strong>Login:</strong>  ${user.login}</p>
    <p><strong>Pasword:</strong> ${user.password}</p>
    <p><strong>Pasword:</strong> ${user.id}</p>
    <p><strong>Nmae:</strong> ${user.firstName}</p>
    <p><strong>Фамилия:</strong> ${user.lastName}</p>
    <p><strong>Отчество:</strong> ${user.middleName}</p>
    <p><strong>Отчество:</strong> ${user.passportId}</p>
    <p><strong>Выбранный факультет:</strong> ${req.faculty_id}</p>
    <p><strong>Общий балл</strong> ${req.score}</p>
    </form>
    <div align="center">
        <form action="<%= request.getContextPath() %>/edit" method="post">
            <table style="with: 80%">
                <tr>
                    <td>Login</td>
                    <td><input type="text" name="old_id"  id="old_id" value="${user.id}" placeholder="${user.id}" required></td>
                </tr>
                <tr>
                    <td>Login</td>
                    <td><input type="text" name="login"  id="login1" value="${login}" placeholder="${user.login}" required></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"  id="password1" value="${password}"placeholder="Enter password" required/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"  id="name1" value="${name}" placeholder="Enter Login" required></td>
                </tr>
                <tr>
                    <td>Middle Name</td>
                    <td><input type="text" name="middleName"  id="middleName1" value="${middleName}" placeholder="Enter Middle Name" required/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName"  id="lastName1" value="${lastName}"placeholder="Enter LastName" required></td>
                </tr>
                <tr>
                    <td>Passport Id</td>
                    <td><input type="text" name="passport_id"  id="passport_id1" value="${passport_id}" placeholder="Enter Login" required></td>
                </tr>
                <tr>
                    <td>Faculty</td>
                    <select name="faculty" id="faculty1" value="${faculty}">

                        <option value="1">MMF</option>
                        <option value="2">FIZ</option>
                        <option value="3">Black</option>

                    </select>

                </tr>
                <tr>
                    <td>Score</td>
                    <td><input type="number" name="score_1"  id="score_11" value="${score_1}" placeholder="Enter Login" required></td>
                    <td><input type="number" name="score_2"  id="score_22" value="${score_2}" placeholder="Enter Login" required></td>
                    <td><input type="number" name="score_3"  id="score_33" value="${score_3}" placeholder="Enter Login" required></td>
                    <td><input type="number" name="score_4"  id="score_43" value="${score_4}" placeholder="Enter Login" required></td>
                </tr>
            </table>
            <input type="submit" value='${user.id}' />
        </form>
    </div>
</div></body>
</html>