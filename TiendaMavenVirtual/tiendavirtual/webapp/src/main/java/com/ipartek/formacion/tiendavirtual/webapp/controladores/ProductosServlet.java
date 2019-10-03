package com.ipartek.formacion.tiendavirtual.webapp.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.tiendavirtual.modelos.Carrito;
import com.ipartek.formacion.tiendavirtual.modelos.Mensaje;
import com.ipartek.formacion.tiendavirtual.servicios.CarritoServicio;
import com.ipartek.formacion.tiendavirtual.servicios.ProductoServicio;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {
	private static final String PRODUCTOS_JSP = "/WEB-INF/vistas/productos.jsp";
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		try {
			
			ProductoServicio servicio = (ProductoServicio) getServletContext().getAttribute("servicioProductos"); 
			try {
				CarritoServicio servicioC = (CarritoServicio) getServletContext().getAttribute("servicioCarrito"); 
				Long uno= Long.parseLong("1");
				Carrito productos =servicioC.getCarrito(uno);
				
				
				request.setAttribute("carrito",productos.getProductos() );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("mensaje", new Mensaje("danger", "carrito doesn´t work!!"));
			}
			
			request.setAttribute("productos", servicio.getAll());
			
			//ProductosServicioImpl.getInstancia();
			//request.setAttribute("mensaje",	new Mensaje("info", "Se ha cargado la lista de productos"));
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("mensaje", new Mensaje("danger", "Ha habido un error al pedir los datos al servidor"));
		}
		
		request.getRequestDispatcher(PRODUCTOS_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
