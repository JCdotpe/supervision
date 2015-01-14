$(document).ready(function() {

$("#actividadForm").validate({
    rules: {  
		nivel:{
			valueNotEquals:'-1',
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
    	
    	tipo:{
    		valueNotEquals:'-1',
    	}, 	  
    	idefa:{
    		valueNotEquals:'-1',
    		required:true,
    	}, 	
    	
    	fechaini:{
    		required:true,
    	}, 	   	
    	fechafin:{
    		required:true,
    		 greaterThan: "#fechaini", 
    	}, 	   	
    	horaini:{
    		required:true,
    	}, 	   	
    	horafin:{
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


$("#idefa").change(function() {
	consultaefa();
});

$("#distrito").change(function() {
	getEfas();
	$("#idefa").trigger("change");
});

$("#analitica").change(function() {
	if($("#analitica").prop('checked'))
		$(".hideanalitica").show();
	else
		$(".hideanalitica").hide();
});

if($("#idefa").val() != '-1')
	$("#idefa").trigger("change");

$("#analitica").trigger("change");



$('#tblSupx').DataTable({
    "oLanguage": {
    "sProcessing": "Procesando",
    "sLengthMenu": "Mostrar _MENU_ registros por página",
    "sZeroRecords": "No se encontraron registros",
    "sInfo": "Mostrando _START_ - _END_ de _TOTAL_ registros",
    "sInfoEmpty": "Mostrando 0 to 0 of 0 records",
    "sInfoFiltered": "(Filtrado de _MAX_ registros en total)",                 
    "sSearch": "Buscar:", 
    "oPaginate": {
        "sNext": "Siguiente", 
        "sPrevious": "Anterior"
      }               
	}               
});



$("#btnsetsup").click(function() {
	setSupres();
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


function consultaefa() {
			var form_data = {
					id: $("#idefa").val()
			};	
			$.ajax({
			    type:"post",
			    data:form_data,
			    url:prefix +'/efa/gett/',
			    success: function(json){
			    	if(json != null){
						$("#edireccion").val(json.direccion);
						$("#enombre").val(json.nombre);
						$("#ewebi").val(json.webi);
			    	}else{
						$("#edireccion").val();
						$("#enombre").val();
						$("#ewebi").val();			    		
			    	}
			    }
			});	
}


function getEfas() {
	if($("#nivel").val() == '-1')
	{
		alert("seleccione el nivel");
	}else{
		var form_data = {
				coddep: $("#departamento").val(),
				codprov: $("#provincia").val(),
				coddist: $("#distrito").val(),
				nivel: $("#nivel").val()
		};	
		$.ajax({
		    type:"post",
		    data:form_data,
		    url:prefix +'/efa/getby/',
		    success: function(json_data){
		    	sel = $("#idefa");
	            $.each(json_data, function(i, data){
	            	sel.append('<option value="' + data.value + '">' + data.lable + '</option>');	
	            });        
	            if(json_data.length == 0){
	        		alert("No se encontraron EFAS con las opciones seleccionadas.");
	        		sel.empty();
	        		sel.append('<option value="-1">--- SELECCIONAR ---</option>');	
	            }
		    }
		});	
	}
}



function setSupres() {
	var sid = $("input:radio[name ='idsupres']:checked").val();
	if(sid == null || sid =='')
	{
		alert("seleccione un responsable.");
	}else{
		var form_data = {
				idsupres: sid,
				idact: $("#idact").val()
		};	
		$.ajax({
		    type:"post",
		    data:form_data,
		    url:prefix +'/actividad/setsup/',
		    success: function(json){  
		    	if(json.success == "1")
		    		alert("Se asigno el responsable correctamente.");
		    	else
		    		alert("Ocurrió un error, intentelo nuevamente.");
		    }
		});	
	}
}


