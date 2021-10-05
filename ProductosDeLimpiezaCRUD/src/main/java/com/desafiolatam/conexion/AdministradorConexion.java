package com.desafiolatam.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorConexion {
	private static Connection conn;
	private static final String usr = "productos_admin";
	private static final String pwd = "1234";
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	
	private AdministradorConexion() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,usr,pwd);
			System.out.println("se genera conexi�n");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection obtenerConexion() {
		if(conn == null) {
			new AdministradorConexion();
		}
		return conn;
	}
}
