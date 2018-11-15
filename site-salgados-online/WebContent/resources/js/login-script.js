$(document).ready(function() {
	$("#linkLogin").addClass("active");

	$("#btnSliderCadastro").click(
			function() {
				if ($("#divCadastroFull").css("display") == "none")
					$("#btnSliderCadastro > span").attr('class',
							'glyphicon glyphicon-menu-up');
				else
					$("#btnSliderCadastro > span").attr('class',
							'glyphicon glyphicon-menu-down');

				$("#divCadastroFull").toggle("slow");
			});

	$("#cEmail").blur(function() {
		var emailCadastro = $("#cEmail").val();

		if (emailCadastro != "") {
			$.post('ValidaEmail', {
				email : emailCadastro
			}, function(responseText) {
				if (responseText != "") {
					$("#alertErroEmail > strong").html("E-mail existente. Tente outro e-mail");
					$("#alertErroEmail").show();
					$("#cEmail").focus();
				} else {
					$("#alertErroEmail").hide();
				}
			});
		} else
			$("#alertErroEmail").hide();
	});
	
	$("#btnCadastro").click(function(){
		$("#alertErroEmail").hide();
		$("#alertErroSenha").hide();
		$("#alertErroNome").hide();
		
		if($("#cEmail").val() == ""){
			$("#alertErroEmail > strong").html("Informe um email");
			$("#alertErroEmail").show();
			$("#cEmail").focus();
		}else if($("#cSenha").val() == ""){
			$("#alertErroSenha > strong").html("Informe uma senha");
			$("#alertErroSenha").show();
			$("#cSenha").focus();
		}else if($("#cNome").val() == ""){
			$("#alertErroNome > strong").html("Informe um nome");
			$("#alertErroNome").show();
			$("#cNome").focus();
		}else{
			email = $("#cEmail").val();
			senha = $("#cSenha").val();
			nome = $("#cNome").val();
			
			$.post('CadastraEmail', {
				email : email,
				senha : senha,
				nome : nome
			}, function(responseText) {
				if (responseText == "OK") {
					alert("E-mail cadastrado com sucesso.");	
					$.post('./login.jsp', {
						lEmail : email,
						lSenha : senha
					}, function(responseText) {
						window.location.replace("./perfil.jsp");
					});
				} else {
					alert("Erro ao cadastrar. Verifique.");	
				}
			});
			
		}
	}); 
});

function FormatarCampos(mascara, documento) {
	var i = documento.value.length;
	var saida = mascara.substring(0, 1);
	var texto = mascara.substring(i)

	if (texto.substring(0, 1) != saida) {
		documento.value += texto.substring(0, 1);
	}

}
