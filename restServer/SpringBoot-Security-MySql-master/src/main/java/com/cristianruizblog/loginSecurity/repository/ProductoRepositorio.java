package com.cristianruizblog.loginSecurity.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristianruizblog.loginSecurity.entity.Producto;



@Repository("productoRepositorio ")
public interface  ProductoRepositorio extends CrudRepository<Producto, Integer>{
	
	

	
	
}
