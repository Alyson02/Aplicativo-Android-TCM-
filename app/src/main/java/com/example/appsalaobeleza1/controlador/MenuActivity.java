package com.example.appsalaobeleza1.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appsalaobeleza1.R;
import com.example.appsalaobeleza1.controlador.CadastrarActivity;
import com.example.appsalaobeleza1.controlador.ConsultarActivity;

public class MenuActivity extends AppCompatActivity {
Button buttonCadastrar, buttonConsultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        buttonConsultar = findViewById(R.id.buttonConsultar);
        //Evento para acessar a Tela de Cadastrar
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaCadastrar = new Intent(getApplicationContext(), CadastrarActivity.class);
                startActivity(telaCadastrar);
            }
        });
        //Evento para acessar a Tela de Consultar
        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaConsultar = new Intent(getApplicationContext(), ConsultarActivity.class);
                startActivity(telaConsultar);
            }
        });

    }


}