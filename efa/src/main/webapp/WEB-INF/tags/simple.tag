<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<!--  <link rel="stylesheet"	href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>-->
	<link rel="stylesheet"	href='<c:url value="/web-resources/css/bootstrap.min.css"/>'>
	<link rel="stylesheet"	href='<c:url value="/web-resources/css/jasny-bootstrap.min.css"/>'>
	<link rel="stylesheet"	href='<c:url value="/web-resources/css/dashboard.css"/>'>
	
	<link rel="stylesheet"	href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
	<link rel="stylesheet"	href='<c:url value="/web-resources/css/jquery.dataTables.min.css"/>'>
	<link rel="stylesheet"	href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>
</head>
<body>
<div id="pageheader">
	<jsp:invoke fragment="header"/>
</div>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><span><img height="49" src="<c:url value="/web-resources/img/logo.png"/>"/></span></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
			<li>
				<a href="${pageContext.request.contextPath}">
					<span>${usuario.usuario} - ${usuario.perfil}</span>
				</a>
				<a class="salir" href="${pageContext.request.contextPath}/logout">
					<span>CERRAR SESION</span>
				</a>
			</li>
			</ul>
		</div>
	</div>
</div> 
<div id="body" class="container-fluid">
	<div id="bookDialog" style="display: none;"></div>
	<div class="col-sm-3 col-md-2 sidebar" id="sidebar1">
	<!--       <ul class="nav nav-sidebar">
	<li><a href="#">Registro</a></li>
	<li><a href="#">Consulta</a></li>
	<li><a href="#">Reportes</a></li>
	<li class="active"> <a href="#">Mantenimiento</a></li>
	</ul>-->
		<ul class="nav navmenu-nav">
		
			<c:forEach items="${menuList}" varStatus="i" var="m">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					<span class="glyphicon ${m.menu.icono}"></span>
					<b> ${m.menu.nombre}</b> 
					<b class="caret"></b>
				</a>
				<c:if test="${not empty m.opciones}">
				<ul class="dropdown-menu navmenu-nav nav " role="menu">
					<c:forEach items="${m.opciones}" varStatus="j" var="o">
					<li><a href="${o.opcion.url}?u=url">${o.opcion.nombre}</a></li>
					</c:forEach>			
				</ul>			
				</c:if>
			</li>
			</c:forEach>		
		
		  
			<!--li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-plus"></span><b> Registro</b> <b class="caret"></b></a>
				<ul class="dropdown-menu navmenu-nav nav " role="menu">
					<li><a href="/efa/actividad/">Programación de Actividades</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-zoom-in"></span><b> Consulta</b> <b class="caret"></b></a>
				<ul class="dropdown-menu navmenu-nav nav" role="menu">
					<li><a href="/efa/actsupervision/">Actividades Programadas</a></li>
					<li><a href="/efa/sinada/">Denuncias de SINADA</a></li>
				</ul>
			</li>
			  
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-list-alt"></span><b> Reporte</b> <b class="caret"></b></a>
				<ul class="dropdown-menu navmenu-nav nav" role="menu">
					<li><a href="/efa/reporte/">Actividades</a></li>
				</ul>
			</li>
		
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					<span class="glyphicon glyphicon-wrench"></span><b> Mantenimiento</b><b class="caret"></b>
				</a>
				<ul class="dropdown-menu navmenu-nav nav" role="menu">
					<li><a href="/efa/efa/">Entidad de Fiscalización Ambiental</a></li>
					<li><a href="/efa/administrados/">Administrados</a></li>
					<li><a href="/efa/supervisor/">Supervisores de Fiscalización Ambiental</a></li>
				</ul>
			</li-->
		</ul>
	</div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="content">  
		<button type="button" id="toggleSidebar" class="btn btn-primary">
			<span class="glyphicon glyphicon-backward"></span>
		</button>
		<jsp:doBody/>  		
	</div>
</div>
 
<div id="pagefooter">
	<script type="text/javascript"	src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"	src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"	src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>   
	<script type="text/javascript"	src='<c:url value="/web-resources/js/lib/bootstrap.min.js"/>'></script>   
	<script type="text/javascript"	src='<c:url value="/web-resources/js/lib/jquery.dataTables.min.js"/>'></script> 
	<script type="text/javascript"	src='<c:url value="/web-resources/js/lib/jquery.validate.min.js"/>'></script> 
	<script type="text/javascript"	src='<c:url value="/web-resources/js/lib/additional-methods.js"/>'></script> 
	<script type="text/javascript"	src='<c:url value="/web-resources/js/lib/jasny-bootstrap.min.js"/>'></script> 
	<script type="text/javascript"	src='<c:url value="/web-resources/js/lib/custom.js"/>'></script>
	
	<script type="text/javascript">var prefix = '/efa';</script>
	<jsp:invoke fragment="footer"/>
</div>
</body>
</html>