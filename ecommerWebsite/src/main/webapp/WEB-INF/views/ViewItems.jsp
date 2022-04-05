<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items</title>


</head>
<body>
<h2>Currently Available Item : </h2>

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
  
</table>
<a href="buyItem">Click here to Buy This Item</a>

</body>
</html>