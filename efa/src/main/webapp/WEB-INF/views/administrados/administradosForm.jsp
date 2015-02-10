<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="/administrados/save" />

<form:form id="administradosForm"  method="post" commandName="administrado" accept-charset="UTF-8"
	action="${actionUrl }" class="form-horizontal upperx" role="form">

	<fieldset>
	<!-- 	<legend></legend> -->
<p class="green info-form">Datos Administrado</p>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Tipo Persona<span class="error"> (*)</span></label>
        <div class="col-sm-3">
		<form:select id="tipopersona" path="tipopersona"  class="form-control">
           <form:option value="-1" label="--- Seleccionar ---"  />
            <form:options items="${listTipoPersona}" itemValue="value" itemLabel="label"/>
         </form:select>       	
        	<div class="help-block error"></div>
        </div>          
</div>

<div class="form-group" id="pj">
<p class="green info-form">Persona Jurídica</p>
        <label for="inputType" class="col-sm-1 control-label">RUC<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="ruc" id="ruc" maxlength="11" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Razón Social<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="razonsocial" maxlength="255" id="razonsocial" class="form-control"/>
        	<div class="help-block error"></div>
        </div>       
</div>


<div id="pn">
<div class="form-group" >
<p class="green info-form">Persona Natural</p>
        <label for="inputType" class="col-sm-1 control-label">Tipo Documento<span class="error"> (*)</span></label>
        <div class="col-sm-3">
		<form:select id="tipodoc" path="tipodoc"  class="form-control">
           <form:option value="0" label="--- Seleccionar ---"  />
            <form:options items="${listTipoDoc}" itemValue="value" itemLabel="label"/>
         </form:select>    
         </div>       
        <label for="inputType" class="col-sm-1 control-label">Número Documento<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="numerodoc" maxlength="40" id="numerodoc" class="form-control"/>
        	<div class="help-block error"></div>
        </div>       
</div>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Nombre<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="nombres" maxlength="255" id="nombres" class="form-control"/>
        	<div class="help-block error"></div>
        </div>      
        <label for="inputType" class="col-sm-1 control-label">Apellido Paterno<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="appaterno" maxlength="255" id="appaterno" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Apellido Materno<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="apmaterno" maxlength="255" id="apmaterno" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
 </div>                 
</div>     

<p class="green info-form">Ubicación</p>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Departamento<span class="error"> (*)</span></label>
        <div class="col-sm-3">
		<form:select id="departamento" path="departamento"  class="form-control">
           <form:option value="-1" label="--- Seleccionar ---"  />
           <form:options items="${listDep}" itemValue="value" itemLabel="label"/>
         </form:select>
         <form:input path="departamentodes" id="departamentodes" name="departamentodes" type="hidden" />
          <div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Provincia<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:select id="provincia" path="provincia"  class="form-control">	
				<form:option value="-1" label="--- Seleccionar ---" />
				 <form:options items="${listProv}" itemValue="value" itemLabel="label"/>
	         </form:select>	        	
	         <form:input path="provinciades" id="provinciades" name="provinciades" type="hidden" /> 	
        	<div class="help-block error"></div>	
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Distrito<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:select id="distrito" path="distrito"  class="form-control">	
				<form:option value="-1" label="--- Seleccionar ---" />
				 <form:options items="${listDis}" itemValue="value" itemLabel="label"/>
	         </form:select>	    
	         <form:input path="distritodes" id="distritodes" name="distritodes" type="hidden" /> 	       	
        	<div class="help-block error"></div>	
        </div>                    
</div>  

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Dirección<span class="error"> (*)</span></label>
        <div class="col-sm-11">
        	<form:input path="direccion" maxlength="255" id="direccion" class="form-control"/>
        	<div class="help-block error"></div>
        </div>                  
</div>    

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Teléfono<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="telefono" maxlength="25" id="telefono" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
</div>  

<p class="green info-form">Representante Legal</p>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Tipo de Documento<span class="error"> (*)</span></label>
        <div class="col-sm-3">
		<form:select id="reptipodoc" path="reptipodoc"  class="form-control">
           <form:option value="-1" label="--- Seleccionar ---"  />
            <form:options items="${listTipoDoc}" itemValue="value" itemLabel="label"/>
         </form:select>    
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Número de Documento<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="repnumdoc" maxlength="12" id="repnumdoc" class="form-control"/>
        	<div class="help-block error"></div>
        </div>       
</div>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Nombre<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="repnombres" maxlength="255" id="repnombres" class="form-control"/>
        	<div class="help-block error"></div>
        </div>      
        <label for="inputType" class="col-sm-1 control-label">Apellido Paterno<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="repappaterno" maxlength="255" id="repappaterno" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Apellido Materno<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="repapmaterno" maxlength="255" id="repapmaterno" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
              
</div>  
	<form:input path="idadministrados" type="hidden" />
		<c:if test="${not empty edit}">	
		<button type="submit" class="btn btn-success">Guardar</button>
		</c:if>			
		<c:if test="${empty edit}">	
		<button type="submit" class="btn btn-success">Guardar</button>
		</c:if>			
	</fieldset>
</form:form>
<p class="error obligatorio" >(*) Campos Obligatorios</p>