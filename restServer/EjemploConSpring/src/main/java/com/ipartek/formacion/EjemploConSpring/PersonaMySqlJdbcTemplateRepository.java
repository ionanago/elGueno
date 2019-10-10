package com.ipartek.formacion.EjemploConSpring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class PersonaMySqlJdbcTemplateRepository implements PersonaRepository{
	@Autowired
	private static JdbcTemplate jdbcTemplate;


	
	public static List<Persona> obtenerTodos() {
		return jdbcTemplate.query("select * from Persona", new PresonaMapper());
	}
	
	private static final class PresonaMapper implements RowMapper<Persona> {
		public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Persona(rs.getLong("id"), rs.getString("nombre"),rs.getString("apellido")
			);
		}
	}

	
	
	
	
	
	
	
	@Override
	public Iterable<Long> findAll() {
		
		return null;
	}
	
	
	
	
	
	
	
	@Override
	public <S extends Long> S save(S entity) {
		
		return null;
	}

	@Override
	public <S extends Long> Iterable<S> saveAll(Iterable<S> entities) {
		
		return null;
	}

	@Override
	public Optional<Long> findById(Persona id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Persona id) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Iterable<Long> findAllById(Iterable<Persona> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Persona id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Long> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Persona> findByApellido(String Apellido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
