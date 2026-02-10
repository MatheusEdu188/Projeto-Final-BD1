package br.edu.ifpb.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.bd.model.Filme;
import br.edu.ifpb.bd.util.ConnectionFactory;

public class FilmeDAO {

    public void salvar(Filme filme) {
        String sql = "INSERT INTO filme (titulo, duracao, classificacao, genero) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, filme.getTitulo());
            ps.setInt(2, filme.getDuracao());
            ps.setString(3, filme.getClassificacao());
            ps.setString(4, filme.getGenero());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
