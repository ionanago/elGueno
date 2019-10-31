<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="appcenter">
	<h2>Formulario Producto</h2>
	
	<form method="post" action="/ProcesarProducto">
	 <div class="form-group">
	 
	<input class="form-control" name="nombre" placeholder="Nombre" value="${producto.nombre}"/>
	</div>
	<div class="form-group">
	<input class="form-control" type="number" name="precio" placeholder="Precio" value="${producto.precio}"/>
	</div>
	<div class="form-group">
	<button type="submit" class="btn btn-primary">Aceptar</button>
	</div>
</form>
	
</div>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>