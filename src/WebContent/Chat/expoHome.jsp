<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Expo Home</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <!-- CSS code from Bootply.com editor -->
  
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


<style type="text/css">

body {
    padding-top: 70px; /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
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

</head>

<body>

  
       

        <!-- Title -->
        <div class="row">
            <div class="col-lg-12">
                <h3>Catalogue</h3>
            </div>
        </div>
        <!-- /.row -->

        <!-- Page Features -->
        <div class="row text-center">

		<c:forEach items="${Announces}" var="a">
		 
            <div class="col-md-6 col-sm-4 hero-feature">
                <div class="thumbnail">
                    <c:forEach items="${a.photo}" var="p">
						<img alt=""  height="540px" width="400px" src="<c:url value="${p}"/>">
						</c:forEach>
                    <div class="caption">
                        <h3>${a.title}</h3>
                        <p>${a.description}</p>
                        <p> <span>Date: </span>${a.date}</p>
                        <span>Prix: </span>${a.price}
                        <span>Superficie: </span>${a.area} <span>m2</span>
                        <span>Adress: </span>${a.address}
                        <span>Code: </span>${a.postalCode}
                        <span>Contact: </span>${a.seller.email}
                        <p>${a.seller.phone}</p>					
					<c:if test="${sessionUser!=null}">
						<c:if test="${!a.isObservor(sessionUser) && a.seller.id != sessionUser.id }">
							<form method="post" action="FollowAnnounce"><input type="hidden" NAME="idAnnounce" VALUE="${a.id}"> <input TYPE="submit" value="Follow"></FORM>
						</c:if>
						<c:if test="${a.isObservor(sessionUser)}">
							<form method="post" action="UnFollowAnnounce"><input type="hidden" NAME="idAnnounce" VALUE="${a.id}"> <input TYPE="submit" value="UnFollow"></FORM>
						</c:if>
					</c:if>
                        <p>
                        	<c:if test="${a.seller.isConnected() && a.seller.id != sessionUser.id}">
                            <a href="<c:url value="/Chat?id=${a.seller.email}"/>" class="btn btn-primary">Contact</a></c:if> 
                            <a href="#" class="btn btn-default">More Info</a>
                        </p>
                    </div>
                </div>
            </div>
				
			</c:forEach>
			</div>
			
        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2016</p>
                </div>
            </div>
        </footer>
   

</body>

</html>
