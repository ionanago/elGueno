package com.ipartek.formacion.EjemploConSpring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class PersonaMySqlJdbcTemplateRepository implements PersonaRepository<Persona>{
	@Autowired
	private static JdbcTemplate jdbcTemplate;


	public static List<Persona> getAll() {
		return jdbcTemplate.query("select * from Persona", new PresonaMapper());
	}
	
	private static final class PresonaMapper implements RowMapper<Persona> {
		public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Persona(rs.getLong("id"), rs.getString("nombre"),rs.getString("apellido")
			);
		}
	}
	public Persona getById(long id) {
		return (Persona) jdbcTemplate.query("select * from Persona while id=?", new PresonaMapper());
	}
	
	
	
	
	
	
	
	@Override
	public <S extends Persona> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Persona> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Persona> findById(Persona id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean existsById(Persona id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterable<Persona> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<Persona> findAllById(Iterable<Persona> ids) {
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
	public void delete(Persona entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll(Iterable<? extends Persona> entities) {
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
	
	
	
	

}	