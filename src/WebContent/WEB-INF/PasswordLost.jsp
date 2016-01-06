<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Connection</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
	<%@ include file="includeJS.jsp" %>
</head>
<body>

 <%@ include file="HeaderPublic.jsp" %> 
 
	<div class="container">
		 <div class="jumbotron">
		 <h2>Password Lost</h2>
		 An email with your password will be sent to you
		<form method="post" action="PasswordLost">
			<fieldset id="Field">
					
				<div>
					<c:out value="${error}" />
				</div>

				<p><output >Email:</output>
				<input type="text" 
					   id="identifiant" 
					   name="email" 
					   value="" 
					   size="20" 
					   maxlength="60" 
					   placeholder="exemple@exemple.exemple"
				       required="" />
			     <br/>

				<p><input type="submit" class="btn btn-primary btn-lg" value="Send Password" class="sansLabel" /></p>
				<br/>
				
				<div class="error">
					<c:out value="${success}" />
				</div>
				
			</fieldset>
			<br>
		</form>
	</div>
	</div>
</body>
</html>