package com.example.appsalaobeleza1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                DtoCliente dtoCliente = new DtoCliente(
                        nome.getText().toString(),
                        cpf.getText().toString(),
                        email.getText().toString(),
                        tel.getText().toString()
                        );
                DaoMercurio daoMercurio = new DaoMercurio(getApplicationContext());
                try {
                    long linhasInseridas = daoMercurio.inserirCli(dtoCliente);
                    if(linhasInseridas>0){
                        Toast.makeText(getApplicationContext(), "Inserido com sucesso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Clientes.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Não foi possível inserir", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception exception){
                    Toast.makeText(getApplicationContext(), "Erro ao inserir: " + exception.toString(), Toast.LENGTH_LONG).show();
                }
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