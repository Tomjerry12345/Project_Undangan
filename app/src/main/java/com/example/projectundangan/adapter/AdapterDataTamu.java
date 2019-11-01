package com.example.projectundangan.adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectundangan.R;
import com.example.projectundangan.model.Tamu;

import java.util.List;


public class AdapterDataTamu extends RecyclerView.Adapter<AdapterDataTamu.MyAdapterViewHolder> {
    List<Tamu> listItemsArrayList;
    Context context;

    public AdapterDataTamu(List<Tamu> listItemsArrayList , Context context) {
        this.listItemsArrayList = listItemsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterDataTamu.MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tamu , parent , false);
        return new MyAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDataTamu.MyAdapterViewHolder holder, int position) {


        Tamu listItem = listItemsArrayList.get(position);
        holder.textNama.setText(listItem.getNama());
        holder.textAlamat.setText(listItem.getAlamat());

        Linkify.addLinks(holder.textNama , Linkify.ALL);

    }

    @Override
    public int getItemCount() {
        return listItemsArrayList.size();
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView textNama , textAlamat;
        CardView cardView;
        public MyAdapterViewHolder(final View itemView) {
            super(itemView);
            textNama = itemView.findViewById(R.id.txtNama);
            textAlamat = itemView.findViewById(R.id.txtAlamat);
            cardView = itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String alamat = listItemsArrayList.get(getAdapterPosition()).getAlamat();

                    Intent i = new Intent();
                    i.setAction(Intent.ACTION_SEND);
                    i.putExtra(Intent.EXTRA_TEXT , alamat);
                    i.setType("text/plain");
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }
}
