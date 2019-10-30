package com.cristianruizblog.loginSecurity.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.cristianruizblog.loginSecurity.DAO.ProductoDao;
import com.cristianruizblog.loginSecurity.entity.Producto;

@Named
public class ProductoService {
	@Inject
	private ProductoDao dao;
	
	public Iterable<Producto> getAll() {
		return dao.getAll();
	}
	
	public void borrar(Producto producto) {
		dao.delete(producto);
	}
	
	
	public Producto insertar(Producto producto) {
		return dao.insert(producto);
	}
}
