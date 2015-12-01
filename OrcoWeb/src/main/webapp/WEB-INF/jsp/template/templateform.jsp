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
	<jsp:include page="../fragments/headertemplate.jsp" />

	<div class="container">
		<c:choose>
			<c:when test="${templates.template['new']}">
				<h3>Agregar Template</h3>
			</c:when>
			<c:otherwise>
				<h3>Actualizar Template</h3>
			</c:otherwise>
		</c:choose>
		<br />
	
		<spring:url value="/template.htm" var="templateActionUrl" />
	
		<form:form class="form-horizontal" method="post" modelAttribute="templates" action="${templateActionUrl}">
	
			<form:hidden path="template.templateId" />
	
			<spring:bind path="template.templateName">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Nombre del Template</label>
				<div class="col-sm-10">
					<form:input path="template.templateName" type="text" class="form-control" 
	                                id="template.templateName" placeholder="Nombre  del Template" />
					<form:errors path="template.templateName" class="control-label" />
				</div>
			  </div>
			</spring:bind>
			
			<div class="input-group">
		                <span class="input-group-btn">
		                    <span class="btn btn-primary btn-file">
		                        Seleccionar archivo&hellip; <input type="file" path="template.templateFile" name="template.templateFile" >
		                    </span>
		                </span>
		                <input type="text" class="form-control" name="template.templateFile" path="template.templateFile" readonly placeholder="Seleccionar Archivo Jasper...">
		    </div>
			
			</br>
			
			<div class="input-group">
		                <span class="input-group-btn">
		                    <span class="btn btn-primary btn-file">
		                        Seleccionar archivo&hellip; <input type="file" name="template.templateThumbnailFile" path="template.templateThumbnailFile">
		                    </span>
		                </span>
		                <input type="text" class="form-control" name="template.templateThumbnailFile" path="template.templateThumbnailFile" readonly placeholder="Seleccionar Archivo Iconizado Jasper...">
		    </div>
			</br>
	
			<spring:bind path="templateJasper.solution">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Solucion</label>
				<div class="col-sm-5">
					<form:select path="templateJasper.solution" class="form-control">
						<form:options items="${solutionList}" />
					</form:select>
					<form:errors path="templateJasper.solution" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			  </div>
			</spring:bind>
			
			<spring:bind path="templateJasper.device">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Dispositivo</label>
				<div class="col-sm-5">
					<form:select path="templateJasper.device" class="form-control">
						<form:options items="${deviceList}" />
					</form:select>
					<form:errors path="templateJasper.device" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			  </div>
			</spring:bind>
			
			<spring:bind path="templateJasper.actor">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Actor</label>
				<div class="col-sm-5">
					<form:select path="templateJasper.actor" class="form-control">
						<form:options items="${actorList}" />
					</form:select>
					<form:errors path="templateJasper.actor" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			  </div>
			</spring:bind>
			
			<spring:bind path="templateJasper.country">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Country</label>
				<div class="col-sm-5">
					<form:select path="templateJasper.country" class="form-control">
						<form:options items="${countryList}" />
					</form:select>
					<form:errors path="templateJasper.country" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			  </div>
			</spring:bind>
			
			<spring:bind path="templateJasper.error">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Error</label>
				<div class="col-sm-10">
					<label class="radio-inline"> 
	                                  <form:radiobutton path="templateJasper.error" value="FALSE" /> FALSE
					</label> 
	                                <label class="radio-inline"> 
	                                  <form:radiobutton path="templateJasper.error" value="TRUE" /> TRUE
					</label> <br />
					<form:errors path="templateJasper.error" class="control-label" />
				</div>
			  </div>
			</spring:bind>
			
			<spring:bind path="templateJasper.segment">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Segmento</label>
				<div class="col-sm-5">
					<form:select path="templateJasper.segment" class="form-control">
						<form:options items="${segmentList}" />
					</form:select>
					<form:errors path="templateJasper.segment" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			  </div>
			</spring:bind>
			
			<spring:bind path="templateJasper.servicio">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Servicio</label>
				<div class="col-sm-10">
					<form:input path="templateJasper.servicio" type="text" class="form-control" 
	                                id="servicio" placeholder="Servicio" />
					<form:errors path="templateJasper.servicio" class="control-label" />
				</div>
			  </div>
			</spring:bind>
			
			<div class="form-group">
			  <div class="col-sm-offset-2 col-sm-10">
				<c:choose>
				  <c:when test="${templates.template['new']}">
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