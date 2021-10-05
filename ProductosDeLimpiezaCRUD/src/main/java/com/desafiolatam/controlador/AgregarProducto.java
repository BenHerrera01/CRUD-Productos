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


@WebServlet("/AgregarProducto")
public class AgregarProducto extends HttpServlet {
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
		List<Categoria> categorias = facade.mostrarCategorias();
		request.setAttribute("categorias", categorias);
		
		request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nombre = request.getParameter("nombre");
		int precio = Integer.parseInt(request.getParameter("precio"));
		String descripcion = request.getParameter("descripcion");
		int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
		
		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		producto.setDescripcion(descripcion);
		producto.setIdCategoria(idCategoria);
		
		String nombreProducto = producto.getNombre();
		request.setAttribute("productoAgregado", nombreProducto);
		
		facade.registrarProducto(producto);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
