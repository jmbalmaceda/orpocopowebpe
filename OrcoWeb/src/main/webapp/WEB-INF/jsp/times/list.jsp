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
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
	<jsp:include page="../fragments/header.jsp" />
	<!-- jsp:include page="../fragments/headerelement.jsp" /-->

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
		<h3>Horarios de Análisis</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Día de la semana</th>
					<th>Comienzo</th>
					<th>Fin</th>
					<th>Acción</th>
				</tr>
			</thead>

			<c:forEach var="time" items="${times}">
				<tr>
					<td>${time.weekDay}</td>
					<td>${time.start}</td>
					<td>${time.finish}</td>
					<td>
						<spring:url value="/times/${time.id}/delete.htm" var="deleteUrl" /> 
						<spring:url value="/times/${time.id}/show.htm" var="updateUrl" /> 
							<button class="btn btn-primary"
								onclick="location.href='${updateUrl}'">Actualizar</button>
							<button class="btn btn-primary"
								onclick="location.href='${deleteUrl}'">Eliminar</button>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../fragments/footerback.jsp" />

</body>
</html>