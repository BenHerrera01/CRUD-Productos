package com.desafiolatam.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;


@WebServlet("/EditarProducto")
public class EditarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Facade facade = new Facade();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misesion = request.getSession();
		String nombreSesion;
		nombreSesion = (String) misesion.getAttribute("logueado");
		if (nombreSesion == null) {
			response.sendRedirect("login.jsp");
			return; 
		}
		int id = Integer.parseInt(request.getParameter("idProducto"));
		
		if(id <= 0) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		Producto producto = facade.buscarProducto(id); 
		
		if(producto.getId() == 0) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		List<Categoria> categorias = facade.mostrarCategorias();
		request.setAttribute("categorias", categorias);
		request.setAttribute("producto", producto);
		request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("idProducto"));
		String nombre = request.getParameter("nombre");
		int precio = Integer.parseInt(request.getParameter("precio"));
		String descripcion = request.getParameter("descripcion");
		int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
		
		if(idCategoria <= 0) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		Producto producto = new Producto();
		producto.setId(id);
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		producto.setDescripcion(descripcion);
		producto.setIdCategoria(idCategoria);
		
		facade.modificarProducto(producto);
				
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
