package com.ipartek.formacion.ejercicioSpring.accesoDatos;

import javax.inject.Inject;

import com.ipartek.formacion.ejercicioSpring.modelos.Usuario;
import com.ipartek.formacion.ejercicioSpring.repositorio.UsuarioRepositorio;

public class UsuarioDao implements Dao<Long, Usuario>{
	@Inject
	UsuarioRepositorio repositorio;
	@Override
	public Iterable<Usuario> getAll() {
		
		return repositorio.findAll();
				}

	@Override
	public Usuario  getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario insert(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	

}
