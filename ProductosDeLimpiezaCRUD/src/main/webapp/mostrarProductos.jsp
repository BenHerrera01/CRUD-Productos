<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrando productos</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

</head>
<body>
	<h1>Lista de Productos</h1>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>ID PRODUCTO</th>
				<th>NOMBRE</th>
				<th>PRECIO</th>
				<th>DESCRIPCION</th>
				<th>CATEGORIA</th>
				<th>ACCION</th>
			</tr>
		</thead>
		<c:forEach items="${productos}" var="elemento">
			<tr>
				<td>${elemento.getProducto().getId()}</td>
				<td>${elemento.getProducto().getNombre()}</td>
				<td>${elemento.getProducto().getPrecio()}</td>
				<td>${elemento.getProducto().getDescripcion()}</td>
				<td>${elemento.getCategoria().getNombre()}</td>
				<td>
					<a href="/ProductosDeLimpiezaCRUD/EditarProducto?idProducto=${elemento.getProducto().getId()}" class="btn btn-lg btn-secondary"><i class="bi bi-pencil"></i></a>
					<a href="/ProductosDeLimpiezaCRUD/EliminarProducto?id=${elemento.getProducto().getId()}" class="btn btn-lg btn-secondary"><i class="bi bi-trash"></i></a>
				</td>				
			</tr>
		</c:forEach>
	</table>
	<a href="/ProductosDeLimpiezaCRUD/Home" class="btn btn-lg btn-secondary">Volver</a>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>