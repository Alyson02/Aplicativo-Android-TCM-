package com.example.appsalaobeleza1.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsalaobeleza1.DaoMercurio;
import com.example.appsalaobeleza1.Servico;
import com.example.appsalaobeleza1.CadastraFunc;
import com.example.appsalaobeleza1.EsqueciSenha;
import com.example.appsalaobeleza1.R;
import com.example.appsalaobeleza1.utils.Mensagem;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin, btnCad;
    LoginDto loginDto;
    DaoMercurio daoMercurio;
    TextView twEsqueci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.inputUser);
        password = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnEnviar);
        twEsqueci = findViewById(R.id.txtEsqueci);
        btnCad = findViewById(R.id.btnCad);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                daoMercurio = new DaoMercurio(getApplicationContext());

                try {
                    boolean verifica = daoMercurio.verificaLogin(username.getText().toString(),
                                                                 password.getText().toString());

                    if ((username.getText().toString().equals(null) || password.getText().toString().equals(null)) ||
                            (username.getText().toString().equals("") || password.getText().toString().equals(""))) {
                        Mensagem.exibirMensagem(getApplicationContext(), "Campos vazios!");
                    } else {
                        if(verifica) {
                            Log.i("Validação", "Usuario" + username + "\n Senha" + password);
                            Toast.makeText(getApplicationContext(), "Logado com sucesso", Toast.LENGTH_SHORT).show();
                            Intent telaMenu = new Intent(getApplicationContext(), Servico.class);
                            startActivity(telaMenu);
                        }else{
                            Toast.makeText(getApplicationContext(), "Email ou senha incorreto!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Erro no banco de dados: " + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CadastraFunc.class);
                startActivity(intent);
            }
        });

        twEsqueci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EsqueciSenha.class);
                startActivity(intent);
            }
        });
    }
}