package com.ipartek.formacion.ejercicioSpring.accesoDatos;

public interface Dao<K,T> {
	Iterable<T> getAll();
	T getById(K id);
	T insert(T objeto);
	T update(T objeto);
	void delete(K id);
	
}