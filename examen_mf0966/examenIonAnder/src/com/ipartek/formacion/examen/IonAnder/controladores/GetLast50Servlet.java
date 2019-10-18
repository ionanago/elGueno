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
 * Servlet implementation class GetLast50Servlet
 */
@WebServlet("/ultimos50")
public class GetLast50Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonaServicio servicios = new PersonasServicioImpl();
		
		Iterable<Persona> last50 = servicios.getLast50();

		request.setAttribute("last50", last50);
		
		request.getRequestDispatcher("/WEB-INF/vistas/ultimos50.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
