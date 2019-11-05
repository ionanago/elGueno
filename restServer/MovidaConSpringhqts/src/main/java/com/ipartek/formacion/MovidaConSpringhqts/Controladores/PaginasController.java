package com.ipartek.formacion.MovidaConSpringhqts.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.MovidaConSpringhqts.Repositorios.PersonaMySqlJdbcTemplateRepository;

@Controller
public class PaginasController {
	
	//creación de la variable repo para acceder al repositorio jdbc
	PersonaMySqlJdbcTemplateRepository repo = new PersonaMySqlJdbcTemplateRepository();
	
	
	@GetMapping({"/"})
	public String index() {
		return "index";
	}
	@GetMapping({"/mostrar"})
	public String MostrarTodos() {
		return "mostrar";
	}
	@GetMapping({"/mostrar/{id}"})
	public String MostrarUno() {
		return "mostrar1";
	}
	@GetMapping({"/modificar/{id}"})
	public String Modificar() {
		return "formularioMod";
	}
	@GetMapping({"/insertar"})
	public String Insertar() {
		return "formulario";
	}
	@GetMapping({"/borrar/{id}"})
	public String Borrar() {
		return "borrar";
	}
}
