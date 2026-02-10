package br.edu.ifpb.bd.test;

import br.edu.ifpb.bd.dao.FilmeDAO;
import br.edu.ifpb.bd.model.Filme;

public class TesteFilmeDAO {

    public static void main(String[] args) {

        Filme filme = new Filme();
        filme.setTitulo("Matrix");
        filme.setDuracao(136);
        filme.setClassificacao("14");
        filme.setGenero("Ficção");

        FilmeDAO dao = new FilmeDAO();
        dao.salvar(filme);

        System.out.println("Filme salvo com sucesso!");
    }
}
