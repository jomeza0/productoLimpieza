package com.edutecno.interfaces;

import java.util.List;

import com.edutecno.model.Producto;

public interface ProductoDao {

	// metodos
	public Producto findById(int id);

	public List<Producto> findAll();

	public Producto add(Producto producto);

	public Producto update(Producto producto);

	public boolean delete(int id);

	public int findLastId();

}
