<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.edutecno.jpacrud.VO.TutorVO"%>
<%@page import="com.edutecno.jpacrud.controlador.TutorController"%>
<%@page import="com.edutecno.jpacrud.controlador.HomeController"%>
<%@page import="com.edutecno.jpacrud.modelo.Estudiante"%>
<%@page import="com.edutecno.jpacrud.VO.EstudianteVO"%>
<%@page import="com.edutecno.jpacrud.VO.RegionVO"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css"
    integrity="sha384-/frq1SRXYH/bSyou/HUp/hib7RVN1TawQYja658FEOodR/FQBKVqT9Ol+Oz3Olq5" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&family=Lobster+Two&family=Open+Sans:wght@300&family=Poppins:wght@200;300;600&family=Roboto:wght@300&display=swap"
    rel="stylesheet">
<link rel="stylesheet" href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="style.css"/>
<title>TUTORES </title>

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
			
			
			<form action="buscarTutor" method="post">
				<table>
				<tr>
					<td class="p-2">
						<label for="cars">Region:</label>
					</td>
						<td class="p-2">
						<label for="cars">Curso:</label>
					</td>
				</tr>
				  <ul class="pagination pagination-lg justify-content-center m-2">
             <c:forEach items="${paginas}" var="pagina">
            <li class="page-item ${paginaActual == pagina ? 'disabled' : ''}">
                <a class="page-link" href="home?p=${pagina}"tabindex="-1">${pagina} </a>
            </li>
        </c:forEach>
    </ul>
    	
				<tr>
					<td class="p-2">
						<select name="cod_region">  
							<option value="0">Elija una region</option>  
						  	<c:forEach var="elemento" items="${Region.regiones}">  
						    	<option value="${elemento.codigo_region}">${elemento.nombre}</option>  
						  </c:forEach>  
						</select>
						
					</td>
				
					<td class="p-2">
						<select name="cod_curso">  
							<option value="0">Elija una curso</option>  
						 	 <c:forEach var="elemento" items="${Curso.cursos}">  
						    	<option value="${elemento.codigo_curso}">${elemento.codigo_curso}</option>  
						  	</c:forEach>  
						</select>
						</td>
					</tr>
			</table>
				
				<input type="submit"class="btn m-2 btn-secondary" value="Busqueda" />
	
			</form>


		</aside>
		<table border="1" class="table table-hover">
			<thead class="thead-info">
				<tr>
					<th scope="col">codigo tutor</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido Paterno</th>
					<th scope="col">Apellido Materno</th>
					<th scope="col">Cargo</th>
					<th scope="col">Comuna</th>
					<th scope="col">Region</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tutores" items="${VO}">
					<tr>
						<td><c:out value="${tutores.codigo_tutor}" /></td>
						<td><c:out value="${tutores.nombre}" /></td>
						<td><c:out value="${tutores.apellido_pat}" /></td>
						<td><c:out value="${tutores.apellido_mat}" /></td>
						<td><c:out value="${tutores.cargo}" /></td>
						<td><c:out value="${tutores.codigo_comuna.nombre}" /></td>
						<td><c:out value="${tutores.codigo_comuna.codigo_region.nombre}" /></td>
						

		</tr>
			
				</c:forEach>
			
				<td class="p-2">
						
						</td>
					</tr>
			</table>
				
				
			</tbody>
		</table>
	
	</div>


</body>
</html>
