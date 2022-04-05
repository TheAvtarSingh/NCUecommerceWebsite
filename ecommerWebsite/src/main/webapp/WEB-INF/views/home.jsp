<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>
	.error{
		color:red
	}
</style>
    </head>
    <body>
        <h1><center>Welcome To Ncu Store!</center></h1>
       <h4> <center>Place to Buy Anything</center> </h4>
        <p>Please login to continue ahead or if you are a new user kindly Sign Up by pressing the button below</p>
       <a href = "SignupController/SignupMe">Click here to Signup</a>
       <br>
       <hr>
        <h4> <center>Already A Customer</center> </h4>
        <form action="SignupController/LoginMe" method="post" >
  <label for="uname">User name: </label>
  <input type="text" name="fname"><br><br>
  <label for="pass">Password: </label>
  <input type="password"  name="lname"><br><br>
  <input type="submit" value="Submit">
</form> 
    </body>
</html>
