<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Analisador de Texto</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="css/heroic-features.css" rel="stylesheet">
    
        <!-- Bootstrap Core CSS -->
    <link href="../vendor2/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor2/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../vendor2/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor2/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>


    <!-- Page Content -->
   <div class="container">  
   <input type="submit" onclick="javascript:history.back()" value="Voltar" />
   
    <div class="row">
	<div class="col-lg-6">
	<jsp:include page="title.jsp"></jsp:include>
	<jsp:include page="abstract.jsp"></jsp:include>
	<jsp:include page="section.jsp"></jsp:include>
	</div>

    </div>
	</div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; Instituto Federal de Educação, Ciências e Tecnologia da Bahia - 2017</p>
        </div>
        <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>