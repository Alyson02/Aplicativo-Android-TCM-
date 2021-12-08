package com.example.appsalaobeleza1;

public class DtoServ {
    private  int id;
    private String titulo, desc;

    public DtoServ(String titulo, String desc) {
        this.titulo = titulo;
        this.desc = desc;
    }

    public DtoServ() {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
