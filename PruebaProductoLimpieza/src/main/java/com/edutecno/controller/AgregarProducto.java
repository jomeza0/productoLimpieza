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
 * Servlet implementation class AgregarProducto xcargar las categorias y
 * despachar a la vista de agegar
 */

@WebServlet("/agregarProducto")
public class AgregarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// instancia de facade para acceder al data access object y obtener las
	// categorias
	Facade facade = new Facade();

	// metodo que recibe la peticion para acceder a la pagina de agregar producto
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// se setean la lista de categorias para ser despachados en la vista
		request.setAttribute("categorias", facade.findAllCategorias());

		request.getRequestDispatcher("agregarproducto.jsp").forward(request, response);
		
	}// fin doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// objeto para setear los valores obtenidos del request y se actualizara en la
			// base
			Producto producto = new Producto();
			// se constituye el producto a guardar mediante los valores obtenido del request
			producto.setNombre(request.getParameter("nombre"));
			producto.setDescripcion(request.getParameter("descripcion"));
			producto.setPrecio(Integer.parseInt(request.getParameter("precio")));
			producto.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));

			Producto productoAgregado = facade.addProducto(producto);

			if (productoAgregado.getId() != 0) {

				request.setAttribute("producto", productoAgregado);
				request.getRequestDispatcher("agregarproducto-success.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("agregarproducto-error.jsp").forward(request, response);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.getRequestDispatcher("agregarproducto-error.jsp").forward(request, response);
			
		}
		
	}// fin doPost()

}//fin class
