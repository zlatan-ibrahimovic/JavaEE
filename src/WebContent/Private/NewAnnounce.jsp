<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="includeJS.jsp" %>
	<title>New Announce</title>
<link type="text/css" rel="stylesheet" href="style.css" />

<script type="text/javascript" src="Private/js/prototype.js"></script>
<script type="text/javascript" src="Private/js/scriptaculous.js"></script>
<script type="text/javascript" src="Private/js/multiupload.js"></script>

</head>
<body onload="init();">


   <%@ include file="HeaderPrivate.jsp" %> 
	
<div class="container">
	<form id="form" method="post" action="NewAnnounce" enctype="multipart/form-data">
		<fieldset id="Fieldset">
			<legend>New Announce</legend>
				<div>
					<c:out value="${error}" />
				</div>
				
				<p><output >Title:</output>
				<input type="text" id="title" name="title" value="" size="60" maxlength="120" placeholder="Title" required=""/>
			    </p>
					
				<p><output>Price:</output>	
				<input type="text" id="price" name="price" value="" size="30" maxlength="30" placeholder="0.00" required=""/>€
				</p>	
					
				<p><output>Area:</output>	
				<input type="text" id="area" name="area" value="" size="30" maxlength="30" placeholder="0.00" required="" />m²
				</p>
				
				<p><output>Adress:</output>
				<input type="text" id="address" name="address" value="" size="30" maxlength="20" placeholder="Address" required=""/>
				<output>PostalCode:</output>
				<input type="text" id="postalCode" name="postalCode" value="" size="5" maxlength="5" required=""/>
				
				</p>
					
				<p><output>Description:</output>
				<textarea type="text" id="description" name="description" value="" size="30" maxlength="560" placeholder="Description"></textarea>
				</p>
				<div id="upload">
				
            	<h1>Photos (Minimum 2 photo)</h1>
            		<div>
						<c:out value="${error}" />
					</div>
            		<div id="fichiers">
              			Aucun fichier à uploader
            		</div>
            		<span id="input"></span>
                	</div>
					
				<input type="submit" class="btn btn-primary btn-lg" value="Save" class="sansLabel" name="NewAnnounce"/>	
	 
			</fieldset>
		</form>
	</div>
						
</body>
</html>