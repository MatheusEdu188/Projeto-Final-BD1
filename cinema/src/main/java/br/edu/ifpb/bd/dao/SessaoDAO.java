package br.edu.ifpb.bd.dao;

import br.edu.ifpb.bd.model.Sessao;
import br.edu.ifpb.bd.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessaoDAO {

    public void salvar(Sessao sessao) {
        String sql = "INSERT INTO sessao(data_horario, filme_id, tipo_sala_id) VALUES (?, ?, ?)";
        try (
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setTimestamp(1, Timestamp.valueOf(sessao.getDataHorario()));
            stmt.setInt(2, sessao.getFilmeId());
            stmt.setInt(3, sessao.getTipoSalaId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Sessao> listar() {
        List<Sessao> sessoes = new ArrayList<>();
        String sql = "SELECT * FROM sessao ORDER BY id";
        try (
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        ) {
            while(rs.next()) {
                Sessao sessao = new Sessao();
                sessao.setId(rs.getInt("id"));
                sessao.setDataHorario(rs.getTimestamp("data_horario").toLocalDateTime());
                sessao.setFilmeId(rs.getInt("filme_id"));
                sessao.setTipoSalaId(rs.getInt("tipo_sala_id"));
                sessoes.add(sessao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessoes;
    }

    public Sessao buscarPorId(int id) {
        Sessao sessao = null;
        String sql = "SELECT * FROM sessao WHERE id = ?";
        try (
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    sessao = new Sessao();
                    sessao.setId(rs.getInt("id"));
                    sessao.setDataHorario(rs.getTimestamp("data_horario").toLocalDateTime());
                    sessao.setFilmeId(rs.getInt("filme_id"));
                    sessao.setTipoSalaId(rs.getInt("tipo_sala_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessao;
    }

    public void atualizar(Sessao sessao) {
        String sql = "UPDATE sessao SET data_horario = ?, filme_id = ?, tipo_sala_id = ? WHERE id = ?";
        try (
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setTimestamp(1, Timestamp.valueOf(sessao.getDataHorario()));
            stmt.setInt(2, sessao.getFilmeId());
            stmt.setInt(3, sessao.getTipoSalaId());
            stmt.setInt(4, sessao.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM sessao WHERE id = ?";
        try (
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
