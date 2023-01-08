<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 
	<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

	<head>
		<title>Add Employee</title>
		
		<link rel="stylesheet" 
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
			integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" 
			crossorigin="anonymous" />
	</head>
	<body>
		
		<div class="container">
		
			<h3>Add New conges</h3>
			<hr/>
			
			<form th:action="@{/saveConges}" th:object="${conges}" method="POST">
				
				<input type="text" th:field="*{name}" class="form-control col-4 mb-4" placeholder="Enter Name" />
				
				<input type="text" th:field="*{email}" class="form-control col-4 mb-4" placeholder="Enter email" />
				
				<input type="text" th:field="*{department}" class="form-control col-4 mb-4" placeholder="Enter department" />
				
				<button type="submit" class="btn btn-primary col-2">Save</button>
				
			</form>
			<hr/>
			<a th:href="@{/list}">Back to list</a>
		</div>
		
	</body>
</html>