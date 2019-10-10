package com.ipartek.formacion.EjemploConSpring;

import java.util.TreeMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRest {
	private static TreeMap<Long, Persona> personas = new TreeMap<>();

	static {
		personas.put(1L, new Persona(1L, "Javier", "Lete García"));
		personas.put(2L, new Persona(2L, "Pepe", "Pérez González"));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/api/personas")
	public Iterable<Persona> getAll() {
		//return personas.values();
		return PersonaMySqlJdbcTemplateRepository.obtenerTodos();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/api/personas/{id}")
	public Persona getById(@PathVariable("id") Long id) {
		
		Persona persona = personas.get(id);

		if(persona == null) {
			throw new NotFoundException("No se ha encontrado la persona con id " + id);
		}

		return persona;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/api/personas")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona insert(@RequestBody Persona persona) {
		Long id = personas.lastKey() + 1;
		persona.setId(id);
		personas.put(id, persona);
		
		return persona;
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/api/personas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Persona update(@PathVariable("id") Long id, @RequestBody Persona persona ) {
	
		personas.put(id, persona);
		
		return persona;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/api/personas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Long id) {
		
		try {
			personas.remove(id);
		} catch (ServerErrorException e) {
			
			e.printStackTrace();
		}
		
	}
	@RequestMapping(method = RequestMethod.PATCH, path = "/api/personas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Persona update_patch(@PathVariable("id") Long id, @RequestBody Persona persona ){
		
		return persona;
		
	}
	
	
}
