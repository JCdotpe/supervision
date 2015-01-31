<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:simple>
    <jsp:attribute name="header">
    
    </jsp:attribute>
    
    <jsp:attribute name="footer">
      <p id="copyright">OEFA</p>
 	<script type="text/javascript"
		src='<c:url value="/web-resources/js/lib/jquery.form.js"/>'></script>  
 	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listActSupervision.js"/>'></script>  
 	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listMatriz.js"/>'></script>     
    </jsp:attribute>
    
    <jsp:body>
		<!--<div id="bookDialog" style="display: none;">
		</div>
		-->
		<span> Consulta </span>
		<h2>Actividades de Supervisión</h2>
		<div>
		<%@ include file="actsupervisionForm.jsp"%>
		</div>	
		<br />
		<br />

		<table class="table datatable uppertext" id="tblAct">
			<thead>
				<tr>
					<th width="1%"></th>
					<th width="8%">Código Act. Programada</th>
					<th width="12%">EFA</th>
					<th width="8%">Fecha Inicio</th>
					<th width="8%">Ubigeo</th>
					<th width="8%">Supervisor Responsable</th>
					<th width="3%">Nivel de Gobierno</th>
					<th width="2%">Amerita Supervisión Especial</th>
					<th width="2%">Requiere Analítica</th>
					<th width="2%">Presentó Hallazgos Críticos </th>
					<th width="2%">Estado</th>
					<th width="1%">Matriz de Supervisión</th>
					<th width="1%">Asignar Ejecución</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${actList}" var="resp" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>			
						<td><c:out value="${resp.CODACTIVIDAD}" /></td>
						<td><c:out value="${resp.EFANOMBRE}" /></td>
						<td><c:out value="${resp.FECHAINI}" /></td>
						<td><c:out value="${resp.UBIGEO}" /></td>
						<td><c:out value="${resp.SUPNOMBRE}" /></td>	
						<td>
						<c:forEach var="nivel" items="${listNivel}" varStatus="i">
						<c:if test="${nivel.value == resp.NIVEL}">
					  		<c:out value="${nivel.label}"/>
					  	</c:if>
						</c:forEach>						
						</td>
						<td><c:out value="${resp.SUPERVISION}" /></td>
						<td><c:out value="${resp.ANALITICA}" /></td>
						<td><c:out value="${resp.HALLAZGO}" /></td>
						<td>
						<c:forEach var="nivel" items="${listEstadoAct}" varStatus="i">
						<c:if test="${nivel.value == resp.ESTADO}">
					  		<c:out value="${nivel.label}"/>
					  	</c:if>
						</c:forEach>	
						</td>	
						<c:choose>
							<c:when test="${usuario.codPerfil eq '14'}">						
								<td>---</td>
								<td>---</td>
							</c:when>
							<c:otherwise>
								<td>
		                            <a href="/efa/ejeact/${resp.IDACTIVIDAD}"class="btn btn-efa btn-xs">
		                                <span class="glyphicon glyphicon-edit"></span>
		                            </a>
								</td>
								<td>							
	                             <a href="#myModal" role="button" class="btn btn-efa-del btn-xs btn-pop-matriz" data-toggle="modal" data-level="${resp.NIVEL}" data-id="${resp.IDACTIVIDAD}"> <span class="glyphicon glyphicon-edit"></span>
	                             </a>
								</td>	                             
	                           								
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
    </jsp:body>
</t:simple>
<!-- Modal -->
<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<c:url var="actionUrlMatriz" value="/matriz/saveMatrizActividad" />
	<form id="frm_matriz_add" method="post" accept-charset="UTF-8"
	action="${actionUrlMatriz}">
		<input type="hidden" name="idactividad" id="idactividad_modal" value="" />
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">Matriz</h3>
		</div>
		<div class="modal-body">
	  		<table class="table uppertext">
	  			<thead>
		  			<tr>
		  				<th width="100"><center>Check</center></th>
		  				<th>Matriz</th>
		  			</tr>
	  			</thead>
	  			<tbody id="listMatriz">
	  				<tr><td colspan="3"><div class="loader"></div></td></tr>
	  			</tbody>
	  		</table>
		</div>
		<div class="modal-footer">
	  		<button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
	  		<a href="#" id="modalverMatriz" class="btn btn-primary">Seleccionar</a>
		</div>
	</form>
</div>