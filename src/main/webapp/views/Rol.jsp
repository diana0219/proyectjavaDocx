
<div class="flex-fill flex-grow-1 ms-3">

<h1>Listado de Roles</h1>

<a href="RolController?accion=abrirForm" class="btn btn-success" role="button">Agregar</a>

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
			<a class="btn btn-warning" href="RolController?accion=ver&id=${r.getIdRol()}" role="button">Editar</a>
			<a class="btn btn-danger" onclick="borrar(event,${r.getIdRol()},'Rol')" role="button">Borrar</a>
			</td>
		</tr>
	</c:forEach>

</table>

</div>