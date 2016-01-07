<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>

</div>
		
				
		<form method="post" action="Registration">
			<fieldset id="Fieldset">
				<legend>Inscription</legend>
				
				<div>
					<c:out value="${error}" />
				</div>
				
				<output >Name</output>
				<input type="text" id="name" name="name" value="" size="30" maxlength="30" placeholder="Name" required="" />
			    <span class="requis">*</span>
			    <br/>
					
				<output>FirstName</output>	
				<input type="text" id="firstName" name="firstName" value="" size="30" maxlength="30" placeholder="firstName" required="" />
				<span class="requis">*</span>
				<br/>	
					
				<output>Email</output>	
				<input type="text" id="email" name="email" value="" size="30" maxlength="30" placeholder="email" required="" /> 
				<span class="requis">*</span>	
				<br/>
				
				<output>Phone number</output>
				<input type="text" id="phone" name="phone" value="" size="30" maxlength="20" required="" /> 
				<span class="requis">*</span>	
				<br/>
					
				<output>Address</output>
				<input type="text" id="phone" name="address" value="" size="30" maxlength="250" required="" /> 
				<span class="requis">*</span>	
				<br/>
					
				<output>Password</output>	
				<input type="password" id="password" name="password" value="" size="20" maxlength="20" placeholder="password" required="" />
				<span class="requis">*</span>
				<br/>
				
				<output></output>
				<input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" placeholder="password Confirmation" required="" />
				<span class="requis">*</span>
				<br/>
				<br/> 
				 
				<input type="submit" value="Registration" class="sansLabel" />	
				
				
				
				
				
				<!-- 
				<output>Adress</output>
				<output>Email</output>
				<output>Birthday</output>
				
				<input type="text" id="nom" name="nom" value="" size="20"
					maxlength="20" placeholder="Nom"
					required="Veuillez compléter ce champ" /> <span class="requis"></span>
					
					
				<input type="text" id="prenom" name="prenom" value="" size="20"
					maxlength="20" placeholder="Prénom"
					required="Veuillez compléter ce champ" /> <span class="requis">*</span>
				<input type="text" id="identifiant" name="identifiant" value=""
					size="20" maxlength="60" placeholder="identifiant"
					required="Veuillez compléter ce champ" /> <span class="requis">*</span>
				<input type="password" id="motDePasse" name="motDePasse" value=""
					size="20" maxlength="20" placeholder="mot de passe"
					required="Veuillez compléter ce champ" /> <span class="requis">*</span>
				<input type="password" id="confirmation" name="confirmation"
					value="" size="20" maxlength="20"
					placeholder="confirmation mot de passe"
					required="Veuillez compléter ce champ" /> <br /> <input
					type="submit" value="Inscription" class="sansLabel" /> <br />
				 -->
				 
			</fieldset>
		</form>

	</div>
	
	
</body>
</html>