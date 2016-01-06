<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My Announces</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
	<%@ include file="includeJS.jsp" %>
	
</head>
<body>


    <%@ include file="HeaderPrivate.jsp" %> 
	
<div class="container">
<div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading"><h1>My Announces</h1></div>
  <div class="panel-body">
    <p> This is the table of all your announces</p>
  </div>
  
	
		<table class="table">
			<tr>
				<th>ID</th>
				<th>TITLE</th>
				<th>DESCRIPTION</th>
				<th>DATE</th>
				<th>PRICE</th>
				<th>AREA</th>
				<th>ADDRESS</th>
				<th></th>
				<th>ACTION</th>
			</tr>

			<c:forEach items="${MyAnnounces}" var="a">
				<tr>
					<td>${a.id}</td>
					<td>${a.title}</td>
					<td>${a.description}</td>
					<td>${a.date}</td>
					<td>${a.price}</td>
					<td>${a.area}</td>
					<td>${a.address}</td>
					<td>${a.postalCode}</td>
					<td>
					<form method="get" action="EditAnnounce"><input type="hidden" NAME="idAnnounce" VALUE="${a.id}"> <input TYPE="submit" value="Edit"></FORM>
					<form method="post" action="RemoveAnnounce"><input type="hidden" NAME="idAnnounce" VALUE="${a.id}"> <input TYPE="submit" value="Delete"></FORM>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

</body>
</html>