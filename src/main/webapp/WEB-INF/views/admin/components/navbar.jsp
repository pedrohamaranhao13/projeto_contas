<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<nav class="navbar navbar-expand-lg navbar-secondary bg-secondary">
	<div class="container">
		<a class="navbar-brand text-white" href="#"><strong>Projeto
				Contas</strong></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link text-white"
					href="/projeto_contas/admin/dashboard">Dashboard</a></li>
				<li class="nav-item"><a class="nav-link text-white"
					href="/projeto_contas/admin/cadastro-contas">Cadastro de Contas</a>
				</li>
				<li class="nav-item"><a class="nav-link text-white"
					href="/projeto_contas/admin/consulta-contas">Consulta de Contas</a>
				</li>
			</ul>
		</div>
		<div class="d-flex">
			<!-- Exibe o nome do usu�rio autenticado -->
			<span class="text-light mt-1 me-3"><strong>${usuario_auth.nome }</strong></span>
			<!-- Bot�o para fazer logout -->
			<a 	href="/projeto_contas/logout" 
					class="btn btn-outline-light btn-sm"
					onclick="javascript:return confirm('Deseja realmente sair do sistema?')" >Sair do Sistema
			</a>
		</div>
		<div class="d-flex"><p class="text-light mt-1 me-3">${project.version}</p></div>
	</div> 
</nav>


