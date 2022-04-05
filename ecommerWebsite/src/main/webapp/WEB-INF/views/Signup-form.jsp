<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup Page</title>
<style>
	.error{
		color:red
	}
</style>
</head>

<body>

<h1>Signup Page</h1>

<form:form action="SignupStatus" method="post" modelAttribute="Customer">
<label for="fname">First Name(*) : </label>
 <form:input type="text" path="fname" /> 
	<form:errors path="fname" cssClass="error"/><br><br>
	
	<label for="lname">Last Name(*) : </label>
	 <form:input type="text" path="lname" /> 
	<form:errors path="lname" cssClass="error"/><br><br>
  
  <label for="uname">User Name(*) : </label>
	 <form:input type="text" path="uname" /> 
	<form:errors path="uname" cssClass="error"/><br><br>
	   
    <label for="pass">Password(*) : </label>
	 <form:input type="password" path="pass" /> 
	<form:errors path="pass" cssClass="error"/><br><br>
	
   <label for="email">Email Id(*) : </label>
	 <form:input type="email" path="email" /> 
	<form:errors path="email" cssClass="error"/><br><br>
		
		
		
		<label for="utype">UserType(*) : </label>
	<form:select path="utype">
<form:options items="${Customer.utypeOptions}"/>
	</form:select> 
	<form:errors path="utype" cssClass="error"/><br><br>
   

  <br><br>
<input type="submit" value="Send">
<input type="reset" value="Clear">
</form:form> 


</body>
</html>