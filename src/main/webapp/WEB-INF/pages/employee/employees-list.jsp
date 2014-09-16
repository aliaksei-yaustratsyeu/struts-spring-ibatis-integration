<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Employees List</title>
</head>
<body>
    <table>
        <thead>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${employeeForm.employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
