<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:simple>
    <jsp:attribute name="header">
    
    </jsp:attribute>
    
    <jsp:attribute name="footer">
      <p id="copyright">OEFA</p>
 	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listSupem.js"/>'></script>     
    </jsp:attribute>
    
    <jsp:body>
		<!--<div id="bookDialog" style="display: none;">
		</div>
		-->
		<span>  <a href="/efa/supervisor/">Supervisores  </a> / Contacto Emergencia</span>
		<h2>Supervisor Ambiental Contactos de Emergencia </h2>
		<c:if test="${not empty actEfa}">	
			<a class="btn btn-efa"	href="/efa/supervisor/${actEfa}">
					Continuar Supervisor
			</a>		
			<a class="btn btn-primary"	href="/efa/actividad/supervisores/${actEfa}">
					Regresar Actividad
			</a>	
		</c:if>			
		
		<h4>Supervisor: ${sup.nombre} ${sup.appPaterno} ${sup.appMaterno}</h4>
		
		<div>
		<%@ include file="supemergenciaForm.jsp"%>
		</div>	
		<br />
		<br />

		<table class="table datatable uppertext" id="tblSupervisor">
			<thead>
				<tr>
					<th width="4%"></th>
					<th width="12%">Nombre</th>
					<th width="12%">Teléfono</th>
					<th width="12%">Parentesco</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${supemList}" var="sup" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><c:out value="${sup.nombre}" /></td>
						<td><c:out value="${sup.telefono}" /></td>		
						<td><c:out value="${sup.parentesco}" /></td>							
						  <td><nobr>																					
								<a class="btn btn-efa-del btn-xs"
									onclick="deleteSupe(${sup.id})"> <span class="glyphicon glyphicon-remove"></span>Eliminar
								</a>
							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table> 

    </jsp:body>
</t:simple>