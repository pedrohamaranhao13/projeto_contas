<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title> Projeto Contas</title>

<!-- Referência da folha de estilo CSS do bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

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
						<h2>Esqueci minha senha</h2>
						<p>Preencha os dados para recuperar seu acesso:</p>
					</div>

					<form action="">
						<div class="mb-3  form-floating">
							 <input type="text"
								class="form-control" 
								placeholder="Digite seu e-mail aqui">
							  <label>E-mail de acesso:</label>
						</div>
						<div class="mb-2 d-grid">
							<input type="submit" class="btn btn-primary" value="Recuperar senha de acesso" />
						</div>
					</form>

					<div class="mb-2 d-grid">
						<a href="/projeto_contas/" class="btn btn-light">
							Voltar
						</a>
					</div>

				</div>
			</div>
		</div>
	</div>


	<!--  Referência do arquivo JS do bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>