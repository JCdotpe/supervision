$(document).ready(function() {

	$.validator.addClassRules('archivos', {
		  required: true,
		  extension: "pdf|jpg|jpeg|gif|png|jpg|doc|docx"
		});
	
	$("#formEjecFile").validate({
	    rules: {  
	    	
	    },

	    messages: {   
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
	    	form.submit();
	    }       
	}); 



});


function deleteEjecfile(id) {
	var result = confirm("Desea eliminar el registro?");
		if (result==true) {
			var form_data = {
			  id: id
			};	
			$.ajax({
			    type:"post",
			    data:form_data,
			    url:prefix +'/ejecarchivo/delete/',
			    success: function(json){
					if(json[0].value == "1")
						 location.reload();
					else
						alert("Por favor intentelo nuevamente");
			    }
			});	
	}

}