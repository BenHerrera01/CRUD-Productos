<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inicio</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	</head>
<body class="text-center">

	<div class= "card" style="text-align: center;padding:8%;">
		<div style="padding:2%;">
			<h1>Login <i class="bi bi-lock-fill"></i>
			</h1>
		 </div>		
		<form action ="/ProductosDeLimpiezaCRUD/LoginUsuario" method="POST" style="display: inline-block;">
				<input type="text" id="usuario" name="usuario" placeholder="usuario" required="required">
				<input type="password" id="clave" name="clave" placeholder="clave" required="required">
				<button type="submit" class="btn btn-secondary">Iniciar Sesion</button>
		</form>
	</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>