package com.example.appsalaobeleza1;

public class DtoCliente {
    private String titulo, desc;
    private int idImage;

    public DtoCliente(String titulo, String desc, int idImage) {
        this.titulo = titulo;
        this.desc = desc;
        this.idImage = idImage;
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

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
