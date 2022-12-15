<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.edutecno.jpacrud.modelo.Estudiante"%>
<%@page import="com.edutecno.jpacrud.VO.EstudianteVO"%>
<%@page import="com.edutecno.jpacrud.VO.RegionVO"%>
<%@page import="com.edutecno.jpacrud.modelo.Region"%>
<%@page import="com.edutecno.jpacrud.VO.RegionVO"%>
<%@page import="com.edutecno.jpacrud.modelo.Region"%>
<%@page import="com.edutecno.jpacrud.controlador.HomeController"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css"
    integrity="sha384-/frq1SRXYH/bSyou/HUp/hib7RVN1TawQYja658FEOodR/FQBKVqT9Ol+Oz3Olq5" crossorigin="anonymous">
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css"
    integrity="sha384-/frq1SRXYH/bSyou/HUp/hib7RVN1TawQYja658FEOodR/FQBKVqT9Ol+Oz3Olq5" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&family=Lobster+Two&family=Open+Sans:wght@300&family=Poppins:wght@200;300;600&family=Roboto:wght@300&display=swap"
    rel="stylesheet">
<link rel="stylesheet" href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="style.css"/>
<title>ESTUDIANTES</title>
</head>
<body>
	<!-- Inicio Header -->
		<nav class="navbar navbar-dark">
	
			<div class="fadeIn first">
				<i class="fa-solid fa-computer"></i></div>
					 <ul class="nav justify-content-end">
   <li class="nav-item"><a class="nav-link active" href="/home">Estudiantes</a></li>
   <li class="nav-item"><a class="nav-link active" href="/tutores">Tutores</a></li>
    <li class="nav-item"><a class="nav-link active" href="/inicio">Inicio</a></li></ul>
	</nav>
	<!-- Fin Header -->
	<!-- Inicio Contenido -->
	<div class="p-3">

		<h3>Agregar Estudiante</h3>
		<c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary  alert-dismissible fade show"
				role="alert">${mensaje}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<form action="agregar" method="post">
			<table>
				<tr>
					<td class="p-2"><label for="id_estudiante">Id:</label></td>
					<td><input class="form-control" type="hidden" name="id"
						placeholder="id_estudiante" /></td>
				</tr>
				<tr>
					<td class="p-2"><label for="rut">Rut:</label></td>
					<td><input class="form-control" type="text" id="rut"
						placeholder="Rut" name="rut" /></td>
				</tr>
				<tr>
					<td class="p-2"><label for="nombre">Nombre:</label></td>
					<td><input class="form-control" type="text" id="nombre"
						placeholder="Nombre" name="nombre" /></td>
				</tr>
				<tr>
				<tr>
					<td class="p-2"><label for="apellido_pat">Apellido
							Paterno:</label></td>
					<td><input class="form-control" type="text" id="apellido_pat"
						placeholder="apellido_pat" name="apellido_pat" /></td>
				</tr>
				<tr>
					<td class="p-2"><label for="apellido_mat">Apellido
							Materno:</label></td>
					<td><input class="form-control" type="text" id="apellido_mat"
						placeholder="apellido_mat" name="apellido_mat" /></td>
				</tr>
				<tr>

					<td class="p-2"><label for="direccion">Direccion:</label></td>
					<td><input class="form-control" type="text" id="direccion"
						placeholder="direccion" name="direccion" /></td>
				</tr>

				<tr>

					<td class="p-2"><label for="codigo_comuna">Codigo Comuna:</label></td>
					<td><input class="form-control" type="text" id="codigo_comuna"
						placeholder="codigo_comuna" name="codigo_comuna" /></td>
				</tr>
				<tr>

					<td class="p-2"><label for="codigo_curso">Codigo Curso:</label></td>
					<td><input class="form-control" type="text" id="codigo_curso"
						placeholder="codigo_curso" name="codigo_curso" /></td>
				</tr>

		<!--  	<td colspan="2">
				<input type="submit" class="btn m-2 btn-secondary" value="Agregar" /></td> -->	
					<td colspan="6">
							<input data-bs-toggle="tooltip" data-bs-placement="top" title="agregado correctamente" type="button" value="Agregar" onclick="submitFormAction('/agregar', 'post')"/>
							<input type="button" value="Eliminar" onclick="deleteRow()"/>
						</td>
					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>