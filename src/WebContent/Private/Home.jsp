<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ include file="includeJS.jsp" %> 

<title>ChezMamie</title>
</head>
<body>

  <%@ include file="HeaderPrivate.jsp" %> 	
  	
  	
<div class="container">
<div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading"><h1>Announces</h1></div>
  
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
				<th>SELLER</th>
				<th></th>
				<th></th>
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
					<td>${a.postalCode}</td>
					<td>${a.seller.email}</td>
					<td>${a.seller.phone}</td>
					<td>
					<c:if test="${a.seller.isConnected()  }">
					<form method="post" action="Chat"><input type="hidden" NAME="idSeller" VALUE="${a.seller.id}"> <input TYPE="submit" value="Chat"></FORM>
					</c:if>
					</td>
					<td>
					<c:if test="${!a.isObservor(sessionUser) && a.seller.id != sessionUser.id }">
					<form method="post" action="FollowAnnounce"><input type="hidden" NAME="idAnnounce" VALUE="${a.id}"> <input TYPE="submit" value="Follow"></FORM>
					</c:if>
					<c:if test="${a.isObservor(sessionUser)}">
					<form method="post" action="UnFollowAnnounce"><input type="hidden" NAME="idAnnounce" VALUE="${a.id}"> <input TYPE="submit" value="UnFollow"></FORM>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	
		
	</div>
</div>


<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading"><h1> Chat </h1></div>
		<div class="chat"><%@ include file="../Chat/ChatUser.jsp" %></div>
		
</div>
</div>
</body>
</body>
</html>

