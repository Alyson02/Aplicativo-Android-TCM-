package com.example.appsalaobeleza1.utils;

public class DtoCliente {
    private String titulo, desc;

    public DtoCliente(String titulo, String desc) {
        this.titulo = titulo;
        this.desc = desc;
    }


    public DtoCliente() {
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
