

//function editEfa(id) {
//
//	$.get("get/" + id, function(result) {
//
//		$("#bookDialog").html(result);
//
//		$('#bookDialog').dialog("option", "title", 'Edit Book');
//
//		$("#bookDialog").dialog('open');
//
//		initializeDatePicker();
//	});
//}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}



$(document).ready(function() {

$("#efaForm").validate({
    rules: {  
    	nombre:{
    		required:true,
    	},
    	nivel:{
    		valueNotEquals:'-1',
    	},
    	tapp:{
    		validName:true,
    		required:true,
    	}, 	
    	tapm:{
    		validName:true,
    		required:true,
    	}, 	    	
    	tnombre:{
    		validName:true,
    		required:true,
    	}, 	  
    	tcargo:{
    		required:true,
    	}, 	
    	direccion:{
    		required:true,
    	}, 	    	
    	departamento:{
    		valueNotEquals:'-1',
    	},    	
    	provincia:{
    		valueNotEquals:'-1',
    	},      
    	distrito:{
    		valueNotEquals:'-1',
    	}, 
    	telefono:{
    		required:true,
    	}, 	  
    	fax:{
    		//required:true,
    	}, 	
    	correo:{
    		required:true,
    		email:true,
    	}, 	   
    	celular:{
    		required:true,
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
    	$("#efaForm").ajaxSubmit();
    }       
}); 


$("#responsableForm").validate({
    rules: {  
		tipo:{
			valueNotEquals:'-1',
		}, 
		sector:{
    		required:true,
			validName:true,
    	},		
		appaterno:{
    		required:true,
			validName:true,
			lettersonly:true,
    	},
    	apmaterno:{
    		required:true,
    		validName:true,
    		lettersonly:true,
    	},
    	nombre:{
    		required:true,
    		validName:true,    		
    		lettersonly:true,    		
    	}, 	
    	cargo:{
    		required:true,
    	}, 	    	
    	direccion:{
    		required:true,
    	}, 	  
    	telefono:{
    		required:true,
    		required:true,
    		digits:true,
    	}, 	  
    	correo:{
    		required:true,
    		email:true,
    	}, 	    	
    	fax:{
//    		required:true,
    		digits:true,
    	}, 	
    	celular:{
    		required:true,
    		digits:true,
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
    	$("#responsableForm").ajaxSubmit();
    }       
}); 


});

function deleteEfa(id) {
	var result = confirm("Desea eliminar el registro?");
		if (result==true) {
			var form_data = {
			  id: id
			};	
			$.ajax({
			    type:"post",
			    data:form_data,
			    url:prefix +'/efa/pdelete/',
			    success: function(json){
					if(json[0].value == "1")
						 location.reload();
					else
						alert("El registro tiene información de contactos.");
			    }
			});	
	}

}

