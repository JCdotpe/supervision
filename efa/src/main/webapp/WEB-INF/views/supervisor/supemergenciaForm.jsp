<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="/supemergencia/save?id=${sup.id}" />


<form:form id="supemForm" commandName="supem" method="post" accept-charset="UTF-8"
	action="${actionUrl }" class="form-horizontal upperx" role="form">
	<p class="green info-form">Datos del Contacto de Emergencia</p>
<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Nombre<span class="error"> (*)</span></label>
        <div class="col-sm-4">
        	<form:input maxlength="250" name = "nombre" path="nombre" class="form-control" />
        	<div class="help-block error"></div>
        </div> 
        <label for="inputType" class="col-sm-1 control-label">Teléfono<span class="error"> (*)</span></label>
        <div class="col-sm-2">
        	<form:input maxlength="25" name = "telefono" path="telefono" class="form-control" />
        	<div class="help-block error"></div>
        </div>     
        <label for="inputType" class="col-sm-1 control-label">Parentesco<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input maxlength="250" name = "parentesco" path="parentesco" class="form-control" />
        	<div class="help-block error"></div>
        </div>     
        	<form:input path="id" type="hidden" />

</div>
<button type="submit" class="btn btn-success">Guardar</button>
	</form:form>
		<p class="error obligatorio" >(*) Campos Obligatorios</p>
		
  