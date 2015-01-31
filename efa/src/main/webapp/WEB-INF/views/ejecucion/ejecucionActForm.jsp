<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="/ejeact/addejeact?id=${actId}" />

<form:form id="ejeactForm"  method="post" modelAttribute="eje" accept-charset="UTF-8"
	action="${actionUrl}" class="form-horizontal upperx" role="form">

	<fieldset>
	<!-- 	<legend></legend> -->
<p class="green info-form">Datos Ejecución de la Actividad</p>

<c:set var="vis1" value=""/>
<c:set var="desha1" value="false"/>

<c:set var="vis2" value=""/>
<c:set var="desha2" value="false"/>

<c:if test="${usuario.codPerfil eq '7'}">
	<c:set var="vis1" value="display:none;"/>
	<c:set var="desha1" value="true"/>
</c:if>
<c:if test="${usuario.codPerfil eq '8' }">
	<c:set var="vis2" value="display:none;"/>
	<c:set var="desha2" value="true"/>
</c:if>

<div class="form-group" style="${vis2}">
        <label for="inputType" class="col-sm-1 control-label">Fecha de Ejecución Supervisión<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input name = "fechaejec" path="fechaejec" class="form-control datepicker" disabled="${desha2}" />
        	<div class="help-block error"></div>
        </div>       
        <div class="col-sm-2">
        <label for="inputType" class="control-label">Amerita Supervision Especial</label>
        	<form:checkbox name="supespecial" value="true" path="supespecial" id="supespecial" class="form-control"  disabled="${desha2}"/>
        	<div class="help-block error"></div>
        </div> 
        <div class="col-sm-2">
        <label for="inputType" class="control-label">Presenta Hallázgos Críticos</label>
        	<form:checkbox name="hallazgos" value="true" path="hallazgos" id="hallazgos" class="form-control" disabled="${desha2}" />
        	<div class="help-block error"></div>
         </div> 	
</div>

<div class="form-group" style="${vis1}">
        <label for="inputType" class="col-sm-1 control-label">Fecha<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input name = "fecha" path="fecha" class="form-control datepicker" disabled="${deshabilitado}"/>
        	<div class="help-block error"></div>
        </div>    
        <label for="inputType" class="col-sm-1 control-label">Estado<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:select id="estado" path="estado"  class="form-control" disabled="${deshabilitado}">	
				<form:option value="-1" label="--- Seleccionar ---" />
				 <form:options items="${listUMestado}" itemValue="value" itemLabel="label"/>
	         </form:select>	   
        	<div class="help-block error"></div>
        </div>    
        
        <label for="inputType" class="col-sm-1 control-label">Observación<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="observacion" id="observacion" class="form-control" disabled="${deshabilitado}"/>
        	<div class="help-block error"></div>
        </div>          
</div>
	<form:input path="idejecucion" type="hidden" />
	<button type="submit" class="btn btn-success">Guardar</button>

	</fieldset>
</form:form>
<p class="error obligatorio" >(*) Campos Obligatorios</p>