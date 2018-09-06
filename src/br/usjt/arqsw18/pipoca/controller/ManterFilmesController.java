package br.usjt.arqsw18.pipoca.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.service.FilmeService;

@Controller
public class ManterFilmesController {
	private FilmeService filmeService;
	
	public ManterFilmesController() {
		filmeService = new FilmeService();
	}
	
	@RequestMapping("/novo")
	public String novoFilme(){
		return "NovoFilme";
	}
	
	@RequestMapping("/inserir")
	public String inserirFilme(Filme filme, Model model) throws SQLException, IOException {
		try {
			filme = filmeService.inserirFilme(filme);
			model.addAttribute("filme", filme);
			return "Resultado";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}}
