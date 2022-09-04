package com.edutecno.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.connection.AdministradorConexion;
import com.edutecno.interfaces.ProductoDao;
import com.edutecno.model.Producto;

public class ProductoDaoImp extends AdministradorConexion implements ProductoDao {

	public ProductoDaoImp() {
		conn = generaPoolConexion();
	}

	@Override
	public Producto findById(int id) {
		Producto producto = new Producto();
		try {
			ps = conn.prepareStatement("SELECT * FROM PRODUCTO WHERE id_producto=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public List<Producto> findAll() {
		List<Producto> listaProductos = new ArrayList<Producto>();

		try {
			ps = conn.prepareStatement("SELECT * FROM PRODUCTO");
			rs = ps.executeQuery();
			while (rs.next()) {
				Producto producto = new Producto();

				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));

				listaProductos.add(producto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProductos;
	}

	@Override
	public Producto add(Producto producto) {
		try {
			ps = conn.prepareStatement("INSERT INTO PRODUCTO VALUES (PRODUCTO_SEC.NEXTVAL,?,?,?,?)");

			ps.setString(1, producto.getNombre());
			ps.setInt(2, producto.getPrecio());
			ps.setString(3, producto.getDescripcion());
			ps.setInt(4, producto.getIdCategoria());

			if (ps.executeUpdate() == 1) {
				producto.setId(findLastId());

			} else {

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.print(e);
		}

		return producto;
	}

	@Override
	public Producto update(Producto producto) {
		try {
			ps = conn.prepareStatement(
					"UPDATE PRODUCTO SET nombre_producto=?, precio_producto=?, descripcion_producto=?, id_categoria=? WHERE id_producto=?");
			ps.setString(1, producto.getNombre());
			ps.setInt(2, producto.getPrecio());
			ps.setString(3, producto.getDescripcion());
			ps.setInt(4, producto.getIdCategoria());
			ps.setInt(5, producto.getId());

			if (ps.executeUpdate() == 1) {
				return producto;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Producto();
	}

	@Override
	public boolean delete(int id) {
		boolean result = true;

		try {
			ps = conn.prepareStatement("DELETE FROM producto WHERE id_producto=?");
			ps.setInt(1, id);

			if (ps.executeUpdate() == 1) {
				return result;

			} else {
				result = false;
				throw new RuntimeException("Ha ocurrido un error al eliminar el producto.");

			}

		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int findLastId() {
		int maxId = -1;

		try {
			ps = conn.prepareStatement("SELECT MAX(id_producto) AS max_id FROM producto");
			rs = ps.executeQuery();

			if (rs.next()) {
				maxId = rs.getInt("max_id");
				return maxId;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxId;
	}

}
