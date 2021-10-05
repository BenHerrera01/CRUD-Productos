package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexion.AdministradorConexion;
import com.desafiolatam. modelo.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;

	
	@Override
	public Categoria buscarCategoria(int id) {
		
		String sql = "SELECT * FROM categoria " + "WHERE id_categoria = ?";
		Categoria categoria = new Categoria();
		
		conn = AdministradorConexion.obtenerConexion();
		
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria;
	}

	@Override
	public List<Categoria> mostrarCategorias() {
		
		String sql = "SELECT * FROM categoria";
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		conn = AdministradorConexion.obtenerConexion();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
				categorias.add(categoria);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categorias;
	}
}
