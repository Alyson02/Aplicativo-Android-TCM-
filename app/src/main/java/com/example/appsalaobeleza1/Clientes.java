package com.example.appsalaobeleza1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.example.appsalaobeleza1.utils.DtoCliente;
import com.example.appsalaobeleza1.utils.adapterCliente;

import java.util.ArrayList;

public class Clientes extends AppCompatActivity {

    ArrayList<DtoCliente> arrayListCliente = new ArrayList<>();
    RecyclerView recyclerViewCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        recyclerViewCliente = findViewById(R.id.recyclerViewCliente);

        carregaClientes();
        adapterCliente adapter = new adapterCliente(arrayListCliente);



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