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
public class EdicaoContasController {

	@RequestMapping(value = "/admin/edicao-contas")
	public ModelAndView edicaoContas(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/admin/edicao-contas");
		
		try {
			
			Integer id = Integer.parseInt(request.getParameter("id")) ;
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");
			
			ContaRepository contaRepository = new ContaRepository();
			Conta conta = contaRepository.findById(id);
			
			if(conta != null && conta.getIdUsuario() == usuario.getIdUsuario())
			{
				modelAndView.addObject("conta", conta);
			}
			else {
				modelAndView.setViewName("redirect:/admin/consulta-contas");
			}
			
			
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/edicao-contas-post", method = RequestMethod.POST)
	public ModelAndView edicaoContasPost(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/edicao-contas");
		
		try {
			
			Conta conta = new Conta();
			
			conta.setIdConta(Integer.parseInt(request.getParameter("idConta")));
			conta.setNome(request.getParameter("nome"));
			conta.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			conta.setValor(Double.parseDouble(request.getParameter("valor")));
			conta.setTipo(Integer.parseInt(request.getParameter("tipo")));
			conta.setDescricao(request.getParameter("descricao"));
			
			ContaRepository contaRepository = new ContaRepository();
			contaRepository.update(conta);
			
			modelAndView.addObject("mensagem_sucesso", "Conta '"+ conta.getNome() +"', atualizada com sucesso!");
			modelAndView.addObject("conta", conta);
			
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
		
	}
}
