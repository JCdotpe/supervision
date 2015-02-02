

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
    		digits:true,
    		required:true,
    	}, 	  
    	fax:{
    		digits:true,
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
    	form.submit();
    }       
}); 


$("#responsableForm").validate({
    rules: {  
		tipo:{
			valueNotEquals:'-1',
		}, 
		sector:{
    		validName:true,
    		required:true,
    	},		
		appaterno:{
			minlength:2,
    		validName:true,
    		required:true,
    	},
    	apmaterno:{
    		minlength:2,
    		validName:true,
    		required:true,
    	},
    	nombre:{
    		minlength:2,
    		validName:true,
    		required:true,
    	}, 	
    	cargo:{
    		required:true,
    	}, 	    	
    	direccion:{
    		
    		required:true,
    	}, 	  
    	telefono:{
    		digits:true,
    		required:true,
    	}, 	  
    	correo:{
    		required:true,
    		email:true,
    	}, 	    	
    	fax:{
    		digits:true,
//    		required:true,
    	}, 	
    	celular:{
    		digits:true,
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
    	form.submit();
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

