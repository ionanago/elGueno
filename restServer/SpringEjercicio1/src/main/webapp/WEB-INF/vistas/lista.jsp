<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<div class="container">

		
		<ul>
			<c:forEach items="${usuarios}" var="u">
				<li>
					<p>id: ${u.id}, Nombre: ${u.nombre}, contrase�a: ${u.passwd}</p>
				</li>
			</c:forEach>
		
		</ul>
</div>

<%@ include file="/WEB-INF/includes/pie.jsp"%>