<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:url var="addUrl" value="/actividad/addsup" />
<c:url var="delUrl" value="/actividad/delsup" />
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
		<span> <a href="/efa/actividad/">Actividad  </a> / Supervisores</span>
		<h2>Actividad Supervisores</h2>
							  <a class="btn btn-efa"
									href="/efa/supervisor/${act.id}">
									Supervisores
								</a>	
							<!--	<a class="btn btn-efa"
									href="/efa/supervisor/">
									Supervisores
								</a>	-->										
		<br/>
		<p class="green info-form">Supervisores de EFA</p>
		<br/>
		
		<table class="table datatable uppertext" id="tblResp">
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
									href="${addUrl}/${act.id}/${sup.id}">
									<span class="glyphicon glyphicon-edit"></span> Agregar
								</a>		

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td width="1%"></td>
					<td width="4%"><input type="text" class="form-control" placeholder="DNI"></td>
					<td width="12%"><input type="text" class="form-control" placeholder="Apellido Paterno"></td>
					<td width="12%"><input type="text" class="form-control" placeholder="Apellido Materno"></td>
					<td width="12%"></td>
					<td width="4%"></td>
					<td width="7%"></td>
					<td width="8%"></td>
					<td width="8%"></td>
				</tr>
			</tfoot>
		</table>
		<br/>
		<p class="green info-form">Supervisores Añadidos a la Actividad</p>
		<br/>
		<table class="table uppertext" id="tblSupx">
			<thead>
				<tr>
					<th width="1%"></th>
					<th width="3%">RESPONSABLE</th>
					<th width="12%">Apellidos y Nombres</th>
					<th width="12%">DNI</th>
					<th width="12%">Profesión</th>
					<th width="12%">Email</th>
					<th width="12%">Teléfono</th>
					<th width="12%">Modalidad Contrato</th>
					<th width="12%">Fecha Fin Contrato</th>
					<th width="8%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listActsup}" var="sup" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><input type="radio" name="idsupres" id="idsupres" <c:if test="${sup.id == act.idsupres }">checked="checked"</c:if> value="${sup.id}" /></td>
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
																			
								<a class="btn btn-efa-del btn-xs"
									href="${delUrl}/${act.id}/${sup.id}">
									<span class="glyphicon glyphicon-remove"></span>Eliminar
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
								<a id="btnsetsup" class="btn btn-success">
									<span class="glyphicon glyphicon-edit"></span> Guardar Responsable
								</a>	

								<a   class="btn btn-efa-del" id="btnsetini">
									Finalizar Programación de Actividad
								</a>									
		<input type="hidden" id="idact" name="idact" value="${act.id}">
    </jsp:body>
</t:simple>