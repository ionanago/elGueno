package com.ipartek.formacion.ejercicioSpring.servicio;

import javax.inject.Inject;
import javax.inject.Named;

import com.ipartek.formacion.ejercicioSpring.accesoDatos.UsuarioDao;
import com.ipartek.formacion.ejercicioSpring.modelos.Usuario;


@Named
public class UsuarioService {
	@Inject
	private UsuarioDao dao;
	
	public Iterable<Usuario> getAll() {
		return dao.getAll();
	}

}
