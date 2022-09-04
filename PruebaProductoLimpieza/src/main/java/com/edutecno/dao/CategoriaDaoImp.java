package com.edutecno.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutecno.connection.AdministradorConexion;
import com.edutecno.interfaces.CategoriaDao;
import com.edutecno.model.Categoria;

public class CategoriaDaoImp extends AdministradorConexion implements CategoriaDao {

	public CategoriaDaoImp() {
		conn = generaPoolConexion();
	}

	@Override
	public Categoria findById(int id) {
		Categoria categoria = new Categoria();

		try {
			ps = conn.prepareStatement("SELECT * FROM CATEGORIA WHERE id_categoria=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoria;
	}

	@Override
	public List<Categoria> findAll() {
		List<Categoria> listaCategoria = new ArrayList<Categoria>();

		try {
			ps = conn.prepareStatement("SELECT * FROM CATEGORIA");
			rs = ps.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria();

				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));

				listaCategoria.add(categoria);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return listaCategoria;
	}

}
