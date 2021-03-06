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
<div>
	<form method="post" action="EditAnnounce">
		<fieldset id="Fieldset">
			<legend>Edit Announce</legend>
				<div>
					<c:out value="${error}" />
				</div>
				
				<p><output >Title:</output>
				<input type="text" id="title" name="title" value="${Announce.title}" size="60" maxlength="120" placeholder="Title"/>
			    </p>
					
				<output>Price:</output>	
				<input type="text" id="price" name="price" value="${Announce.price}" size="30" maxlength="30" placeholder="0.00"/>€
				</p>	
					
				<p><output>Area:</output>	
				<input type="text" id="area" name="area" value="${Announce.area}" size="30" maxlength="30" placeholder="0.00"/>m²
				</p>
				
				<p><output>Adress:</output>
				<input type="text" id="address" name="address" value="${Announce.address}" size="30" maxlength="20" placeholder="Address"/>
				<output>PostalCode:</output>
				<input type="text" id="postalCode" name="postalCode" value="${Announce.postalCode}" size="5" maxlength="5" required=""/>
				</p>
					
				<p><output>Description:</output>
				<textarea type="text" id="description" name="description" value="${Announce.description}" size="30" maxlength="560" placeholder="Description">${Announce.description}</textarea>
				</p>
				<input type="hidden" NAME="idAnnounce" VALUE="${Announce.id}">	
				<input type="submit" class="btn btn-primary btn-lg" value="Save" class="sansLabel" name="EditAnnounce"/>	
	 
			</fieldset>
		</form>
	</div>
		</div>
						
</body>
</html>