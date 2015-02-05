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
		src='<c:url value="/web-resources/js/js-for-listSupervisores.js"/>'></script>     
    </jsp:attribute>
    
    <jsp:body>
		<!--<div id="bookDialog" style="display: none;">
		</div>
		-->
		<span> Supervisores </span>
		<h2>Supervisores Ambientales</h2>
		
		<c:if test="${not empty actEfa}">	
			<a class="btn btn-primary"	href="/efa/actividad/supervisores/${actId}">
					Regresar Actividad
			</a>	
		</c:if>					
		<div>
		<%@ include file="supervisorForm.jsp"%>
		</div>	
		
		<br />
		<br />

		<table class="table datatable uppertext" id="tblSupervisor">
			<thead>
				<tr>
					<th width="4%"></th>
					<th width="12%">Apellidos y Nombres</th>
					<th width="12%">DNI</th>
					<th width="12%">Profesión</th>
					<th width="12%">Email</th>
					<th width="12%">Teléfono</th>
					<th width="12%">Modalidad Contrato</th>
					<th width="12%">Fecha Fin Contrato</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${supList}" var="sup" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><c:out value="${sup.appPaterno} ${sup.appMaterno}, ${sup.nombre}" /></td>
						<td><c:out value="${sup.dni}" /></td>
						<td><c:out value="${sup.profesion}" /></td>
						<td><c:out value="${sup.correo}" /></td>
						<td><c:out value="${sup.telefono}" /></td>
						<td>
						<c:forEach var="moda" items="${listMcontrato}" varStatus="i">
						<c:if test="${moda.value == sup.modalidad}">
					  		<c:out value="${moda.label}"/>
					  	</c:if>
						</c:forEach>						
						</td>	
						<fmt:formatDate value="${sup.finLaboral}" pattern="dd/MM/yyyy" var="newdatevar" />
						<td><c:out value="${newdatevar}" /></td>
										
						  <td><nobr>

								<a class="btn btn-efa btn-xs"
									href="suparchivo/${sup.id}">
									<span class="glyphicon glyphicon-edit"></span> Archivo
								</a>	
								<a class="btn btn-efa btn-xs"
									href="supemergencia/${sup.id}">
									<span class="glyphicon glyphicon-edit"></span> Contacto
								</a>									
								<a class="btn btn-efa btn-xs"
									href="edit/${sup.id}">
									<span class="glyphicon glyphicon-edit"></span> Editar
								</a> 																							
								<a class="btn btn-efa-del btn-xs"
									onclick="deleteSup(${sup.id})"> <span class="glyphicon glyphicon-remove"></span>Eliminar
								</a>
							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table> 

    </jsp:body>
</t:simple>