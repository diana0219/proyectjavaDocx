<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>

<header id="home" class="header">
		<nav class="nav" role="navigation">
			<div class="container nav-elements">
				<div class="branding">
					<a href="#home"><img src="img/logodocx.png"></a>
				</div>
				<!-- branding -->
				<ul class="navbar">
					<li><a href="home">home</a></li>
					

				</ul>
				<!-- navbar -->
			</div>
			<!-- container nav-elements -->
		</nav>
		
		<section id="registration" class="section">
	 <div class="container tagline">
	 <em>Registra un rol</em><br/>
	
		<form action="listarRoles" method="post">
			<label>Rol</label> <input type="text" name="rol" id="rol"><br/>
		<input type="submit" value="Submit" id="submit">
		</form>
		</div>
	</section>
	<!-- #products -->
		

</body>
</html>