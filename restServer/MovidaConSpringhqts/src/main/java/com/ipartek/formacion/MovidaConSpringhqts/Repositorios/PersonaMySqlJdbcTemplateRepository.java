package com.ipartek.formacion.MovidaConSpringhqts.Repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.MovidaConSpringhqts.Modelos.Persona;


@Repository
public class PersonaMySqlJdbcTemplateRepository implements RESTable<Persona> {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Persona> obtenerTodos() {
		return jdbcTemplate.query("select * from personas", new PersonaMapper());
	}
	
	private static final class PersonaMapper implements RowMapper<Persona> {
		public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Persona(rs.getLong("id"), rs.getString("nombre"),rs.getString("apellido"));
		}

}

	@Override
	public List<Persona> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}}
