'use strict';

var URL = 'http://localhost:8080/api/productos/';
//jQuery(function($) {
//	listarProductos($);
//});


//añadir
jQuery(function($) { //Equivalente a window.onload
	$('#btninsertar').click(function(e) {
		e.preventDefault(); //Cancelar la emisión del formulario por el action

		var nombre = $('#nombre').val();
		var descripcion = $('#descripcion').val();
		var precio = $('#precio').val();

		var producto = { nombre, descripcion, precio };

		console.log(producto);

		ajaxRest($, URL, 'POST', producto,"").done(function(respuesta) {
			alert("Añadido correctamente a la base de datos");
			console.log(respuesta);
			addProductoAListado($, producto);
		}).fail(function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseJSON.message);
			console.log(jqXHR, textStatus, errorThrown);
		});
	});

	listarProductos($);
});

//pasar datos de tabla a formulario de Mod
jQuery(function($) {
	$('#modlink').click(function(e){
		e.preventDefault();
		var padre=$(this).closest('td');
		 $('#idMod').val();
		 $('#nombreMod').val($('#nombre').val());
		 $('#descripcionMod').val($('#descripcion').val());
		 $('#precioMod').val($('#precio').val());
	});
	
});

//modificar
jQuery(function($) { //Equivalente a window.onload
	$('#btnMod').click(function(e) {
		e.preventDefault(); //Cancelar la emisión del formulario por el action
		
		var nombreMod = $('#nombreMod').val();
		var descripcionMod = $('#descripcionMod').val();
		var precioMod = $('#precioMod').val();

		var productoMod = { nombreMod, descripcionMod, precioMod };

		console.log(productoMod);

		ajaxRest($, URL, 'PUT', productoMod).done(function(respuesta) {
			alert("Modificado correctamente a la base de datos");
			console.log(respuesta);
			addProductoAListado($, producto);
		}).fail(function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseJSON.message);
			console.log(jqXHR, textStatus, errorThrown);
		});
	});

	listarProductos($);
});

//borrar

function ajaxRest($, url, metodo, producto) {
	return $.ajax({
		url: url,
		method: metodo,
		data: JSON.stringify(producto),
		contentType: 'application/json',
		dataType: 'json'
	});
}
//listar
function listarProductos($) {
	$('#productos').empty();

	$.getJSON(URL, function(respuesta) {
		var productos = respuesta._embedded.productos;
		console.log(productos);
		$(productos).each(function() {
			console.log(this);
			addProductoAListado($, this);
		});
	});
};
//semirefresque
function addProductoAListado($, producto) {
	console.log(producto);
	 var elemento = 
	  '<tr>'+
        '<td>' + producto.nombre + '</td>'+
        '<td>' + producto.descripcion + '</td>'+
        '<td>' + producto.precio + '</td>'+
		'<td>' + '<a class="btn btn-info" id="modificar" href="">Modificar</a>'+'<a class="btn btn-danger" id="borrar" href="" >Borrar</a>' + '</td>'+
      '</tr>';
      
   $('#productos').append(elemento);
	/*$('#productos').append($('<td>').html(
		producto.nombre + ' ' + producto.descripcion + ' ' + producto.precio));
		*/
};
