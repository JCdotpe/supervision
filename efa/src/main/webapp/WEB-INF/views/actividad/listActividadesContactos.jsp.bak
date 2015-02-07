<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:url var="addUrl" value="/actividad/addcon" />
<c:url var="delUrl" value="/actividad/delcon" />
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
		<span> <a href="/efa/actividad/">Actividad  </a> / Contactos</span>
		<h2>Actividad Contactos</h2>
								<a class="btn btn-efa"
									href="/efa/efa/detail/${efa.id}/${act.id}">
									Contacto
								</a>			
		<br/>
		<p class="green info-form">Contactos de EFA</p>
		<br/>
		<table class="table datatable uppertext" id="tblResp" cellpadding="0" cellspacing="0" border="0" class="display">
			<thead>
				<tr>
					<th width="1%"></th>
					<th width="8%">Sector</th>
					<th width="8%">Tipo</th>
					<th width="12%">Apellido Paterno</th>
					<th width="12%">Apellido Materno</th>
					<th width="12%">Nombre</th>
					<th width="12%">Cargo</th>
					<th width="12%">Correo</th>
					<th width="8%">Teléfono</th>
					<th width="12%">Dirección Legal</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${respList}" var="resp" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td>
							<c:out value="${resp.sector}" />
						</td>
						<td>
						<c:forEach var="rtipo" items="${respTipos}" varStatus="i">
						<c:if test="${rtipo.value == resp.tipo}">
					  		<c:out value="${rtipo.label}"/>
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
						<td>
							
								<a class="btn btn-efa btn-xs"
									href="${addUrl}/${act.id}/${resp.idresponsable}">
									<span class="glyphicon glyphicon-edit"></span> Agregar
								</a>		

							</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br/>
		<p class="green info-form">Contactos Añadidos a la Actividad</p>
		<br/>
		<table class="table datatable uppertext" id="tblResp">
			<thead>
				<tr>
					<th width="1%"></th>
					<th width="8%">Sector</th>
					<th width="8%">Tipo</th>
					<th width="12%">Apellido Paterno</th>
					<th width="12%">Apellido Materno</th>
					<th width="12%">Nombre</th>
					<th width="12%">Cargo</th>
					<th width="12%">Correo</th>
					<th width="8%">Teléfono</th>
					<th width="12%">Dirección Legal</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listActres}" var="resp" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td>
							<c:out value="${resp.sector}" />
						</td>
						<td>
						<c:forEach var="rtipo" items="${respTipos}" varStatus="i">
						<c:if test="${rtipo.value == resp.tipo}">
					  		<c:out value="${rtipo.label}"/>
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
																			
								<a class="btn btn-efa-del btn-xs"
									href="${delUrl}/${act.id}/${resp.idresponsable}">
									<span class="glyphicon glyphicon-remove"></span>Eliminar
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

								<a class="btn btn-efa-del"
									href="/efa/actividad/supervisores/${act.id}">
									<span class="glyphicon glyphicon-edit"></span>Continuar
								</a>										
    </jsp:body>
</t:simple>