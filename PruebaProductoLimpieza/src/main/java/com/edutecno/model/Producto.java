package com.edutecno.model;

public class Producto {
	//atributos
	private int id;
	private String nombre;
	private String descripcion;
	private int precio;
	private int idCategoria;
	
	//Constructor
	public Producto() {
	}

	//constructor(fields)
	public Producto(int id, String nombre, String descripcion, int precio, int idCategoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.idCategoria = idCategoria;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	
	//toString
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", idCategoria=" + idCategoria + "]";
	}
	
	
	 

}
