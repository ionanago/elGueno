package com.ipartek.formacion.examen.IonAnder.accesodatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.examen.IonAnder.modelos.Persona;

public class PersonasDAOimpl implements PersonasDAO{
	private final static String URL = "jdbc:mysql://root:admin@localhost:3307/gestion_personas?serverTimezone=UTC";
	private static final String GET_LAST_50 = "{call last50()}";
	private final static String ADD_PERSONA = "{ call add_personas(?,?,?,?)}";
	
	
	public PersonasDAOimpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de MySQL", e);
		}
	}
	

	@Override
	public Persona addPersona(Persona persona) {
		try(Connection con = DriverManager.getConnection(URL)) {
			try(CallableStatement cs = con.prepareCall(ADD_PERSONA)) {
				
				
				cs.setString(1,persona.getNombre());
				cs.setString(2, persona.getApellido());
				cs.setString(3, persona.getEmail());
				cs.setString(4, persona.getDni());
				
				int numeroRegistrosModificados = cs.executeUpdate();
				
				if(numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("No se ha insertado ningún registro o se ha insertado más de uno");
				}
			} catch(SQLException e) {
				throw new AccesoDatosException("No se ha podido hacer la inserción", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
		return persona;
	}

	@Override
	public Persona getPersonaDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getPersonaEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getPersona(String Nombre, String Apellido) {
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<Persona> personas;
	
	@Override
	public Iterable<Persona>  getLast50() {
		try (Connection con = DriverManager.getConnection(URL)) {
			try (CallableStatement cs = con.prepareCall(GET_LAST_50)) {
				ResultSet rs = cs.executeQuery();

				personas = new ArrayList<>();

				Persona persona;

				while (rs.next()) {
					persona = new Persona(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellido"),
							rs.getString("email"),rs.getString("dni"));
					System.out.println(persona.toString());
					personas.add(persona);
				}

				return personas;

			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido llamar al procedimiento " + GET_LAST_50,e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al cerrar la conexión a la base de datos", e);
		}
		
	}

}
