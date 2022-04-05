<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Please Provide Details : </title><style>
	.error{
		color:red
	}
</style>

</head>
<body>
<h3>${name} : Please Add Details </h3>
<h1>Add New Items : </h1>
<form:form action="Addme" method="post" modelAttribute="Seller">
<label for="sname">Seller Name(*) : </label>
 <form:input type="text" path="sname" /> 
	<form:errors path="sname" cssClass="error"/><br><br>
	
	<label for="category">Select Category (*) : </label>
	<form:select path="category">
<form:options items="${Seller.categoryOptions}"/>
	</form:select> 
	<form:errors path="category" cssClass="error"/><br><br>
	
	<label for="proname">Product Name(*) : </label>
	 <form:input type="text" path="proname" /> 
	<form:errors path="proname" cssClass="error"/><br><br>
  
  <label for="quantity">Quantity(*) : </label>
	 <form:input type="number" path="quantity" /> 
	<form:errors path="quantity" cssClass="error"/><br><br>
	   
    <label for="prodesc">Product Description : </label>
	 <form:input type="text" path="prodesc" /> 
	<form:errors path="prodesc" cssClass="error"/><br><br>
	
   <label for="price">Product Price(*) : </label>
	 <form:input type="number" path="price" /> 
	<form:errors path="price" cssClass="error"/><br><br>
		
		

  <br><br>
<input type="submit" value="Send">
<input type="reset" value="Clear">
</form:form> 
</body>
</html>