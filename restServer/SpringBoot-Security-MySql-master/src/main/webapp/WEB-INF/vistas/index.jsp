<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera_login.jsp"%>


 <div class="modal-dialog text-center">
        <div class="col-sm-8 main-section">
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="/img/user.png" />
                </div>
               <form class="col-12" action="/login" method="post">
                    <div class="form-group" id="user-group">
                        <input type="text" class="form-control" placeholder="Nombre de usuario" name="username"/>
                    </div>
                    <div class="form-group" id="contrasena-group">
                        <input type="password" class="form-control" placeholder="Contrasena" name="password"/>
                    </div>
                    <button type="submit" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i>  Ingresar </button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                
                <c:if test="${param.error}">
                <div  class="alert alert-danger" role="alert">
		            Usuario y contrase�a incorrectos.
		        </div>
		        </c:if>
		        <c:if test="${param.logout}">
		        <div  class="alert alert-success" role="alert">
		            Sesi�n cerrada exitosamente.
		        </div>
		        </c:if>
            </div>
        </div>
    </div>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>