package com.example.appsalaobeleza1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterServ extends  RecyclerView.Adapter<AdapterServ.ServViewHolder>{

    ArrayList<DtoServ> arrayListServ;

    public AdapterServ(ArrayList<DtoServ> arrayListServ) {
        this.arrayListServ = arrayListServ;
    }

    /*passo para implementar o adapter

           1 - implementar uma classe privada com o nome de viewholder extendendo um RecyclerView.ViewHolder
           2 - Implementar o construtor dessa classe privada (dica: use o sistema da ide para gerar isso)
           3 - Implementar metodos abstrados para começar a estrutura baisca do adapter
        *
        */
    @NonNull
    @Override
    public ServViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_serv,parent,false);
        return new ServViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ServViewHolder holder, int position) {
        holder.txtTitulo.setText(arrayListServ.get(position).getTitulo());
        holder.txtDesc.setText(arrayListServ.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return arrayListServ.size();
    }

    public class ServViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitulo, txtDesc;
        public ServViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.tituloServ);
            txtDesc = itemView.findViewById(R.id.desc);
        }
    }


}
