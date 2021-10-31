package com.example.appsalaobeleza1.controlador;

import android.content.Context;

import com.example.appsalaobeleza1.utils.Mensagem;

public class LoginDto {
    //atributos
    private String senha, usuarioEmail;

    //Construtores

    public LoginDto() {
    }

    public LoginDto(String senha, String usuarioEmail) {
        this.senha = senha;
        this.usuarioEmail = usuarioEmail;
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

    //Método de autenticação

    public boolean autenticar(String usuario, String senha) {
        if (getUsuarioEmail().equals(usuario) && getSenha().equals(senha)) {
            return true;
        }
        return false;
    }
}
