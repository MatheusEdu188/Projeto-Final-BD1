package br.edu.ifpb.bd.dto;

import java.time.LocalDateTime;

public class SessaoDTO {
    private int id;
    private String tituloFilme;
    private String tipoSala;
    private LocalDateTime dataHorario;

    public SessaoDTO(int id, String tituloFilme, String tipoSala, LocalDateTime dataHorario) {
        this.id = id;
        this.tituloFilme = tituloFilme;
        this.tipoSala = tipoSala;
        this.dataHorario = dataHorario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public LocalDateTime getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(LocalDateTime dataHorario) {
        this.dataHorario = dataHorario;
    }


    
}