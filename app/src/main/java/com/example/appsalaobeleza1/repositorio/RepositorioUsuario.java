package com.example.appsalaobeleza1.repositorio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.annotation.Nullable;

import com.example.appsalaobeleza1.fabrica.FabricaUsuario;
import com.example.appsalaobeleza1.dominio.Usuario;

import java.util.LinkedList;
import java.util.List;

public class RepositorioUsuario extends RepositorioBase {
    private static final String TABELA_USUARIO = "usuario";

    public RepositorioUsuario(@Nullable Context context) {
        super(context);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS usuario");
        this.onCreate(db);
    }

    public boolean salvarUsuario(Usuario usuario) {
        boolean salvo = salvar(TABELA_USUARIO, FabricaUsuario.criarUsuarioCv(usuario));
        Log.d("salvarUsuario", usuario.toString());
        return salvo;
    }

    public List<Usuario> obterTodos() {
        List<Usuario> usuarios = new LinkedList<Usuario>();
        String sql = "SELECT * FROM " + TABELA_USUARIO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                usuarios.add(FabricaUsuario.criarUsuario(cursor));
            } while (cursor.moveToNext());
        }
        Log.d("obterTodos", usuarios.toString());
        return usuarios;
    }

}
