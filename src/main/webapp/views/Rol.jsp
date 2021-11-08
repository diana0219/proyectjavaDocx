
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<head>
 <meta http-equiv="Content-Type" content="text/html; charset =UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

</head>

<div class="flex-fill flex-grow-1 ms-3">
<form method="post" action="RolController?accion=listarRoles">

<h1>Listado de Roles</h1>

	

<table class="table table-bordered table-hover">
	
	<tr>
		<th>Id</th>
		<th>Descripción</th>
		
		
		
	</tr>
	
	
	<c:forEach items="${roles}" var="r">
	
		<tr>
			<td>${r.getIdRol()}</td>
			<td>${r.getRol()}</td>
			<td>
		
			<a href="rol-add.jsp" class="btn btn-success" role="button">Agregar</a>
			<a class="btn btn-warning" href="RolController?accion=ver&id=${r.getIdRol()}" role="button">Editar</a>
			<a class="btn btn-danger" onclick="borrar(event,${r.getIdRol()},'Rol')" role="button">Borrar</a>
			</td>
		</tr>
	</c:forEach>

</table>

</div>