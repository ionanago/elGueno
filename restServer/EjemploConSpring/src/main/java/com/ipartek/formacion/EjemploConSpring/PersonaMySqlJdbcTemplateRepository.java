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
	public Object save(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable saveAll(Iterable entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable findAllById(Iterable ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List findByApellido(String Apellido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}

	
	