package com.example.appsalaobeleza1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appsalaobeleza1.controlador.LoginActivity;
import com.example.appsalaobeleza1.controlador.LoginDto;

public class CadastraFunc extends AppCompatActivity {
    EditText nome, email, cpf, senha;
    Button btnCadastrar;
    TextView twBackLogin;
    LoginDto loginDto;
    DaoMercurio daoMercurio;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_func);

        twBackLogin = findViewById(R.id.twBackLogin);
        //Pegando componentes
        nome = findViewById(R.id.inputNomeFunc);
        cpf = findViewById(R.id.inputCpfFunc);
        email = findViewById(R.id.inputEmailFunc);
        senha = findViewById(R.id.inputPasswordFunc);
        btnCadastrar = findViewById(R.id.btnEnviar);

        //eventos
        twBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginDto = new LoginDto(senha.getText().toString(),
                        email.getText().toString(),
                        nome.getText().toString(),
                        cpf.getText().toString() );

                daoMercurio = new DaoMercurio(getApplicationContext());
                try {
                    long inserido = daoMercurio.inserirFunc(loginDto);
                    if (inserido > 0) {
                        Toast.makeText(getApplicationContext(), "Inserido com sucesso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    }else
                    Toast.makeText(getApplicationContext(), "Falaha ao inserir", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Erro no banco de dados: " + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
