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
<c:if test="${sessionUser==null}">
	<style type="text/css">

body {
    padding-top: 100px; /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
}

.hero-spacer {
    margin-top: 50px;
}

.hero-feature {
    margin-bottom: 30px;
}

footer {
    margin: 50px 0;
}

</style>
	</c:if>
	
<c:if test="${sessionUser!=null}">	
	<script type="text/javascript">  
	window.setInterval(foo,500);
	var lastvalue = "";
	function foo() {
		
		var value = "${sessionUser.alert}";
		if(value != lastvalue){
			console.log("dans if");
			alert(value);
		}

		lastvalue = value;
	}
</script> 
</c:if>
</head>
<body>

<c:if test="${sessionUser==null}">
<%@ include file="HeaderPublic.jsp" %> 
</c:if>
<c:if test="${sessionUser!=null}">
<%@ include file="../Private/HeaderPrivate.jsp" %> 
</c:if>

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
				<th>PHOTO</th>
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
					<td>
						<c:forEach items="${a.photo}" var="p">
						<img alt="" height="50px" width="50px" src="<c:url value="${p}"/>">
						</c:forEach>
					
					</td>
					<td>${a.seller.email}</td>
					<td>${a.seller.phone}</td>
					<td>
					
					<c:if test="${a.seller.isConnected() && a.seller.id != sessionUser.id}">
					<a href="<c:url value="/Chat?id=${a.seller.email}"/>"><button type="submit" class="btn btn-default btn-xs">
							Chat
						</button></a>
					<!-- form method="post" action="Chat"><input type="hidden" NAME="idSeller" VALUE="${a.seller.id}"> <input TYPE="submit" value="Chat"></FORM>
					 -->
					</c:if>
					
					<c:if test="${sessionUser!=null}">
						<c:if test="${!a.isObservor(sessionUser) && a.seller.id != sessionUser.id }">
							<form method="post" action="FollowAnnounce"><input type="hidden" NAME="idAnnounce" VALUE="${a.id}"> <input TYPE="submit" value="Follow"></FORM>
						</c:if>
						<c:if test="${a.isObservor(sessionUser)}">
							<form method="post" action="UnFollowAnnounce"><input type="hidden" NAME="idAnnounce" VALUE="${a.id}"> <input TYPE="submit" value="UnFollow"></FORM>
						</c:if>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

<c:if test="${sessionUser==null}">
<div class="container"><%@ include file="../Chat/expoHome.jsp" %></div>
</c:if>		
<c:if test="${sessionUser!=null}">
<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading"><h1> Chat </h1></div>
		<div class="chat"><%@ include file="../Chat/ChatUser.jsp" %></div>
		
</div>
</div> 
</c:if>
</body>
</html>