<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	<jsp:include page="../fragments/header.jsp" />
	<jsp:include page="../fragments/headerelement.jsp" />
	<div class="container">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" 
	                                aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		<h3>Detalles Elementos</h3>
		<br />
	
		<div class="row">
			<label class="col-sm-2">Nombre del Elemento</label>
			<div class="col-sm-10">${element.elementName}</div>
		</div>
	
		<div class="row">
			<label class="col-sm-2">Descripcion del Elemento</label>
			<div class="col-sm-10">${element.description}</div>
		</div>
	
		<div class="row">
			<label class="col-sm-2">Solucion</label>
			<div class="col-sm-10">${element.solution}</div>
		</div>
	
		<div class="row">
			<label class="col-sm-2">Dispositivo</label>
			<div class="col-sm-10">${element.device}</div>
		</div>
	
		<div class="row">
			<label class="col-sm-2">Actor</label>
			<div class="col-sm-10">${element.actor}</div>
		</div>
	
		<div class="row">
			<label class="col-sm-2">Pais</label>
			<div class="col-sm-10">${element.country}</div>
		</div>
	
		<div class="row">
			<label class="col-sm-2">Error</label>
			<div class="col-sm-10">${filter.error}</div>
		</div>
	
		<div class="row">
			<label class="col-sm-2">Segmento</label>
			<div class="col-sm-10">${element.segment}</div>
		</div>
	
		<div class="row">
			<label class="col-sm-2">Servicio</label>
			<div class="col-sm-10">${element.service}</div>
		</div>
	
		<div class="row">
			<label class="col-sm-2">Tipo</label>
			<div class="col-sm-10">${element.type}</div>
		</div>
	
		<div class="row">
			<label class="col-sm-2">xPath</label>
			<div class="col-sm-10">${element.xPath}</div>
		</div>

	</div>

	<jsp:include page="../fragments/footerback.jsp" />

</body>
</html>