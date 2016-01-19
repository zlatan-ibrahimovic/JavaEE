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
  <div class="panel-heading"><h1>My favorite Announces</h1></div>
  <div class="panel-body">
    <p> This is the table of our favorite announces</p>
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
				<th>PHOTO</th>
				<th>SELLER</th>
				<th></th>
			</tr>

			<c:forEach items="${MyFavoritesAnnounces}" var="a">
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
						<c:forEach items="${a.photo}" var="p">
						<img alt="" height="50px" width="50px" src="<c:url value="${p}"/>">
						</c:forEach>
					</td>
					<td>${a.seller.email}</td>
					<td>${a.seller.phone}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

</body>
</html>
		
	