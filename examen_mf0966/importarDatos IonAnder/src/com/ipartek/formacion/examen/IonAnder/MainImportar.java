package com.ipartek.formacion.examen.IonAnder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainImportar {
	
	
	
	
	private final static String ADD_PERSONA = "{ call add_personas(?,?,?,?)}";
	private final static String URL = "jdbc:mysql://root:admin@localhost:3307/gestion_personas?serverTimezone=UTC";
	
	
	
	public static void main(String[] args) {
		
		System.out.println("hola");
		 System.out.println(System.getProperty("user.dir")+"/resources/personas.txt");
		String rutaFicheroCSV = System.getProperty("user.dir")+"/resources/personas.txt";
		try {
			
			MainImportar.importarCSV(rutaFicheroCSV);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void importarCSV(String rutaFicheroCSV) throws Exception {
		try (FileReader fr = new FileReader(rutaFicheroCSV)) {
			try (BufferedReader br = new BufferedReader(fr)) {

				String linea = null;

				if (br.readLine() == null) {
					throw new Exception("No se ha encontrado ninguna línea en el fichero");
				}

				while ((linea = br.readLine()) != null) {
					String[] datos = linea.split(",");

					System.out.printf(" %s, %s, %s, %s",  datos[0], datos[1], datos[4], datos[5]);

					
					String nombre = datos[0];
					String apellido = datos[1];
					String email = datos[4];
					String dni = datos[5];

					System.out.printf(" ->  %s, %s, %s,%s\n",  nombre, apellido, email, dni);

					insertarPersona( nombre, apellido, email, dni);
				}
			}
		} catch (FileNotFoundException e) {
			throw new Exception("No se ha encontrado el fichero", e);
		} catch (IOException e) {
			throw new Exception("No se ha podido abrir el fichero", e);
		}
	}
	
	private static void insertarPersona( String nombre, String apellido, String email, String dni) throws Exception {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection con = DriverManager.getConnection(URL)) {
			try(CallableStatement cs = con.prepareCall(ADD_PERSONA)) {
				
				
				cs.setString(1,nombre);
				cs.setString(2, apellido);
				cs.setString(3, email);
				cs.setString(4, dni);
				
				int numeroRegistrosModificados = cs.executeUpdate();
				
				if(numeroRegistrosModificados != 1) {
					throw new Exception("No se ha insertado ningún registro o se ha insertado más de uno");
				}
			} catch(SQLException e) {
				throw new Exception("No se ha podido hacer la inserción", e);
			}
		} catch (SQLException e) {
			throw new Exception("No se ha podido conectar a la base de datos", e);
		}
	}

}
