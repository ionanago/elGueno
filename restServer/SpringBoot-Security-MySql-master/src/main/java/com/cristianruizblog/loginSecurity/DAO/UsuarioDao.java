package com.cristianruizblog.loginSecurity.DAO;

import javax.inject.Inject;
import javax.inject.Named;

import com.cristianruizblog.loginSecurity.entity.User;
import com.cristianruizblog.loginSecurity.repository.UserRepository;

@Named
public class UsuarioDao implements Dao<Long,User>{
	@Inject
	private UserRepository repo;
	@Override
	public Iterable<User> getAll() {
		
		return repo.findAll();
	}

	@Override
	public User getById(Long id) {
		
		return null;
	}

	@Override
	public User insert(User objeto) {
		
		return repo.save(objeto);
	}

	@Override
	public User update(User objeto) {
	
		return null;
	}

	@Override
	public void delete(Long id) {
		
		repo.deleteById(id);
	}

}
