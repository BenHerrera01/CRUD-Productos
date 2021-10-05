<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregando Producto</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body>

	<h1>Agregar Producto</h1>
	<form action="/ProductosDeLimpiezaCRUD/AgregarProducto" method="POST">
		<div class="form-group">
		    <label>Nombre</label>
		    <input type="text" class="form-control" id="nombre" name="nombre" required="required">
		</div>
		<div class="form-group">
		    <label>Precio</label>
		    <input type="number" class="form-control" id="precio" name="precio" required="required">
		</div>
		<div class="form-group">
		    <label>Descripcion</label>
		    <input type="text" class="form-control" id="descripcion" name="descripcion" required="required">
		</div>
		<div class="form-group">
		    <label>ID Categoria</label>
		    <select name="idCategoria" id="idCategoria">
		    	<c:forEach items="${categorias}" var="categoria">
		    		<option value="${categoria.getId()}">${categoria.getNombre()}</option>
		    	</c:forEach>
		    </select>
		</div>
	  <button type="submit" class="btn btn-lg btn-secondary">Enviar</button>
	</form>
	<br>
	<a href="/ProductosDeLimpiezaCRUD/Home" class="btn btn-lg btn-secondary">Volver</a>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>