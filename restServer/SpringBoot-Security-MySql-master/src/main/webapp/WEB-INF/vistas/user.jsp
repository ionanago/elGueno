<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="appcenter">

<h2>${pageContext.request.remoteUser}, esto es un listado de productos de la empresa </h2>

<h3>PRODUCTOS</h3>
<table class="table ">
		<thead>
			<tr>
				<th>Id</th>
				<th>Producto</th>
				<th>Precio</th>
				
				<th/>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<th>${p.id}</th>
					<td>${p.nombre}</td>
					<td>${p.precio}&euro;</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>




</div>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>