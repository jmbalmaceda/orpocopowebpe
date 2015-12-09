<%@ page session="false"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>  
</head>

<body>
	<jsp:include page="fragments/header.jsp" />

	<div class="container">
		<h3>Indice de operaciones</h3>
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" 
	                                aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>	
		<div class="panel-group">
		    <div class="panel panel-default">
		      <div class="panel-heading">
		        <h4 class="panel-title">
		          <a data-toggle="collapse" href="#collapse1">Elementos</a>
		        </h4>
		      </div>
		      <div id="collapse1" class="panel-collapse collapse">
		      
		        <div class="panel-body"><a href="${pageContext.request.contextPath}/filterFields.htm"> Listar</a></div>
		        <div class="panel-footer"><a href="${pageContext.request.contextPath}/filterFields/add.htm"> Agregar</a></div>
		      </div>
		      <div class="panel-heading">
		        <h4 class="panel-title">
		          <a data-toggle="collapse" href="#collapse2">Template</a>
		        </h4>
		      </div>
		      <div id="collapse2" class="panel-collapse collapse">
		        <div class="panel-body"><a href="${pageContext.request.contextPath}/customizeTemplate.htm"> Customizacion</a></div>
		        <div class="panel-footer"><a href="${pageContext.request.contextPath}/templateValidator.htm"> Validacion</a></div>
		        <div class="panel-body"><a href="${pageContext.request.contextPath}/template.htm"> Listar Templates</a></div>
		        <div class="panel-footer"><a href="${pageContext.request.contextPath}/template/add.htm"> Agregar Templates</a></div>
		      </div>
		      <div class="panel-heading">
		        <h4 class="panel-title">
		          <a data-toggle="collapse" href="#collapse3">Ticket</a>
		        </h4>
		      </div>
		      <div id="collapse3" class="panel-collapse collapse">
		        <div class="panel-body"><a href="${pageContext.request.contextPath}/selectTicket.htm"> Buscar</a></div>
		      </div>
		       <div class="panel-heading">
		        <h4 class="panel-title">
		          <a data-toggle="collapse" href="#collapse4">Mensajes CMM</a>
		        </h4>
		      </div>
		      <div id="collapse4" class="panel-collapse collapse">
		        <div class="panel-body"><a href="${pageContext.request.contextPath}/index.htm"> Listar</a></div>
		        <div class="panel-footer"><a href="${pageContext.request.contextPath}/index.htm"> Agregar</a></div>
		      </div>
		    </div>
		  </div>
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>
	