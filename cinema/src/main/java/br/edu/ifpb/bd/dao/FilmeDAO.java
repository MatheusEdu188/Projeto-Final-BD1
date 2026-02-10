package br.edu.ifpb.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Filme> listar(){
        List<Filme> filmes = new ArrayList<>();

        String sql = "SELECT * FROM filme;";

        try(
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        ){
            while(rs.next()){
                Filme filme = new Filme();

                filme.setId(rs.getInt("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setDuracao(rs.getInt("duracao"));
                filme.setClassificacao(rs.getString("classificacao"));
                filme.setGenero(rs.getString("genero"));

                filmes.add(filme);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return filmes;
    }


    public List<Filme> buscarPorTitulo(String titulo){
        List<Filme> filmes = new ArrayList<>();

        String sql = "SELECT * FROM filme WHERE titulo ILIKE ?";

        try(
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1,"%" + titulo + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Filme filme = new Filme();

                filme.setId(rs.getInt("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setDuracao(rs.getInt("duracao"));
                filme.setClassificacao(rs.getString("classificacao"));
                filme.setGenero(rs.getString("genero"));


                filmes.add(filme);
                
            }
            rs.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return filmes;
    }

    
}
