

function deleteAdm(id) {
	var result = confirm("Desea eliminar el administrado?");
		if (result==true) {
			var form_data = {
			  id: id
			};	
			$.ajax({
			    type:"post",
			    data:form_data,
			    url:prefix +'/administrados/delete/',
			    success: function(json){
					if(json[0].value == "1"){
						 location.reload();
					}else if(json[0].value == "2"){
						alert("El registro tiene información de unidades mineras.");
					}else{
						alert("Intentelo nuevamente.");
					}

			    }
			});	
	}

}

$(document).ready(function() {
	
$("#pn").hide();
$("#pj").hide();
$( "#tipopersona" ).change(function() {
	if($(this).val() == '1'){
		 $("#pn").show();
		 $("#pj").hide();
	}else if($(this).val() == '2'){
		 $("#pn").hide();
		 $("#pj").show();		 		
	}else{
		$("#pn").hide();
		$("#pj").hide();		
	}
});	

$("#tipopersona").trigger("change");	

$("#administradosForm").validate({
    rules: {  
    	tipopersona:{
    		valueNotEquals:'-1',
    	},
    	ruc:{
    		digits:true,
    		exactlenght:11,
    		required:true,
    	},
    	razonsocial:{
    		validName:true,
    		required:true,
    	}, 	
    	tipodoc:{
    		valueNotEquals:'0',
    	},    	
    	numerodoc:{
    		digits:true,
    		required:true,
    	},    	
    	nombres:{
    		validName:true,
    		required:true,
    	}, 	  
    	appaterno:{
    		validName:true,
    		required:true,
    	}, 	    	
    	apmaterno:{
    		validName:true,
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
    	reptipodoc:{
    		valueNotEquals:'-1',
    	},    	
    	repnumdoc:{
    		digits:true,
    		required:true,
    	},   
    	repnombres:{
    		validName:true,
    		required:true,
    	}, 	  
    	repappaterno:{
    		validName:true,
    		required:true,
    	}, 	    	
    	repapmaterno:{
    		validName:true,
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


$("#distrito").change(function() {
	setDes();
});

function setDes() {
	$("#departamentodes").val($('#departamento :selected').text());
	$("#provinciades").val($('#provincia :selected').text());
	$("#distritodes").val($('#distrito :selected').text());
}


});