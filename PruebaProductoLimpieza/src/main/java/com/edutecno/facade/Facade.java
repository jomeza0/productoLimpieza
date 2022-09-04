package com.edutecno.facade;

import java.util.List;

import com.edutecno.dao.CategoriaDaoImp;
import com.edutecno.dao.ProductoCategoriaDaoImp;
import com.edutecno.dao.ProductoDaoImp;
import com.edutecno.dto.ProductoCategoria;
import com.edutecno.interfaces.CategoriaDao;
import com.edutecno.interfaces.ProductoCategoriaDao;
import com.edutecno.interfaces.ProductoDao;
import com.edutecno.model.Categoria;
import com.edutecno.model.Producto;

public class Facade {
	
	//establecer los metodos que se encuentraan en el data acces object y que acceden a travwes de la interfaz
	
	
	//instancias para acceder a los data access objct a traves de la interfaz
	private ProductoDao productoDao = new ProductoDaoImp();
	private CategoriaDao categoriaDao = new CategoriaDaoImp();
	private ProductoCategoriaDao productoCategoriaDao = new ProductoCategoriaDaoImp();
		
	
	//metodos de acceso para DAO producto Dao
	public Producto findProductoById(int id) {
		return productoDao.findById(id);
	}
	

	
	public List<Producto> findAllProductos() {
		return productoDao.findAll();
	}

	public Producto addProducto(Producto producto) {
		return productoDao.add(producto);
	}

	public Producto updateProducto(Producto producto) {
		return productoDao.update(producto);
	}

	public boolean deleteProducto(int id) {
		return productoDao.delete(id);
	}

	public int findProductoLastId() {
		return productoDao.findLastId();
	}
	
	//metodos de acceso para DAO categoria dao
	public Categoria findCategoriaById(int id) {
		return categoriaDao.findById(id);
	}
	public List<Categoria> findAllCategorias() {
		return categoriaDao.findAll();
	}
	
	//metodos de acceso para DAO productocategoriaDao	
	public List<ProductoCategoria> findAllProductoCategoria() {
		return productoCategoriaDao.findAll();
	}


}
