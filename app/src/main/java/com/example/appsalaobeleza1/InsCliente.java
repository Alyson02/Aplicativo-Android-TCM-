package com.example.appsalaobeleza1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsCliente extends AppCompatActivity {
    EditText nome, cpf, email, tel;
    Button cancel, confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins_cliente);

        //Pegando componentes
        nome = findViewById(R.id.inputNome);
        cpf = findViewById(R.id.inputCpf);
        email = findViewById(R.id.inputEmail);
        tel = findViewById(R.id.inputTel);
        cancel = findViewById(R.id.btnCancelar);
        confirm = findViewById(R.id.btnConfirmar);

        //eventos

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Clientes.class);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Clientes.class);
                startActivity(intent);
            }
        });
    }
}