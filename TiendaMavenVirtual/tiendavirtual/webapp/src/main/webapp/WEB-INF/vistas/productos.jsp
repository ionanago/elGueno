<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jspf"%>

<div class="col-10">
	<table class="table text-center">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Descripción</th>
				<th>Precio</th>
				<th><a href="producto" class="btn btn-primary mx-2"> Añadir producto </a></th>
				<th/>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<th>${p.id}</th>
					<td>${p.nombre}</td>
					<td>${p.descripcion}</td>
					<td><fmt:formatNumber value="${p.precio}" type="currency" />
					</td>
					<td><a class="btn btn-primary" href="producto?id=${p.id}">Modificar</a>
						<%--<a onclick="return confirm('¿Estás seguro de que quieres borrar el registro cuyo id es ${libro.id}?')" class="btn btn-danger" href="admin/libroprocesar?op=borrar&id=${libro.id}">Borrar</a>--%>
						<form style="display: inline" method="post" action="producto"
							onsubmit="return confirm('¿Estás seguro de que quieres borrar el registro cuyo id es ${p.id}?')">

							<button class="btn btn-danger">Borrar</button>
							<input type="hidden" name="id" value="${p.id}" /> <input
								type="hidden" name="op" value="borrar" /> <input type="hidden"
								name="nombreBorrar" value="${p.nombre}" /> <input type="hidden"
								name="descripcionBorrar" value="${p.descripcion}" /> <input
								type="hidden" name="precioBorrar" value="${p.precio}" />
						</form></td>
					<td>
						<form style="display: inline" method="post" action="carrito">
							<button class="btn btn-success">Comprar</button>
							<input type="hidden" name="nombreCart" value="${p.nombre}" /> 
							<input type="hidden" name="precioCart" value="${p.precio}" />
						</form>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<aside class="col-2 carrito">
	<c:forEach items="${carritos}" var="c">
		<div>
			<span>${c.nombre}</span> <span>${c.precio}</span>
			<form style="display: inline" method="post" action="carrito">
				<button class="btn btn-danger">X</button>
				<input type="hidden" name="idCart" value="${c.id}" /> 
			</form>
		</div>
	</c:forEach>
	<div>
			<span>pepe</span> <span>pepe</span>
			<form style="display: inline" method="post" action="carrito">
				<button class="btn btn-danger">X</button>
				<input type="hidden" name="idCart" value="${c.id}" /> 
			</form>
		</div>
</aside>

<%--  <a href="producto" class="btn btn-primary">Añadir producto</a>--%>

<%@ include file="/WEB-INF/vistas/includes/pie.jspf"%>
