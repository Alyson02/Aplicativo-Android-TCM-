package com.example.appsalaobeleza1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterCliente extends RecyclerView.Adapter<AdapterCliente.ClienteViewHolder> {

    DaoMercurio daoMercurio;
    DtoCliente dtoCliente;
    ArrayList<DtoCliente> arrayListCliente;
    OnNoteListener onNoteListener;

    public AdapterCliente(ArrayList<DtoCliente> arrayListCliente, OnNoteListener onNoteListener) {
        this.arrayListCliente = arrayListCliente;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cliente,parent,false);
        return new ClienteViewHolder(itemLista, onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, int position) {
        holder.txtTitulo.setText(arrayListCliente.get(position).getNome());
        holder.txtDesc.setText(arrayListCliente.get(position).getDesc());
        holder.imgView.setImageResource(arrayListCliente.get(position).getIdImage());

    }

    @Override
    public int getItemCount() {
        return arrayListCliente.size();
    }

    public class  ClienteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtTitulo, txtDesc;
        ImageView imgView;
        OnNoteListener onNoteListener;

        public ClienteViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.textViewTitulo);
            txtDesc = itemView.findViewById(R.id.textViewDesc);
            imgView = itemView.findViewById(R.id.imgCli);


            this.onNoteListener = onNoteListener;


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    //arrayListCliente.remove(getAdapterPosition());
                    //notifyItemRemoved(getAdapterPosition());
                    daoMercurio = new DaoMercurio(view.getContext());
                    int pos = getAdapterPosition();
                    dtoCliente = new DtoCliente();
                    dtoCliente = arrayListCliente.get(pos);
                    int del = daoMercurio.excluir(dtoCliente);
                    if(del > 0) {
                        arrayListCliente.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        return true;
                    }else{
                        Toast.makeText(view.getContext(), "Deletado com sucesso", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
            });

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
