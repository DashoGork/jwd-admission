<html>
<head>
    <title>Title</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
    <div align="center">
        <form action="<%= request.getContextPath() %>/home?command=edit" method="post">
            <table style="with: 80%">
                <tr>
                    <td >Login</td>
                    <td><input type="text" name="login" value="${user.login}" required/></td>
                    <td output type="text"><c:out value="${user.login}"/>}</td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" placeholder="${user.password}" required/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" placeholder="${user.firstName}"required></td>
                </tr>
                <tr>
                    <td>Middle Name</td>
                    <td><input type="text" name="middleName"  id="middleName" value="${middleName}" placeholder="${user.middleName}" required/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName"  id="lastName" value="${lastName}"placeholder="${user.lastName}" required></td>
                </tr>
                <tr>
                    <td>Passport Id</td>
                    <td><input type="text" name="passport_id"  id="passport_id" value="${passportId}" placeholder="${user.passportId}" required></td>
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
                    <td><input type="number" name="score_1"  id="score_1" value="${score_1}" placeholder="Enter Login" required></td>
                    <td><input type="number" name="score_2"  id="score_2" value="${score_2}" placeholder="Enter Login" required></td>
                    <td><input type="number" name="score_3"  id="score_3" value="${score_3}" placeholder="Enter Login" required></td>
                    <td><input type="number" name="score_4"  id="score_4" value="${score_4}" placeholder="Enter Login" required></td>
                </tr>
                <td><input type="text" name="id" value="${user.id}" required/><c:out value="${user.id}"/></td>

            </table>
            <input type="submit"  name="conf" />
        </form>
    </div>
</div>
</body>
</html>
