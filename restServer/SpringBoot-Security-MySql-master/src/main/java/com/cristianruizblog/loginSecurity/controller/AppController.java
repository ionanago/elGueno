package com.cristianruizblog.loginSecurity.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cristianruizblog.loginSecurity.entity.Producto;
import com.cristianruizblog.loginSecurity.entity.User;
import com.cristianruizblog.loginSecurity.service.ProductoService;
import com.cristianruizblog.loginSecurity.service.UsuarioService;

@Controller
public class AppController implements ErrorController {
	//encriptador de contraseñas
	BCryptPasswordEncoder PassEncoder = new BCryptPasswordEncoder(4);
	//variables de los servicios	
	@Inject
	private ProductoService pservicio;
	@Inject
	private UsuarioService uservicio;
	
	
	// controladores simples de pagina
	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/formProductos")
	public String formp() {
		return "formProductos";
	}
	
	@GetMapping("/formUsuarios")
	public String formu() {
		return "formUsuarios";
		}
	
	// controladores de envio de datos a las jsp
	
	
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
	
	
	@GetMapping("/usuGest")
	public String usuariogestion(Model model) {
		model.
		addAttribute
		("usuarios",uservicio.getAll());
		return "gestionUsuarios";
	}
	
	//controladores de los fromularios
	
	@PostMapping("/ProcesarUsuario")
	public String procesarFormularioU(@Valid @ModelAttribute User usuario, BindingResult bindingResult) {
		
		User usuEncrypt = new User();
		usuEncrypt.setUsername(usuario.getUsername());
		usuEncrypt.setPassword(PassEncoder.encode(usuario.getPassword()));
		uservicio.insertar(usuEncrypt);

		return "gestionUsuarios";
	}
	
	@PostMapping("/ProcesarProducto")
	public String procesarFormularioP(@Valid @ModelAttribute Producto producto, BindingResult bindingResult) {
		
		pservicio.insertar(producto);

		return "gestionProductos";
	}
	
	 
	//controladores de errores
	
	@GetMapping("/403")
    public String accessDenied() {
        return "errorPages/403";
    }
	@GetMapping("/405")
    public String methodNotallowed() {
        return "errorPages/405";
    }
	 @GetMapping("/error")
	    public String serverError() {
	        return "errorPages/500";
	    }

	@Override
	public String getErrorPath() {
		
		return "/error";
	}
}
