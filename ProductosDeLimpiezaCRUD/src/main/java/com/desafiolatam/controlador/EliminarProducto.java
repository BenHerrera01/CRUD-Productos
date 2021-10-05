package com.desafiolatam.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.facade.Facade;


@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("id"));
		if(id <= 0) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		request.setAttribute("id", id);
		request.getRequestDispatcher("eliminarProducto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		if(id <= 0) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		facade.eliminarProduto(id);
		request.getRequestDispatcher("/MostrarProductos").forward(request, response);
	}
}
