package com.example.appsalaobeleza1.dominio;

public class Usuario {
    private Long codigo;
    private String login;
    private  String nome;
    private String senha;

    public Usuario() {

    }

    public Usuario(Long codigo, String login, String nome, String senha) {
        this.codigo = codigo;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(String login, String nome, String senha) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigo=" + codigo +
                ", login='" + login + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
