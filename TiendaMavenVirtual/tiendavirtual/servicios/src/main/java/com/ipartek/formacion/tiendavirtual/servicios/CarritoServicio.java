package com.ipartek.formacion.tiendavirtual.servicios;

import com.ipartek.formacion.tiendavirtual.modelos.Carrito;

public interface CarritoServicio {

	Carrito getCarrito(Long idu);
	int getTotalCarrito(Long idu);
	
	
	
}
