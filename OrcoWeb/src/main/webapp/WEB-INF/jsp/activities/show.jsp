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
	
	
	<!-- Periodo de fechas -->
	<div class="panel panel-default panel-primary col-sm-5">
		<div class="panel-heading">
			<h3>Filtros</h3>			
		</div>
		<div class="panel-body">
			
				<spring:bind path="inicio">
				  <div class="form-group ">
					<label class="col-sm-2 control-label">Comienzo</label>
					<div class="col-sm-10">
						<form:input path="inicio" type="date" class="form-control" 
		                                id="inicio" placeholder="Comienzo" />
						<form:errors path="inicio" class="control-label" />
					</div>
				  </div>
				</spring:bind>
				<spring:bind path="fin">
				  <div class="form-group ">
					<label class="col-sm-2 control-label">Comienzo</label>
					<div class="col-sm-10">
						<form:input path="fin" type="date" class="form-control" 
		                                id="fin" placeholder="Fin" />
						<form:errors path="fin" class="control-label" />
					</div>
				  </div>
				</spring:bind>
				 <button type="submit" style="float: right;" class="btn btn-primary">Actualizar</button>
			
		</div>
		<div class="panel-footer">
			footer
		</div>
	</div>
	
	<!-- Resumen -->
	<div class="panel panel-default col-sm-5">
		<div class="panel-heading">
			<h3>Resumen de Actividad</h3>			
		</div>
		<div class="panel-body">
			body
		</div>
		<div class="panel-footer">
			footer
		</div>
	</div>
	
	
	<!-- visitantes promedio diario -->
	<div class="panel panel-default  col-sm-7">
		<div class="panel-heading">
			<h3>Visitantes Promedio Diario</h3>			
		</div>
		<div class="panel-body">
			<img alt="" src="${pageContext.request.contextPath}/getBarChartView.htm" />
		</div>
		<div class="panel-footer">
			footer
		</div>
	</div>
	
	
	<!-- Heatmap -->
	<div class="panel panel-default  col-sm-5">
		<div class="panel-heading">
			<h3>Heatmap</h3>			
		</div>
		<div class="panel-body">
			body
		</div>
		<div class="panel-footer">
			footer
		</div>
	</div>
	
	<!-- Promedio horario -->
	<div class="panel panel-default  col-sm-7">
		<div class="panel-heading">
			<h3>Visitantes Promedio Horario</h3>			
		</div>
		<div class="panel-body">
			<img alt="" src="${pageContext.request.contextPath}/getPromedioVisitantesDiario.htm" />
		</div>
		<div class="panel-footer">
			footer
		</div>
	</div>
	
	<!-- Visitas por dia -->
	<div class="panel panel-default  col-sm-5">
		<div class="panel-heading">
			<h3>Visitas Por Dia</h3>			
		</div>
		<div class="panel-body">
			body
		</div>
		<div class="panel-footer">
			footer
		</div>
	</div>
	
	
	<!-- Shoppers /100 -->
	<div class="panel panel-default  col-sm-5">
		<div class="panel-heading">
			<h3>Shoppers /100 visitantes</h3>			
		</div>
		<div class="panel-body">
			body
		</div>
		<div class="panel-footer">
			footer
		</div>
	</div>
	<jsp:include page="../fragments/footerback.jsp" />
</body>
</html>