package br.edu.ifpb.bd.model;

public class Filme {

    private int id;
    private String titulo;
    private int duracao;
    private String classificacao;
    private String genero;

    public Filme() {
    }

    public Filme(int id, String titulo, int duracao, String classificacao, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
