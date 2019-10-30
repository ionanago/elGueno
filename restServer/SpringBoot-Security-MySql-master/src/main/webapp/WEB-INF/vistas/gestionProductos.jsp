<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="appcenter">
	<h2>Gestión De Productos</h2>
	
	<h3>PRODUCTOS</h3>
<table class="table ">
		<thead>
			<tr>
				<th>Id</th>
				<th>Producto</th>
				<th>Precio</th>
				
				<th><a href="producto" class="btn btn-primary mx-2"> Añadir producto </a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<th>${p.id}</th>
					<td>${p.nombre}</td>
					<td>${p.precio}&euro;</td>
					
					<td><a class="btn btn-primary" href="/formProductos?id=${p.id}">Modificar</a>
						<%--<a onclick="return confirm('¿Estás seguro de que quieres borrar el registro cuyo id es ${libro.id}?')" class="btn btn-danger" href="admin/libroprocesar?op=borrar&id=${libro.id}">Borrar</a>--%>
						<form style="display: inline" method="post" action="/borrar"
							onsubmit="return confirm('¿Estás seguro de que quieres borrar el registro cuyo id es ${p.id}?')">

							<button class="btn btn-danger">Borrar</button>
							<input type="hidden" name="id" value="${p.id}" /> <input
								type="hidden" name="op" value="borrar" /> <input type="hidden"
								name="nombreBorrar" value="${p.nombre}" /> <input type="hidden"
								name="descripcionBorrar" value="${p.descripcion}" /> <input
								type="hidden" name="precioBorrar" value="${p.precio}" />
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</div>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>