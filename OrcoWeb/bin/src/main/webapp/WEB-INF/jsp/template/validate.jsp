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

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" 
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>
	<h3>Validador de Templates</h3>
	<spring:url value="/validate.htm" var="validateTemplateActionUrl" />

	<form:form class="form-horizontal" method="post" action="${validateTemplateActionUrl}" enctype="multipart/form-data" >
	
			<h4>Cargar Template</h4>
			<div class="input-group">
	                <span class="input-group-btn">
	                    <span class="btn btn-primary btn-file">
	                        Seleccionar archivo&hellip; <input type="file" name="templateFile" >
	                    </span>
	                </span>
	                <input type="text" class="form-control" name="templateFile" readonly placeholder="Seleccionar Archivo Jasper...">
	        </div>
	        <br>
	        <h4>Seleccionar Template existente</h4>
			<div class="class="btn btn-primary btn-file">
				<select class="form-control" id="templateList" name="templateList_CB" >
					<option value="">Seleccione</option>
					<c:forEach  var="templateId" items="${templateList}" >
						<option value="${templateId}">${templateId}</option>
					</c:forEach>              
				</select>
			</div>
			<br>
			<h4>Cargar Mensaje CMM</h4>
				<div class="input-group">
	                <span class="input-group-btn">
	                    <span class="btn btn-primary btn-file">
	                        Seleccionar archivo&hellip; <input type="file" name="messageCMM" >
	                    </span>
	                </span>
	                <input type="text" class="form-control" name="messageCMM" readonly placeholder="Seleccionar mensaje CMM...">
		        </div>
	        <br>
	        <div class="form-group">
			  	<div class="col-sm-offset-2 col-sm-10">
	       			<button type="submit" style="float: right;" class="btn btn-primary">Validar</button>
	       		</div>
	       	</div>
                             
   	</form:form>
       	
</div>

<jsp:include page="../fragments/footerback.jsp" />

</body>
</html>