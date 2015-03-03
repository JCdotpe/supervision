<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="/ejeact/addejeact?id=${actId}" />

<form:form id="ejeactForm"  method="post" modelAttribute="eje" accept-charset="UTF-8"
	action="${actionUrl}" class="form-horizontal upperx" role="form">

	<fieldset>
	<!-- 	<legend></legend> -->
<p class="green info-form">Datos Ejecución de la Actividad</p>

<c:set var="desha1" value="false"/>
<c:set var="desha2" value="false"/>
<c:set var="desha3" value=""/>

<c:if test="${usuario.codPerfil eq '7'}">
	<c:set var="desha1" value="true"/>
</c:if>
<c:if test="${usuario.codPerfil eq '8' }">
	<c:set var="desha2" value="true"/>
</c:if>
<c:if test="${usuario.codPerfil eq '4'}">
	<c:set var="desha1" value="true"/>
	<c:set var="desha2" value="true"/>
	<c:set var="desha3" value="disabled='true'"/>
</c:if>

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Fecha de Ejecución Supervisión<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input name = "fechaejec" path="fechaejec" class="form-control datepicker" disabled="${desha2}" readonly="true"/>
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

<div class="form-group">
        <label for="inputType" class="col-sm-1 control-label">Fecha<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input name = "fecha" path="fecha" class="form-control datepicker" disabled="${desha1}" readonly="true"/>
        	<div class="help-block error"></div>
        </div>    
        <label for="inputType" class="col-sm-1 control-label">Estado<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:select id="estado" name="estado" path="estado" class="form-control" disabled="${desha1}">	
				<form:option value="-1" label="--- Seleccionar ---" />
				 <form:options items="${listUMestado}" itemValue="value" itemLabel="label"/>
	         </form:select>	   
        	<div class="help-block error"></div>
        </div>
        <label for="inputType" class="col-sm-1 control-label">Observación<span class="error"> (*)</span></label>
        <div class="col-sm-3">
        	<form:input maxlenght="255" path="observacion" id="observacion" class="form-control" disabled="${desha1}"/>
        	<div class="help-block error"></div>
        </div>          
</div>
	<form:input path="idejecucion" type="hidden" />
	<button type="submit" id="btnGuardar" class="btn btn-success" ${desha3}>Guardar</button>

	</fieldset>
</form:form>
<p class="error obligatorio" >(*) Campos Obligatorios</p>
<script type="text/javascript">
$(document).ready(function(){
	if($("#estado").val() === '3'){
		$("#ejeactForm :input, #formEjecFile :input").attr('disabled', true);
 		$("#tblSupervisor a.btn-efa-del").removeAttr('onclick','').attr('href','javascript:;');

	}
	
	$("#ejeactForm").validate({
	    rules: {  
	    	fechaejec:{
	    		required:true,
	    	},	
	    	fecha:{
	    		required:true,
	    	},		
	    	observacion:{
	    		required:true,
	    	},		    	
	    	estado:{
	    		valueNotEquals:'-1',
	    	},  	    	
	  	
	    },

	    messages: {   
		//FIN MESSAGES
	    },
	    errorPlacement: function(error, element) {
	        $(element).next().after(error);
	    },
	    invalidHandler: function(form, validator) {
	      var errors = validator.numberOfInvalids();
	      if (errors) {
	        var message = errors == 1
	          ? 'Por favor corrige estos errores:\n'
	          : 'Por favor corrige los ' + errors + ' errores.\n';
	        var errors = "";
	        if (validator.errorList.length > 0) {
	            for (x=0;x<validator.errorList.length;x++) {
	                errors += "\n\u25CF " + validator.errorList[x].message;
	            }
	        }
	        alert(message + errors);
	      }
	      validator.focusInvalid();
	    },
	    submitHandler: function(form) {
	    	alert("Datos Guardados");
	    	var frmef = $('#ejeactForm');
	    	var disabled = frmef.find(':input:disabled').removeAttr('disabled');
	    	$("#ejeactForm").ajaxSubmit();
	    }  	
	});
	
//  	$('#btnGuardar').click(function(e){
//  		debugger;
//  		var form_data = {
//  				  id: ${actId}
//  				};
//  		$.ajax({
// 		    type:"post",
// 		    data:form_data,
// 		    url:prefix +'/ejeact/updejeact/',
// 		    success: function(json){
// 				if(json[0].value == "1"){
// 					alert("Se cerro la actividad satisfactoriamente");
// 				}
// 		    }
// 		});	
 		
 		
// 		e.preventDefault();
// 		var frmef = $('#ejeactForm');
// 		var disabled = frmef.find(':input:disabled').removeAttr('disabled');
// 		frmef.submit();
//	});
	
	
});
</script>