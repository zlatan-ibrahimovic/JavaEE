<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>

<h1>Admisnistrator's Page </h1><br>

<h2>Users</h2><br>

	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>FIRSTNAME</th>
				<th>EMAIL</th>
				<th>PASSWORD</th>
				<th>ADDRESS</th>
				<th>PHONE</th>
			</tr>

			<c:forEach items="${Users}" var="u">
				<tr>
					<td>${u.id}</td>
					<td>${u.name}</td>
					<td>${u.firstName}</td>
					<td>${u.email}</td>
					<td>${u.password}</td>
					<td>${u.address}</td>
					<td>${u.phone}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>TITLE</th>
				<th>DESCRIPTION</th>
				<th>DATE</th>
				<th>PRICE</th>
				<th>AREA</th>
				<th>ADDRESS</th>
				<th>SELLER</th>
			</tr>

			<c:forEach items="${Announces}" var="a">
				<tr>
					<td>${a.id}</td>
					<td>${a.title}</td>
					<td>${a.description}</td>
					<td>${a.date}</td>
					<td>${a.price}</td>
					<td>${a.area}</td>
					<td>${a.address}</td>
					<td>${a.seller.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>