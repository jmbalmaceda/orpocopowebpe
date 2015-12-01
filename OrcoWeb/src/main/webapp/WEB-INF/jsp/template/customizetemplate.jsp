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
	<h3>Customizador de Templates</h3>
	<spring:url value="/customizeTemplate.htm" var="customizeTemplateActionUrl" />

	<form:form class="form-horizontal" method="post" 
                modelAttribute="filterFields" action="${customizeTemplateActionUrl}" enctype="multipart/form-data">

			<spring:bind path="filterFields">
				<div class="row">
			        <div class="col-xs-6">
			            <h4 class="text">Filter Fields</h4>
			            <div class="well" style="max-height: 300px;overflow: auto;">
			        		<ul class="list-group checked-list-box">
							<c:forEach  var="fields" items="${filterFields}" >
			                  <li class="list-group-item" style="margin-left: -5px">                 
									<input type="checkbox" name="filterFieldList" id="filterFieldList" value="${fields}" style="margin-left: -5px; width: 32px">${fields}<br>                   
					          </li>
					        </c:forEach>
			                </ul>
			            </div>
			        </div>
			    </div>
			</spring:bind>
		
			<div class="input-group">
	                <span class="input-group-btn">
	                    <span class="btn btn-primary btn-file">
	                        Cargar desde archivo&hellip; <input type="file" name="templateFile" >
	                    </span>
	                </span>
	                <input type="text" class="form-control" name="templateFile" readonly>
	        </div>
	        <br>
	        <div class="form-group">
			  	<div class="col-sm-offset-2 col-sm-10">
	       			<button type="submit" style="float: right;" class="btn btn-primary">Customizar</button>
	       		</div>
	       	</div>
                             
   	</form:form>
       	
</div>

<jsp:include page="../fragments/footerback.jsp" />

</body>
</html>