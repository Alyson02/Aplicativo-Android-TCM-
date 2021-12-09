package com.example.appsalaobeleza1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appsalaobeleza1.controlador.LoginDto;

import java.util.ArrayList;

public class DaoMercurio extends SQLiteOpenHelper {

    private final String tabelaServ = "SERVICO";
    private final String tabelaAtiv = "ATIVIDADE";
    private final String tabelaCli = "CLIENTE";
    private final String tabelaFunc = "FUNCIONARIO";

    public DaoMercurio(@Nullable Context context) {
        super(context, "DB_MERCURIO", null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Metodo que é chamado automaticamente e cria tabelas

        String cmdServ = "CREATE TABLE " + tabelaServ + "(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOME VARCHAR(50)," +
                "DESCRICAO VARCHAR(100))";

        String cmdAtiv = "CREATE TABLE " + tabelaAtiv + "(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DESCRICAO VARCHAR(100))";

        String cmdCli = "CREATE TABLE " + tabelaCli + "(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOME VARCHAR(100)," +
                "DESCRICAO VARCHAR(100)," +
                "EMAIL VARCHAR(200)," +
                "TELEFONE VARCHAR(15))";

        String cmdFunc = "CREATE TABLE " + tabelaFunc + "(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOME VARCHAR(100)," +
                "EMAIL VARCHAR(200)," +
                "SENHA VARCHAR(100)," +
                "CPF VARCHAR(20))";

        sqLiteDatabase.execSQL(cmdServ);
        sqLiteDatabase.execSQL(cmdAtiv);
        sqLiteDatabase.execSQL(cmdCli);
        sqLiteDatabase.execSQL(cmdFunc);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //metodo usado para alterar coisas, exemplo: adicionar um campo na tabela ou uma tabela
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tabelaServ);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tabelaAtiv);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tabelaCli);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tabelaFunc);
        onCreate(sqLiteDatabase);
    }

    public long inserirServ(DtoServ dtoServ){
        //Classe para associar os valores digitados do usuario a coluna
        ContentValues values = new ContentValues();
        values.put("NOME", dtoServ.getTitulo());
        values.put("DESCRICAO", dtoServ.getDesc());

        long nLinha = getWritableDatabase().insert(tabelaServ, null, values);

        return nLinha;
    }

    public ArrayList<DtoServ> consultarServ(){
        String comando = "SELECT * FROM " + tabelaServ;
        Cursor cursor = getReadableDatabase().rawQuery(comando, null);
        ArrayList<DtoServ> listServs = new ArrayList<>();

        while(cursor.moveToNext()){
            DtoServ dtoServ = new DtoServ();
            dtoServ.setId(cursor.getInt(0));
            dtoServ.setTitulo(cursor.getString(1));
            dtoServ.setDesc(cursor.getString(2));

            listServs.add(dtoServ);
        }

        return listServs;
    }

    public long inserirAtiv(DtoAtiv dtoAtiv){
        //Classe para associar os valores digitados do usuario a coluna
        ContentValues values = new ContentValues();
        values.put("DESCRICAO", dtoAtiv.getAtividade());

        long nLinha = getWritableDatabase().insert(tabelaAtiv, null, values);

        return nLinha;
    }

    public ArrayList<DtoAtiv> consultarAtiv(){
        String comando = "SELECT * FROM " + tabelaAtiv;
        Cursor cursor = getReadableDatabase().rawQuery(comando, null);
        ArrayList<DtoAtiv> listAtiv = new ArrayList<>();

        while(cursor.moveToNext()){
            DtoAtiv dtoAtiv = new DtoAtiv();
            dtoAtiv.setId(cursor.getInt(0));
            dtoAtiv.setAtividade(cursor.getString(1));

            listAtiv.add(dtoAtiv);
        }

        return listAtiv;
    }


    public long inserirCli(DtoCliente dtoCliente){
        //Classe para associar os valores digitados do usuario a coluna
        ContentValues values = new ContentValues();
        values.put("NOME", dtoCliente.getNome());
        values.put("DESCRICAO", dtoCliente.getDesc());
        values.put("EMAIL", dtoCliente.getEmail());
        values.put("TELEFONE", dtoCliente.getTelefone());

        long nLinha = getWritableDatabase().insert(tabelaCli, null, values);

        return nLinha;
    }

    public ArrayList<DtoCliente> consultarCli(){
        String comando = "SELECT * FROM " + tabelaCli;
        Cursor cursor = getReadableDatabase().rawQuery(comando, null);
        ArrayList<DtoCliente> listAtiv = new ArrayList<>();

        while(cursor.moveToNext()){
            DtoCliente dtoCliente = new DtoCliente();
            dtoCliente.setId(cursor.getInt(0));
            dtoCliente.setNome(cursor.getString(1));
            dtoCliente.setDesc(cursor.getString(2));
            dtoCliente.setEmail(cursor.getString(3));
            dtoCliente.setTelefone(cursor.getString(4));
            dtoCliente.setIdImage(R.drawable.tony);

            listAtiv.add(dtoCliente);
        }

        return listAtiv;
    }

    public ArrayList<DtoCliente> consultarCliPorNome(String nome){
        String comando = "SELECT * FROM " + tabelaCli + " WHERE NOME LIKE ?" + " ORDER BY NOME";
        String[] args = {"%"+nome+"%"};
        Cursor cursor = getReadableDatabase().rawQuery(comando, args);
        ArrayList<DtoCliente> listAtiv = new ArrayList<>();

        while(cursor.moveToNext()){
            DtoCliente dtoCliente = new DtoCliente();
            dtoCliente.setId(cursor.getInt(0));
            dtoCliente.setNome(cursor.getString(1));
            dtoCliente.setDesc(cursor.getString(2));
            dtoCliente.setEmail(cursor.getString(3));
            dtoCliente.setTelefone(cursor.getString(4));
            dtoCliente.setIdImage(R.drawable.tony);

            listAtiv.add(dtoCliente);
        }

        return listAtiv;
    }

    public int excluir(DtoCliente dtoCliente) {
        String id = "id=?";
        String[] args = {dtoCliente.getId()+""};
        return getWritableDatabase().delete(tabelaCli, id, args);
    }


    public long inserirFunc(LoginDto loginDto){
        //Classe para associar os valores digitados do usuario a coluna
        ContentValues values = new ContentValues();
        values.put("NOME", loginDto.getNomeFunc());
        values.put("EMAIL", loginDto.getUsuarioEmail());
        values.put("SENHA", loginDto.getSenha());
        values.put("CPF", loginDto.getCpf());

        long nLinha = getWritableDatabase().insert(tabelaFunc, null, values);

        return nLinha;
    }

    public boolean verificaLogin(String email, String senha){
        String comando = "SELECT * FROM " + tabelaFunc + " WHERE EMAIL = ? AND SENHA = ?";
        String[] args = {email, senha};
        Cursor cursor = getReadableDatabase().rawQuery(comando, args);
        int cursorCount = cursor.getCount();
        if (cursorCount > 0) {
            return true;
        }else {
            return false;
        }
    }

    public long alterarCli(DtoCliente dtoCliente) {
        //Classe para associar os valores digitados do usuario a coluna
        ContentValues values = new ContentValues();
        values.put("NOME", dtoCliente.getNome());
        values.put("DESCRICAO", dtoCliente.getDesc());
        values.put("EMAIL", dtoCliente.getEmail());
        values.put("TELEFONE", dtoCliente.getTelefone());
        String id = "id=?";
        String[] args = {dtoCliente.getId()+""};
        return getWritableDatabase().update(tabelaCli, values, id, args);
    }

    public int pegarId(String user){
        String comando = "SELECT id FROM " + tabelaFunc + " WHERE EMAIL = ?";
        String[] args = {user};
        Cursor cursor = getReadableDatabase().rawQuery(comando, args);
        LoginDto idFunc = new LoginDto();
        while (cursor.moveToNext()){
            idFunc.setId(cursor.getInt(0));
        }
        return idFunc.getId();
    }

    public String pegaNome(String user){
        String comando = "SELECT NOME FROM " + tabelaFunc + " WHERE EMAIL = ?";
        String[] args = {user};
        Cursor cursor = getReadableDatabase().rawQuery(comando, args);
        LoginDto idFunc = new LoginDto();
        while (cursor.moveToNext()){
            idFunc.setNomeFunc(cursor.getString(0));
        }
        return idFunc.getNomeFunc();
    }
}
