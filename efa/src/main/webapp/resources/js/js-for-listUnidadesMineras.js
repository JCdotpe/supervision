function deleteUM(id) {
		var result = confirm("Desea eliminar la Unidad Minera?");
			if (result==true) {
				var form_data = {
				  id: id
				};	
				$.ajax({
				    type:"post",
				    data:form_data,
				    url:prefix +'/uminera/deleteum/',
				    success: function(json){
						if(json[0].value == "1"){
							 location.reload();
						}else{
							alert("Intentelo nuevamente.");
						}

				    }
				});	
		}

}	
$(document).ready(function() {
	$("#divdm").hide();
	$( "#sector" ).change(function() {
		if($(this).val() == '2'){
			$("#divdm").show(); 		
		}else{
			$("#divdm").hide();		
		}
	});	
	

	$("#unidadesmForm").validate({
	    rules: {  
	    	sector:{
	    		valueNotEquals:'-1',
	    	},
	    	actividad:{
	    		valueNotEquals:'-1',
	    	},
	
	    	tipodm:{
	    		valueNotEquals:'-1',
	    	}, 	
	    	nombredm:{
	    		validName:true,
	    		required:true,
	    		minlength: 3
	    	},    	
	    	codinacc:{
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
	    	cuenca:{
	    		valueNotEquals:'-1',
	    	}, 		    	
	    	direccion:{
	    		required:true,
	    		minlength: 6
	    	}, 	    	
	    	estado:{
	    		valueNotEquals:'-1',
	    	},    	

	    	norte:{
	    		required:true,
	    		minlength: 3
	    	}, 	  
	    	este:{
	    		required:true,
	    		minlength: 3
	    	},    	
	    	zona:{
	    		valueNotEquals:'-1',
	    	},   
	    	direccionunidad:{
	    		required:true,
	    		minlength: 3
	    	}, 	  
	    	nombreunidad:{
	    		validName:true,
	    		required:true,
	    		minlength: 3
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
	    	alert("Datos guardados");
	    	$("#unidadesmForm").ajaxSubmit();
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