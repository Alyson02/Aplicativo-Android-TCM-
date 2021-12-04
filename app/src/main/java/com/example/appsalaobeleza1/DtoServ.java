package com.example.appsalaobeleza1;

public class DtoServ {
    private String titulo, desc;

    public DtoServ(String titulo, String desc) {
        this.titulo = titulo;
        this.desc = desc;
    }

    public DtoServ() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
