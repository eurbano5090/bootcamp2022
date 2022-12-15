<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css" integrity="sha384-/frq1SRXYH/bSyou/HUp/hib7RVN1TawQYja658FEOodR/FQBKVqT9Ol+Oz3Olq5" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&family=Lobster+Two&family=Open+Sans:wght@300&family=Poppins:wght@200;300;600&family=Roboto:wght@300&display=swap"
    rel="stylesheet">
<link rel="stylesheet" href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="style.css"/>
<title>Insert title here</title>
</head>
<body>
 		<nav class="navbar navbar-dark">
		
			<div class="fadeIn first">
				<i class="fa-solid fa-computer"></i></div>
					 <ul class="nav justify-content-end">
   <li class="nav-item"><a class="nav-link active" href="/tutores">Tutores</a></li>
   </ul></nav>
	<!-- Inicio Contenido -->
	<div class="p-3">

		<h3>Login</h3>
		<c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary  alert-dismissible fade show"
				role="alert">${mensaje}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<form action="/login" method="post">
			<table>
				<tr>
					<td class="p-2"><label for="nombre">Nombre:</label></td>
					<td><input class="form-control" type="text" name="nombre"
						placeholder="nombre" /></td>
				</tr>
				<tr>
					<td class="p-2"><label for="clave">Clave:</label></td>
					<td><input class="form-control" type="password"
						placeholder="password" name="clave" /></td>
				</tr>
			
				<tr>
					<td colspan="2"><input type="submit"
						class="btn m-2 btn-success" value="login" /></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>