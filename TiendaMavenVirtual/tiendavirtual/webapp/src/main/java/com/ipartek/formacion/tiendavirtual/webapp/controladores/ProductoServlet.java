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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		// Producto producto = null;

		if (id != null && id != "") {
			
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
		Long id=0L;
		String ids = request.getParameter("id");
		String op = request.getParameter("op");
		if (ids != null && ids != "") {
		   id = Long.parseLong(ids);
		}
		
		if (op == null) {
			request.getRequestDispatcher("/productos").forward(request, response);
			return;
		}
		switch (op) {
		
		

		case "alta":
			
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

					request.setAttribute("mensaje",
							new Mensaje("success", "Registro insertado correctamente con el id " + producto.getId()));
					request.getRequestDispatcher("/productos").forward(request, response);

					return;
				}
			} catch (Exception e) {
				e.printStackTrace();

				request.setAttribute("mensaje", new Mensaje("danger", "Error al dar de alta el producto"));
			}

			request.getRequestDispatcher(PRODUCTO_JSP).forward(request, response);
			break;
			
			
		case "modificar":
			
			try {
				String nombre = request.getParameter("nombre");
				String descripcion = request.getParameter("descripcion");
				String precio = request.getParameter("precio");

				Producto producto = new Producto(id,nombre, descripcion, precio);
				if (producto.isError()) {
					request.setAttribute("producto", producto);
				} else {
					producto = ((ProductoServicio) getServletContext().getAttribute("servicioProductos"))
							.update(producto);

					request.setAttribute("mensaje",
							new Mensaje("success", "Registro modificado correctamente con el id " + producto.getId()));
					request.getRequestDispatcher("/productos").forward(request, response);

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
				ProductoServicio servicio = (ProductoServicio) getServletContext().getAttribute("servicioProductos"); 
				servicio.delete(id);
				request.setAttribute("mensaje",
						new Mensaje("success", "Registro borrado correctamente con el id " + id));
				request.getRequestDispatcher("/productos").forward(request, response);
			}
			catch (Exception e) {
				e.printStackTrace();

				request.setAttribute("mensaje", new Mensaje("danger", "Error al borrar el producto"));
			}

			//request.getRequestDispatcher("/productos").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/productos");

			break;
			
			
		}
	}

}
