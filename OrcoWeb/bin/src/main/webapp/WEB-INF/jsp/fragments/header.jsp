<spring:url value="/index.htm" var="urlHome" />

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand">Centro de Recibos</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/index.htm">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Elementos <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/filterFields.htm">Listar </a></li>
            <li><a href="${pageContext.request.contextPath}/filterFields/add.htm">Agregar </a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Templates <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/template.htm">Listar</a></li>
            <li><a href="${pageContext.request.contextPath}/template/add.htm">Agregar</a></li>
            <li><a href="${pageContext.request.contextPath}/customizeTemplate.htm">Customizar</a></li>
            <li><a href="${pageContext.request.contextPath}/templateValidator.htm">Validar</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Ticket <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/selectTicket.htm">Buscar</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Mensajes CMM <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Listar</a></li>
            <li><a href="#">Agregar</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>