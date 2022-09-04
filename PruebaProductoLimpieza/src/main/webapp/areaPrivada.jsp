<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- BOOTSTRAP CSS -->
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<title>Area Privada</title>
</head>
<body>

<!-- scriplet para obtener datos del request -->
	<%
		HttpSession sessionRequest = request.getSession();//se obtiene sesion
		String nombre = (String)sessionRequest.getAttribute("requestLogin");//se obtiene los atributos seteados en la sesion
		request.setAttribute("cookies", request.getCookies());
	%>

	<!-- BARRA DE NAVEGACION  -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container">
	    <a class="navbar-brand" href="#">Productos</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav ms-auto">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Usuario: <%=nombre %></a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="listarProductos">Listar Productos</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="agregarProducto">Agregar Producto</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="logout">Logout</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<!-- SECCION VALORES DESPLEGADOS  -->
	<section class="container mt-5 text-center">
		<h1>Bienvenido</h1>
		<p>Se ha conectado de manera correcta.</p>
	</section>
	
	<!-- FOOTER  -->
	<footer
		class="container-fluid text-center bg-dark text-white py-4 fixed-bottom">
		<h1>Productos</h1>
		<a href="" class="text-white">web site developed by FS-0003 <i class="far fa-registered"></i>
		</a>
	</footer>
	
	
<!-- BOOTSTRAP POPPER -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<!-- BOOTSTRAP JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
</body>
</html>