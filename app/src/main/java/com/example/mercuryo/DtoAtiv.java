package com.example.mercuryo;

public class DtoAtiv {
    private  int id;
    private String atividade;

    public DtoAtiv(String atividade) {
        this.atividade = atividade;
    }

    public DtoAtiv() {
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
