package com.example.appsalaobeleza1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class BottomMenuActivity extends AppCompatActivity {

    private ImageView info = null;
    ArrayList<DtoServ> arrayListServ = new ArrayList<>();
    RecyclerView recyclerViewServ;
    ArrayList<DtoAtiv> arrayListAtiv = new ArrayList<>();
    RecyclerView recyclerViewAtiv;
    CardView cardAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_menu);

        //variável de inicialização e atribuição
        recyclerViewServ = findViewById(R.id.recyclerViewServ);
        recyclerViewAtiv = findViewById(R.id.listAtv);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navogatiom);
        info = findViewById(R.id.imgInfo);
        cardAdd = findViewById(R.id.cardAdd);

        // Setar a home selecionada
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Evento para o item do menu home
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.client:
                        startActivity(new Intent(getApplicationContext(), Clientes.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(), UserActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        //evento para ir para pagina info

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(getApplicationContext(), Info.class);
                startActivity(info);
            }
        });

        cardAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        carregaServs();

        AdapterServ adapter = new AdapterServ(arrayListServ);


//        LinearLayoutManager layoutManager
//                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerViewServ.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        recyclerViewServ.setAdapter(adapter);

        carregaAtivs();

        AdaperAtiv adaperAtiv = new AdaperAtiv(arrayListAtiv);

        recyclerViewAtiv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewAtiv.setAdapter(adaperAtiv);

    }

    private void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    private void carregaServs() {
        DtoServ serv = new DtoServ("Infinity Games", "Espoiler para um aplicativo e-comeerce no terceito semestre");
        DtoServ serv2 = new DtoServ("Sim!", "Talvez amanhã?");

        arrayListServ.add(serv);
        arrayListServ.add(serv2);
    }

    private void carregaAtivs() {
        DtoAtiv ativ = new DtoAtiv("Desenvolver o back do sistema com ASP.NET");
        DtoAtiv ativ2 = new DtoAtiv("Desenvolver o front do sistema com ASP.NET");

        arrayListAtiv.add(ativ);
        arrayListAtiv.add(ativ2);
    }
}