<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<div class="container">
<table class="table text-center">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>contraseña</th>
				
				<th/>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="u">
				<tr>
					<th>${u.id}</th>
					<td>${u.nombre}</td>
					<td>${u.passwd}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<%@ include file="/WEB-INF/includes/pie.jsp"%>