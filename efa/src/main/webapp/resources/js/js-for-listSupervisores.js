
function resetDialog(form) {

	form.find("input").val("");
}


$(document).ready(function() {
	

$("#supervisorForm").validate({
    rules: {  
		dni:{
    		digits:true,
    		minlength: 8,
    		required:true
    	},
    	appPaterno:{
    		validName:true,
    		minlength: 2,
    		required:true
    	},
    	appMaterno:{
    		validName:true,
    		minlength: 2,
    		required:true
    	}, 	
    	nombre:{
    		validName:true,
    		minlength: 2,
    		required:true
    	}, 	    	
    	sexo:{
    		required:true
    	}, 	  
    	fechaNac:{
    		required:true
    	}, 	
    	telefono:{
    		digits:true,
    		minlength: 6,
    		required:true
    	}, 	  
    	direccion:{
    		minlength: 5,
    		required:true
    	}, 	    	
    
    	departamento:{
    		valueNotEquals:'-1'
    	},    	
    	provincia:{
    		valueNotEquals:'-1'
    	},      
    	distrito:{
    		valueNotEquals:'-1'
    	}, 
    	
    	estadoCivil:{
    		valueNotEquals:'-1'
    	}, 	  
    	profesion:{
    		minlength: 2,
    		required:true
    	}, 	
    	correo:{
    		email:true
    	}, 	
    	modalidad:{
    		valueNotEquals:'-1'
    	}, 	   	
    	remuneracion:{
    		digits:true
    	}, 	   	
    	cargo:{
    		valueNotEquals:'-1'
    	}, 	    	
    	correoIns:{
    		email:true,
    		minlength: 3,
    		required:true
    	}, 	   	
    	cuentaBco:{
    		maxlength: 50
    	}, 		   	
    	otroBcoNro:{
    		maxlength: 50
    	} 	    	
  	
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
    	i_enable("#appPaterno");
    	i_enable("#appMaterno");
    	i_enable("#nombre");
    	i_enable("#sexo");    	
    	alert("Datos Guardados");
    	$("#supervisorForm").ajaxSubmit();
    }       
}); 


$( "#consultadni" ).click(function() {
	consultadni();
});



});

function deleteSup(id) {
	var result = confirm("Desea eliminar el registro?");
		if (result==true) {
			var form_data = {
			  id: id
			};	
			$.ajax({
			    type:"post",
			    data:form_data,
			    url:prefix +'/supervisor/delete/',
			    success: function(json){
					if(json[0].value == "1")
						 location.reload();
					else
						alert("El registro tiene información de contactos o archivos.");
			    }
			});	
	}

}


function consultadni() {
	$("#consultadni").disable(true);
			var form_data = {
					dni: $("#dni").val()
			};	
			$.ajax({
			    type:"post",
			    data:form_data,
			    url:prefix +'/supervisor/getdni/',
			    success: function(json){
					if(json.RESULTADO == 1){
						$("#appPaterno").val(json.APEPAT);
						i_dis("#appPaterno");
						$("#appMaterno").val(json.APEMAT);
						i_dis("#appMaterno");
						$("#nombre").val(json.NOMBRE);
						i_dis("#nombre");
						$("#sexo").val(json.CODSEX);
						i_dis("#sexo");
						
						var fJson = json.FECNAC;
						var fechaNac = [];
						fechaNac['yyyy'] = fJson.substring(0,4);
						fechaNac['mm'] = fJson.substring(4,6);
						fechaNac['dd'] = fJson.substring(6,8);
						$("#fechaNac").val(fechaNac['dd']+'/'+fechaNac['mm']+'/'+fechaNac['yyyy']);
						//i_dis("#fechaNac");
						
						$("#departamento").val(json.CODDEP).trigger('change');
						//i_dis("#departamento");
						var setProv = setInterval(function(){
							if ( $("#provincia > option").length >1 ){
								$("#provincia").val(json.CODPRO).trigger('change');
								clearInterval(setProv);
							}
							console.log('running');
						},1000);
						//i_dis("#provincia");
						var setDist = setInterval(function(){
							if ( $("#distrito > option").length >1 ){
								$("#distrito").val(json.CODDIS);
								clearInterval(setDist);
							}
							console.log('running dist');
						},1500);						
						//i_dis("#distrito");							
					}else{
						i_en("#appPaterno");
						i_en("#appMaterno");
						i_en("#nombre");
						i_en("#sexo");
						i_en("#fechaNac");
						alert("No se encontraron datos.");
					}
					$("#consultadni").disable(false);
			    }
			});	
}




