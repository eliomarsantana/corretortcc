<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Analisador de Texto</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/heroic-features.css" rel="stylesheet">

</head>

<body>

	<SCRIPT language=JavaScript>
		/*function validar(formulario) {
			if (formulario.arquivo.value == '') {
				alert('POR FAVOR, ESCOLHA UM ARQUIVO!');
				formulario.arquivo.focus();
				return false;
			}
			return true;
		}*/
		function duplicarCampos() {
			var clone = document.getElementById('origem').cloneNode(true);
			var destino = document.getElementById('destino');
			destino.appendChild(clone);
			var camposClonados = clone.getElementsByTagName('input');
			for (i = 0; i < camposClonados.length; i++) {
				camposClonados[i].value = '';
			}
		}
		function removerCampos(id) {
			var node1 = document.getElementById('destino');
			node1.removeChild(node1.childNodes[0]);
		}
	</SCRIPT>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarResponsive" aria-controls="navbarResponsive"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav ml-auto">

		</ul>
	</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		<form action="ProcessFile" method="POST"
			onSubmit="return (validar(this))" enctype="multipart/form-data">
			<!-- Jumbotron Header -->
			<header class="jumbotron my-4">
			<p class="lead">Faça aqui o Upload do ".tex"</p>
			<div id="origem">
				<tr>
					<th><input name="arquivo" type="file" id="arquivo"
						value="arquivo" /></th>
					<th><img src="img/botaomais.png" style="cursor: pointer;"
						onclick="duplicarCampos();"></th>
					<th><img src="img/botaomenos.png" style="cursor: pointer;"
						onclick="removerCampos(this);"></th>
				</tr>

				<br>
			</div>
			<div id="destino"></div>
			<input type="submit" class="btn btn-primary btn-large" value="Upload" />
			</header>
		</form>
		<!-- Page Features -->
		<div class="row text-center">
		</div>
		<!-- /.row -->

	</div>

	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Instituto
			Federal de Educação, Ciências e Tecnologia da Bahia - 2017</p>
	</div>
	<!-- /.container --> </footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>