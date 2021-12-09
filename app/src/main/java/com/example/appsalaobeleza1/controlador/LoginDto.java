package com.example.appsalaobeleza1.controlador;

public class LoginDto {
    //atributos
    private String senha, usuarioEmail, nomeFunc, cpf;
    private int id;

    //Construtores

    public LoginDto() {
    }

    public LoginDto(String senha, String usuarioEmail) {
        this.senha = senha;
        this.usuarioEmail = usuarioEmail;
    }

    public LoginDto(String senha, String usuarioEmail, int id) {
        this.senha = senha;
        this.usuarioEmail = usuarioEmail;
        this.id = id;
    }

    public LoginDto(String senha, String usuarioEmail, String nome, String cpf) {
        this.senha = senha;
        this.usuarioEmail = usuarioEmail;
        this.nomeFunc = nome;
        this.cpf = cpf;
    }

    //Geters and Seters

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
