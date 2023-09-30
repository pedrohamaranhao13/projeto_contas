package br.com.smarttec.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.smarttec.entities.Usuario;
import br.com.smarttec.helpers.EncryptHelper;
import br.com.smarttec.repositories.UsuarioRepository;

@Controller
public class AutenticarController {

	@RequestMapping(value = "/")
	public ModelAndView autenticar() {
		
		ModelAndView modelAndView = new ModelAndView("autenticar");
		return modelAndView;
	}
	
	@RequestMapping(value="/autenticar-post", method = RequestMethod.POST )
	public ModelAndView autenticarPost(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("autenticar");
		
		try {
			
			String email = request.getParameter("email");
			String senha = EncryptHelper.encryptToSHA1(request.getParameter("senha"));
			
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.find(email, senha);
			
			if (usuario != null) {

				request.getSession().setAttribute("usuario_auth", usuario);
				
				modelAndView.setViewName("redirect:/admin/dashboard");
			}
			else {
				throw new Exception("Acesso negado, Usário inválido.");
			}
			
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
		
	}
	
}

