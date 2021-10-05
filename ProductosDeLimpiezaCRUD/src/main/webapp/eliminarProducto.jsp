<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminando Producto</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body>
	<h1>Eliminar Producto</h1>
	<h4>¿Estás seguro que deseas borrar el producto?</h4>
	<form action="/ProductosDeLimpiezaCRUD/EliminarProducto" method="POST">
		<input type="hidden" name="id" value="${id}">
		<button type="submit" class="btn btn-lg btn-secondary">Si</button>
	</form>
		<br>
		<a href="/ProductosDeLimpiezaCRUD/MostrarProductos" class="btn btn-lg btn-secondary">Volver</a>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>