package com.edutecno.interfaces;

import java.util.List;

import com.edutecno.model.Categoria;

public interface CategoriaDao {
	
	public Categoria findById(int id);
	public List<Categoria> findAll();

}
