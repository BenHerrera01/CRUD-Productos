package com.desafiolatam.dao;

import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;
import com.desafiolatam.modelo.ProductoCategoria;

public class ProductoCategoriaDaoImpl implements ProductoCategoriaDao{
	private ProductoDao productoDao = new ProductoDaoImpl();
	private CategoriaDao categoriaDao = new CategoriaDaoImpl();
	
	@Override
	public List<ProductoCategoria> mostrarProductoCategoria() {

		List<ProductoCategoria> lista = new ArrayList<ProductoCategoria>();
		List<Producto> productos = productoDao.mostrarProductos();
		
		for (Producto producto : productos) {
			Categoria categoria = categoriaDao.buscarCategoria(producto.getIdCategoria());
			
			ProductoCategoria productoCategoria = new ProductoCategoria();
			productoCategoria.setProducto(producto);
			productoCategoria.setCategoria(categoria);
			
			lista.add(productoCategoria);
		}
		return lista;
	}
}
