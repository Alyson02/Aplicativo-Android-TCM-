package com.example.appsalaobeleza1.controlador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;

import com.example.appsalaobeleza1.repositorio.RepositorioUsuario;


public class BaseActivity extends AppCompatActivity {

    protected RepositorioUsuario repositorioUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        repositorioUsuario = new RepositorioUsuario(this);

    }

    protected void abrirTela(Context tela, Class<?> novaTela) {
        Intent intent = new Intent(tela, novaTela);
        this.startActivity(intent);
    }
    public void finalizarAplicacao(){
        this.finish();
    }

        protected String obterTexto(EditText editText) {
            String texto = editText.getText().toString();

            return texto != null && !texto.isEmpty() ? texto : "";
        }
}
