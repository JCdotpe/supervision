<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:url var="editUM" value="/administrados/um/" />
<t:simple>
    <jsp:attribute name="header">
    
    </jsp:attribute>
    
    <jsp:attribute name="footer">
      <p id="copyright">OEFA</p>
 	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listAdministrados.js"/>'></script>     
    </jsp:attribute>
    
    <jsp:body>
		<!--<div id="bookDialog" style="display: none;">
		</div>
		-->
		<span>Mantenimiento / Administrados </span>
		<h2>Administrados</h2>
		<div>
		<%@ include file="administradosForm.jsp"%>
		</div>	
		<br />
		<br />

		<table class="table datatable uppertext" id="tblAct">
			<thead>
				<tr>
					<th width="1%"></th>
					<th width="8%">Tipo Persona</th>
					<th width="8%">Departamento</th>
					<th width="12%">Provincia</th>
					<th width="8%">Distrito</th>
					<th width="8%">Dirección</th>
					<th width="12%">Teléfono</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${admList}" var="resp" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>			
						<td>
						<c:forEach var="nivel" items="${listTipoPersona}" varStatus="i">
						<c:if test="${nivel.value == resp.tipopersona}">
					  		<c:out value="${nivel.label}"/>
					  	</c:if>
						</c:forEach>						
						</td>
						<td><c:out value="${resp.departamentodes}" /></td>
						<td><c:out value="${resp.provinciades}" /></td>
						<td><c:out value="${resp.distritodes}" /></td>
						<td><c:out value="${resp.direccion}" /></td>		
						<td><c:out value="${resp.telefono}" /></td>						
						<td><nobr>
								<a class="btn btn-efa btn-xs"
									href="edit/${resp.idadministrados}">
									<span class="glyphicon glyphicon-edit"></span> Editar
								</a> 		
								<a class="btn btn-efa btn-xs"
									href="${editUM}${resp.idadministrados}">
									<span class="glyphicon glyphicon-edit"></span> Unidad Operativa
								</a> 																															
								<a class="btn btn-efa-del btn-xs" href="#"
									onclick="deleteAdm(${resp.idadministrados})"> <span class="glyphicon glyphicon-remove"></span>Eliminar
								</a>
							</nobr></td>																			
					</tr>
				</c:forEach>
			</tbody>
		
		</table>

    </jsp:body>
</t:simple>