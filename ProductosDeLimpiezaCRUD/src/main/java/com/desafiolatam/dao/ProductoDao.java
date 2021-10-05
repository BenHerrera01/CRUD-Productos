package com.desafiolatam.dao;

import java.util.List;

import com.desafiolatam.modelo.Producto;

public interface ProductoDao {
	public Producto buscarProducto(int id);
	public List<Producto> mostrarProductos();
	public boolean registrarProducto(Producto producto);
	public boolean modificarProducto(Producto producto);
	public boolean eliminarProduto(int id);
}
