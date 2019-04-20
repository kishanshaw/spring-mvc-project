<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type = "text/css" rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/css/style.css"/>
<title>Customer Details</title>
</head>
<body>
		<div id = "wrapper">
			<div id = "header">
				<h2>Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id = "container">
				<div id= "content">
				<input type="button" value= "Add Customer" class = "add-button" onclick="window.location.href='showFormForAddCustomers'; return false;"/>
					<table>
					<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
					</tr>
					<c:forEach var = "customer" items="${customers}">
						<!-- Construct an update link with Customer id -->
						<c:url var = "updateLink" value = "/customer/showFormForUpdate">
							<c:param name="customerId" value="${customer.id }"></c:param>
						</c:url>
						
						<c:url var = "deleteLink" value = "/customer/delete">
							<c:param name="customerId" value="${customer.id }"></c:param>
						</c:url>
					<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td><a href = "${updateLink}">Update</a>
							<b>|</b>
							<a href = "${deleteLink}" onclick = "if(!(confirm('Are you sure that you want to delete this customer?'))) return false">Delete</a>
							</td>
							
					</tr>
					</c:forEach>
					
					</table>
				 </div>
		</div>		

</body>
</html>