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
	rel="stylesheet" />

<link href="resources/style.css" rel="stylesheet" />

</head>
<body class="bg-secondary">

	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card mt-5">
				<div class=card-body>

					<div class="text-center">
						<img alt="member login"
							src="https://www.pngmart.com/files/3/Member-Login-Button-PNG-File.png"
							width="70%">
						<h2>Acesso ao Sistema</h2>
						<p>Entre com as suas credenciais de acesso:</p>
					</div>

					<form id="formAutenticar" action="">
						<div class="mb-2">
							<label>E-mail de acesso:</label> <input id="email" type="text"
								name="email" class="form-control"
								placeholder="Digite seu e-mail aqui">
						</div>

						<div class="mb-2">
							<label>Senha de acesso:</label> <input id="senha" name="senha"
								type="password" class="form-control"
								placeholder="Digite sua senha aqui">
						</div>

						<div class="mb-2 d-grid">
							<input type="submit" class="btn btn-primary" value="Entrar" />
						</div>
					</form>

					<div class="mb-2 d-grid">
						<a href="/projeto_contas/criar-usuario" class="btn btn-light">
							Não possui conta? <strong>Cadastre-se aqui!</strong>
						</a>
					</div>

					<div class="mb-2 d-grid">
						<a href="/projeto_contas/recuperar-senha" class="btn btn-light">
							Esqueceu sua senha? <strong>Clique aqui!</strong>
						</a>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!-- Referência do arquivo JS do bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

	<!-- JQuery JS -->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

	<!-- JQuery Validate JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/localization/messages_pt_BR.min.js"></script>
	<script src="resources/js/autenticar.js"></script>

</body>
</html>
