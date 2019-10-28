<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<!-- 
httpServletRequest.remoteUser
-->
<h2>Hello ${pageContext.request.remoteUser}</h2>
<form action="/logout" method="post">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" /> <input type="submit" value="Cerrar Sesion" />

</form>
<h2>
	<a href="/admin"> admin</a> | <a href="/user"> user</a>
</h2>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>