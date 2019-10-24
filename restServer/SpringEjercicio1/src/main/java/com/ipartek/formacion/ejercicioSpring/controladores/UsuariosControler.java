package com.ipartek.formacion.ejercicioSpring.controladores;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.ejercicioSpring.servicio.UsuarioService;

@Controller
public class UsuariosControler { 
	private UsuarioService servicio;
	
	@GetMapping("/lista")
	public String getAll1(Model model) {
		model.addAttribute("usuarios", servicio.getAll());
		return "lista";
	}
	@GetMapping("/tabla")
	public String getAll(Model model) {
		model.addAttribute("usuarios", servicio.getAll());
		return "tabla";
	}
}
