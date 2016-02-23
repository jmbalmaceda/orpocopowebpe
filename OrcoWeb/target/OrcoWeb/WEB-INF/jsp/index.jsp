<%@ page session="false"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>

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
	<jsp:include page="fragments/header.jsp" />
	<div>
	 	<c:import  url="http://www.criterya.com/orco/" />
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>
</html>
	