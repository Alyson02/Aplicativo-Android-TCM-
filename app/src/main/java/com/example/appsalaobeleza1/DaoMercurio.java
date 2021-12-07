package com.example.appsalaobeleza1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DaoMercurio extends SQLiteOpenHelper {

    private final String tabelaServ = "SERVICO";

    public DaoMercurio(@Nullable Context context) {
        super(context, "DB_MERCURIO", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Metodo que é chamado automaticamente e cria tabelas

        String comando = "CREATE TABLE " + tabelaServ + "(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOME VARCHAR(50)," +
                "DESCRICAO VARCHAR(100))";

        sqLiteDatabase.execSQL(comando);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //metodo usado para alterar coisas, exemplo: adicionar um campo na tabela
    }

    public long inserirServ(DtoServ dtoServ){
        //Classe para associar os valores digitados do usuario a coluna
        ContentValues values = new ContentValues();
        values.put("Nome", dtoServ.getTitulo());
        values.put("DESCRICAO", dtoServ.getDesc());

        long nLinha = getWritableDatabase().insert(tabelaServ, null, values);

        return nLinha;
    }

}
