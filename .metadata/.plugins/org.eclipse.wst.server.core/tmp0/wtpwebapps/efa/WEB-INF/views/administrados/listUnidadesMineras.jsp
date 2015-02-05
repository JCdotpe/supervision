<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:url var="editUrl" value="/uminera/editum/" />
<c:url var="delUrl" value="/uminera/deleteum/" />
<c:url var="admUrl" value="/administrados/" />
<t:simple>
    <jsp:attribute name="header">
    
    </jsp:attribute>
    
    <jsp:attribute name="footer">
      <p id="copyright">OEFA</p>
 	<script type="text/javascript"
		src='<c:url value="/web-resources/js/js-for-listUnidadesMineras.js"/>'></script>     
    </jsp:attribute>
    
    <jsp:body>
		<!--<div id="bookDialog" style="display: none;">
		</div>
		-->
		<a href="${admUrl }">Administrados </a>/	<span> Unidad Operativa</span>
		
		<h2>Datos de Unidad Operativa </h2>
		<c:if test="${not empty adm.nombres}">	
			<h4>Nombre Administrado: ${adm.nombres} ${adm.appaterno} ${adm.apmaterno}</h4>	
		</c:if>		
		<c:if test="${not empty adm.razonsocial}">	
			<h4>Razón Social Administrado: ${adm.razonsocial}</h4>	
		</c:if>				
		
		<div>
		<%@ include file="unidadesmForm.jsp"%>
		</div>	
		<br />
		<br />

		<table class="table datatable uppertext" id="tblUniM">
			<thead>
				<tr>
					<th width="1%"></th>
					<th width="8%">Unidad Minera</th>
					<th width="8%">Tipo Derecho Minero</th>
					<th width="12%">Derecho Minero</th>
					<th width="12%">Código INACC-INGEMETT</th>
					<th width="12%">Ubicación</th>
					<th width="8%">Norte</th>
					<th width="8%">Este</th>
					<th width="8%">Zona</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUM}" var="resp" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td>
						<c:out value="${resp.nombreunidad}" />
					<!-- <c:forEach var="nivel" items="${listSectores}" varStatus="i">
						<c:if test="${nivel.value == resp.sector}">
					  		<c:out value="${nivel.label}"/>
					  	</c:if>
						</c:forEach>		 -->					
						</td>
						<td>
						<c:forEach var="nivel" items="${listTiposDerechoM}" varStatus="i">
						<c:if test="${nivel.value == resp.tipodm}">
					  		<c:out value="${nivel.label}"/>
					  	</c:if>
						</c:forEach>						
						</td>						
						<td><c:out value="${resp.nombredm}" /></td>
						<td><c:out value="${resp.codinacc}" /></td>
						<td><c:out value="${resp.departamentodes} - ${resp.provinciades} - ${resp.distritodes}" /></td>
						<td><c:out value="${resp.norte}" /></td>
						<td><c:out value="${resp.este}" /></td>
						<td><c:out value="${resp.zona}" /></td>					
						<td><nobr>
							
								<a class="btn btn-efa btn-xs"
									href="${editUrl}${resp.idunidadminera}">
									<span class="glyphicon glyphicon-edit"></span> Editar
								</a>												
								<a class="btn btn-efa-del btn-xs"
									onclick="deleteUM(${resp.idunidadminera})"
									href="#"> <span class="glyphicon glyphicon-remove"></span>Eliminar
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
        

    </jsp:body>
</t:simple>