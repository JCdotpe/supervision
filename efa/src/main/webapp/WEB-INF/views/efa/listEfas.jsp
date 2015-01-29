<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

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
		<span> Mantenimiento EFA</span>
		<h2>Entidad Fiscalización Ambiental (EFA)</h2>
		<div>
		<%@ include file="efaForm.jsp"%>
		</div>	
		<br />
		<br />
		<!-- <button class="btn btn-primary btn-lg active" onclick="addBook()">
			<span class="glyphicon glyphicon-plus"></span> Agregar EFA
		</button>
		-->
		<table class="table datatable uppertext" id="tblEfa">
			<thead>
				<tr>
					<th width="1%"></th>
					<th width="12%">Nombre</th>
					<th width="12%">Nivel</th>
					<th width="24%">Titular</th>
					<th width="8%">Cargo</th>
					<th width="12%">Correo</th>
					<th width="8%">Teléfono</th>
					<th width="12%">Domicilio Legal</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${efaList}" var="efa" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><c:out value="${efa.nombre}" /></td>
						<td>
						<c:forEach var="nivel" items="${listNivel}" varStatus="i">
						<c:if test="${nivel.value == efa.nivel}">
					  		<c:out value="${nivel.label}"/>
					  	</c:if>
						</c:forEach>						
						</td>
						
						<td><c:out value="${efa.tnombre} ${efa.tapp} ${efa.tapm}" /></td>
						<td><c:out value="${efa.tcargo}" /></td>
						<td><c:out value="${efa.correo}" /></td>
						<td><c:out value="${efa.telefono}" /></td>
						<td>
						<c:if test="${fn:length(efa.direccion) > 20}">	
						<a href="#" data-toggle="tooltip" data-placement="left" title="${efa.direccion}"><c:out value="${fn:substring(efa.direccion, 0, 20)}" /></a>
						</c:if>
						<c:if test="${fn:length(efa.direccion) <= 20}">	
						<c:out value="${efa.direccion}" />
						</c:if>								
						</td>						
						<td><nobr>

								<a class="btn btn-efa btn-xs"
									href="detail/${efa.id}">
									<span class="glyphicon glyphicon-edit"></span> Contacto
								</a>	
								<a class="btn btn-efa btn-xs"
									href="edit/${efa.id}">
									<span class="glyphicon glyphicon-edit"></span> Editar
								</a> 																							

								<a class="btn btn-efa-del btn-xs"
									onclick="deleteEfa(${efa.id})"> <span class="glyphicon glyphicon-remove"></span>Eliminar
								</a>
							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
        

    </jsp:body>
</t:simple>