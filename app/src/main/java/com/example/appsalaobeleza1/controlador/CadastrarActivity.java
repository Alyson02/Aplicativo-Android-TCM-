package com.example.appsalaobeleza1.controlador;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appsalaobeleza1.R;
import com.example.appsalaobeleza1.dominio.Usuario;
import com.example.appsalaobeleza1.utils.Mensagem;

public class CadastrarActivity extends BaseActivity {
EditText editTextNome, editTextLogin,editTextSenha;
Button buttonSalvarCadastro, buttonConsultarCadastro;
ListView listViewTodos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inicializar();
        configurarBotao();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void inicializar() {
        editTextNome = findViewById(R.id.editTextNome);
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonSalvarCadastro = findViewById(R.id.buttonSalvarCadastro);
        buttonConsultarCadastro = findViewById(R.id.buttonConsultarCadastro);
        listViewTodos = (ListView) findViewById(R.id.listViewTodos);

    }

    private void configurarBotao() {
        buttonSalvarCadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validarObrigatoriedadeCampos()) {

                   String nome = obterTexto(editTextNome);
                    String login = obterTexto(editTextLogin);
                    String senha = obterTexto (editTextSenha);


                    if (repositorioUsuario.salvarUsuario(new Usuario(nome, login, senha))) {
                        Mensagem.exibirMensagem(getApplicationContext(), "Usuario cadastrado com sucesso");

                    } else {
                        Mensagem.exibirMensagem(getApplicationContext(), "Falha ao cadastrar usuario");
                    }
                }
            }
        });
        buttonConsultarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listViewTodos.setAdapter(new ArrayAdapter<Usuario>(CadastrarActivity.this,
                        android.R.layout.simple_list_item_1, repositorioUsuario.obterTodos()));
                inicializar();
                configurarBotao();
            }
        });
    }


    private boolean validarObrigatoriedadeCampos() {
        boolean sucesso = false;

        if (obterTexto(editTextNome).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um nome valido");
            sucesso = false;
        } else if (obterTexto(editTextLogin).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira um login valido");
            sucesso = false;
        } else if (obterTexto(editTextSenha).isEmpty()) {
            Mensagem.exibirMensagem(this, "Insira uma senha valida");
            sucesso = false;
        }else {
            sucesso = true;
        }

        return sucesso;
    }



}