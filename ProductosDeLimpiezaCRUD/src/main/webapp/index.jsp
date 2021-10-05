<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inicio</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">

    <link href="https://getbootstrap.com/docs/4.6/examples/cover/cover.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	</head>
<body class="text-center">
	
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column ">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="text-center">Productos de Limpieza</h3>
				<a href="/ProductosDeLimpiezaCRUD/Deslogueo" class="btn btn-secondary btn-sm">Cerrar Sesión</a>
				<nav class="nav nav-masthead justify-content-center">
		
				</nav>
			</div>
		</header>
		
		<main role="main" class="inner cover">
			<h1 class="cover-heading">Menú de productos de limpieza</h1>
			<p>Hora de inicio <c:out value="${cookie['hora'].getValue()}"/> </p>
			<br><br><br>
			<p>
				<a href="/ProductosDeLimpiezaCRUD/AgregarProducto" class="btn btn-lg btn-secondary">Agregar Producto</a>
			</p>
			<p>
				<a href="/ProductosDeLimpiezaCRUD/MostrarProductos" class="btn btn-lg btn-secondary">Mostrar Productos</a>
			</p>
		</main>

		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>
					Página de Inicio
				</p>
			</div>
		</footer>
	</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>