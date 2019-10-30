package com.cristianruizblog.loginSecurity.DAO;

import javax.inject.Inject;
import javax.inject.Named;

import com.cristianruizblog.loginSecurity.entity.Producto;
import com.cristianruizblog.loginSecurity.repository.ProductoRepositorio;

@Named
public class ProductoDao implements Dao<Long, Producto>{
	@Inject
	private ProductoRepositorio repo;

	@Override
	public Iterable<Producto> getAll() {
		return repo.findAll();	
	}

	@Override
	public Producto getById(Long id) {
		
		return null;
	}

	@Override
	public Producto insert(Producto objeto) {
		
		return null;
	}

	@Override
	public Producto update(Producto objeto) {
		
		return null;
	}

	@Override
	public void delete(Long id) {
		
		
	}

}