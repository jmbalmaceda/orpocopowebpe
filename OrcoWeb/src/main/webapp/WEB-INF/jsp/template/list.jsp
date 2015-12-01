<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<h3>Todos los Templates</h3>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nombre del Template</th>
					<th>Template File</th>
					<c:if test="${showIcons}"><th>Template File Icono</th></c:if>
					<th>Accion</th>
				</tr>
			</thead>

			<c:forEach var="template" items="${templateList}">
			    <tr>
				<td>
					${template.templateName}
				</td>
				<td>
				  <spring:url value="/template/downloadFile/${template.templateId}.htm" var="templateFileDownloadUrl" />
				  <button class="btn btn-primary"  onclick="location.href='${templateFileDownloadUrl}'">Descargar</button>
				</td>
				<c:if test="${showIcons}">
				<td>
				  <spring:url value="/template/downloadThumbnailFile/${template.templateId}.htm" var="ThumbnailFileDownloadUrl" />
				  <button class="btn btn-primary" onclick="location.href='${ThumbnailFileDownloadUrl}'">Descargar</button>

				</td>
				</c:if>
				<td>
				  <spring:url value="/template/${template.templateId}.htm" var="templateDetailsUrl" />
				  <spring:url value="/template/${template.templateId}/update.htm" var="updateTemplateUrl" />
				  <button class="btn btn-info" onclick="location.href='${templateDetailsUrl}'">Detalles</button>
					<button class="btn btn-primary" onclick="location.href='${updateTemplateUrl}'">Actualizar</button>
				</td>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../fragments/footerback.jsp" />

</body>
</html>