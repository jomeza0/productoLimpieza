package com.edutecno.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.facade.Facade;
import com.edutecno.model.Categoria;
import com.edutecno.model.Producto;

/**
 * Servlet implementation class ModificarProducto responsabilidad de recibir el
 * id del producto a modificar y consultarlo y comprobar si existe
 */

@WebServlet("/modificarProducto")
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Facade facade = new Facade();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// captura del parametro en la url
			int id = Integer.parseInt(request.getParameter("id"));

			Producto producto = facade.findProductoById(id);
			List<Categoria> listaCategorias = facade.findAllCategorias();

			if (producto.getId() != 0 && !listaCategorias.isEmpty()) {

				request.setAttribute("producto", producto);
				request.setAttribute("categorias", listaCategorias);
				request.getRequestDispatcher("modificarproducto.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("agregarproducto-error.jsp").forward(request, response);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("agregarproducto-error.jsp").forward(request, response);

		}

	}//fin doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// recibir todos los valores enviados desde el formulario de modificar producto
			Producto producto = new Producto();
			producto.setId(Integer.parseInt(request.getParameter("id")));
			producto.setNombre(request.getParameter("nombre"));
			producto.setDescripcion(request.getParameter("descripcion"));
			producto.setPrecio(Integer.parseInt(request.getParameter("precio")));
			producto.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));

			Producto productoModificado = facade.updateProducto(producto);

			if (productoModificado.getId() != 0) {
				request.setAttribute("producto", productoModificado);
				request.getRequestDispatcher("agregarproducto-success.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("agregarproducto-error.jsp").forward(request, response);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("agregarproducto-error.jsp").forward(request, response);

		}
		
	}//fin doPost()

}// Fin Class
