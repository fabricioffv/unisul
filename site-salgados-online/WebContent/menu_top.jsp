<%!
   String usuario;
%>

<nav class="navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span>
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">JJ - Doces e Salgados</a>
		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li id="linkInicio"><a href="index.jsp">Início</a></li>
				<li id="linkPedidos"><a href="#">Pedidos</a></li>
				<li id="linkCardapio"><a href="#">Cardápio</a></li>
				<li id="linkOrcamento"><a href="#">Orçamento</a></li>
				<li id="linkContato"><a href="#">Contato</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
			
				<%		
					usuario = (String) session.getAttribute("NomeUsuario");
				
					if ((usuario == "") || (usuario == null)){
						Cookie[] cookies = null;
						cookies = request.getCookies();
						 
						for (int i = 0; i < cookies.length; i++) {
							String nomeCookie = (String) cookies[i].getName();
				        	
							if(nomeCookie.equals("NomeUsuario")){
				        		usuario = (String) cookies[i].getValue();	
				        		break;
				        	}
						}
				               
					}
					if ((usuario != "") && (usuario != null)){
						out.print("<li class='dropdown' id='linkUsuario'>"+
								  	"<a class='dropdown-toggle' data-toggle='dropdown' href='#'>"+
										"<span class='glyphicon glyphicon-user'/></span>Bem Vindo(a) " + usuario + 
										"<span class='caret'/></span>"+
									"</a> "+
								  	"<ul class='dropdown-menu'>"+
										"<li><a href='perfil.jsp'>Meu Perfil</a></li>"+
										"<li><a href='logout.jsp'>Sair</a></li>"+
								  	"</ul>"+
								  "</li>");	
					}else{
						out.print("<li id='linkLogin'><a href='login.jsp'>Login</a></li>");
					}
				%>	
					
				<li id="linkSobre"><a href="#">Sobre</a></li>
				<li class="hidden-xs" id="linkCarrinho"><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
				<li class="hidden-md hidden-sm hidden-lg" id="linkCarrinho"><a href="#">Carrinho</a></li>
			</ul>
		</div>
	</div>
</nav>



