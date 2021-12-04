package com.example.appsalaobeleza1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Clientes extends AppCompatActivity {

    ArrayList<DtoCliente> arrayListCliente = new ArrayList<>();
    RecyclerView recyclerViewCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        //variável de inicialização e atribuição
        recyclerViewCliente = findViewById(R.id.recyclerViewCliente);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navogatiom);

        // Setar a home selecionada
        bottomNavigationView.setSelectedItemId(R.id.client);

        //Evento
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), BottomMenuActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.client:
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(), UserActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


        carregaClientes();
        AdapterCliente adapter = new AdapterCliente(arrayListCliente);



        recyclerViewCliente.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewCliente.setAdapter(adapter);
    }

    private void carregaClientes() {
        DtoCliente cliente = new DtoCliente("Tony Stark", "Genio playboy milionáro e filantropo", R.drawable.tony);
        DtoCliente cliente2 = new DtoCliente("Bruce Wayne", "Morcegão que te assombra", R.drawable.batman);

        arrayListCliente.add(cliente);
        arrayListCliente.add(cliente2);
    }
}