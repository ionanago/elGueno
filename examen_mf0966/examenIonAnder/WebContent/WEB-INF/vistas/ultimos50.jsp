<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<h2>last 50</h2>

<table class="table text-center">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Email</th>
				<th>Dni</th>
				<th/>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${last50}" var="p">
				<tr>
					<th>${p.id}</th>
					<td>${p.nombre}</td>
					<td>${p.apellido}</td>
					<td>${p.email}</td>
					<td>${p.dni}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>