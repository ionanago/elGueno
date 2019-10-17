package com.ipartek.formacion.MovidaConSpringhqts.Repositorios;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.MovidaConSpringhqts.Modelos.Persona;


@Repository
public class PersonaMySqlJdbcTemplateRepository implements RESTable<Persona> {
	private static final String PERSONA_INSERT = "{call persona_insert(?, ?, ?)}";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Persona> getAll() {
		return jdbcTemplate.query("select * from personas", new PersonasMapper());
	}
	
	@Override
	public Persona getById(Long id) {
		
		return  jdbcTemplate.queryForObject("SELECT * FROM personas WHERE id = ?", new Object[] { id },
	            new PersonasMapper());
	} 
	
	@Override
	public void deleteById(Long id) {
		jdbcTemplate.update("Delete FROM personas p WHERE p.id = ?", new Object[]{ id });

	}
	
	@Override
	public Persona modify(Long id, Persona persona) {
	
		jdbcTemplate.update(
                "update personas set nombre = ?, apellido = ? where id = ?", persona.getNombre() ,persona.getApellidos(), id  );
 
		return persona;
	}
	
	@Override
	public Persona insert( Persona persona)  {
		try (Connection con = jdbcTemplate.getDataSource().getConnection()){
			
			try(  CallableStatement cs = con.prepareCall(PERSONA_INSERT)){
			  cs.setString(1, persona.getNombre());
			  cs.setString(2, persona.getApellidos());
			  cs.registerOutParameter(3,Types.INTEGER);
			  cs.executeUpdate();
			  
			  persona.setId(cs.getLong(3));
			  

		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return persona;
}

	
	
	private static final class PersonasMapper implements RowMapper<Persona> {
		public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Persona(rs.getLong("id"), rs.getString("nombre"),rs.getString("apellido"));
		}
	}

	}
