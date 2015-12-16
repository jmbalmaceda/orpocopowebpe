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
	
	<div class="container">
	<c:choose>
		<c:when test="${elementForm['new']}">
			<h3>Nuevo Horario</h3>
		</c:when>
		<c:otherwise>
			<h3>Actualizar Horario</h3>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/times/update.htm" var="timeActionUrl" />

	<form:form class="form-horizontal" method="post" 
                modelAttribute="time" action="${timeActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="weekDay">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Día de la semana</label>
			<div class="col-sm-10">
				<form:select path="weekDay" class="form-control">
					<form:option value="0" label="Domingo"/>
					<form:option value="1" label="Lunes"/>
					<form:option value="2" label="Martes"/>
					<form:option value="3" label="Miércoles"/>
					<form:option value="4" label="Jueves"/>
					<form:option value="5" label="Viernes"/>
					<form:option value="6" label="Sábado"/>
   				</form:select>
				<!-- 
				<form:input path="weekDay" type="text" class="form-control" 
                                id="stweekDayart" placeholder="Día" />
				<form:errors path="weekDay" class="control-label" />
				-->
			</div>
		  </div>
		</spring:bind>

		<spring:bind path="start">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Comienzo</label>
			<div class="col-sm-10">
				<form:input path="start" type="time" class="form-control" 
                                id="start" placeholder="Comienzo" />
				<form:errors path="start" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="finish">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Fin</label>
			<div class="col-sm-10">
				<form:input path="finish" type="time" class="form-control" 
                                id="finish" placeholder="Fin" />
				<form:errors path="finish" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10">
			<c:choose>
			  <c:when test="${elementForm['new']}">
			     <button type="submit" style="float: right;" class="btn btn-primary">Agregar
                             </button>
			  </c:when>
			  <c:otherwise>
			     <button type="submit" style="float: right;" class="btn btn-primary">Actualizar
                             </button>
			  </c:otherwise>
			</c:choose>
		  </div>
		</div>
	</form:form>

</div>

<jsp:include page="../fragments/footerback.jsp" />

</body>
</html>