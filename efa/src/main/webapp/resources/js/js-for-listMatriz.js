$(document).ready(function() {
	var idmatrizactividad ; 
	var idfuncion;
	var listArchivos = $("#listArchivos");
	$(".btn-pop-matriz").click(function(){
		var codActividad = $(this).data('id');
		var codNivel = $(this).data('level');
		var listMatriz = $("#listMatriz");
		$("#idactividad_modal").val(codActividad);
		$("#modalverMatriz").attr("href", "/efa/matriz/get/"+codActividad);
		listMatriz.html('<tr><td colspan="3"><div class="loader"></div></td></tr>');
		$.post(prefix + '/matriz/getMatrices', 
			{codActividad:codActividad, codNivel:codNivel},
			function(json_data){
				listMatriz.html("");
				$.each(json_data, function(i, data){
					
					$.post(prefix + '/matriz/getMatricesActividadbyId', {idMatriz:data.label, idActividad:codActividad},
							function(response){
						if (response.length > 0) {
							$.each(response, function(i, dt){
								var checked = "";
								var disabled = false;
								if (dt.estadomatrizactividad === "1") {
									checked = "checked";
								}
								else if (dt.estadomatrizactividad === "2") {
									disabled = true;
								}
								var row = '';
								row += '<tr>';
								if (!disabled) {
									row += '<td><center><input type="checkbox" ' + checked + ' class="chk_matriz" name="chk_matriz" value="' + data.label + '" /></center></td>';
								} else {
									row += '<td><center>Completo</center>';
								}
								row += '<td>' + data.value + '</td>';
								row += '</tr>';
								listMatriz.append(row);
							})
						}
						else{
							var row = '';
							row += '<tr>';
							row += '<td><center><input type="checkbox" class="chk_matriz" name="chk_matriz" value="' + data.label + '" /></center></td>';
							row += '<td>' + data.value + '</td>';
							row += '</tr>';
							listMatriz.append(row);
						}
					})
					
					
					
					//listMatriz.append('<option value="' + data.value + '">' + data.label + '</option>');
		        });  
		})
	});
	

	$(document).on('click', '#modalverMatriz', function(e){

		var atLeastOneIsChecked = $('#myModal :checkbox:checked').length > 0;
		if(!atLeastOneIsChecked){
			e.preventDefault();
		}
	});
	
	$(document).on('click', '.chk_matriz', function(e){
		var v = $(this).is(":checked");
		var idactividad_modal = $("#idactividad_modal").val();
		var idMatriz = $(this).val();
		if (v) {
			$.post(prefix+'/matriz/saveMatrizActividad',
					{idactividad:idactividad_modal, idMatriz:idMatriz, estado:"1" },
					function(json_data){
						console.log("exito");
					});
		} else {
			$.post(prefix+'/matriz/saveMatrizActividad',
					{idactividad:idactividad_modal, idMatriz:idMatriz, estado:"0" },
					function(json_data){
						console.log("exito");
					});
		}
	});
	$(".btn_verFunciones").click(function(e){
		$('.block_td_bot').hide();
		$(this).parent().parent().parent().find('.block_td_bot').show();
		e.preventDefault();
	});
	$('#tabMatriz a').click(function (e) {
		e.preventDefault();
	  	$(this).tab('show');
	});
	$(".btn_save_funcion").click(function(e){
		var pos = $(this).data("pos");
		idmatrizactividad = $(this).data("matrizactividad");
		idfuncion = $(this).data("funcion");
		var atLeastOneIsChecked = $('#frm_funcion_' + pos + ' :checkbox:checked').length > 0;
		var action;
		if(!atLeastOneIsChecked){
			alert("Debe seleccionar al menos un indicador");
		}
		else{
			$.post(prefix + '/matriz/checkArchive',
					{idmatrizactividad:idmatrizactividad, idfuncion:idfuncion}, 
					function(json_data){
						if (json_data > 0) {
							$('#frm_funcion_' + pos).submit();
						}
						else{
							alert("Debe agregar al menos un archivo para este indicador.");
						}
			})
		}
		e.preventDefault();
	});
	$(".btnArchive").click(function(e){
		idmatrizactividad = $(this).data("matrizactividad");
		idfuncion = $(this).data("funcion");
		
		$("#idmatrizactividad").val(idmatrizactividad);
		$("#idfuncion").val(idfuncion);
		var disabled = $(this).data('disabled');
		if (disabled) {
			$("#frm_archive").hide();
		} else {
			$("#frm_archive").show();
		}
		listArchivos.html('<tr><td colspan="4"><div class="loader"></div></td></tr>');
		getArchives(disabled);
		e.preventDefault();
	});
	

	$(document).on('click', '.delete_archive', function(e){
		var id = $(this).data("id");
		if (confirm("Desea eliminar este archivo?")) {
			$.post(prefix + '/matriz/deleteArchive', {idArchive:id}, function(e){
				getArchives();
			});
		}
		e.preventDefault();
	})
	
	getArchives = function(disabled){
		$.post(prefix + '/matriz/getArchivesFuncion',
				{idmatrizactividad:idmatrizactividad, idfuncion:idfuncion}, 
				function(json_data){
			listArchivos.html("");
			$.each(json_data, function(i, data){
				addListArchive(data, disabled);
	        });
		});
	}
	
	$('#frm_archive').ajaxForm({
        dataType:  'json', 
        beforeSubmit : showRequest, 
        success:   processJson 
    });
    function showRequest(){
    	listArchivos.html('<tr><td colspan="3"><div class="loader"></div></td></tr>');
    }
    function processJson(json_data) {
    	listArchivos.html("");
		$.each(json_data, function(i, data){
			addListArchive(data, false)
        });
    }
    function addListArchive(data, estado){
		var row = '';
		row += '<tr>';
		row += '<td>'+ data.tipo +'</td>';
		row += '<td>'+ data.nombrearchivo +'</td>';
		var v = data.arhivo;
		v.replace('"', '');
		if (estado) {
			row += '<td colspan="2"><a href="http://localhost/efa/'+ v  +'" target="_blank">Archivo</a></td>';
		}
		else{
			row += '<td><a href="http://localhost/efa/'+ v  +'" target="_blank">Archivo</a></td>';
			row += '<td><a href="#" class="btn btn-primary delete_archive" data-id="'+ data.idarchivofunciones  +'">X</a></td>';
		}
		row += '</tr>';
		listArchivos.append(row);
    }
});