<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<!-- 
httpServletRequest.remoteUser
-->
<div class="appcenter">
<h2>Hello ${pageContext.request.remoteUser}</h2>
<!-- <form action="/logout" method="post">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" /> <input type="submit" value="Cerrar Sesion" />

</form>-->
<h4>
	<a href="/admin" class="btn btn-light"> seccion administración</a> 
	<a href="/user" class="btn btn-light"> seccion normal y corriente</a>
</h4>

</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>