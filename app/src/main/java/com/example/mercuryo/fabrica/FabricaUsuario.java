package com.example.mercuryo.fabrica;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.mercuryo.dominio.Usuario;


public class FabricaUsuario {

    public static Usuario criarUsuario (Cursor cursor) {
        Usuario usuario = new Usuario();

        usuario.setCodigo(Long.parseLong(cursor.getString(0)));
        usuario.setNome(cursor.getString(2));
        usuario.setLogin(cursor.getString(1));
        usuario.setSenha(cursor.getString(3));

        return usuario;

    }

    public static ContentValues criarUsuarioCv (Usuario usuario) {
        ContentValues usuarioCv = new ContentValues();

        usuarioCv.put("nome", usuario.getNome());
        usuarioCv.put("login", usuario.getLogin());
        usuarioCv.put("senha", usuario.getSenha());

        return usuarioCv;
    }
}
