<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.edutecno.jpacrud.modelo.Estudiante"%>
<%@page import="com.edutecno.jpacrud.VO.EstudianteVO"%>
<%@page import="com.edutecno.jpacrud.service.*"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="style.css">
<title>ESTUDIANTES </title>

</head>
<body>
	<!-- Inicio Header -->
		<nav class="navbar navbar-dark">
		
			<div class="fadeIn first">
				<i class="fa-solid fa-computer"></i></div>
					 <ul class="nav justify-content-end">
    <li class="nav-item"><a class="nav-link active" href="/home">Estudiantes</a></li>
    <li class="nav-item"><a class="nav-link active" href="/agregarForm">Agregar Estudiate</a></li>
    <li class="nav-item"><a class="nav-link active" href="/inicio">Inicio</a></li></ul>
	</nav>


	<div class="p-3">
		<table border="1" class="table table-hover">
			<h3>Estudiantes</h3>
			<thead class="thead-info">
				<tr>
					<th scope="col">Rut</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido Paterno</th>
					<th scope="col">Apellido Materno</th>
					<th scope="col">Codigo Curso</th>
					<th scope="col">Descripcion Curso</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="estudiantes" items="${VO.estudiantes}">
					<tr>
						<td><c:out value="${estudiantes.rut}" /></td>
						<td><c:out value="${estudiantes.nombre}" /></td>
						<td><c:out value="${estudiantes.apellido_pat}" /></td>
						<td><c:out value="${estudiantes.apellido_mat}" /></td>
						<td><c:out value="${estudiantes.codigo_curso.codigo_curso}" /></td>
						<td><c:out value="${estudiantes.codigo_curso.codigo_plan_formativo.descripcion}" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="home" class="btn btn-secondary">Volver</a>
	</div>

</body>
</html>