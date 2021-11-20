package com.example.appsalaobeleza1.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsalaobeleza1.R;

import java.util.ArrayList;

public class adapterCliente extends RecyclerView.Adapter<adapterCliente.ClienteViewHolder> {

    ArrayList<DtoCliente> arrayListCliente;
    public adapterCliente(ArrayList<DtoCliente> arrayListCliente) {
        this.arrayListCliente = arrayListCliente;
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cliente,parent,false);
        return new ClienteViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, int position) {
        holder.txtTitulo.setText(arrayListCliente.get(position).getTitulo());
        holder.txtDesc.setText(arrayListCliente.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return arrayListCliente.size();
    }

    public class  ClienteViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitulo, txtDesc;

        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitulo = itemView.findViewById(R.id.textViewTitulo);
            txtDesc = itemView.findViewById(R.id.textViewDesc);
        }
    }

}
