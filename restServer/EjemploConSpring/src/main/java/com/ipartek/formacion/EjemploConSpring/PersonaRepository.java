package com.ipartek.formacion.EjemploConSpring;

import java.util.List;


import org.springframework.data.repository.CrudRepository;



public interface PersonaRepository<T> extends CrudRepository<T,Persona> {

	 List<Persona> findByApellido(String Apellido);

		Persona getById(long id);
		
		
}
