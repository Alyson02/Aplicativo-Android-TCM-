package com.example.appsalaobeleza1.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public abstract  class RepositorioBase extends SQLiteOpenHelper {
    private  static  final int DATABASE_VERSION =1 ;
    public static final String DATABASE_NAME = "dbSalaoBeleza";
    private Context context;

    public RepositorioBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        criarTabelaUsuario(db);

    }
    private void criarTabelaUsuario (SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE usuario( ";
        sql += "codigo INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "nome TEXT, ";
        sql += "login TEXT, ";
        sql += "senha TEXT ";
        sql += ")" ;

        db.execSQL(sql);
    }

    protected boolean salvar(String nomeTabela, ContentValues objeto){
        boolean sucesso = false;
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.insert(nomeTabela, null, objeto);
            sucesso = true;
        } catch (Exception e){
            sucesso = false;
            Log.e("Erro ao salvar " + objeto, e.toString());
        }
        db.close();
        return sucesso;
    }
}
    