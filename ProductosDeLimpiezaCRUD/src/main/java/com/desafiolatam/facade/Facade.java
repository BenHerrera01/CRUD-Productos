package com.desafiolatam.facade;

import java.util.List;

import com.desafiolatam.dao.CategoriaDao;
import com.desafiolatam.dao.CategoriaDaoImpl;
import com.desafiolatam.dao.LoginDao;
import com.desafiolatam.dao.LoginDaoImpl;
import com.desafiolatam.dao.ProductoCategoriaDao;
import com.desafiolatam.dao.ProductoCategoriaDaoImpl;
import com.desafiolatam.dao.ProductoDao;
import com.desafiolatam.dao.ProductoDaoImpl;
import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Credencial;
import com.desafiolatam.modelo.Producto;
import com.desafiolatam.modelo.ProductoCategoria;

public class Facade {
	public Categoria buscarCategoria(int id) {
		CategoriaDao categoriaDao = new CategoriaDaoImpl();
		return categoriaDao.buscarCategoria(id);
	}
	
	public List<Categoria> mostrarCategorias(){
		CategoriaDao categoriaDao = new CategoriaDaoImpl();
		return categoriaDao.mostrarCategorias();
	}
	
	public Producto buscarProducto(int id) {
		ProductoDao productoDao = new ProductoDaoImpl();
		return productoDao.buscarProducto(id);
	}
	
	public List<Producto> mostrarProductos(){
		ProductoDao productoDao = new ProductoDaoImpl();
		return productoDao.mostrarProductos();
	}
	
	public boolean registrarProducto(Producto producto) {
		ProductoDao productoDao = new ProductoDaoImpl();
		return productoDao.registrarProducto(producto);
	}
	
	public boolean modificarProducto(Producto producto) {
		ProductoDao productoDao = new ProductoDaoImpl();
		return productoDao.modificarProducto(producto);
	}
	
	public boolean eliminarProduto(int id) {
		ProductoDao productoDao = new ProductoDaoImpl();
		return productoDao.eliminarProduto(id);
	}
	
	public List<ProductoCategoria> mostrarProductoCategoria(){
		ProductoCategoriaDao productoCategoriaDao = new ProductoCategoriaDaoImpl();
		return productoCategoriaDao.mostrarProductoCategoria();
	}
	
	public Credencial obtenerCredenciales(String usuario, String clave) {
		LoginDao loginDao = new LoginDaoImpl();
		return loginDao.obtenerCredenciales(usuario, clave);
	}
	
}
