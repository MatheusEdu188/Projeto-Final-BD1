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


   public Filme buscarPorId(int id) {

    String sql = "SELECT * FROM filme WHERE id = ?";

    try (
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
    ) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { 
            Filme filme = new Filme();

            filme.setId(rs.getInt("id"));
            filme.setTitulo(rs.getString("titulo"));
            filme.setDuracao(rs.getInt("duracao"));
            filme.setClassificacao(rs.getString("classificacao"));
            filme.setGenero(rs.getString("genero"));

            return filme;
        }

        rs.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; 
}

    public void updateFilme(Filme filme){
        String sql = "UPDATE filme SET titulo = ?, duracao = ?, classificacao = ?, genero = ? WHERE id = ?;";

        try(
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, filme.getTitulo());
            stmt.setInt(2, filme.getDuracao());
            stmt.setString(3, filme.getClassificacao());
            stmt.setString(4, filme.getGenero());
            stmt.setInt(5, filme.getId());

            int att = stmt.executeUpdate();

            System.out.println("Filme atualizado! " + att);

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int id){

        String sql = "DELETE FROM filme WHERE id = ?";

        try(
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, id);

            int att = stmt.executeUpdate();

            System.out.println("Linhas removidas: "+att);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public List<String> filmesDeAcao() {
    List<String> lista = new ArrayList<>();

    String sql = """
        SELECT f.titulo
        FROM sessao s
        INNER JOIN filme f ON s.filme_id = f.id
        INNER JOIN tipo_sala ts ON s.tipo_sala_id = ts.id
        WHERE f.genero = 'Ação'
    """;

    try (
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
    ) {
        while (rs.next()) {
            lista.add(rs.getString("titulo"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
    }


    public List<String> listarSessoesPorGenero(String genero) {
        List<String> lista = new ArrayList<>();

        String sql = """
            SELECT f.titulo, s.data_horario, ts.nome AS sala
            FROM sessao s
            INNER JOIN filme f ON s.filme_id = f.id
            INNER JOIN tipo_sala ts ON s.tipo_sala_id = ts.id
            WHERE f.genero = ?
            ORDER BY s.data_horario
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, genero);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(
                    rs.getString("titulo") + " | " +
                    rs.getTimestamp("data_horario") + " | Sala: " +
                    rs.getString("sala")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // 2

    public List<String> listarPorClassificacao(String classificacao) {
        List<String> lista = new ArrayList<>();

        String sql = """
            SELECT f.titulo, s.data_horario, ts.nome AS sala
            FROM sessao s
            INNER JOIN filme f ON s.filme_id = f.id
            INNER JOIN tipo_sala ts ON s.tipo_sala_id = ts.id
            WHERE f.classificacao = ?
            ORDER BY f.titulo
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, classificacao);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(
                    rs.getString("titulo") + " | " +
                    rs.getTimestamp("data_horario") + " | Sala: " +
                    rs.getString("sala")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // 3

    public List<String> quantidadeSessoesPorFilme() {
        List<String> lista = new ArrayList<>();

        String sql = """
            SELECT f.titulo, COUNT(s.id) AS total
            FROM filme f
            INNER JOIN sessao s ON f.id = s.filme_id
            GROUP BY f.titulo
            ORDER BY total DESC
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(
                    rs.getString("titulo") +
                    " | Total sessões: " +
                    rs.getInt("total")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // 5

    public List<String> listarFilmesComOuSemSessao() {
        List<String> lista = new ArrayList<>();

        String sql = """
            SELECT f.titulo, s.data_horario
            FROM filme f
            LEFT JOIN sessao s ON f.id = s.filme_id
            ORDER BY f.titulo
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(
                    rs.getString("titulo") +
                    " | Sessão: " +
                    rs.getTimestamp("data_horario")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // 6

    public String filmeComMaisSessoes() {

        String sql = """
            SELECT titulo
            FROM filme
            WHERE id = (
                SELECT filme_id
                FROM sessao
                GROUP BY filme_id
                ORDER BY COUNT(id) DESC
                LIMIT 1
            )
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getString("titulo");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



}
