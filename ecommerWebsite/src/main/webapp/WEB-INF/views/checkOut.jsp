<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Complete Bill </title>
<style>
table, th, td {
  border: 1px solid black;
  border-radius: 10px;
}
</style>
</head>
<body>
<p style="color:blue">
<center>
 <h1> NCU Shopping Service </h1>
 </center>
  </p>
<table style="width:100%">
  <tr>
    <th>Item Id</th>
    <th>Item Seller Name</th>
    <th>Item Category</th>
    <th>Item Name</th>
    <th>Item Quantity</th>
    <th>Item Description</th>
    <th>Item Price</th>
  </tr>
  <tr>
    <td>${id}</td>
<td> ${sname}</td>
 <td>${cate}</td>
 <td>${ProN}</td>
 <td>${Qty}</td>
 <td> ${proD}</td>
 <td> ${proP}</td>
  </tr>
  </table><br><br>
 <b>Total Cost after Tax = ${aftertax }</b>
 <i> <h1><center> Thank You For Purchasing This Item and Choosing Our Service</center></h1></i>
 <br><br>
 <a href="expiremySession">Click here to Log Out</a>
</body>
</html>