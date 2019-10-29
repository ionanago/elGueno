package com.cristianruizblog.loginSecurity.controller;

import javax.inject.Inject;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cristianruizblog.loginSecurity.service.ProductoService;
import com.cristianruizblog.loginSecurity.service.UsuarioService;

@Controller
public class AppController implements ErrorController {

	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@Inject
	private ProductoService pservicio;
	
	@GetMapping("/user")
	public String user(Model model) {
		model.
		addAttribute
		("productos", 
				pservicio.
				getAll());
		return "user";
	}
	@GetMapping("/proGest")
	public String productogestion(Model model) {
		model.
		addAttribute
		("productos",pservicio.getAll());
		return "gestionProductos";
	}
	
	
	@Inject
	private UsuarioService uservicio;
	
	@GetMapping("/usuGest")
	public String usuariogestion(Model model) {
		model.
		addAttribute
		("usuarios",uservicio.getAll());
		return "gestionUsuarios";
	}
	
	
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	 
	@GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
	 @GetMapping("/error")
	    public String serverError() {
	        return "500";
	    }

	@Override
	public String getErrorPath() {
		
		return "/error";
	}
}
