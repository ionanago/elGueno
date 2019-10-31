<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="appcenter">
	<h2>Gestión De Usuarios</h2>
	
	<h3>USUARIOS</h3>
<table class="table ">
		<thead>
			<tr>
				<th>Id</th>
				<th>Usuario</th>
				
				
				<th><a href="/formUsuarios" class="btn btn-primary mx-2"> Añadir Usuario </a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="u">
				<tr>
					<th>${u.id}</th>
					<td>${u.username}</td>
					<td><form style="display: inline" method="post" action="/borrar"
							onsubmit="return confirm('¿Estás seguro de que quieres borrar el registro cuyo id es ${u.id}?')">
							<button class="btn btn-danger">Borrar</button>
							<input type="hidden" name="id" value="${u.id}" /> 
							<input type="hidden" name="op" value="borrar" /> 
						</form>
				   </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>