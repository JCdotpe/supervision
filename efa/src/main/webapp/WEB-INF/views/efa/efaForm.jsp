<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="/efa/save" />

<form:form id="efaForm" commandName="efa" method="post" accept-charset="UTF-8"
	action="${actionUrl }" class="form-horizontal upperx" role="form">

	<fieldset>
	<!-- 	<legend></legend> -->


<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Nombre de la EFA<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input maxlength="255" name = "customerId" path="nombre" class="form-control" />
        	<div class="help-block error"></div>
        </div>
        <label for="inputType" class="col-sm-1 control-label">Nivel de Gobierno<span class="error"> (*)</span></label>
        <div class="col-sm-3">
			<form:select id="nivel" path="nivel" class="form-control">
	           <form:option value="-1" label="--- Seleccionar ---" />
	           <form:options items="${listNivel}" itemValue="value" itemLabel="label"/>
	         </form:select>		
	         <div class="help-block error"></div>
        </div>      
         
</div>
<p class="green info-form">Datos del Titular de la EFA</p>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Apellido Paterno<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input maxlength="255" path="tapp" id="tapp" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Apellido Materno<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="tapm" maxlength="255" id="tapm" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Nombre<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="tnombre" maxlength="255" id="tnombre" class="form-control"/>
        	<div class="help-block error"></div>
        </div>                    
</div>        

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Cargo<span class="error"> (*)</span></label>
        <div class="col-sm-7">
        	<form:input path="tcargo" maxlength="255" id="tcargo" class="form-control"/>
        	<div class="help-block error"></div>
        </div>                  
</div>    

<p class="green info-form">Ubicación de la EFA</p>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Domicilio Legal<span class="error"> (*)</span></label>
        <div class="col-sm-11">
        	<form:input path="direccion" maxlength="255" id="direccion" class="form-control"/>
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
          <div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Provincia<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:select id="provincia" path="provincia"  class="form-control">	
				<form:option value="-1" label="--- Seleccionar ---" />
				 <form:options items="${listProv}" itemValue="value" itemLabel="label"/>
	         </form:select>	        	
        	<div class="help-block error"></div>	
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Distrito<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:select id="distrito" path="distrito"  class="form-control">	
				<form:option value="-1" label="--- Seleccionar ---" />
				 <form:options items="${listDis}" itemValue="value" itemLabel="label"/>
	         </form:select>	           	
        	<div class="help-block error"></div>	
        </div>                    
</div>  

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Teléfono<span class="error"> (*)</span></label>
        <div class="col-sm-3">
			<form:input path="telefono" maxlength="255" id="telefono" class="form-control"/>
			<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Fax</label>
        <div class="col-sm-3">
        	<form:input path="fax" maxlength="255" id="fax" class="form-control"/>
        	<div class="help-block error"></div>
        </div>   
        <label for="inputType" class="col-sm-1 control-label">Correo<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="correo" maxlength="255" id="correo" class="form-control"/>
        	<div class="help-block error"></div>
        </div>                    
</div>  

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Web Institucional</label>
        <div class="col-sm-7">
        	<form:input path="webi" maxlength="255" class="form-control"/>
        </div>   
         <label for="inputType" class="col-sm-1 control-label">Celular<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input path="celular" maxlength="255" id="celular" class="form-control"/>
        	<div class="help-block error"></div>
        </div>                          
</div>  

	<form:input path="id" type="hidden" />
	<button type="submit" class="btn btn-success">Agregar</button>

	</fieldset>
</form:form>

<p class="error obligatorio" >(*) Campos Obligatorios</p>