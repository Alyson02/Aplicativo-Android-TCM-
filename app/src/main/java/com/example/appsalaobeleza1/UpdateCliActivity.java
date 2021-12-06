package com.example.appsalaobeleza1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateCliActivity extends AppCompatActivity {
    EditText nome, cpf, email, tel;
    Button cancel, confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cli);

        //Pegando componentes
        nome = findViewById(R.id.inputNomeUpdate);
        cpf = findViewById(R.id.inputCpfUpdate);
        email = findViewById(R.id.inputEmailUpdate);
        tel = findViewById(R.id.inputTelUpdate);
        cancel = findViewById(R.id.btnCancelarUpdate);
        confirm = findViewById(R.id.btnConfirmarUpdate);

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