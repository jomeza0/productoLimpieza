package com.edutecno.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.facade.Facade;
import com.edutecno.model.Producto;

/**
 * Servlet implementation class EliminarProducto
 * resdponsabilidad de recibir el id del producto a eliminar y verificar o comprobar si existe
 */
@WebServlet("/eliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Facade facade = new Facade();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//se obtiene el id que viene como parametro en la url
			int id = Integer.parseInt(request.getParameter("id"));
			
			// se busca el producto a eliminar en la base de datos
			Producto producto = facade.findProductoById(id);
			
			if (producto.getId() != 0 && facade.deleteProducto(producto.getId())) {
				request.getRequestDispatcher("listarProductos").forward(request, response);
			
			} else {
				request.getRequestDispatcher("agregarproducto-error.jsp").forward(request, response);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("agregarproducto-error.jsp").forward(request, response);
		
		}
		
	}// end doGet()

} // end class