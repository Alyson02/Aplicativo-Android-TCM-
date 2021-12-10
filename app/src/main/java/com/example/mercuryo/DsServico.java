package com.example.mercuryo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DsServico extends AppCompatActivity {

    ArrayList<DtoAtiv> arrayListAtiv = new ArrayList<>();
    RecyclerView recyclerViewAtiv;
    LinearLayout addAtiv;
    Button btnCancel, btnConfirm;
    DaoMercurio daoMercurio;
    TextView titulo, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_servico);

        daoMercurio = new DaoMercurio(this);
        recyclerViewAtiv = findViewById(R.id.listAtv);
        addAtiv = findViewById(R.id.ll_addAtiv);
        btnConfirm = findViewById(R.id.btn_confirmar);
        btnCancel = findViewById(R.id.btn_cancelar);
        titulo = findViewById(R.id.tvTitulo);
        desc = findViewById(R.id.tvDesc);

        Bundle bundle = getIntent().getExtras();
        titulo.setText(bundle.getString("titulo"));
        desc.setText(bundle.getString("desc"));

        // carregar
        carregaAtivs();

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

    public void carregaAtivs() {
       /*DtoAtiv ativ = new DtoAtiv("Desenvolver o back do sistema com ASP.NET");
        DtoAtiv ativ2 = new DtoAtiv("Desenvolver o front do sistema com ASP.NET");

        arrayListAtiv.add(ativ);
        arrayListAtiv.add(ativ2);*/


        arrayListAtiv = daoMercurio.consultarAtiv();

        AdaperAtiv adaperAtiv = new AdaperAtiv(arrayListAtiv);

        recyclerViewAtiv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewAtiv.setAdapter(adaperAtiv);
    }

    private void openDialog() {
        AtivDialog ativDialog = new AtivDialog();
        ativDialog.show(getSupportFragmentManager(), "Ativ Dialog");
    }
}