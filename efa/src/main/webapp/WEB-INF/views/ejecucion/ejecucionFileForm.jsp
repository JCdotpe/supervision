<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="actionUrl" value="/ejecarchivo/savefile?id=${actId}" />

<c:set var="desha0" value="false"/>
<c:set var="btnDesha0" value=""/>

<c:if test="${usuario.codPerfil eq '4'}">
	<c:set var="desha0" value="true"/>
	<c:set var="btnDesha0" value="disabled='true'"/>
</c:if>

	<form:form method="post" action="${actionUrl}" id="formEjecFile"
	     commandName="ejecfile" enctype="multipart/form-data">
	<p class="green info-form">Datos del Archivo</p>
	
	
	<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Tipo</label>
        <div class="col-sm-3">
			<select id="tipo" name="tipo" class="form-control" disabled="${desha0}">
				<c:forEach items="${listTiposejecfile}" var="sp">
				        <option value="${sp.value}">${sp.label}</option>
				    </c:forEach>					          
	         </select>		
	         <div class="help-block error"></div>
        </div>      
         <label for="inputType" class="col-sm-1 control-label">Nombre<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="nombre" id="nombre" class="form-control" disabled="${desha0}"/>
        	<div class="help-block error"></div>
        </div>         
	</div>
	    <table id="fileTable">    
	        <tr>
	            <td><input name="file" type="file" class="archivos" ${btnDesha0}/></td>
	             
	        </tr>
	           <tr>
	        <td><b>Extensiones permitidas:</b> JPG | PNG | GIF | PDF | DOC | DOCX</td>
	         </tr>
	    </table>
	    <br/>	<button id="btnSubirArchivo" type="submit" class="btn btn-success" ${btnDesha0}>Subir Archivo</button>
	</form:form>
	<script type="text/javascript">
	$(document).ready(function(){
		 var frm = $('#formEjecFile');
		 $('#btnSubirArchivo').click(function(e){
			 e.preventDefault();
			 var disabled = frm.find(':input:disabled').removeAttr('disabled');
			 frm.submit();
		 });
	});
	</script>	
		
			<br />
		
<table class="table datatable uppertext" id="tblSupervisor">
			<thead>
				<tr>
					<th width="4%"></th>
					<th width="12%">Tipo</th>
					<th width="12%">Nombre</th>
					<th width="12%">Archivo</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listEfiles}" var="sup" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td>
						<c:forEach var="nivel" items="${listTiposejecfile}" varStatus="i">
						<c:if test="${nivel.value == sup.tipo}">
					  		<c:out value="${nivel.label}"/>
					  	</c:if>
						</c:forEach>						
						</td>		
						<td><c:out value="${sup.nombre}" /></td>
						<c:choose>	
							<c:when test="${usuario.codPerfil eq '4'}">				
							<td><a><c:out value="${sup.archivo}" /></a></td>
							</c:when>
							<c:otherwise>
							<td><a href="file:///C:/Desarrollo_App/SISEFA/ejecucion/${sup.archivo}" target="_blank"><c:out value="${sup.archivo}" /></a></td>
							</c:otherwise>
						</c:choose>
						
						<td>
						<nobr>
						<c:choose>	
							<c:when test="${usuario.codPerfil eq '4' || usuario.codPerfil eq '8'}">				
							  	<a class="btn btn-efa-del btn-xs"> <span class="glyphicon glyphicon-remove"></span>Eliminar</a>
							</c:when>
							<c:otherwise>
							  	<a class="btn btn-efa-del btn-xs" onclick="deleteEjecfile(${sup.idejecfile})"> <span class="glyphicon glyphicon-remove"></span>Eliminar</a>
							</c:otherwise>
						</c:choose>
						</nobr>
						</td>
						
						
					</tr>
				</c:forEach>
			</tbody>
</table> 