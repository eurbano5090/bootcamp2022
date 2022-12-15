<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.edutecno.jpacrud.modelo.Estudiante"%>
<%@page import="com.edutecno.jpacrud.VO.EstudianteVO"%>
<%@page import="com.edutecno.jpacrud.VO.RegionVO"%>
<%@page import="com.edutecno.jpacrud.modelo.Region"%>
<%@page import="com.edutecno.jpacrud.VO.CursoVO"%>

<%@page import="com.edutecno.jpacrud.controlador.CursoController"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css"
    integrity="sha384-/frq1SRXYH/bSyou/HUp/hib7RVN1TawQYja658FEOodR/FQBKVqT9Ol+Oz3Olq5" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&family=Lobster+Two&family=Open+Sans:wght@300&family=Poppins:wght@200;300;600&family=Roboto:wght@300&display=swap"
    rel="stylesheet">
<link rel="stylesheet" href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="style.css"/>
<title>cursos</title>
</head>
<body>
	<nav class="navbar navbar-dark">
		
			<div class="fadeIn first">
				<i class="fa-solid fa-computer"></i></div>
					 <ul class="nav justify-content-end">
	<li class="nav-item"><a class="nav-link active" href="/home">Estudiantes</a></li>
    <li class="nav-item"><a class="nav-link active" href="/agregarForm">Agregar Estudiante</a></li>
   <li class="nav-item"><a class="nav-link active" href="/tutores">Tutores</a></li>
    <li class="nav-item"><a class="nav-link active" href="/inicio">Inicio</a></li></ul>
	</nav>
	<aside>
			<c:if test="${mensaje != null ? true : false}">
				<div class="alert alert-secondary  alert-dismissible fade show"
					role="alert">${mensaje}
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
	</aside>
	<table border="1" class="table table-hover">
			<thead class="thead-info">
				<tr>
					<th scope="col">nombre comuna</th>
					<th scope="col">fecha de inicio</th>
					<th scope="col">fecha de termino</th>
					<th scope="col">Codigo Curso</th>
					<th scope="col">Descripcion Curso</th>
					<th scope="col">Duracion Curso</th>
				</tr>
			</thead>
				<tbody>
				<c:forEach var="elemento" items="${Curso.cursos}">
					<tr>
						<!-- <td><c:out value="${estudiantes.id_estudiante}" /></td> -->
						<td><c:out value="${elemento.codigo_comuna.nombre}" /></td>
						<td><c:out value="${elemento.fecha_inicio}" /></td>
						<td><c:out value="${elemento.fecha_termno}" /></td>
						<td><c:out value="${elemento.codigo_curso}" /></td>
				 	<td><c:out value="${elemento.codigo_plan_formativo.descripcion}" /></td> 	
					<td><c:out value="${elemento.codigo_plan_formativo.duracion_horas}" /></td> 	      


					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>