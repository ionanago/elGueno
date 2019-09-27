package com.ipartek.formacion.tiendavirtual.accesodatos;



public interface Dao<PK, T> {
	Iterable<T> getAll();
	T getById(PK id);
	
	T insert(T objeto);
	T update(T objeto);
	T update(T objeto, T objetoViejop);
	T delete(T objeto);
	Long deleteById(PK id);
}
