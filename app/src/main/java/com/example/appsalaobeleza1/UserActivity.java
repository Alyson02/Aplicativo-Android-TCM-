package com.example.appsalaobeleza1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    }
}