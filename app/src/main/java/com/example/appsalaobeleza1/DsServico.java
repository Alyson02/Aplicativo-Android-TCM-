package com.example.appsalaobeleza1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class DsServico extends AppCompatActivity {

    ArrayList<DtoAtiv> arrayListAtiv = new ArrayList<>();
    RecyclerView recyclerViewAtiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_servico);

        recyclerViewAtiv = findViewById(R.id.listAtv);

        carregaAtivs();

        AdaperAtiv adaperAtiv = new AdaperAtiv(arrayListAtiv);

        recyclerViewAtiv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewAtiv.setAdapter(adaperAtiv);
    }

    private void carregaAtivs() {
        DtoAtiv ativ = new DtoAtiv("Desenvolver o back do sistema com ASP.NET");
        DtoAtiv ativ2 = new DtoAtiv("Desenvolver o front do sistema com ASP.NET");

        arrayListAtiv.add(ativ);
        arrayListAtiv.add(ativ2);
    }
}