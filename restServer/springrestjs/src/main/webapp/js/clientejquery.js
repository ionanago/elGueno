'use strict';

var URL = 'http://localhost:8080/api/productos/';
//jQuery(function($) {
//	listarProductos($);
//});



jQuery(function($) { //Equivalente a window.onload
//añadir
	$('#btninsertar').click(function(e) {
		e.preventDefault(); //Cancelar la emisión del formulario por el action

		var nombre = $('#nombre').val();
		var descripcion = $('#descripcion').val();
		var precio = $('#precio').val();

		var producto = { nombre, descripcion, precio };

		//console.log(producto);
		 $('#agregar').modal('toggle');
		ajaxRest($, URL, 'POST', producto, "").done(function(respuesta) {
			console.log("la respuesta")
			console.log(respuesta);
			console.log("el producto")
			console.log(producto);
			addProductoAListado($, respuesta);
			
			alert("Añadido correctamente a la base de datos");
		}).fail(function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseJSON.message);
			console.log(jqXHR, textStatus, errorThrown);
		});
	});



//pasar datos de tabla a formulario de Mod

	$('.modificar').click(function(e) {
		e.preventDefault();
		var padre = $(this).closest('tr');
		console.log(padre);
		 $('#formularioMod').modal('toggle');
		$('padre.nombreMod').val($('#nombre').val());
		$('padre.descripcionMod').val($('#descripcion').val());
		$('padre.precioMod').val($('#precio').val());
	});



//modificar

	$('#btnMod').click(function(e) {
		e.preventDefault(); //Cancelar la emisión del formulario por el action

		var nombreMod = $('#nombreMod').val();
		var descripcionMod = $('#descripcionMod').val();
		var precioMod = $('#precioMod').val();

		var productoMod = { nombreMod, descripcionMod, precioMod };
		 $('#formularioMod').modal('toggle');
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



//borrar
jQuery(".borrar").click(function(e) {
 
  console.log("algo");
});

//	$('.borrar').click(function(e) {
//		

//			var urlborrar = this;
//		console.log(this);
//
//		ajaxRest($, urlborrar, 'DELETE',"").done(function(respuesta) {
//			alert("Modificado correctamente a la base de datos");
//			console.log(respuesta);
//			
//		}).fail(function(jqXHR, textStatus, errorThrown) {
//			alert(jqXHR.responseJSON.message);
//			console.log(jqXHR, textStatus, errorThrown);
//		});
//	});

	listarProductos($);
});

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
		'<tr>' +
		'<td class="nombre">' + producto.nombre + '</td>' +
		'<td class="descripcion">' + producto.descripcion + '</td>' +
		'<td class="precio">' + producto.precio + '</td>' +

		'<td class="ops">' +
		'<button class="btn btn-info modificar"  link="' + producto._links.self.href + '"  >Modificar</button>' +
		'<button class="btn btn-danger borrar"  link="' + producto._links.self.href + '">Borrar</button>' +
		'</td>' +
		'</tr>';

	$('#productos').append(elemento);
	/*$('#productos').append($('<td>').html(
	  producto.nombre + ' ' + producto.descripcion + ' ' + producto.precio));
	*/
};
