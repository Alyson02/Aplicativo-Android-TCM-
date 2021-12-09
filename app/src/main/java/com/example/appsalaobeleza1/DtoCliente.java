package com.example.appsalaobeleza1;

public class DtoCliente {
    private String nome, desc, email, telefone;
    private int idImage, id;

    public DtoCliente(String titulo, String desc, int idImage) {
        this.nome = titulo;
        this.desc = desc;
        this.idImage = idImage;
    }

    public DtoCliente(String nome, String desc, String email, String telefone) {
        this.nome = nome;
        this.desc = desc;
        this.email = email;
        this.telefone = telefone;
    }

    public DtoCliente(String nome, String desc, String email, String telefone, int id) {
        this.nome = nome;
        this.desc = desc;
        this.email = email;
        this.telefone = telefone;
        this.id = id;
    }

    public DtoCliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
