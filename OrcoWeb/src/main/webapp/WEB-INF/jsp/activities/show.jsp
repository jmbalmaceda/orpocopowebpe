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


	<!-- Periodo de fechas -->
	<div class="panel panel-default panel-primary col-sm-3">
		<div class="panel-heading">
			<h3>Filtros</h3>
		</div>
		<div class="panel-body">
			<spring:url value="/activities/updateTimes.htm" var="updateTimeUrl" />
			<form:form class="form-horizontal" method="post"
				modelAttribute="dashboardFilter" action="${updateTimeUrl}">
				<spring:bind path="start">
					<div class="form-group ">
						<label class="col-sm-4 control-label">Comienzo</label>
						<div class="col-sm-8">
							<form:input path="start" type="date" class="form-control"
								id="start" placeholder="Comienzo" />
							<form:errors path="start" class="control-label" />
						</div>
					</div>
				</spring:bind>
				<spring:bind path="finish">
					<div class="form-group ">
						<label class="col-sm-4 control-label">fin</label>
						<div class="col-sm-8">
							<form:input path="finish" type="date" class="form-control"
								id="finish" placeholder="Fin" />
							<form:errors path="finish" class="control-label" />
						</div>
					</div>
				</spring:bind>
				<button type="submit" style="float: right;" class="btn btn-primary">Actualizar</button>
			</form:form>
		</div>
		<div class="panel-footer">
			<a download="datos.csv" href="${pageContext.request.contextPath}/downloadData.htm?start=${startParam}&finish=${finishParam}">
				<button type="button" class="btn">Descargar datos mostrados</button>
			</a>
		</div>
	</div>

	<!-- Resumen -->
	<div class="panel panel-default col-sm-8">
		<div class="panel-heading">
			<h3>Resumen de Actividad</h3>
		</div>
		<div class="panel-body">
			<ul class="list-group col-sm-2">
				<li class="list-group-item">Visitantes</li>
				<li class="list-group-item"><div class="alert alert-info" role="alert">${cantidadVisitantes}</div></li>
			</ul>
			<ul class="list-group col-sm-2">
				<li class="list-group-item">Sentido D-I</li>
				<li class="list-group-item"><div class="alert alert-info" role="alert">${sentidoDI}</div></li>
			</ul>
			<ul class="list-group col-sm-2">
				<li class="list-group-item">Sentido I-D</li>
				<li class="list-group-item"><div class="alert alert-info" role="alert">${sentidoID}</div></li>
			</ul>
			<ul class="list-group col-sm-2">
				<li class="list-group-item">Detenciones</li>
				<li class="list-group-item"><div class="alert alert-info" role="alert">...</div></li>
			</ul>
			<ul class="list-group col-sm-2">
				<li class="list-group-item">Shoppers</li>
				<li class="list-group-item"><div class="alert alert-info" role="alert">${shoppers}</div></li>
			</ul>
		</div>
	</div>


	<!-- visitantes promedio diario -->
	<div class="panel panel-default  col-sm-7">
		<div class="panel-heading">
			<h3>Visitantes Promedio Diario</h3>
		</div>
		<div class="panel-body">
			<img alt=""
				src="${pageContext.request.contextPath}/getPromedioVisitantesDiaSemana.htm?start=${startParam}&finish=${finishParam}" />
		</div>
		<!-- <div class="panel-footer">footer</div> -->
	</div>


	<!-- Heatmap -->
	<!-- 
	<div class="panel panel-default  col-sm-5">
		<div class="panel-heading">
			<h3>Heatmap</h3>
		</div>
		<div class="panel-body">body</div>
		<div class="panel-footer">footer</div>
	</div>
	-->

	<!-- Promedio horario -->
	<div class="panel panel-default  col-sm-7">
		<div class="panel-heading">
			<h3>Visitantes Promedio Horario</h3>
		</div>
		<div class="panel-body">
			<img alt=""
				src="${pageContext.request.contextPath}/getPromedioVisitantesHora.htm?start=${startParam} }&finish=${finishParam}" />
		</div>
		<!-- <div class="panel-footer">footer</div> -->
	</div>

	<!-- Visitas por dia -->
	<div class="panel panel-default  col-sm-5">
		<div class="panel-heading">
			<h3>Visitas Por Dia</h3>
		</div>
		<div class="panel-body">
			<img alt=""
				src="${pageContext.request.contextPath}/getPromedioVisitantesDiario.htm?start=${startParam} }&finish=${finishParam}" />
		</div>
		<!-- <div class="panel-footer">footer</div> -->
	</div>


	<!-- Shoppers /100 -->
	<!-- 
	<div class="panel panel-default  col-sm-5">
		<div class="panel-heading">
			<h3>Shoppers /100 visitantes</h3>
		</div>
		<div class="panel-body">body</div>
		<div class="panel-footer">footer</div>
	</div>
	-->
</body>
</html>