<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Home</title>
</head>
<body>
   <h1>Login Page</h1>

   <form method="get" action="login">

        Enter Your Role:
        <input type="radio" name="role" value="User">User
        <input type="radio" name="role" value="Manager">Manager
        <input type="radio" name="role" value="Admin">Admin</br>

        Enter Email:
        <input type="text" name="username"></br>
        Enter Password:
        <input type="password" name="password"></br>

        <input type="Submit" value="Login">

    </form>




   <c:if test="${not empty param.name}">
      <p>Name: ${param.name}</p>
   </c:if>
</body>
</html>