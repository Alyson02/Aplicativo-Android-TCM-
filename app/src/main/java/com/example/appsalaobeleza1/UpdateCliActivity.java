package com.example.appsalaobeleza1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateCliActivity extends AppCompatActivity {
    EditText nome, desc, email, tel;
    Button cancel, confirm;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cli);

        //Pegando componentes
        nome = findViewById(R.id.inputNomeUpdate);
        desc = findViewById(R.id.inputDescUpdate);
        email = findViewById(R.id.inputEmailUpdate);
        tel = findViewById(R.id.inputTelUpdate);
        cancel = findViewById(R.id.btnCancelarUpdate);
        confirm = findViewById(R.id.btnConfirmarUpdate);

        Bundle bundle = getIntent().getExtras();
        nome.setText(bundle.getString("nome"));
        desc.setText(bundle.getString("desc"));
        email.setText(bundle.getString("email"));
        tel.setText(bundle.getString("tel"));
        id = bundle.getInt("id");

        //eventos
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DtoCliente dtoCliente = new DtoCliente(
                        nome.getText().toString(),
                        desc.getText().toString(),
                        email.getText().toString(),
                        tel.getText().toString(),
                        id
                );
                DaoMercurio daoMercurio = new DaoMercurio(getApplicationContext());
                try {
                    long linhasInseridas = daoMercurio.alterarCli(dtoCliente);
                    if(linhasInseridas>0){
                        Toast.makeText(getApplicationContext(), "Alterado com sucesso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Clientes.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Não foi possível alterar", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception exception){
                    Toast.makeText(getApplicationContext(), "Erro ao alterar: " + exception.toString(), Toast.LENGTH_LONG).show();
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