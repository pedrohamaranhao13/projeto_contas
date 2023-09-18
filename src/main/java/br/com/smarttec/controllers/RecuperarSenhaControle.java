package br.com.smarttec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecuperarSenhaControle {

	@RequestMapping(value = "/recuperar-senha")
	public ModelAndView recuperarSenha(){
		
		ModelAndView modelAndView = new ModelAndView("recuperar-senha");
		return modelAndView;
	}
	
}
