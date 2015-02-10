<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="/uminera/addum?id=${adm.idadministrados}" />

<form:form id="unidadesmForm"  method="post" commandName="unidadM" accept-charset="UTF-8"
	action="${actionUrl}" class="form-horizontal upperx" role="form">

	<fieldset>
	<!-- 	<legend></legend> -->
<p class="green info-form">Unidad Operativa</p>

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Sector<span class="error"> (*)</span></label>
        <div class="col-sm-3">
		<form:select id="sector" path="sector"  class="form-control">
           <form:option value="-1" label="--- Seleccionar ---"  />
           <form:options items="${listSector}" itemValue="value" itemLabel="label"/>
         </form:select>
          <div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Actividad<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:select id="actividad" path="actividad"  class="form-control">	
				<form:option value="-1" label="--- Seleccionar ---" />
				<form:options items="${listUMAct}" itemValue="value" itemLabel="label"/>
	         </form:select>	        	
        	<div class="help-block error"></div>	
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Categoría<span class="error"></span></label>
        <div class="col-sm-3">
        	<form:select id="categoria" path="categoria"  class="form-control">	
				<form:option value="-1" label="--- Seleccionar ---" />
				<form:options items="${listUMCat}" itemValue="value" itemLabel="label"/>
	         </form:select>	     	
        	<div class="help-block error"></div>	
        </div>                    
</div>  
<div class="form-group" id="divdm">

        <label for="inputType" class="col-sm-1 control-label">Tipo Derecho Minero<span class="error"> (*)</span></label>
        <div class="col-sm-3">
		<form:select id="tipodm" path="tipodm"  class="form-control">
           <form:option value="-1" label="--- Seleccionar ---"  />
           <form:options items="${listTiposDerechoM}" itemValue="value" itemLabel="label"/>
         </form:select>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Nombre Derecho Minero<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input  maxlength="255" path="nombredm" id="nombredm" class="form-control"/>
        	<div class="help-block error"></div>
        </div>      
        <label for="inputType" class="col-sm-1 control-label">Código INACC - INGEMMET<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input  maxlength="100" path="codinacc" id="codinacc" class="form-control"/>
        	<div class="help-block error"></div>
        </div>          
</div>  
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
        <label for="inputType" class="col-sm-1 control-label">Cuenca<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:select id="cuenca" path="cuenca"  class="form-control">	
				<form:option value="-1" label="--- Seleccionar ---" />
				 <form:options items="${listUMcuenca}" itemValue="value" itemLabel="label"/>
	         </form:select>	   
        	<div class="help-block error"></div>
        </div>      
        <label for="inputType" class="col-sm-1 control-label">Dirección<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="direccion"  maxlength="255" id="direccion" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Estado<span class="error"> (*)</span></label>
        <div class="col-sm-3">
		<form:select id="estado" path="estado"  class="form-control">
           <form:option value="-1" label="--- Seleccionar ---"  />
           <form:options items="${listUMestado}" itemValue="value" itemLabel="label"/>
         </form:select>
        	<div class="help-block error"></div>
        </div>   
              
</div>  
<p class="green info-form">Coordenadas(UTM wgs84)</p>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Norte<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="norte"  maxlength="255" id="norte" class="form-control"/>
        	<div class="help-block error"></div>
        </div>      
        <label for="inputType" class="col-sm-1 control-label">Este<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="este"  maxlength="255" id="este" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Zona Geográfica<span class="error"> (*)</span></label>
        <div class="col-sm-3">
		<form:select id="zona" path="zona"  class="form-control">
           <form:option value="-1" label="--- Seleccionar ---"  />
           <form:options items="${listZonaGeografica}" itemValue="value" itemLabel="label"/>
         </form:select>
        	<div class="help-block error"></div>
        </div>   
              
</div>  
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Dirección Unidad<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="direccionunidad"  maxlength="255" id="direccionunidad" class="form-control"/>
        	<div class="help-block error"></div>
        </div>      
        <label for="inputType" class="col-sm-1 control-label">Nombre Unidad<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="nombreunidad"  maxlength="255" id="nombreunidad" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
</div>  
	<form:input path="idunidadminera" type="hidden" />
		<c:if test="${not empty edit}">	
		<button type="submit" class="btn btn-success">Guardar</button>
		</c:if>			
		<c:if test="${empty edit}">	
		<button type="submit" class="btn btn-success">Guardar</button>
		</c:if>			

	</fieldset>
</form:form>
<p class="error obligatorio" >(*) Campos Obligatorios</p>