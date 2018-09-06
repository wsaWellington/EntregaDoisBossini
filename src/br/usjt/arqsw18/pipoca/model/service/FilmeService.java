package br.usjt.arqsw18.pipoca.model.service;

import java.io.IOException;
import java.sql.SQLException;

import br.usjt.arqsw18.pipoca.model.dao.FilmeDAO;
import br.usjt.arqsw18.pipoca.model.entity.Filme;

public class FilmeService {
	private FilmeDAO dao;
	
	public FilmeService() {
		dao = new FilmeDAO();
	}
	
	public Filme inserirFilme(Filme filme) throws IOException, SQLException {
		int id = dao.inserirFilme(filme);
		filme.setId(id);
		return filme;
	}

}
