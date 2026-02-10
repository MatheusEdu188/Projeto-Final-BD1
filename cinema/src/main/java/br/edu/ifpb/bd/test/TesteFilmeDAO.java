package br.edu.ifpb.bd.test;

import br.edu.ifpb.bd.dao.FilmeDAO;
import br.edu.ifpb.bd.model.Filme;

public class TesteFilmeDAO {

    public static void main(String[] args) {

        Filme filme = new Filme();
        filme.setTitulo("Matrix");
        filme.setDuracao(230);
        filme.setClassificacao("14");
        filme.setGenero("Ação");

        FilmeDAO dao = new FilmeDAO();
        dao.salvar(filme);

        System.out.println("Filme salvo com sucesso!");

        for(Filme film : dao.listar()){
            System.out.println("Id " + film.getId());
            System.out.println("Nome "+film.getTitulo());
        }


        for(Filme file : dao.buscarPorTitulo("Matrix")){
            System.out.println("Encontramos...");
            System.out.println(file.getTitulo());
        }



    }
}
