<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Click</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"> 
</head>
<body>
	<body>
        <!--[if lt IE 10]><p class="browsehappy">Seu navegador está <strong>desatualizado</strong>. Atualize-o <a href="http://browsehappy.com/">aqui.</a></p><![endif]-->
		<div id="login_page">
            <!-- Foto de fundo -->
            <div class="front_bg">
                <img src="${pageContext.request.contextPath}/img/login_page/top.jpg" alt="">
            </div>
            <div id="form_login_register" class="fright">
				<!-- Login -->
				<div class="login_form">
                    <form class="login" action="LoginServlet" method="POST" enctype="multipart/form-data">
						<span class="icon_user"><img src="${pageContext.request.contextPath}/img/at.png" alt=""></span>
                        <input type="email" name="email" class="input_text">
                        
                        <span class="icon_pass"><img src="${pageContext.request.contextPath}/img/lock.png" alt=""></span>
                        <input type="password" name="senha" class="input_text">
                        <span><a href="" class="forgot_pass">Esqueci minha senha</a></span>
                        
                        <button type="submit" class="button_submit">Entrar</button>
                    </form>
				</div>
				
				<!-- Registrar -->
				<div class="register_form form_wrapper">
					<h2 class="title_form">Registrar-se</h2>
					<form action="CadastroUsuarioServlet" role="form"  method="POST"class="form-group">
						<input type="text" name="nome" required class="input_text" placeholder="João">

						<input type="text" name="sobrenome" required class="input_text" placeholder="da Silva">

						<input type="email" name="email" required class="input_text" placeholder="exemplo@dominio.com">

						<div class="radio_group">
							<span><input type="radio" name="sexo" class="input_radio" value="M">Masculino</span>
							<span><input type="radio" name="sexo" class="input_radio" value="F">Feminino</span>
						</div>

						<div class="data_nascimento">
							<select name="dataNascimento" id="" class="dia input_text">
								<option value="" disabled selected>Dia</option>
								<%
								for (int i = 1; i <= 31; i++) {
									out.print("<option value="+i+">"+i+"</option>");
								}
								%>
							</select>

							<select name="mes" id="" class="mes input_text">
								<option value="" disabled selected>Mês</option>
								<option value="00">Janeiro</option>
								<option value="01">Fevereiro</option>
								<option value="02">Março</option>
								<option value="03">Abril</option>
								<option value="04">Maio</option>
								<option value="05">Junho</option>
								<option value="06">Julho</option>
								<option value="07">Agosto</option>
								<option value="08">Setembro</option>
								<option value="09">Outubro</option>
								<option value="10">Novembro</option>
								<option value="11">Dezembro</option>
							</select>

							<select name="ano" id="" class="ano input_text">
								<option value="" disabled selected>Ano</option>
								<% 
								for (int i = 2014; i >= 1950; i--) {
									out.println("<option value="+i+">"+i+"</option>");
								}
								%>
							</select>
						</div>

						<input type="password" name="senha" required class="input_text" placeholder="************">

						<button type="submit" class="button_submit">Registrar</button>
					</form>
				</div>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
    </body>
</body>
</html>