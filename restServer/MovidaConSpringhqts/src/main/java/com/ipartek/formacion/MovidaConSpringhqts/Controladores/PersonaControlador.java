package com.ipartek.formacion.MovidaConSpringhqts.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		System.out.println("Les Persona:" + PersonaRepositorio.getById(id).toString());
		return PersonaRepositorio.getById(id);
	}
}
