package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.desafiolatam.conexion.AdministradorConexion;
import com.desafiolatam.modelo.Credencial;

public class LoginDaoImpl implements LoginDao{
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	@Override
	public Credencial obtenerCredenciales(String usuario, String clave) {
		
		String sql = "SELECT * FROM credenciales " + "WHERE usuario = ? and clave = ?";
		Credencial credencial = new Credencial();
		
		conn = AdministradorConexion.obtenerConexion();

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, clave);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				credencial.setUsuario(rs.getString("usuario"));
				credencial.setClave(rs.getString("clave"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(credencial.getUsuario()==null) {
			credencial.setUsuario("no encontrado");
		}
		if(credencial.getClave()==null) {
			credencial.setClave("no encontrado");
		}
		return credencial;
	}

}
