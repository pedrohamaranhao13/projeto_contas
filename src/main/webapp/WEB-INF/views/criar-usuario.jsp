<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Projeto Contas</title>

<!-- Referência da folha de estilo CSS do bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link href="resources/style.css" rel="stylesheet" />

</head>
<body class="bg-secondary">

	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card mt-5">
				<div class=card-body>

					<div class="text-center">
						<img class="mb-3" alt="member login"
							src="https://www.pngmart.com/files/3/Member-Login-Button-PNG-File.png"
							width="70%">
						<h2>Criar conta de usuário</h2>
						<p>Preencha os seus dados para criar um conta:</p>
					</div>

					<div class="text-center text-success">
						<h3>${mensagem_sucesso}</h3>
					</div>

					<div class="text-center text-danger">
						<h3>${mensagem_erro}</h3>
					</div>

					<form id="formCriarUsuario" method="post" action="criar-usuario-post">
						<div class="mb-3 form-floating">
							<input 	id="name" 
											type="text"
											id="floatingNome"
											name="nome" 
											class="form-control"
											placeholder="Digite seu nome aqui">
							<label>Nome do usuário:</label> 
						</div>
						<div class="mb-3 form-floating">
							<input 	id="email" 
											type="text"
											name="email" 
											class="form-control"
											placeholder="Digite seu e-mail aqui">
							<label>E-mail de acesso:</label> 
						</div>

						<div class="mb-3 form-floating">
							<input  	id="senha"
											type="password"
											class="form-control" 
											name="senha"
											placeholder="Digite sua senha aqui">
							<label>Senha de acesso:</label> 
						</div>

						<div class="mb-3 form-floating">
							<input	id="senhaConfirmacao" 
											type="password" 
											class="form-control"
											name="senhaConfirmacao" 
											placeholder="Confirme sua senha aqui">
							<label>Confirmar a sua senha:</label> 
						</div>

						<div class="mb-2 d-grid">
							<input type="submit" class="btn btn-primary"
								value="Realizar Cadastro" />
						</div>
					</form>

					<div class="mb-2 d-grid">
						<a href="/projeto_contas/" class="btn btn-light"> Voltar </a>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!--  Referência do arquivo JS do bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

	<!--  Referência do arquivo JS do Jquery -->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

	<!-- JQuery Validate JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/localization/messages_pt_BR.min.js"></script>
	<script src="resources/js/criar-usuario.js" ></script>

</body>
</html>