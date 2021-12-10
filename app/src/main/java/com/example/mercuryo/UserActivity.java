package com.example.mercuryo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mercuryo.controlador.LoginDto;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity {

    TextView nome;
    EditText email, senha;
    Button btn;
    int id;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //variável de inicialização e atribuição
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navogatiom);
        nome = findViewById(R.id.txtNome);
        email = findViewById(R.id.inputEmailUser);
        senha = findViewById(R.id.inputPassUser);
        btn = findViewById(R.id.btnAlteraAcesso);
        session = new Session(this);

        email.setText(session.getuser());
        senha.setText(session.getpass());
        nome.setText(session.getnome());
        id = session.getid();

        // Setar a home selecionada
        bottomNavigationView.setSelectedItemId(R.id.user);

        //Evento
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Servico.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.client:
                        startActivity(new Intent(getApplicationContext(), Clientes.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.user:
                        return true;
                }
                return false;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDto user = new LoginDto(
                        senha.getText().toString(),
                        email.getText().toString(),
                        id);
                DaoMercurio daoMercurio = new DaoMercurio(getApplicationContext());
                try {
                    long linhasInseridas = daoMercurio.alterarFunc(user);
                    if(linhasInseridas>0){
                        Toast.makeText(getApplicationContext(), "Alterado com sucesso", Toast.LENGTH_SHORT).show();
                        session.setuser(email.getText().toString());
                        session.setpass(senha.getText().toString());
                        Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Não foi possível alterar", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception exception){
                    Toast.makeText(getApplicationContext(), "Erro ao alterar: " + exception.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}