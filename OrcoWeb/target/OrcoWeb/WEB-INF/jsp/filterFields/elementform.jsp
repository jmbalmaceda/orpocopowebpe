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
	<c:choose>
		<c:when test="${elementForm['new']}">
			<h3>Agregar Elemento</h3>
		</c:when>
		<c:otherwise>
			<h3>Actualizar Elemento</h3>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/filterFields.htm" var="filterFieldsActionUrl" />

	<form:form class="form-horizontal" method="post" 
                modelAttribute="elementForm" action="${filterFieldsActionUrl}">

		<form:hidden path="elementId" />

		<spring:bind path="elementName">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Nombre del Elemento</label>
			<div class="col-sm-10">
				<form:input path="elementName" type="text" class="form-control" 
                                id="elementName" placeholder="elementName" />
				<form:errors path="elementName" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="description">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Descripcion del Elemento</label>
			<div class="col-sm-10">
				<form:input path="description" type="text" class="form-control" 
                                id="description" placeholder="description" />
				<form:errors path="description" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<spring:bind path="solution">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Solucion</label>
			<div class="col-sm-5">
				<form:select path="solution" class="form-control">
					<form:options items="${solutionList}" />
				</form:select>
				<form:errors path="solution" class="control-label" />
			</div>
			<div class="col-sm-5"></div>
		  </div>
		</spring:bind>
		
		<spring:bind path="device">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Dispositivo</label>
			<div class="col-sm-5">
				<form:select path="device" class="form-control">
					<form:options items="${deviceList}" />
				</form:select>
				<form:errors path="device" class="control-label" />
			</div>
			<div class="col-sm-5"></div>
		  </div>
		</spring:bind>
		
		<spring:bind path="actor">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Actor</label>
			<div class="col-sm-5">
				<form:select path="actor" class="form-control">
					<form:options items="${actorList}" />
				</form:select>
				<form:errors path="actor" class="control-label" />
			</div>
			<div class="col-sm-5"></div>
		  </div>
		</spring:bind>
		
		<spring:bind path="country">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Country</label>
			<div class="col-sm-5">
				<form:select path="country" class="form-control">
					<form:options items="${countryList}" />
				</form:select>
				<form:errors path="country" class="control-label" />
			</div>
			<div class="col-sm-5"></div>
		  </div>
		</spring:bind>
		
		<spring:bind path="error">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Error</label>
			<div class="col-sm-10">
				<label class="radio-inline"> 
                                  <form:radiobutton path="error" value="FALSE" /> FALSE
				</label> 
                                <label class="radio-inline"> 
                                  <form:radiobutton path="error" value="TRUE" /> TRUE
				</label> <br />
				<form:errors path="error" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="segment">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Segmento</label>
			<div class="col-sm-5">
				<form:select path="segment" class="form-control">
					<form:options items="${segmentList}" />
				</form:select>
				<form:errors path="segment" class="control-label" />
			</div>
			<div class="col-sm-5"></div>
		  </div>
		</spring:bind>
		
		<spring:bind path="variante">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Variante</label>
			<div class="col-sm-10">
				<form:input path="variante" type="text" class="form-control" 
                                id="variante" placeholder="variante" />
				<form:errors path="variante" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="service">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Servicio</label>
			<div class="col-sm-10">
				<form:input path="service" type="text" class="form-control" 
                                id="service" placeholder="service" />
				<form:errors path="service" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="type">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Type</label>
			<div class="col-sm-5">
				<form:select path="type" class="form-control">
					<form:options items="${typeList}" />
				</form:select>
				<form:errors path="type" class="control-label" />
			</div>
			<div class="col-sm-5"></div>
		  </div>
		</spring:bind>
		
		<spring:bind path="xPath">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">xPath</label>
			<div class="col-sm-10">
				<form:textarea path="xPath" rows="5" class="form-control" 
                                id="xPath" placeholder="xPath" />
				<form:errors path="xPath" class="control-label" />
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