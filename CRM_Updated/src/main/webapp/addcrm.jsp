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
	<h1>Registration Page</h1>
    	<form action="addcrm" method="get">
    	Enter issue Id to assign to this issue
       <input type="text" id="crm_id" name="issues_id" required><br><br>

    	Enter Crm Id to assign to this issue
        <input type="text" id="crm_id" name="crm_id" required><br><br>


    		<input type="submit" value="Register">


    	</form>
</body>
</html>