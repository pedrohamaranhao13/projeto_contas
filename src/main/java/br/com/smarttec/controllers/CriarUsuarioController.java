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
public class CriarUsuarioController {

	@RequestMapping(value = "/criar-usuario")
	public ModelAndView criarUsuario() {
		
		ModelAndView modelAndView = new ModelAndView("criar-usuario");
		return modelAndView;
	}
	
	@RequestMapping(value = "/criar-usuario-post", method = RequestMethod.POST)
	public ModelAndView criarUsuarioPost(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("criar-usuario");
		
		try {
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(request.getParameter("nome"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(EncryptHelper.encryptToSHA1(request.getParameter("senha")) );
			
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			
			if(usuarioRepository.find(usuario.getEmail()) == null) {
				
				usuarioRepository.create(usuario);
				
				modelAndView.addObject("mensagem_sucesso", "Usuário cadastrado com sucesso!");
			}
			else {
				throw new Exception("O e-mail informado já está cadastrado para outro usuário.");
			}	
			
		} catch (Exception e) {
		
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}
	
}
