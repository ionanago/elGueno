<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="appcenter">
	<h2>Formulario Usuario</h2>
	
	<form method="post" action="/ProcesarUsuario">
	 <div class="form-group">
	 
	<input class="form-control" name="username" placeholder="Nombre"/>
	</div>
	<div class="form-group">
	<input class="form-control" type="password" name="password" placeholder="Contrase�a" />
	</div>
	<div class="form-group">
	<button type="submit" class="btn btn-primary">A�adir Usuario</button>
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</div>
   </form>
	
</div>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>