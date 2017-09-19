<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		function validar(formulario) {
			if (formulario.arquivo.value == '') {
				alert('POR FAVOR, ESCOLHA UM ARQUIVO!');
				formulario.arquivo.focus();
				return false;
			}
			return true;
		}

		$(document)
				.ready(
						function() {
							var max_fields = 10; //maximum input boxes allowed
							var wrapper = $(".input_fields_wrap"); //Fields wrapper
							var add_button = $(".add_field_button"); //Add button ID

							var x = 1; //initlal text box count
							$(add_button)
									.click(
											function(e) { //on add input button click
												e.preventDefault();

												if (x < max_fields) { //max input box allowed
													x++; //text box increment
													$(wrapper)
															.append(
																	'<div><input type="file" /><a href="#" class="remove_field">Remove</a></div>'); //add input box
												}
												//Fazendo com que cada uma escreva seu name
												replaceName();
											});

							$(wrapper).on("click", ".remove_field",
									function(e) { //user click on remove text
										e.preventDefault();
										$(this).parent('div').remove();
										x--;
										replaceName();
									})

							function replaceName() {
								wrapper
										.find("input:file")
										.each(
												function() {
													$(this)
															.attr(
																	'name',
																	"arquivo"
																			+ (+$(
																					this)
																					.index(
																							"input:file") + 1));
													$(this)
															.val(
																	$(this)
																			.attr(
																					'name'))
												});
							}
						});
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
			<p class="lead">Faça aqui o Upload do "main.tex"</p>
			<input name="arquivo" type="file" id="arquivo" value="arquivo" />
			<!-- <input name="arquivo2" type="file" id="arquivo2" value="arquivo2" />-->
			<br>
			<br>
			<input type="submit" class="btn btn-primary btn-large" value="Upload" />
			</header>	
		</form>
		<!-- Page Features -->
		<div class="row text-center"></div>
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