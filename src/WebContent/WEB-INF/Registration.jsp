<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="includeJS.jsp" %>
	<title>Registration</title>
</head>
<body>
  
   <%@ include file="HeaderPublic.jsp" %> 
   
   <div class="container">
		 <header class="jumbotron">
		 <h2>Registration</h2>	
		<form method="post" action="Registration">
			<fieldset id="Fieldset">
				
				<div class="error">
					<c:out value="${error}" />
				</div>
					
				<p><output>Email</output>	
				<input type="text" id="email" name="email" value="${user.email}" size="30" maxlength="30" placeholder="email" required="" /> 
				<span class="requis">*</span>	
				</p>
				
				<p><output>Password</output>	
				<input type="password" id="password" name="password" value="" size="20" maxlength="20" placeholder="password" required="" />
				<span class="requis">*</span>
				</p>
				
				<p><output></output>
				<input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" placeholder="password Confirmation" required="" />
				<span class="requis">*</span>
				<p/>
				<br/> 
				 
				<input type="submit" class="btn btn-primary btn-lg" value="Registration" class="sansLabel" />	
				 
			</fieldset>
		</form>
	</header>
	</div>
	
	
</body>
</html>