package com.example.mercuryo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setuser(String user) {
        prefs.edit().putString("usename", user).commit();
    }

    public String getuser() {
        String user = prefs.getString("usename","");
        return user;
    }

    public void setpass(String pass) {
        prefs.edit().putString("pass", pass).commit();
    }

    public String getpass() {
        String pass = prefs.getString("pass","");
        return pass;
    }

    public void setid(int id){
        prefs.edit().putInt("id", id ).commit();
    }

    public int getid(){
        int id = prefs.getInt("id", 0);
        return id;
    }

    public void setnome(String nome) {
        prefs.edit().putString("nome", nome).commit();
    }

    public String getnome() {
        String nome = prefs.getString("nome","");
        return nome;
    }
}
