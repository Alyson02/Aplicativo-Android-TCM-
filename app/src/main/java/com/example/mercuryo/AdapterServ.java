package com.example.mercuryo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterServ extends  RecyclerView.Adapter<AdapterServ.ServViewHolder>{

    ArrayList<DtoServ> arrayListServ;
    private OnNoteListener onNoteListener;


    public AdapterServ(ArrayList<DtoServ> arrayListServ, OnNoteListener onNoteListener) {
        this.arrayListServ = arrayListServ;
        this.onNoteListener = onNoteListener;
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
        return new ServViewHolder(itemLista, onNoteListener);
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

    public class ServViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView txtTitulo, txtDesc;
        OnNoteListener onNoteListener;
        public ServViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.tituloServ);
            txtDesc = itemView.findViewById(R.id.desc);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }


}
