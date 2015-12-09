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
		<h3>Todos los Elementos</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nombre del Elemento</th>
					<th>Descripcion</th>
					<th>Resumen (ambito y error)</th>
					<th>Accion</th>
				</tr>
			</thead>

			<c:forEach var="filter" items="${filterFields}">
			    <tr>
				<td>
					${filter.elementName}
				</td>
				<td>
					${filter.description}
				</td>
				<td>${filter.summary}</td>
				<td>
				  <spring:url value="/filterFields/${filter.elementId}.htm" var="filterFieldsUrl" />
				  <spring:url value="/filterFields/${filter.elementId}/update.htm" var="updateFilterFieldsUrl" />

				  <button class="btn btn-info" 
                                          onclick="location.href='${filterFieldsUrl}'">Detalles</button>
				  <button class="btn btn-primary" 
                                          onclick="location.href='${updateFilterFieldsUrl}'">Actualizar</button>
			    </tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../fragments/footerback.jsp" />

</body>
</html>