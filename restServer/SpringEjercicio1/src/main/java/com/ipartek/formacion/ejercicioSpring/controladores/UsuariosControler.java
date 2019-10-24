package com.ipartek.formacion.ejercicioSpring.controladores;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.ejercicioSpring.servicio.UsuarioService;

@Controller
public class UsuariosControler { 
	@Inject
	private UsuarioService servicio;
	
	@GetMapping("/lista")
	public String lista(Model model) {
		model.
		addAttribute
		("usuarios", 
				servicio.
				getAll());
		
		return "lista";
	}
	@GetMapping("/tabla")
	public String tabla(Model model) {
		model.addAttribute("usuarios", servicio.getAll());
		return "tabla";
	}
}
