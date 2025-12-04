<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Data</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

    <%@ include file="header.jsp" %>

    <div class="container mt-4">
        <h1 class="mb-4">Student Data</h1>

        <table class="table table-bordered table-striped">
            <tr>
                <th>Sr No.</th>
                <th>Fullname</th>
                <th>Email</th>
                <th>Password</th>
                <th>Address</th>
                <th></th>
                <th></th>
            </tr>

            <c:forEach var="s" items="${list}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${s.fullname}</td>
                    <td>${s.email}</td>
                    <td>${s.password}</td>
                    <td>${s.address}</td>
                    <td>
                    	<a href="delete/${s.id}" class="btn btn-danger" onclick="return confirm('Are you sure ?')">Delete</a>
                    </td>
                    <td>
                    	<a href="profileedit/${s.id}" class="btn btn-success">Edit Profile</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
