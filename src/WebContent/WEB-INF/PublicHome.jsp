<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
	<%@ include file="includeJS.jsp" %>
</head>
<body>

<%@ include file="HeaderPublic.jsp" %> 

<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading"><h1> Announces</h1></div>

		<table class="table">
			<tr>
				<th>ID</th>
				<th>TITLE</th>
				<th>DESCRIPTION</th>
				<th>DATE</th>
				<th>
				<ul class="nav navbar-nav navbar-right">
				<li><span>PRICE  </span></li> 
				<li><form method="post" action="PublicHome">
				<input type="hidden" NAME="sort" VALUE="priceDESC"> 
				<button type="submit" class="btn btn-default btn-xs">
  				<i class="glyphicon glyphicon-triangle-bottom btn-xs"></i> 
				</button>
				</form>
				</li>
				<li>
				<form method="post" action="PublicHome">
				<input type="hidden" NAME="sort" VALUE="priceASC"> 
				<button type="submit" class="btn btn-default btn-xs">
  				<i class="glyphicon glyphicon-triangle-top btn-xs"></i> 
				</button>
				</form>
				</li>
				</ul>
				</th>
				<th>
				<ul class="nav navbar-nav navbar-right">
				<li>
				<span>AREA  </span>
				</li>
				<li>
				<form method="post" action="PublicHome">
				<input type="hidden" NAME="sort" VALUE="areaDESC"> 
				<button type="submit" class="btn btn-default btn-xs">
  				<i class="glyphicon glyphicon-triangle-bottom btn-xs"></i> 
				</button>
				</form>
				</li>
				<li>
				<form method="post" action="PublicHome">
				<input type="hidden" NAME="sort" VALUE="areaASC"> 
				<button type="submit" class="btn btn-default btn-xs">
  				<i class="glyphicon glyphicon-triangle-top btn-xs"></i> 
				</button>
				</form>
				</li>
				</th>
				<th>
				<ul class="nav navbar-nav navbar-right"><li><span>ADDRESS  </span></li>
				<li><form method="post" action="PublicHome">
				<input type="hidden" NAME="sort" VALUE="address"> 
				<button type="submit" class="btn btn-default btn-xs">
  				<i class="glyphicon glyphicon-triangle-bottom btn-xs"></i> 
				</button>
				</form>
				</li>
				</ul>
				</th>
				<th></th>
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
					<td>${a.postalCode}</td>
					<td>${a.seller.email}</td>
					<td>${a.seller.phone}</td>
					<td><a href="<c:url value="/Chat"/>"><button type="submit" class="btn btn-default btn-xs">
							Chat
						</button></a>
				</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

</body>

</html>