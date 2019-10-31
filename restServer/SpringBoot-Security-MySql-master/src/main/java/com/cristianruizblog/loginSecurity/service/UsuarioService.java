package com.cristianruizblog.loginSecurity.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.cristianruizblog.loginSecurity.DAO.UsuarioDao;
import com.cristianruizblog.loginSecurity.entity.User;

@Named
public class UsuarioService {

	@Inject
	private UsuarioDao dao;
	
	public Iterable<User> getAll() {
		return dao.getAll();
	}
	public void borrar(User usuario) {
		dao.delete(usuario.getId());
	}
	
	
	public User insertar(User usuario) {
		return dao.insert(usuario);
	}
}
