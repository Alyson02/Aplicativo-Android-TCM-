package com.example.appsalaobeleza1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaperAtiv extends RecyclerView.Adapter<AdaperAtiv.AtivViewwHolder>{

    ArrayList<DtoAtiv> arrayListAtiv;

    public AdaperAtiv(ArrayList<DtoAtiv> arrayListAtiv) {
        this.arrayListAtiv = arrayListAtiv;
    }

    @NonNull
    @Override
    public AtivViewwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_ativ,parent,false);
        return new AdaperAtiv.AtivViewwHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AtivViewwHolder holder, int position) {
        holder.atividade.setText(arrayListAtiv.get(position).getAtividade());
    }

    @Override
    public int getItemCount() {
        return arrayListAtiv.size();
    }

    public class AtivViewwHolder extends RecyclerView.ViewHolder{
        TextView atividade;
        public AtivViewwHolder(@NonNull View itemView) {
            super(itemView);
            atividade = itemView.findViewById(R.id.txtAtiv);
        }
    }
}
