package com.ipartek.formacion.examen.IonAnder.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examen.IonAnder.modelos.Persona;
import com.ipartek.formacion.examen.IonAnder.servicios.PersonaServicio;
import com.ipartek.formacion.examen.IonAnder.servicios.PersonasServicioImpl;

/**
 * Servlet implementation class PersonaProcesar
 */
@WebServlet("/procesar")
public class PersonaProcesar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			try {
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				String email = request.getParameter("email");
				String dni = request.getParameter("dni");
				

				Persona persona = new Persona(nombre,apellido,email,dni);

				PersonaServicio servicio = new PersonasServicioImpl();
				
				servicio.addPersona(persona);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			request.getRequestDispatcher("/ultimos50").forward(request, response);
				

		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
