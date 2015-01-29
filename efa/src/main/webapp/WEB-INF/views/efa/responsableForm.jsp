<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!--<c:url var="actionUrl" value="/efa/addres" />-->
<c:url var="actionUrl" value="/responsable/addres?id=${efa.id}" />
<form:form id="responsableForm" modelAttribute="responsable" method="POST" 
	action="${actionUrl }" class="form-horizontal upperx" role="form">

	<fieldset>


<p class="green info-form">Datos del Contacto de la EFA </p>

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Tipo<span class="error"> (*)</span></label>
         <div class="col-sm-3">
			<form:select id="tipo" path="tipo" class="form-control">
	           <form:option value="-1" label="--- Seleccionar ---" />
	           <form:options items="${listTipos}" itemValue="value" itemLabel="label"/>
	         </form:select>		
	         <div class="help-block error"></div>
        </div>
        
        <label for="inputType" class="col-sm-1 control-label">Sector Área<span class="error"> (*)</span></label>
         <div class="col-sm-3">
         <form:input path="sector" id="sector" class="form-control"/>
		<!--  	<form:select id="sector" path="sector" class="form-control">
	           <form:option value="-1" label="--- Seleccionar ---" />
	           <form:options items="${listSectores}" itemValue="value" itemLabel="label"/>
	         </form:select>		-->
        	<div class="help-block error"></div>
        </div>
</div>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Apellido Paterno<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="appaterno" id="appaterno" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Apellido Materno<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="apmaterno" id="apmaterno" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Nombre<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="nombre" id="nombre" class="form-control"/>
        	<div class="help-block error"></div>
        </div>                    
</div>        

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Cargo<span class="error"> (*)</span></label>
        <div class="col-sm-7">
        	<form:input path="cargo" id="cargo" class="form-control"/>
        	<div class="help-block error"></div>
        </div>        
        <label for="inputType" readonly class="col-sm-1 control-label">Fecha Designación</label>
        <div class="col-sm-3">
        	<form:input path="fecha" id="fecha" class="form-control datepicker"/>
        	<div class="help-block error"></div>
        </div>                         
</div>    
<p class="green info-form">Ubicación</p>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Domicilio Legal<span class="error"> (*)</span></label>
        <div class="col-sm-7">
        	<form:input path="direccion" id="direccion" class="form-control"/>
        	<div class="help-block error"></div>
        </div>           
         <label for="inputType" class="col-sm-1 control-label">Celular<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="celular" id="celular" class="form-control"/>
        	<div class="help-block error"></div>
        </div>                    
</div>    
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Teléfono<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="telefono" id="telefono" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Correo<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="correo" id="correo" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Fax</label>
        <div class="col-sm-3">
        	<form:input path="fax" id="fax" class="form-control"/>
        	<div class="help-block error"></div>
        </div>                    
</div>       
	<form:input path="idresponsable" type="hidden" />
	<button type="submit" class="btn btn-success">Guardar</button>

	</fieldset>
</form:form>

<p class="error obligatorio" >(*) Campos Obligatorios</p>