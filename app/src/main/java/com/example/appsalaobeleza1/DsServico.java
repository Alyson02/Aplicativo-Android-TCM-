package com.example.appsalaobeleza1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class DsServico extends AppCompatActivity {

    ArrayList<DtoAtiv> arrayListAtiv = new ArrayList<>();
    RecyclerView recyclerViewAtiv;
    LinearLayout addAtiv;
    Button btnCancel, btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_servico);

        recyclerViewAtiv = findViewById(R.id.listAtv);
        addAtiv = findViewById(R.id.ll_addAtiv);
        btnConfirm = findViewById(R.id.btn_confirmar);
        btnCancel = findViewById(R.id.btn_cancelar);

        // carregar
        carregaAtivs();

        AdaperAtiv adaperAtiv = new AdaperAtiv(arrayListAtiv);

        recyclerViewAtiv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewAtiv.setAdapter(adaperAtiv);

        //evento de click
        addAtiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Servico.class);
                startActivity(intent);
            }
        });
//
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Servico.class);
                startActivity(intent);
            }
        });
    }

    private void carregaAtivs() {
        DtoAtiv ativ = new DtoAtiv("Desenvolver o back do sistema com ASP.NET");
        DtoAtiv ativ2 = new DtoAtiv("Desenvolver o front do sistema com ASP.NET");

        arrayListAtiv.add(ativ);
        arrayListAtiv.add(ativ2);
    }

    private void openDialog() {
        AtivDialog ativDialog = new AtivDialog();
        ativDialog.show(getSupportFragmentManager(), "Ativ Dialog");
    }
}