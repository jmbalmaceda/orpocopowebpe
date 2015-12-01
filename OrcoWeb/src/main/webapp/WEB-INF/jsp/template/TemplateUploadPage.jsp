<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<style>
.titulo {
    font-family: arial, helvetica, sans-serif;
    /*color: #003366;*/
    color: white;
    background-color: #2A4594;
    font-weight: bold;
    font-size: 24px;
    text-align: center;
}
.titulo_2 {
    font-family: arial, helvetica, sans-serif;
    /*color: #003366;*/
    color: #2B3D4D;
    font-weight: bold;
    font-size: 18px;
    text-align: center;
    border-top: 1px solid #ddd;
    padding: 20px;
}
.titulo_3 {
    font-family: arial, helvetica, sans-serif;
    /*color: #003366;*/
    color: #2B3D4D;
    font-weight: bold;
    font-size: 18px;
    text-align: center;
    padding: 10px;
}
.body {
        background-repeat:no-repeat;  		
  		font-family: monospace;
		font-size: 12px;  		
		float: center;
		text-align: center; 		  	      
 	    }
.mensaje{
	color:#003366;
	font-family: Arial;
	font-size: 13px;
	font-weight: bold;
}
.contentsDiv {
	overflow: auto;
	background-color: white;
	min-height: 85%;
	height: 89%;
	_height: auto;	
	width: 100%;
	position: relative !important;
	z-index: 2;
	margin-top: 20px;
	clear: both;
}

.tabla {
	border: 1px solid #ddd;
}
 </style>
	<title>Validador de Templates</title>
</head>

<body>
	<div id="contents" class="contentsDiv">
	<form id="viewTemplate" action="viewTemplate.htm" commandName="templateUploadCommand" enctype="multipart/form-data" method="post">
		<table width="60%" cellspacing="2" align="center" border="0" class="tabla">
			<tr>
				<td class="titulo" colspan="2">Validador de Templates</td>
			</tr>
			<tr>
				<td class="titulo_2" colspan="2">Nuevo Template</td>
			</tr>
			<tr>
				<td width="40%" align="center" style="border-right: 1px solid #ddd;">
				<table>
					<td class="titulo_3"> Filter Fields</td>
					<tr>
						<td>
							<c:forEach  var="fields" items="${filterFields}" >
								<input type="checkbox" name="filterFieldList" id="filterFieldList" value="${fields}">${fields}<br>
							</c:forEach>

						</td>
					</tr>
					</tr>
				</table>
				</td>
				<td>
					<table>
					<td colspan="2" class="titulo_3">Opciones de contexto</td>
					<tr><td>Servicio:</td><td><input type="text" name="service"></td></tr>
					<tr>
						<td>Solución:</td>
						<td>
							<select id="solution" name="solution">
							   <option value="ALL">--Todos--</option>
							   <option value="DB">Digital Banking</option>
							   <option value="SP">Security & Profiling</option>
							   <option value="CP">Commercial Platform</option>
							</select> 
						</td>
					</tr>
					<tr>
						<td>Dispositivo:</td>
						<td>
							<select id="device" name="device">
							   <option value="ALL">--Todos--</option>
							   <option value="DS">Desktop</option>
							   <option value="MB">Mobile</option>
							   <option value="TB">Tablet</option>
							   <option value="SS">SelfService</option>
							   <option value="ST">SmartTV</option>
							</select> 
						</td>
					</tr>
					<tr>
						<td>Actor:</td>
						<td>
							<select id="actor" name="actor">
							   <option value="ALL">--Todos--</option>
							   <option value="BI">Banca Individuos</option>
							   <option value="BE">Cliente Empresa</option>
							   <option value="NC">No Clientes</option>
							   <option value="OP">Operador</option>
							</select> 
						</td>
					</tr>
					<tr>
						<td>País:</td>
						<td>
							<select id="country" name="country">
							   <option value="ALL">--Todos--</option>
							   <option value="AR">Argentina</option>
							   <option value="CH">Chile</option>
							   <option value="PE">Peru</option>
							   <option value="CO">Colombia</option>
							</select> 
						</td>
					</tr>
					<tr>
						<td>Error:</td>
						<td>
							<select id="error" name="error">
							   <option value="FALSE">False</option>
							   <option value="TRUE">True</option>
							</select> 
						</td>
					</tr>
					<tr>
						<td>Segmento:</td>
						<td>
							<select id="segment" name="segment">
							   <option value="ALL">--Todos--</option>
							</select> 
						</td>
					</tr>
					<td colspan="2" style="border-top: 1px solid #ddd; padding: 5px"> </td>
					<tr>
						<td>
							Cargar desde archivo:
					</td><td>
					<input type="file" name="templateFile"/>
					</td></tr>
					<c:if test="${showIcons}">
						<tr><td>
						Cargar vista Miniatura:
						</td><td>
						<input type="file" name="templateThumbnailFile"/>
						</td></tr>
					</c:if>
					<td colspan="2" style="border-top: 1px solid #ddd; padding: 5px"> </td>
					<tr><td>Nombre del Template:</td><td><input type="text" name="templateName"></td></tr>
					<td colspan="2" style="border-top: 1px solid #ddd; padding: 5px"> </td>
					<tr><td style="text-align: center;" colspan="2"><a  onclick="var form = document.forms[0]; form.guardarTemplate.value=true; form.submit();" href="#">Guardar Template</a></td> </tr>
					</table>
				</td>
			</tr>
			<tr height="10px"></tr>
				<td class="titulo_2" colspan="2">Utilizar uno existente:
					<form:select name="templateList_CB" path="templateSelected">
						<form:option value="-1">-</form:option>
						<form:options items="${templateList}"/>
					</form:select>
				</td>
			<tr height="10px"></tr>
			<tr>
				<td class="titulo_2" colspan="2">Mensaje XML</td>
			</tr>
			<tr align="center">
				<td class="body" colspan="2">
					Puede cargarse desde un archivo o reemplazar los tag por valores por defecto
				<br>
					<input type="file" name="dataFile"/>
				<br>
				</td>
			</tr>
			<tr>
				<td class="titulo_2" colspan="2">
					<a  onclick="var form = document.forms[0]; form.submit();" href="#">Generar Ticket</a> 
				</td>
			</tr>
		</table>
		<input type="hidden" id="guardarTemplate" name="guardarTemplate" value="false" />
		</form>
	</div>
</body>
</html>