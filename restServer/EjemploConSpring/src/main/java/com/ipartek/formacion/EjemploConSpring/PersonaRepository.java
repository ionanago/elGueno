package com.ipartek.formacion.EjemploConSpring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface PersonaRepository extends CrudRepository<Long, Persona> {

	 List<Persona> findByApellido(String Apellido);

		Persona findById(long id);
		
		
}
