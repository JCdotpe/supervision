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