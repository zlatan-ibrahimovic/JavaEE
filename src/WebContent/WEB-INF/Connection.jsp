<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Connection</title>
	<%@ include file="includeJS.jsp" %>
</head>
<body>

 <%@ include file="HeaderPublic.jsp" %> 
 
	<div class="container">
	
	
		 <header class="jumbotron">
		 <h2>Connection</h2>	
		<form method="post" action="Connection">
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
				 <a href="Registration" id="inscrire">Registration ?</a></p>
			     <br/>

				<p><output >Password:</output>
				<input type="password" 
				       id="password" 
				       name="password" 
				       value=""
					   size="20" 
					   maxlength="20" 
					   placeholder="password"
				  	   required="" /> 
				<a href="PasswordLost">Password lost ?</a></p>
				<br/>
				
				<p><input type="submit" class="btn btn-primary btn-lg" value="Connection" class="sansLabel" /></p>
				<br/>
			</fieldset>
			<br>
		</form>
	</header>
	</div>
</body>
</html>