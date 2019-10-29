<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<div class="appcenter">
	<h2>${pageContext.request.remoteUser},esto es la administración</h2>


	<h3>
		<a href="/proGest" class="btn btn-light"> administar productos</a> 
		<a href="/usuGest" class="btn btn-light">administrar usuarios</a>
	</h3>

</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>