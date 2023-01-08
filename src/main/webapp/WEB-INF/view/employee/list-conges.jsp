
<html lang="en" xmlns:th="http://www.thymeleaf.org">

	
	<head>
		<title>List Employees</title>
		
		<link rel="stylesheet" 
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
			integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" 
			crossorigin="anonymous" />
	</head>
	
	<body>
		
		<div class="container">
		
			<h3>List Employees</h3>
			
			<hr/>
			<a th:href="@{/addCongesForm}" class="btn btn-primary">Add Conges</a>
			<br/><br/>
			<table class="table table-bordered table-striped">
			
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Department  </th>
					</tr>
				</thead>
				<tbody>
	  					<tbody>
						
                  	  
					<tr th:each="conges: ${conges}">
						<td th:text="${conges.name}"> </td>
						<td th:text="${conges.email}"> </td>
						<td th:text="${conges.department}"> </td>
						
						</tr>
				</tbody>
				
			</table>
		</div>
		
		
	</body>
	
</html>