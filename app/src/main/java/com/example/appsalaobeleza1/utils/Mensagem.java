package com.example.appsalaobeleza1.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.Toast;

import com.example.appsalaobeleza1.controlador.BaseActivity;


public class Mensagem {

    public static void exibirMensagem(Context tela, String mensagem) {
        Toast.makeText(tela, mensagem, Toast.LENGTH_LONG).show();
    }
}
