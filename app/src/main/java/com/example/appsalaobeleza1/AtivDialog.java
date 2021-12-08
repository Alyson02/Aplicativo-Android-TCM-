package com.example.appsalaobeleza1;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class AtivDialog extends DialogFragment {
    private EditText editTxtDescAtiv, editTxtDate;
    DatePickerDialog.OnDateSetListener setListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_dialog_ativ, null);

        builder.setView(view)
                .setTitle("Cadastrar atividade")
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DtoAtiv dtoAtiv = new DtoAtiv(
                                editTxtDescAtiv.getText().toString());
                        DaoMercurio daoMercurio = new DaoMercurio(getActivity().getApplicationContext());
                        try {
                            long linhasInseridas = daoMercurio.inserirAtiv(dtoAtiv);
                            if(linhasInseridas>0){
                                Toast.makeText(getActivity().getApplicationContext(), "Inserido com sucesso", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity().getApplicationContext(), DsServico.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getActivity().getApplicationContext(), "Não foi possível inserir", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception exception){
                            Toast.makeText(getActivity().getApplicationContext(), "Erro ao inserir: " + exception.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

        editTxtDescAtiv = view.findViewById(R.id.edit_dsAtiv);
        editTxtDate = view.findViewById(R.id.date);


        Calendar calendar = Calendar.getInstance();
        final int ano = calendar.get(Calendar.YEAR);
        final int mes = calendar.get(Calendar.MONTH);
        final int dia = calendar.get(Calendar.DAY_OF_MONTH);

//        editTxtDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DatePickerDialog datePickerDialog = new DatePickerDialog(
//                        getActivity().getApplicationContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth
//                        ,setListener,ano,mes,dia);
//                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                datePickerDialog.show();
//            }
//        });

// precisa de um textview
//        setListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
//                mes = mes=1;
//                String date = dia+"/"+mes+"/"+ano;
//                editTxtDate.setText(date);
//            }
//        };

        editTxtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                    getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
                        mes = mes+1;
                        String date = dia+"/"+mes+"/"+ano;
                        editTxtDate.setText(date);
                    }
                },ano,mes,dia);
                datePickerDialog.show();
            }
        });

        return builder.create();
    }
}
