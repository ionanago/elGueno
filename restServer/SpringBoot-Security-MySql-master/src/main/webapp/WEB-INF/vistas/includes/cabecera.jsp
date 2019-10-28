<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<base href="${pageContext.request.contextPath}/" />

<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/fontawesome-all.min.css" rel="stylesheet" />

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>

<link href="css/estilos.css" rel="stylesheet" />

<head>
<meta charset="UTF-8">
<title>spring login copy and mod</title>
</head>
<body>


	<header>
		<h1>spring login</h1>
	</header>
	<!-- Image and text -->
	<nav class="navbar navbar-dark bg-dark sticky-top">
		<a class="navbar-brand" href="/">spring login</a>
		<c:if test="${httpServletRequest.remoteUser != null} ">
			<form action="/logout" method="post">
				<input type="submit" value="Cerrar Sesion" />
			</form>
		</c:if>
	</nav>

	<main class="container">