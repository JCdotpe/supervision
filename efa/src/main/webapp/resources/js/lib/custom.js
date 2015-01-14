var datatbl;


function ini_table(){
	datatbl = $('.datatable').DataTable({
        "sScrollY": "500px",
        "sScrollX": "100%",
        "scrollX": false,
        "scrollY": false,
        //"sScrollXInner": "110%",
        "bScrollCollapse": true,     
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
	
}



//Disable function
jQuery.fn.extend({
    disable: function(state) {
        return this.each(function() {
            this.disabled = state;
        });
    }
});
jQuery.fn.extend({
    readonly: function(state) {
        return this.each(function() {
            this.readonly = state;
        });
    }
});

function i_enable(ctrl){
  $(ctrl).removeAttr("disabled");
}

function i_disable(ctrl){
  $(ctrl).val('').attr("disabled","disabled");
}


function i_en(ctrl){
  $(ctrl).val('').removeAttr("disabled");
}

function i_dis(ctrl){
  $(ctrl).attr("disabled","disabled");
}




$(function(){
	
$(window).keydown(function(event){
	      if(event.keyCode == 13) {
	          event.preventDefault();
	          return false;
	      }
});
	
$("form").submit(function() {
	    $(this).submit(function() {
	        return false;
	    });
	    return true;
});



$('[data-toggle="tooltip"]').tooltip()


    $.asm = {};
    $.asm.panels = 2;

    $('#toggleSidebar').click(function(){
        if ($.asm.panels === 1) {
            $('#toggleSidebar span').attr({'class': 'glyphicon glyphicon-backward'});
            $('#content').attr({'class': 'col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main'});
            $('#sidebar1').show();
            $.asm.panels = 2;
        } else {
            $('#toggleSidebar span').attr({'class': 'glyphicon glyphicon-forward'});
            $('#content').attr({'class': 'col-md-12 main'});
            $('#sidebar1').hide();
            $.asm.panels = 1;
        }
    });

$.extend(jQuery.validator.messages, {
     required: "Campo obligatorio",
    // remote: "Please fix this field.",
     email: "Ingrese un email válido",
    // url: "Please enter a valid URL.",
     date: "Ingrese una fecha válida",
    // dateISO: "Please enter a valid date (ISO).",
     number: "Solo se permiten números",
     digits: "Solo se permiten números",
    range: jQuery.validator.format("Por favor ingrese un valor  entre {0} y {1}."),
    // creditcard: "Please enter a valid credit card number.",
    // equalTo: "Please enter the same value again.",
    // accept: "Please enter a value with a valid extension.",
    // maxlength: jQuery.validator.format("Please enter no more than {0} characters."),
    // minlength: jQuery.validator.format("Please enter at least {0} characters."),
    // rangelength: jQuery.validator.format("Please enter a value between {0} and {1} characters long."),
    // range: jQuery.validator.format("Please enter a value between {0} and {1}."),
    // max: jQuery.validator.format("Please enter a value less than or equal to {0}."),
    // min: jQuery.validator.format("Please enter a value greater than or equal to {0}.")
});
$.validator.addMethod("valueNotEquals", function(value, element, arg){
    return arg != value;
}, "Seleccione un valor");

$.validator.addMethod("validName", function(value, element) {
    return this.optional(element) || /^[a-zA-ZàáâäãåąćęèéêëìíîïłńòóôöõøùúûüÿýżźñçčšžÀÁÂÄÃÅĄĆĘÈÉÊËÌÍÎÏŁŃÒÓÔÖÕØÙÚÛÜŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$/.test(value);
}, "Caracteres no permitidos"); 

$.validator.addMethod("exactlength", function(value, element, param) {
    return this.optional(element) || value.length == param;
}, jQuery.format("Ingrese {0} caracteres."));


$.validator.addMethod("greaterThan", 
		function(value, element, params) {

		    if (!/Invalid|NaN/.test(new Date(value))) {
		        return new Date(value) > new Date($(params).val());
		    }

		    return isNaN(value) && isNaN($(params).val()) 
		        || (Number(value) > Number($(params).val())); 
		},'Debe ser mayor a {0}.');


ini_table();



$("#departamento").change(function(event) {
    $.ajax({
        url: prefix +'/ubigeo/prov',
        data: {
            depId:  $(this).val()
        },
        success: function (json_data) {
        	sel = $("#provincia");
        	sel.empty();
        	sel.append('<option value="-1">-</option>');
            $.each(json_data, function(i, data){
            	sel.append('<option value="' + data.value + '">' + data.label + '</option>');
        });                	
        }
    });        
});

$("#provincia").change(function(event) {
$.ajax({
    url: prefix +'/ubigeo/dist',
    data: {
        depId:  $("#departamento").val(),
        provId:  $(this).val()
    },
    success: function (json_data) {
    	sel = $("#distrito");
    	sel.empty();
    	sel.append('<option value="-1">-</option>');
        $.each(json_data, function(i, data){
        	sel.append('<option value="' + data.value + '">' + data.label + '</option>');
    });                	
    }
});        
});	

$(".datepicker").datepicker({
	dateFormat : "dd/mm/yy",
	changeMonth : true,
	changeYear : true,
	showButtonPanel : true
});


$("#sector").change(function(event) {
    $.ajax({
        url: prefix +'/sectorum/umact',
        data: {
        	secId:  $(this).val()
        },
        success: function (json_data) {
        	sel = $("#actividad");
        	sel.empty();
        	sel.append('<option value="-1">-</option>');
            $.each(json_data, function(i, data){
            	sel.append('<option value="' + data.value + '">' + data.label + '</option>');
        });                	
        }
    });        
});

$("#actividad").change(function(event) {
$.ajax({
    url: prefix +'/sectorum/umcat',
    data: {
        secId:  $("#sector").val(),
        actId:  $(this).val()
    },
    success: function (json_data) {
    	sel = $("#categoria");
    	sel.empty();
    	sel.append('<option value="-1">-</option>');
        $.each(json_data, function(i, data){
        	sel.append('<option value="' + data.value + '">' + data.label + '</option>');
    });                	
    }
});        
});	


});

