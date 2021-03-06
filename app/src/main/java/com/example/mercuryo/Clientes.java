package com.example.mercuryo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Clientes extends AppCompatActivity implements AdapterCliente.OnNoteListener {

    ArrayList<DtoCliente> arrayListCliente = new ArrayList<>();
    RecyclerView recyclerViewCliente;
    CardView cardAddCli;
    DaoMercurio daoMercurio;
    DtoCliente dtoCliente;
    EditText edPesquisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        //variável de inicialização e atribuição
        recyclerViewCliente = findViewById(R.id.recyclerViewCliente);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navogatiom);
        cardAddCli = findViewById(R.id.cardAddCli);
        edPesquisa = findViewById(R.id.edPesquisa);


        // Setar a home selecionada
        bottomNavigationView.setSelectedItemId(R.id.client);

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
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(), UserActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        cardAddCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InsCliente.class);
                startActivity(intent);
            }
        });

        carregaClientes();

        edPesquisa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                arrayListCliente = daoMercurio.consultarCliPorNome(editable.toString());
                AdapterCliente adapter = new AdapterCliente(arrayListCliente,Clientes.this );
                recyclerViewCliente.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerViewCliente.setAdapter(adapter);

            }
        });
    }



    private void carregaClientes() {
        /*DtoCliente cliente = new DtoCliente("Tony Stark", "Genio playboy milionáro e filantropo", R.drawable.tony);
        DtoCliente cliente2 = new DtoCliente("Bruce Wayne", "Morcegão que te assombra", R.drawable.batman);

        arrayListCliente.add(cliente);
        arrayListCliente.add(cliente2);*/

        daoMercurio = new DaoMercurio(this);
        arrayListCliente = daoMercurio.consultarCli();

        AdapterCliente adapter = new AdapterCliente(arrayListCliente, this);
        recyclerViewCliente.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewCliente.setAdapter(adapter);
    }

    @Override
    public void onNoteClick(int position) {
        daoMercurio = new DaoMercurio(getApplicationContext());
        dtoCliente = new DtoCliente();
        dtoCliente = arrayListCliente.get(position);
        Intent intent = new Intent(this, UpdateCliActivity.class);
        //Como passar esse item selecionado:
        //intent.putExtra("some_object", arrayListServ.get(position)  obs: pesquisar: Como anexar objetos parcel a pacotes );
        intent.putExtra("nome", dtoCliente.getNome());
        intent.putExtra("desc", dtoCliente.getDesc());
        intent.putExtra("email", dtoCliente.getEmail());
        intent.putExtra("tel", dtoCliente.getTelefone());
        intent.putExtra("id", dtoCliente.getId());
        startActivity(intent);
    }
}