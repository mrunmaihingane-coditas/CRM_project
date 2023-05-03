<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Home</title>
   <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
   <div class="container">
      <h1>Login Page</h1>
      <form action="regestrtion.jsp" method="get">
         <button class="btn btn-primary" type="submit">Registration</button>
      </form>
      <br>
      <form action="login.jsp" method="get">
         <button class="btn btn-primary" type="submit">Login</button>
      </form>
   </div>
   <script src="js/bootstrap.min.js"></script>
</body>
</html>
