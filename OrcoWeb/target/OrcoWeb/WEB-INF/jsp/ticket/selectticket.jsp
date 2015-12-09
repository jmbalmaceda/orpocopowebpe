<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="es">

<script type="text/javascript">
	function search(){
		var id = document.getElementById("idTicket").value;
		if (Number(id) > 0) {
			var action = "${pageContext.request.contextPath}/findTicket/"+id+".htm";
			document.getElementById("formSearch").action=action;
			document.getElementById("formSearch").submit();
        }
        else{
        	alert("Por favor ingrese un valor");
        }
	}
</script>

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
	<h2>Visualizador de Tickets</h2>
		
	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" 
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>
	
	<form id="formSearch" role="form">
	<div class="form-group">
	    <div class="input-group">
	      		<input type="text" id="idTicket" class="form-control" placeholder="Ingresar ticket...">
	      		<span class="input-group-btn">
	        		<button type="button" id="button" class="btn btn-default" onclick="search();">Buscar</button>
	      		</span>
	    </div>
  	</div>
  	</form>
  	
	<br>
	<c:if test="${! empty imageData}">
		<c:if test="${showIcons}">
			<td>
				<object width="500" height="500" data="${iconData}" >
					<param name="view" value="fit" valuetype="data"/>
				</object>
			</td>
		</c:if>
		<!-- 
		#view=FitH&pagemode=thumbs&search=pdfobject&toolbar=0&statusbar=0&messages=0&navpanes=1
		-->
		<td>
			<object width="500" height="500" data="${imageData}" >
				<param name="view" value="FitV" />
				
			</object>
		</td>       
	 </c:if>
 	
</div>

<jsp:include page="../fragments/footerback.jsp" />

</body>
</html>

