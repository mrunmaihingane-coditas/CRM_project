<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	<h1>CRM Registration Page</h1>
    	<form action="saveCrm" method="get">
    		<label for="username">Username:</label>
    		<input type="text" id="username" name="crm-username" required><br><br>

    		<label for="username">name:</label>
            <input type="text" id="name" name="crm-name" required><br><br>

           Date:
           <input type="date" id="date_crm" name="date_crm" required><br><br>

    		<input type="submit" value="Register">
    		<a href ='login.jsp'>LoginButton</a>

    	</form>
</body>
</html>