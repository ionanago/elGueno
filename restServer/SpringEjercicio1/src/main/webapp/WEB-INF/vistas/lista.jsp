<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<div class="container">

		
		<ul>
			<c:forEach items="${usuarios}" var="u">
				<li>
					<p>id: ${u.id}, Nombre: ${u.nombre}, contraseña: ${u.passwd}</p>
				</li>
			</c:forEach>
		
		</ul>
</div>

<%@ include file="/WEB-INF/includes/pie.jsp"%>