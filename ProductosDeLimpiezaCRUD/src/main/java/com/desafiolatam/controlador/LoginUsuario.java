package com.desafiolatam.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.Credencial;

@WebServlet("/LoginUsuario")
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Facade facade = new Facade();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Credencial credencial = new Credencial();
		String requestUsuario = "";
		String requestPass = "";
		
		PrintWriter out = response.getWriter();

		requestUsuario = request.getParameter("usuario");
		requestPass = request.getParameter("clave");

		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		Cookie cookie = new Cookie("hora", dateFormat.format(date));
		cookie.setMaxAge(9000);
		cookie.setComment("Se guarda nombre de usuario logueado");
		response.addCookie(cookie);
		
		credencial = facade.obtenerCredenciales(requestUsuario, requestPass);
		
		if(!credencial.getUsuario().contentEquals(requestUsuario) || !credencial.getClave().contentEquals(requestPass)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Usuario o password incorrecto');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}else{
			HttpSession sesionUsuario= request.getSession(true);
			sesionUsuario.setMaxInactiveInterval(600);
			sesionUsuario.setAttribute("logueado", requestUsuario);
			request.getRequestDispatcher("index.jsp").forward(request, response); 
		}
	}

}
