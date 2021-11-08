<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Docx</title>
</head>
<body>
<form method="post" action="RolController?accion=add">
<h2> Registro nuevo rol</h2>
<br>


<p>
Nombre Rol:
<input  id="rol" name="rol" type="text"/>

</p>




<button id="guardar" type="submit">Guardar</button>

</form>
		

</body>
</html>