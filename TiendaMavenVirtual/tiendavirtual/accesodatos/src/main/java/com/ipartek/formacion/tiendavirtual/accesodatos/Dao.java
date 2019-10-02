package com.ipartek.formacion.tiendavirtual.accesodatos;

import com.ipartek.formacion.tiendavirtual.modelos.Carrito;

public interface Dao<PK, T> {
	Iterable<T> getAll();
	T getById(PK id);
	
	T insert(T objeto);
	T update(T objeto);
	T update(T objeto, T objetoViejo);
	T delete(T objeto);
	Long deleteById(PK id);
	
}
