package com.example.mercuryo.utils;

import android.content.Context;
import android.widget.Toast;


public class Mensagem {

    public static void exibirMensagem(Context tela, String mensagem) {
        Toast.makeText(tela, mensagem, Toast.LENGTH_LONG).show();
    }
}
