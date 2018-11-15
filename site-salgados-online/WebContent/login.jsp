<%@page import="site.jjsaldados.Usuario"%>
<%@page import="site.jjsaldados.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>JJ Doces e Salgados - Login</title>

	<!-- Bootstrap -->
	<link href="./resources/boostrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="./resources/css/login-style.css" rel="stylesheet">
</head>
<body>
	<section>
		<jsp:include page="menu_top.jsp" />
	</section>	
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-5 col-md-5 col-lg-5" id="divLogin">
					<h2 class="text-center">Entrar</h2>
					<form class="" action="" method="post">
						<!--o for é utilizado para o id-->
						<div class="form-group">
							<label for="email">E-mail</label>
							<input type="email" class="form-control" id="email" name="lEmail" required>
						</div>
		
						<div class="form-group">
							<label for="pwd">Senha</label>
							<input type="password" class="form-control" id="pwd" name="lSenha" required>
						</div>
		
						<div class="form-group">
							<input type="checkbox" id="chkConectado" name="lConectado">
							<label for="chkConectado">Manter Conectado</label>
						</div>
						
						<div class="alert alert-danger alert-dismissable" id="alertErroLogin">
								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		    					<strong>Usuário/Conta não encontrada</strong>
		  				</div>
		  				
						<div class="form-group text-center">
							<button type="submit" class="btn btn-success btn-lg" onclick="">Login</button>
							<button type="reset" class="btn btn-primary btn-lg">Limpar</button>					
						</div>
					</form>
				</div>
			
				<!-- Divisão -->
				<div class="col-sm-2 col-md-2 col-lg-2"></div>
			
				<!-- Form de Cadastro -->
				<div class="col-xs-12 col-sm-5 col-md-5 col-lg-5" id="divCadastro">
					<h2 class="text-center">Cadastre-se!</h2>
					
					<!--o for é utilizado para o id-->
					<div class="form-group">
						<label for="cEmail">E-mail</label>
						<input type="email" class="form-control" id="cEmail" name="cEmail">

						<div class="alert alert-warning alert-dismissable" id="alertErroEmail">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    					<strong></strong>
	  					</div>
					</div>

					<div class="form-group">
						<label for="pwd">Senha</label>
						<input type="password" class="form-control" id="cSenha">
						
						<div class="alert alert-warning alert-dismissable" id="alertErroSenha">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    					<strong></strong>
	  					</div>
					</div>

					<div id="divCadastroFull">
						<div class="form-group">
							<label for="nome">Nome</label>
							<input type="text" class="form-control" id="cNome">
							
							<div class="alert alert-warning alert-dismissable" id="alertErroNome">
								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    						<strong></strong>
	  						</div>
						</div>
	
						<div class="form-group">
							<label for="cpf">CPF</label>
							<input type="text" maxlength="14" OnKeyPress="FormatarCampos('###.###.###-##', this)" class="form-control"
							id="cpf">
						</div>

						<div class="form-group">
							<label for="cep">CEP</label>
							<input type="text" maxlength="9" OnKeyPress="FormatarCampos('#####-###', this)" class="form-control" id="CEP">
						</div>
	
						<div class="form-group">
							<label for="endereco">Endereço</label>
							<input type="text" class="form-control" id="endereco">
						</div>

						<div class="form-group">
							<label for="bairro">Bairro</label>
							<input type="text" class="form-control" id="bairro">
						</div>

						<div class="form-group">
							<label for="cidade">Cidade/UF</label>
							<input type="text" class="form-control" id="cidade">
						</div>

						<div class="form-group">
							<label for="telefone">Telefone</label>
							<input type="text" maxlength="13" OnKeyPress="FormatarCampos('##-#####-####', this)" class="form-control" id="telefone">
						</div>

						<div class="form-group text-center">
							<button type="reset" id="btnCadastro" class="btn btn-success btn-lg">Cadastrar</button>
							<button type="reset" class="btn btn-primary btn-lg">Limpar</button>
						</div>
					</div>
				
					<!-- Botão para mostrar resto do cadastro -->
					<div class="text-center">
						<button id ="btnSliderCadastro" class="btn btn-primary">
							<span class="glyphicon glyphicon-menu-down">
						</button>
					</div>
					<br><br>
				</div>
			</div>
		</div>
	</section>

	<%
	     if ((request.getParameter("lEmail") != null) && (request.getParameter("lSenha") != null)) {
	    	 Usuario user = new Usuario();
	         user.setEmail(request.getParameter("lEmail"));
	         user.setSenha(request.getParameter("lSenha"));

	         String chkBoxConectado = (String) request.getParameter("lConectado");

	         UsuarioDAO userDao = new UsuarioDAO();
	         String nomeUsuario = userDao.nomeUsuarioLogin(user);

	         if (nomeUsuario != ""){
	        	 if (chkBoxConectado != null){
	        		 if (chkBoxConectado.equals("on")){
	 	        		Cookie cookieNome = new Cookie("NomeUsuario",nomeUsuario);
	 	        		cookieNome.setMaxAge(60*60);
	 	        		response.addCookie(cookieNome);
	 	        	 }	 
	        	 }else{
	        	 	session.setAttribute("NomeUsuario", nomeUsuario);
	        	 }
	        	 
	        	 out.print("<script>document.getElementById('alertErroLogin').style.display='none';</script>");
	        	 response.sendRedirect("perfil.jsp");
	         }else{
	        	 out.print("<script>document.getElementById('alertErroLogin').style.display='block';</script>");
	         }
	     }
	%>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="./resources/boostrap/js/bootstrap.min.js"></script>
	<script src="./resources/js/login-script.js"></script>
</body>
</html>
