package com.example.appsalaobeleza1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.DialogCompat;
import androidx.fragment.app.DialogFragment;

public class AddServDialog extends DialogFragment {
    private EditText editTextNomeProj, editTextDesc;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_dialog, null);

        editTextNomeProj = view.findViewById(R.id.edit_nomeproj);
        editTextDesc = view.findViewById(R.id.descproj);

        builder.setView(view)
                .setTitle("Cadastrar serviço")
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DtoServ dtoServ = new DtoServ(
                                editTextNomeProj.getText().toString(),
                                editTextDesc.getText().toString());
                        DaoMercurio daoMercurio = new DaoMercurio(getActivity().getApplicationContext());
                        try {
                            long linhasInseridas = daoMercurio.inserirServ(dtoServ);
                            if(linhasInseridas>0){
                                Toast.makeText(getActivity().getApplicationContext(), "Inserido com sucesso", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception exception){
                            Toast.makeText(getActivity().getApplicationContext(), "Erro ao inserir: " + exception.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

        return  builder.create();

    }
}
