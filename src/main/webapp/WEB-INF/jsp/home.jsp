<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
  <link href="https://fonts.googleapis.com/css2?family=Lobster&family=Lobster+Two&family=Open+Sans:wght@300&family=Poppins:wght@200;300;600&family=Roboto:wght@300&display=swap"
    rel="stylesheet">
<link rel="stylesheet" href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="style.css"/>
<title>ESTUDIANTES </title>

</head>
<body>
	<!-- Inicio Header -->
	
      		<nav class="navbar navbar-dark">
		
			<div class="fadeIn first">
			<i class="fa-solid fa-computer"></i></div>
	<ul class="nav justify-content-end">
	<li class="nav-item"><a class="nav-link active" href="/home">Estudiantes</a></li>
    <li class="nav-item"><a class="nav-link active" href="/agregarForm">Agregar Estudiante</a></li>
    <li class="nav-item"><a class="nav-link active" href="/tutores">Tutores</a></li>
    <li class="nav-item"><a class="nav-link active" href="/inicio">Inicio</a></li></ul>
	</nav>

       </nav>
	
	</nav>
         
         
		<aside>
			<c:if test="${mensaje != null ? true : false}">
				<div class="alert alert-secondary  alert-dismissible fade show"
					role="alert">${mensaje}
					<button type="button" class="close" data-dismiss="alert"aria-label="Close">
					<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
			
			
			<form action="buscar" method="post">
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
						<!-- <td><c:out value="${estudiantes.id_estudiante}" /></td> -->
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
	
	</div>


</body>
</html>
