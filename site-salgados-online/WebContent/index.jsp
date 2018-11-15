<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<title>JJ - Doces e Salgados</title>
	<!-- Bootstrap -->
	<link href="./resources/boostrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="./resources/css/index-style.css" rel="stylesheet">
</head>
<body>
	<header>
		<jsp:include page="menu_top.jsp" />
	</header>
	
	<section id="Carousel">
		<div id="myCarousel" class="carousel slide"" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		    <li data-target="#myCarousel" data-slide-to="1"></li>
		  </ol>
		
		  <!-- Wrapper for slides -->
		  <div class="carousel-inner">
		    <div class="item active">
		      <img src="./resources/midia/banner1.jpg" alt="Banner 1">
		    </div>
		
		    <div class="item">
		      <img src="./resources/midia/banner2.jpg" alt="Banner 2">
		    </div>
		  </div>
		
		  <!-- Left and right controls -->
		  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#myCarousel" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
	</section>

	<section id="Galeria">
		<div class="container-fluid">
			<div class="row">
		 		<img class="imgBanner img1" src="./resources/midia/banner1.jpg" alt="Banner 1">
		 		<br>
		 		<img class="imgBanner img2" src="./resources/midia/banner2.jpg" alt="Banner 1">
		 	</div>
		</div>		
	</section>

	<footer class="section section-primary">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center ">
					<h1>JJ Doces e Salgados</h1>
					<p>
						&nbsp;<br>Endereço: Rua Fulano de Tal,
						5000<br>São José - Santa Catarina
					</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) Junto com bootstrap tem ficar no fim-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="./resources/boostrap/js/bootstrap.min.js"></script>
	<script src="./resources/js/inicio-script.js"></script>
</body>
</html>
