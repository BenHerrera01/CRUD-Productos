package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexion.AdministradorConexion;
import com.desafiolatam.modelo.Producto;

public class ProductoDaoImpl implements ProductoDao{
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;

	@Override
	public Producto buscarProducto(int id) {
		
		String sql = "SELECT * FROM producto WHERE id_producto = ?";
		Producto producto = new Producto();
		
		conn = AdministradorConexion.obtenerConexion();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return producto;
	}

	@Override
	public List<Producto> mostrarProductos() {
		
		String sql = "SELECT * FROM producto";
		List<Producto> productos = new ArrayList<Producto>();
		
		conn = AdministradorConexion.obtenerConexion();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				productos.add(producto);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productos;
	}

	@Override
	public boolean registrarProducto(Producto producto) {
		
		String sql = "INSERT INTO producto (nombre_producto,precio_producto,descripcion_producto,id_categoria) " + "VALUES (?,?,?,?)";
		
		conn = AdministradorConexion.obtenerConexion();
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, producto.getNombre());
			pstm.setInt(2, producto.getPrecio());
			pstm.setString(3, producto.getDescripcion());
			pstm.setInt(4, producto.getIdCategoria());
			
			int resultado = pstm.executeUpdate();
			
			if(resultado == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return false;
	}

	@Override
	public boolean modificarProducto(Producto producto) {
		
		String sql = "UPDATE producto SET nombre_producto = ?, precio_producto = ?, descripcion_producto = ?, id_categoria = ? "
				+ "WHERE id_producto = ?";
		
		conn = AdministradorConexion.obtenerConexion();
		
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, producto.getNombre());
			pstm.setInt(2, producto.getPrecio());
			pstm.setString(3, producto.getDescripcion());
			pstm.setInt(4, producto.getIdCategoria());
			pstm.setInt(5, producto.getId());
			
			int resultado = pstm.executeUpdate();
			if(resultado == 1) {
				return true;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return false;
	}

	@Override
	public boolean eliminarProduto(int id) {
		
		String sql = "DELETE FROM producto WHERE id_producto = ?";
		
		conn = AdministradorConexion.obtenerConexion();
		
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			int resultado = pstm.executeUpdate();
			if(resultado == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
