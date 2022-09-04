package com.edutecno.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//clase para realizar la conexion a la base de datos con sus respectivos metodos y atributos
public class AdministradorConexion {

	protected static Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;

	// metodo que generara una conexion mediante JDBC clasica
	protected Connection generaConexion() {

		if (conn == null) {// si conexion es igual a null
			try {
				// clase del driver a utilizar para la conexion
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "EDUTECNO", "admin");
				System.out.println("Conexi�n generada con generaConexion()");

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return conn;

	}// fin Connection generaConexion()

	// metodo que generara una conexion mediante singleton referenciando un recurso
	protected Connection generaPoolConexion() {

		Context initContext;// variable declarada con la que se ubicara el recurso mediante el archivo
							// context.xml del servidor

		if (conn == null) {// verificando si la conexion es nula o no esta instanciada solo declarada
			try {
				initContext = new InitialContext();// instancia para acceder a la ruta donde se ubica el recurso
				DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/ConexionOracle");
				conn = ds.getConnection();
				System.out.println("conexi�n establecida con generaPoolConexion()");

			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		return conn;

	}// fin generaPoolConexion()

}// Fin class
