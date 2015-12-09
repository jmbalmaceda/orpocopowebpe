<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="es">

<script type="text/javascript">
	function detail(){
	
	var e = document.getElementById("sel1");
	var action = e.options[e.selectedIndex].value;
	document.getElementById("formDetail").action=action;
	document.getElementById("formDetail").submit();
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
	<c:if test="${showIcons}">
		<td>
			<object data="${iconData}" />
		</td>
	</c:if>
	<td>
		<object data="${imageData}" />
	</td>       

    <form id="formDetail" role="form" action="${selectTicketActionUrl}">
		<div class="form-group">
			<label for="sel1">Seleccionar Ticket:</label>
			<select class="form-control" id="sel1">
				<option value="">Seleccione</option>
				<c:forEach  var="ticket" items="${ticketList}" >
					<option value="${pageContext.request.contextPath}/selectTicket/${ticket}.htm">${ticket}</option>
					
				</c:forEach>              
			</select>
			<hiden 
		</div>
		<br>
		<button type="button" class="btn-lg btn-primary pull-right" onclick="detail();">Visualizar</button>
		<br>
	</form>   	
       	
</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>

