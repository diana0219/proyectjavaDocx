<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Docx</title>
</head>
<body>

<a href="doc-agreg.jsp">Nuevo registro</a>
<br>
<table border="1" width="804"></table>
<thead>
<tr>
	<th>Nombre Documento</th>
	<th>Obligatorio S/N</th>
	
	
	<tbody>
	
	<c:forEach var="docvo" items="${lista}">
	<tr>
	<td><c:out value="${docvo.nombre_producto }"/></td>
	<td><c:out value="${docvo.obligatorio_s_n }"/></td>
	
	
	</tr>
	
	
	</c:forEach>
	
	
	
	</tbody>

</tr>
</thead>

</body>
</html>