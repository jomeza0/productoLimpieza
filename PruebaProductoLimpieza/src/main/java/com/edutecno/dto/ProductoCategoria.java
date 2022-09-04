package com.edutecno.dto;

import com.edutecno.model.Categoria;
import com.edutecno.model.Producto;

public class ProductoCategoria {

	private Producto producto;
	private Categoria categoria;
	
	public ProductoCategoria() {
		
	}

	public ProductoCategoria(Producto producto, Categoria categoria) {
		super();
		this.producto = producto;
		this.categoria = categoria;
	}



	// getters and setters
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// toString()
	@Override
	public String toString() {
		return "ProductoCategoria [producto=" + producto + ", categoria=" + categoria + "]";
	}

}
