<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>ORCO WEB | Conoce a tus clientes</title>
<link rel="shortcut icon" href="images/ico/favicon.ico">
<style type="text/css">
	.section{
		font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
		color: #777;
    	font-weight: 300;
    	font-size: 18px;
		}
</style>
</head>
<body>
	<table>
		<thead>Encabezado</thead>
		<tr>
			<td class="section">
				<img alt="Horarios de análisis" src="${pageContext.request.contextPath}/images/image1.png">
			</td>
			<td colspan="2">
				<img alt="Resumen de entradas y salidas" src="${pageContext.request.contextPath}/images/image2.png">
			</td>
		</tr>
		<tr>
			<td>
				<img alt="Visitantes promedio diario" src="${pageContext.request.contextPath}/images/image3.png">
			</td>
			<td colspan="2">
				<img alt="Hitmap" src="${pageContext.request.contextPath}/images/image4.png">
			</td>
		</tr>
		<tr>
			<td>
				<img alt="Promedio visitantes por franja horaria" src="${pageContext.request.contextPath}/images/image5.png">
			</td>
			<td>
				<img alt="Cantidad de visitas por dia" src="${pageContext.request.contextPath}/images/image6.png">
			</td>
			<td>
				<img alt="Shoppers sobre 100 visitantes" src="${pageContext.request.contextPath}/images/image7.png">
			</td>
		</tr>
		<tfoot>Pie</tfoot>
	</table>
</body>
</html>