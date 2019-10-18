<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<br>
<h2>Añadir Una Nueva Persona</h2>
<form method="post" action="procesar">
	<div class="form-group row">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-10">
			<input type="text" class="form-control" name="nombre">
			
		</div>
	</div>
	<div class="form-group row">
		<label for="apellido" class="col-sm-2 col-form-label">Apellido</label>
		<div class="col-10">
			<input type="text" class="form-control" name="apellido">
			
		</div>
	</div>
	<div class="form-group row">
		<label for="email" class="col-sm-2 col-form-label">Email</label>
		<div class="col-10">
			<input type="email" class="form-control" name="email">
			
		</div>
	</div>
	<div class="form-group row">
		<label for="dni" class="col-sm-2 col-form-label">Dni</label>
		<div class="col-10">
			<input type="text" class="form-control" name="dni">
			
		</div>
	</div>
	<div class="form-group row">
		<div class="col-10">
		
		<button type="submit" class="btn btn-primary">Añadir</button>
					
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>