<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy") ;
	String anio = sdf.format(new Date()); 
%>
<!DOCTYPE html>
<html lang="es-PE">
<head>
	<title>EFA | Login</title>
	<link rel="stylesheet" type="text/css" href='<c:url value="/web-resources/css/seguridad/base.css"/>'>
	<link rel="stylesheet" type="text/css" href='<c:url value="/web-resources/css/seguridad/page.css"/>'>
</head>
<body class="index-page">        
	<div id="page-content">
		<header id="header">
			<div class="sub-header-1">
				<div class="wrapper">
					<span id="logo-oefa"></span>
					<span id="logo-portal"></span>				
				</div>
			</div>
			<div class="sub-header-2"></div>
		</header>
		<div id="content-wrap">
			<section id="content">
				<img src="<c:url value="/web-resources/img/seguridad/fondo-contenedor-login.png"/>" width="100%" id="img-fondo-login"/>
				<div class="wrapper">
					<div id="frm-login">
						<header>
							<h1>Sistema de Supervisión a Entidades</h1>
						</header>
						<form:form method="POST" action="login" id="login" commandName="loginForm">
							<label>
								<form:input type="text" path="usuario" name="usuario" id="usuario" placeholder="Usuario" class="in"/>				
							</label>
							<label>
								<form:password path="contrasena" name="contrasena" id="contrasena" placeholder="Contraseña" class="in"/>
							</label>
							<div>${msj}</div>
							<input type="submit" value="Ingresar" class="submit"/>
						</form:form>
					</div>
				</div>
			</section>			
		</div>
		<footer id="footer">
			<div id="copyright">
				<span>&copy; <%=anio%> OEFA, El uso de este sitio está sujeto a nuestras Condiciones de uso. Todos los derechos reservados.</span>
			</div>
		</footer>	
	</div>
</body>
</html>