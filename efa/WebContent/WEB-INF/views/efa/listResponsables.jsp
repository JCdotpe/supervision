<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:url var="editUrl" value="/responsable/edit/" />
<c:url var="delUrl" value="/responsable/deleteres/" />
<c:url var="efaUrl" value="/efa/" />
<t:simple>
    <jsp:attribute name="header">
    
    </jsp:attribute>
    
    <jsp:attribute name="footer">
      <p id="copyright">OEFA</p>
 	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listEfas.js"/>'></script>     
    </jsp:attribute>
    
    <jsp:body>
		<!--<div id="bookDialog" style="display: none;">
		</div>
		-->
		<a href="${efaUrl }">Mantenimiento EFA  </a>/	<span> Contacto</span>
		
		<h2>Datos del Contacto de la EFA </h2>
		<h4>Entidad de Fiscalización Ambiental: ${efa.nombre}</h4>
		<h4>Nivel de Gobierno: 
			<c:forEach var="nivel" items="${listNivel}" varStatus="i">
				<c:if test="${nivel.value == efa.nivel}">
					<c:out value="${nivel.label}"/>
				</c:if>
			</c:forEach>			
		
		</h4>
		<c:if test="${not empty actEfa}">	
			<a class="btn btn-primary"	href="/efa/actividad/contactos/${actId}">
					Regresar Actividad
			</a>	
		</c:if>		
		<div>
		<%@ include file="responsableForm.jsp"%>
		</div>	
		<br />
		<br />

		<table class="table datatable uppertext" id="tblResp">
			<thead>
				<tr>
					<th width="1%"></th>
					<th width="8%">Sector/Área</th>
					<th width="8%">Tipo</th>
					<th width="12%">Apellido Paterno</th>
					<th width="12%">Apellido Materno</th>
					<th width="12%">Nombre</th>
					<th width="8%">Cargo</th>
					<th width="8%">Correo</th>
					<th width="8%">Teléfono</th>
					<th width="16%">Domicilio Legal</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${respList}" var="resp" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td>
						<c:out value="${resp.sector}" />
					<!-- <c:forEach var="nivel" items="${listSectores}" varStatus="i">
						<c:if test="${nivel.value == resp.sector}">
					  		<c:out value="${nivel.label}"/>
					  	</c:if>
						</c:forEach>		 -->					
						</td>
						<td>
						<c:forEach var="nivel" items="${listTipos}" varStatus="i">
						<c:if test="${nivel.value == resp.tipo}">
					  		<c:out value="${nivel.label}"/>
					  	</c:if>
						</c:forEach>						
						</td>						
						<td><c:out value="${resp.appaterno}" /></td>
						<td><c:out value="${resp.apmaterno}" /></td>
						<td><c:out value="${resp.nombre}" /></td>
						<td><c:out value="${resp.cargo}" /></td>
						<td><c:out value="${resp.correo}" /></td>
						<td><c:out value="${resp.telefono}" /></td>
						<td>
						<c:if test="${fn:length(resp.direccion) > 20}">	
						<a href="#" data-toggle="tooltip" data-placement="left" title="${resp.direccion}"><c:out value="${fn:substring(resp.direccion, 0, 20)}" /></a>
						</c:if>
						<c:if test="${fn:length(resp.direccion) <= 20}">	
						<c:out value="${resp.direccion}" />
						</c:if>						
						</td>						
						<td><nobr>
							
								<a class="btn btn-efa btn-xs"
									href="${editUrl}${efa.id}/${resp.idresponsable}">
									<span class="glyphicon glyphicon-edit"></span> Editar
								</a>		
													
								<a class="btn btn-efa-del btn-xs"
									onclick="return confirm('Esta seguro de eliminar este registro?');"
									href="${delUrl}${resp.idresponsable}"> <span class="glyphicon glyphicon-remove"></span>Eliminar
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
        

    </jsp:body>
</t:simple>