<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="/supervisor/save" />

<form:form id="supervisorForm" commandName="supervisor" method="post" accept-charset="UTF-8"
	action="${actionUrl }" class="form-horizontal upperx" role="form">

	<fieldset>
	<!-- 	<legend></legend> -->

<p class="green info-form">Datos Personales</p>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">DNI<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input maxlength="8" name="dni" path="dni" class="form-control" />
        	<div class="help-block error"></div>
        </div> 
        <button type="button" id="consultadni" class="btn btn-success">Consultar</button>
</div>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Apellido Paterno<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input name = "appPaterno" path="appPaterno" class="form-control" />
        	<div class="help-block error"></div>
        </div> 
        <label for="inputType" class="col-sm-1 control-label">Apellido Materno<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input name = "appMaterno" path="appMaterno" class="form-control" />
        	<div class="help-block error"></div>
        </div>     
        <label for="inputType" class="col-sm-1 control-label">Nombre<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input name = "nombre" path="nombre" class="form-control" />
        	<div class="help-block error"></div>
        </div>              
</div>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Sexo<span class="error"> (*)</span></label>
        <div class="col-sm-3">
		<form:select id="sexo" path="sexo"  class="form-control">
           <form:option value="-1" label="--- Seleccionar ---"  />
           <form:options items="${listSexo}" itemValue="value" itemLabel="label"/>
         </form:select>        	
        	<div class="help-block error"></div>
        </div> 
        <label for="inputType" class="col-sm-1 control-label">Fecha de Nacimiento<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input name = "fechaNac" path="fechaNac" class="form-control datepicker" />
        	<div class="help-block error"></div>
        </div>     
        <label for="inputType" class="col-sm-1 control-label">Teléfono<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input name = "telefono" path="telefono" class="form-control" />
        	<div class="help-block error"></div>
        </div>              
</div>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Dirección<span class="error"> (*)</span></label>
        <div class="col-sm-11">
        	<form:input path="direccion" class="form-control"/>
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
        <label for="inputType" class="col-sm-1 control-label">Estado Civil<span class="error"> (*)</span></label>
        <div class="col-sm-3">
			<form:select id="estadoCivil" path="estadoCivil" class="form-control">
	           <form:option value="-1" label="--- Seleccionar ---" />
	           <form:options items="${listEstadoCivil}" itemValue="value" itemLabel="label"/>
	         </form:select>		
        	<div class="help-block error"></div>
        </div> 
        <label for="inputType" class="col-sm-1 control-label">Profesión<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input name = "profesion" path="profesion" class="form-control" />
        	<div class="help-block error"></div>
        </div>     
        <label for="inputType" class="col-sm-1 control-label">Correo Personal</label>
        <div class="col-sm-3">
        	<form:input name = "correo" path="correo" class="form-control" />
        	<div class="help-block error"></div>
        </div>              
</div>

<p class="green info-form">Datos Laborales</p>


<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Inicio</label>
        <div class="col-sm-3">
        	<form:input name="iniLaboral" path="iniLaboral" class="form-control datepicker" id="fechaInicioDate" readonly="true"/>
        	<div class="help-block error"></div>
        </div> 
        <label for="inputType" class="col-sm-1 control-label">Fin</label>
        <div class="col-sm-3">
        	<form:input name="finLaboral" path="finLaboral" class="form-control datepicker" id="fechaFinDate" readonly="true"/>
        	<div class="help-block error"></div>
        </div>                
</div>

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Modalidad de Contrato<span class="error"> (*)</span></label>
        <div class="col-sm-3">
			<form:select id="modalidad" path="modalidad" class="form-control">
	           <form:option value="-1" label="--- Seleccionar ---" />
	           <form:options items="${listMcontrato}" itemValue="value" itemLabel="label"/>
	         </form:select>	        	
        	<div class="help-block error"></div>
        </div> 
        <label for="inputType" class="col-sm-1 control-label">Nro Contrato</label>
        <div class="col-sm-3">
        	<form:input name = "nroContrato" path="nroContrato" class="form-control" />
        	<div class="help-block error"></div>
        </div>     
        <label for="inputType" class="col-sm-1 control-label">Remuneración</label>
        <div class="col-sm-3">
        	<form:input name = "remuneracion" path="remuneracion" class="form-control" />
        	<div class="help-block error"></div>
        </div>              
</div>

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Cargo</label>
        <div class="col-sm-7">
        	<form:input name = "cargo" path="cargo" class="form-control" />
        	<div class="help-block error"></div>
        </div> 
        <label for="inputType" class="col-sm-1 control-label">Correo Institucional<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input name = "correoIns" path="correoIns" class="form-control" />
        	<div class="help-block error"></div>
        </div>                
</div>

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Cuenta Banco de la Nación</label>
        <div class="col-sm-3">
			<form:input name = "cuentaBco" path="cuentaBco" class="form-control" />
        	<div class="help-block error"></div>
        </div> 
        <label for="inputType" class="col-sm-1 control-label">Otro Banco</label>
        <div class="col-sm-3">
			<form:select id="otroBco" path="otroBco" class="form-control">
	           <form:option value="0" label="--- Seleccionar ---" />
	           <form:options items="${listBanco}" itemValue="value" itemLabel="label"/>
	         </form:select>	               	
        	<div class="help-block error"></div>
        </div>     
        <label for="inputType" class="col-sm-1 control-label">Nro Cuenta Otro Banco</label>
        <div class="col-sm-3">
        	<form:input name = "otroBcoNro" path="otroBcoNro" class="form-control" />
        	<div class="help-block error"></div>
        </div>              
</div>

	<form:input path="id" type="hidden" />
		<c:if test="${not empty edit}">	
		<button type="submit" class="btn btn-success">Guardar</button>
		</c:if>			
		<c:if test="${empty edit}">	
		<button type="submit" class="btn btn-success">Agregar</button>
		</c:if>		

	</fieldset>
</form:form>
<p class="error obligatorio" >(*) Campos Obligatorios</p>