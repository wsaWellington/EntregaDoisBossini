package br.usjt.arqsw18.pipoca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arqsw18.pipoca.model.entity.Filme;

public class FilmeDAO {

	public int inserirFilme(Filme filme) throws SQLException {
		int id = -1;
		String sql = "insert into filme (nome, descricao) values (?,?)";

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, filme.getNome());
			pst.setString(2, filme.getDescricao());
			pst.execute();

			String query = "select LAST_INSERT_ID()";
			try (PreparedStatement pst1 = conn.prepareStatement(query); ResultSet rs = pst1.executeQuery();) {

				if (rs.next()) {
					id = rs.getInt(1);
				}
			}

			// especificar o comando sql de inserção de um filme
			// pré compilar o comando sql
			// executar o comandop
			// pré compilar o comando sql que permite a obtenção do última
			// id gerado na sessão atual
			// colocar o id dentro do objeto filme
			// devolver o id gerado

		}

		return id;
	}

}
