package br.edu.ifpb.bd.model;

import java.time.LocalDateTime;

public class Sessao {
    private int id;                
    private LocalDateTime dataHorario; 
    private int filmeId;           
    private int tipoSalaId;
    


    public Sessao(int id, LocalDateTime dataHorario, int filmeId, int tipoSalaId) {
        this.id = id;
        this.dataHorario = dataHorario;
        this.filmeId = filmeId;
        this.tipoSalaId = tipoSalaId;
    }



    public Sessao() {
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public LocalDateTime getDataHorario() {
        return dataHorario;
    }



    public void setDataHorario(LocalDateTime dataHorario) {
        this.dataHorario = dataHorario;
    }



    public int getFilmeId() {
        return filmeId;
    }



    public void setFilmeId(int filmeId) {
        this.filmeId = filmeId;
    }



    public int getTipoSalaId() {
        return tipoSalaId;
    }



    public void setTipoSalaId(int tipoSalaId) {
        this.tipoSalaId = tipoSalaId;
    }


    
    
    
}
