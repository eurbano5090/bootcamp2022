<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.edutecno.jpacrud.modelo.Estudiante"%>
<%@page import="com.edutecno.jpacrud.VO.EstudianteVO"%>
<%@page import="com.edutecno.jpacrud.VO.TutorVO" %>
<%@page import="com.edutecno.jpacrud.service.*"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />

<title>Tutor </title>

</head>
<body>
	<!-- Inicio Header -->
	<nav class="navbar navbar-dark">
	
			
	</nav>

	<div class="p-3">
		<table border="1" class="table table-hover">
			<h3>Resultados</h3>
			<thead class="thead-info">
				<tr>
					<th scope="col">codigo tutor</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido Paterno</th>
					<th scope="col">Apellido Materno</th>
					<th scope="col">Cargo</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="tutores" items="${Tutor.tutores}">
					<tr>
					<td><c:out value="${tutores.codigo_tutor}" /></td>
						<td><c:out value="${tutores.nombre}" /></td>
						<td><c:out value="${tutores.apellido_pat}" /></td>
						<td><c:out value="${tutores.apellido_mat}" /></td>
						<td><c:out value="${tutores.cargo}" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="tutores" class="btn btn-secondary">Volver</a>
	</div>

</body>
</html>