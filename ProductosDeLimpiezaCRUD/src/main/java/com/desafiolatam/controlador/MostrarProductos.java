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
import com.desafiolatam.modelo.ProductoCategoria;

/**
 * Servlet implementation class MostrarProductos
 */
@WebServlet("/MostrarProductos")
public class MostrarProductos extends HttpServlet {
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
		List<ProductoCategoria> lista = facade.mostrarProductoCategoria();
		request.setAttribute("productos", lista);
		request.getRequestDispatcher("mostrarProductos.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
