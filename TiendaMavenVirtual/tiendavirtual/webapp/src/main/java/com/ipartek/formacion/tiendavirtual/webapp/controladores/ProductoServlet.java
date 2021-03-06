package com.ipartek.formacion.tiendavirtual.webapp.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.tiendavirtual.modelos.Mensaje;
import com.ipartek.formacion.tiendavirtual.modelos.Producto;
import com.ipartek.formacion.tiendavirtual.servicios.ProductoServicio;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {
	private static final String PRODUCTO_JSP = "/WEB-INF/vistas/producto.jsp";

	private static final long serialVersionUID = 1L;
	long tiempo;
	String theJoker="";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		theJoker = "jajajajaja";
		
		// Producto producto = null;

		if (id != null && !id.equals("")) {

			long l = Long.parseLong(id);

			// producto = ProductosServicioImpl.getInstancia().getById(l);
			
			ProductoServicio servicio = (ProductoServicio) getServletContext().getAttribute("servicioProductos");
			
			// ProductosServicioImpl.getInstancia();

			request.setAttribute("producto", servicio.getById(l));
		}

		// request.setAttribute("producto", producto);
		request.setAttribute("op", id == null ? "alta" : "modificar");
		
		request.getRequestDispatcher(PRODUCTO_JSP).forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf8");
		Long id = 0L;
		String ids = request.getParameter("id");
		String op = request.getParameter("op");
		
		 
		
		
		
		if (ids != null && !ids.equals("")) {
			id = Long.parseLong(ids);
		}
//		System.out.println(tiempo);
//		System.out.println(System.currentTimeMillis());
		
		
		

		if (op == null) {
			
			// request.getRequestDispatcher("/productos").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/productos");
			
			return;
		}
		switch (op) {

		case "alta":
			if(theJoker.equals("")) {
				 request.setAttribute("mensaje", new Mensaje("warning", "Refrescar es peligroso. Encuentro el pasado un lugar inquietante y ansioso"));
				 request.getRequestDispatcher("/productos").forward(request, response);
				return;
			}
			tiempo = System.currentTimeMillis();

			try {
				String nombre = request.getParameter("nombre");
				String descripcion = request.getParameter("descripcion");
				String precio = request.getParameter("precio");

				Producto producto = new Producto(nombre, descripcion, precio);

				if (producto.isError()) {
					request.setAttribute("producto", producto);
				} else {
					producto = ((ProductoServicio) getServletContext().getAttribute("servicioProductos"))
							.insert(producto);

					 request.setAttribute("mensaje", new Mensaje("success", "Registro insertado correctamente con el id " + producto.getId()));
					 request.getRequestDispatcher("/productos").forward(request, response);
					
					 
					 tiempo = System.currentTimeMillis();
					 theJoker ="";
//					request.getSession().setAttribute("mensaje",
//							new Mensaje("success", "Registro insertado correctamente con el id " + producto.getId()));
//
//					response.sendRedirect(request.getContextPath() + "/productos");

					return;
				}
			} catch (Exception e) {
				e.printStackTrace();

				request.setAttribute("mensaje", new Mensaje("danger", "Error al dar de alta el producto"));
			}

			request.getRequestDispatcher(PRODUCTO_JSP).forward(request, response);
			
			break;

		case "modificar":
			if(theJoker.equals("")) {
				 request.setAttribute("mensaje", new Mensaje("warning", "Refrescar es peligroso. Encuentro el pasado un lugar inquietante y ansioso"));
				 request.getRequestDispatcher("/productos").forward(request, response);
				return;
			}

			try {
				String nombre = request.getParameter("nombre");
				String descripcion = request.getParameter("descripcion");
				String precio = request.getParameter("precio");
				
				String nombreViejo = request.getParameter("nombreViejo");
				String descripcionVieja = request.getParameter("descripcionVieja");
				String precioViejo = request.getParameter("precioViejo");
				
				Producto productoViejo = new Producto(id, nombreViejo, descripcionVieja, precioViejo);
				Producto producto = new Producto(id, nombre, descripcion, precio);
				if (producto.isError() || productoViejo.isError()) {
					request.setAttribute("producto", producto);
					
				} else {
					producto = ((ProductoServicio) getServletContext().getAttribute("servicioProductos"))
							.update(producto,productoViejo);

					 request.setAttribute("mensaje",new Mensaje("success", "Registro modificado correctamente con el id " + producto.getId()));
					 request.getRequestDispatcher("/productos").forward(request, response);

//					getServletContext().setAttribute("mensaje",
//							new Mensaje("success", "Registro modificado correctamente con el id " + producto.getId()));
//					response.sendRedirect(request.getContextPath() + "/productos");
					 theJoker ="";
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();

				request.setAttribute("mensaje", new Mensaje("danger", "Error al modificar el producto"));
			}

			request.getRequestDispatcher(PRODUCTO_JSP).forward(request, response);

			break;

		case "borrar":

			try {
				
				
				
				//servicio.delete(id); borrar por id
				//Producto producto = servicio.getById(id); 
				String nombreBorrar = request.getParameter("nombreBorrar");
				String descripcionBorrar = request.getParameter("descripcionBorrar");
				String precioBorrar = request.getParameter("precioBorrar");
				
				Producto producto = new Producto(id,nombreBorrar,descripcionBorrar,precioBorrar);//borrar por objeto
				ProductoServicio servicio = (ProductoServicio) getServletContext().getAttribute("servicioProductos");
				servicio.delete(producto);
				
				 request.setAttribute("mensaje",new Mensaje("success", "Registro borrado correctamente con el id " + id));
				 request.getRequestDispatcher("/productos").forward(request, response);

//				getServletContext().setAttribute("mensaje",
//						new Mensaje("success", "Registro borrado correctamente con el id " + id));
//
//				response.sendRedirect(request.getContextPath() + "/productos");

				return;
				
			} catch (Exception e) {
				e.printStackTrace();

				request.setAttribute("mensaje", new Mensaje("danger", "Error al borrar el producto"));
			}

			 request.getRequestDispatcher("/productos").forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/productos");

			break;
			
		 default:
			 request.setAttribute("mensaje",
						new Mensaje("warning", "No dispongo de la opción: " + op));

				//response.sendRedirect(request.getContextPath() + "/productos");
				request.getRequestDispatcher("/productos").forward(request, response);

				return;

		}
	}

}
