package br.com.smarttec.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.smarttec.entities.Conta;
import br.com.smarttec.entities.Usuario;
import br.com.smarttec.repositories.ContaRepository;

@Controller
public class ConsultaContasController {


	@RequestMapping(value = "/admin/consulta-contas")
	public ModelAndView consultaContas() {
		ModelAndView modelAndView = new ModelAndView("admin/consulta-contas");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/consulta-contas-get", method = RequestMethod.GET)
	public ModelAndView consultaContasGet(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/consulta-contas");
		
		try {
			
			String dataMin = request.getParameter("dataMin");
			String dataFim = request.getParameter("dataFim");
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");
			
			ContaRepository contaRepository = new ContaRepository();
			List<Conta> contas = contaRepository.findByDatas(
					new SimpleDateFormat("yyyy-MM-dd").parse(dataMin),
					new SimpleDateFormat("yyyy-MM-dd").parse(dataFim),
					usuario.getIdUsuario()
					);
			
			modelAndView.addObject("contas", contas);
			
			modelAndView.addObject("dataMin", dataMin);
			modelAndView.addObject("dataFim", dataFim);
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/excluir-conta", method = RequestMethod.GET)
	public ModelAndView excluirConta(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/consulta-contas");
	
		try {
			
			Integer idConta = Integer.parseInt(request.getParameter("id"));
			String dataMin = request.getParameter("dataMin");
			String dataFim = request.getParameter("dataFim");
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");
			
			ContaRepository contaRepository = new ContaRepository();
			Conta conta = contaRepository.findById(idConta);
			contaRepository.delete(conta);
			
			List<Conta> contas = contaRepository.findByDatas(
					new SimpleDateFormat("yyyy-MM-dd").parse(dataMin),
					new SimpleDateFormat("yyyy-MM-dd").parse(dataFim),
					usuario.getIdUsuario()
					);
			
			modelAndView.addObject("contas", contas);
			
			modelAndView.addObject("dataMin", dataMin);
			modelAndView.addObject("dataFim", dataFim);		
			
			modelAndView.addObject("mensagem_sucesso", "Conta excluída com sucesso.");
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}	
}
