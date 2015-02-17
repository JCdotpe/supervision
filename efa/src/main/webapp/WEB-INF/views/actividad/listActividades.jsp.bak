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
		src='<c:url value="/web-resources/js/js-for-listActividades.js"/>'></script>     
    </jsp:attribute>
    
    <jsp:body>
		<!--<div id="bookDialog" style="display: none;">
		</div>
		-->
		<span>Actividad </span>
		<h2>Programación de Actividades de Supervisión</h2>
		<div>
		<%@ include file="actividadForm.jsp"%>
		</div>	
		<br />
		<br />

		<table class="table datatable uppertext" id="tblAct">
			<thead>
				<tr>
					<th width="1%"></th>
					<th width="8%">Cod. Actividad</th>
					<th width="8%">Nivel de Gobierno</th>
					<th width="8%">Tipo</th>
					<th width="12%">Efa</th>
					<th width="8%">Fecha Inicio</th>
					<th width="8%">Fecha Fin</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${actList}" var="resp" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><c:out value="${resp.codactividad}" /></td>
						<td>
						<c:forEach var="nivel" items="${listNivel}" varStatus="i">
						<c:if test="${nivel.value == resp.nivel}">
					  		<c:out value="${nivel.label}"/>
					  	</c:if>
						</c:forEach>						
						</td>						
						<td>
						<c:forEach var="tipo" items="${listTipoAct}" varStatus="i">
						<c:if test="${tipo.value == resp.tipo}">
					  		<c:out value="${tipo.label}"/>
					  	</c:if>
						</c:forEach>						
						</td>	
						<td>
						<c:forEach var="efa" items="${efas}" varStatus="i">
						<c:if test="${efa.id == resp.idefa}">
					  		<c:out value="${efa.nombre}"/>
					  	</c:if>
						</c:forEach>						
						</td>								
						<fmt:formatDate value="${resp.fechaini}" pattern="dd/MM/yyyy" var="newfechaini" />
						<td><c:out value="${newfechaini}" /></td>
						<fmt:formatDate value="${resp.fechafin}" pattern="dd/MM/yyyy" var="newfechafin" />
						<td><c:out value="${newfechafin}" /></td>				
						<td><nobr>
							<c:if test="${empty resp.codactividad}">
								<a class="btn btn-efa btn-xs"
									href="contactos/${resp.id}">
									<span class="glyphicon glyphicon-edit"></span> Contactos
								</a>	
								<a class="btn btn-efa btn-xs"
									href="supervisores/${resp.id}">
									<span class="glyphicon glyphicon-edit"></span> Supervisores
								</a>									
								<a class="btn btn-efa btn-xs"
									href="edit/${resp.id}">
									<span class="glyphicon glyphicon-edit"></span> Editar
								</a> 																							
								<a class="btn btn-efa-del btn-xs" href="#"
									onclick="deleteAct(${resp.id})"> <span class="glyphicon glyphicon-remove"></span>Eliminar
								</a>
							</c:if>
							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>

    </jsp:body>
</t:simple>