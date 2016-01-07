<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="includeJS.jsp" %>
	<title>My Space</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>

  
  
  <%@ include file="HeaderPrivate.jsp" %> 
  
  <div class="container">
		<div class="jumbotron">
  	<h1>My Infos</h1>
  	<form method="post" action="MySpace">
		<fieldset id="Fieldset">
			<legend></legend>
				<div>
					<c:out value="${error}" />
				</div>
				
				<p><output >Name</output>
				<input type="text" id="name" name="name" value="${sessionUser.name}" size="30" maxlength="30" placeholder="No informed"/>
			    </p>
					
				<p><output>FirstName</output>	
				<input type="text" id="firstName" name="firstName" value="${sessionUser.firstName}" size="30" maxlength="30" placeholder="No informed"/>
				</p>	
					
				<p><output>Email</output>	
				<input type="text" id="email" name="email" value="${sessionUser.email}" size="30" maxlength="30" placeholder="No informed"/>
				</p>
				
				<p><output>Phone number</output>
				<input type="text" id="phone" name="phone" value="${sessionUser.phone}" size="30" maxlength="20" placeholder="No informed"/>
				</p>
					
				<p><output>Address</output>
				<input type="text" id="address" name="address" value="${sessionUser.address}" size="30" maxlength="250" placeholder="No informed"/>
				</p>
					
				<p><input class="btn btn-primary btn-lg" type="submit" value="Save" class="sansLabel" name="modifiedUser"/>	
				</p>	 
			</fieldset>
		</form>
  
	</div>
	
	<div class="jumbotron">
		<form method="post" action="MySpace">
			<fieldset id="Fieldset">
				<legend>Change Password</legend>
				
				<div>
					<c:out value="${errorP}" />
				</div>
				<p><output>Password</output>	
				<input type="password" id="password" name="password" value="" size="20" maxlength="20" placeholder="Password" required="" />
				<span class="requis">*</span>
				<p/>
					
				<p><output>New Password</output>	
				<input type="password" id="newpassword" name="newPassword" value="" size="20" maxlength="20" placeholder="New Password" required="" />
				<span class="requis">*</span>
				</p>
				
				<p><output></output>
				<input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" placeholder="Confirmation"  required="" />
				<span class="requis">*</span>
				</p>
				<br/> 
				 
				<input type="submit" class="btn btn-primary btn-lg" value="Save" class="sansLabel" name="changePassword"/>	
				 
				<div>
					<c:out value="${successP}" />
				</div>
				 
			</fieldset>
		</form>
	</div>
</div>	
</body>
</html>