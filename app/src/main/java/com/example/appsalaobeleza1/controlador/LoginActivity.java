package com.example.appsalaobeleza1.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appsalaobeleza1.BottomMenuActivity;
import com.example.appsalaobeleza1.R;
import com.example.appsalaobeleza1.utils.Mensagem;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;
    LoginDto loginDto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.inputUser);
        password = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnEnviar);

        loginDto = new LoginDto("123","gmail");



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((username.getText().toString().equals(null) || password.getText().toString().equals(null)) ||
                        (username.getText().toString().equals("") || password.getText().toString().equals(""))) {
                    Mensagem.exibirMensagem(getApplicationContext(), "Campos vazios!");
                }else {

                    if (loginDto.autenticar(password.getText().toString(), username.getText().toString())) {
                        Log.i("Validação", "Usuario" + username + "\n Senha" + password);
                        Intent telaMenu = new Intent(getApplicationContext(), BottomMenuActivity.class);
                        startActivity(telaMenu);
                        Mensagem.exibirMensagem(getApplicationContext(), "Logado com sucesso!!");
                    } else {
                        Mensagem.exibirMensagem(getApplicationContext(), "Usuario/Senha inválidos!!");
                    }
                }
            }
        });
    }
}