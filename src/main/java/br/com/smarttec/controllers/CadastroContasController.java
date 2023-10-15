package br.com.smarttec.controllers;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.smarttec.entities.Conta;
import br.com.smarttec.entities.Usuario;
import br.com.smarttec.repositories.ContaRepository;

@Controller
public class CadastroContasController {

	@RequestMapping(value = "/admin/cadastro-contas")
	public ModelAndView cadastroContas() {
		ModelAndView modelAndView = new ModelAndView("admin/cadastro-contas");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/cadastro-contas-post", method = RequestMethod.POST)
	public ModelAndView cadastroContasPost(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/cadastro-contas");
		
		try {
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");
			
			Conta conta = new Conta();
			
			conta.setNome(request.getParameter("nome"));
			conta.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			conta.setValor(Double.parseDouble(request.getParameter("valor")));
			conta.setTipo(Integer.parseInt(request.getParameter("tipo")));
			conta.setDescricao(request.getParameter("descricao"));
			conta.setIdUsuario(usuario.getIdUsuario());
			
			ContaRepository contaRepository = new ContaRepository();
			contaRepository.create(conta);
			
			modelAndView.addObject("mensagem_sucesso", "Conta '"+ conta.getNome() +"', cadastrada com sucesso!");
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}
}