package com.ipartek.formacion.MovidaConSpringhqts.Controladores;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.MovidaConSpringhqts.Modelos.Persona;
import com.ipartek.formacion.MovidaConSpringhqts.Repositorios.RESTable;

@RestController
public class PersonaControlador {

	
	@Autowired
	private final RESTable<Persona> PersonaRepositorio = null;
	
	@GetMapping("/api/personas")
	public List<Persona> obtenerPersonas() {
		System.out.println("Les Persones:" + PersonaRepositorio.getAll().toString());
		return PersonaRepositorio.getAll();
	}
	
	@GetMapping("/api/personas/{id}")
	public Persona obtenerPersona(@PathVariable("id") Long id) {
		System.out.println("Le Persona:" + PersonaRepositorio.getById(id).toString());
		return PersonaRepositorio.getById(id);
	}
	
	@DeleteMapping("/api/personas/{id}")
	public  void borrarPersona(@PathVariable("id") Long id) {
		System.out.println("Le Persona auf borrare:" + PersonaRepositorio.getById(id).toString());
		PersonaRepositorio.deleteById(id);
		
	}
	
	@PutMapping("/api/personas/{id}")
	public Persona modificarPersona() {
		throw new NotYetImplementedException();
	}
	
	@PostMapping("/api/personas")
	public Persona añadirPersona(@RequestBody Persona personae) {
		System.out.println();
		throw new NotYetImplementedException();
	}
}
