<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Projeto Contas - Cadastro de contas</title>
<link 	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"	rel="stylesheet" />
</head>
<body>

	<jsp:include page="/WEB-INF/views/admin/components/navbar.jsp"></jsp:include>

	<div class="container mt-3">
	<h4>Cadastro Contas</h4>
	<p>Preencha os campos abaixo para incluir uma conta a pagar ou receber</p>
	</hr>
	
	<form action="">
	
		<div class="row mb-2">
				<div class="col-md-6">
					<label>Nome da conta:</label>
					<input type="text" class="form-control" placeholder="Digite o nome da conta."/>
				</div>
				<div class="col-md-3">
					<label>Data da conta:</label>
					<input type="date" class="form-control"/>
				</div>
				<div class="col-md-3">
					<label>Valor da conta:</label>
					<input type="text" class="form-control" placeholder="Digite um valor aqui."/>
				</div>
				
				<div class="row mb-2">
					<div  class="col-md-9">
						<label>Descrição da conta:</label>
						<textarea class="form-control" placeholder="Digite a descrição aqui."></textarea>
					</div>
					<div class="col-md-3">	
						<label>Tipo de conta:</label>			
						<select class="form-select">
							<option value="">Escolha uma opção </option>
							<option value="1">Conta a receber</option>
							<option value="2">Conta a pagar </option>
						</select>
					</div>
				</div>
				
				<div class="row mb-2">
					<div class="col-md-12 text-end">
						<a href="/projeto_contas/admin/consulta-contas" class="btn btn-light">
							Ir para a consulta
						</a>
						<input ype="submit" class="btn btn-success" value="Realizar Cadastro"/>
					</div>
				</div>
				
		</div>
	</form>	
	</div>
	
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>