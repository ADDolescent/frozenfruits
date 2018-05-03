package com.example.jameswidjaja.frozenfruits;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class data_Adapter extends RecyclerView.Adapter<data_Adapter.MyViewHolder> {

    private List<record> recordList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nama, barang, harga_satu, kuantitas;

        public MyViewHolder(View view) {
            super(view);
            nama = view.findViewById(R.id.Nama);
            harga_satu = view.findViewById(R.id.Harga_satu);
            barang = view.findViewById(R.id.Barang);
            kuantitas = view.findViewById(R.id.Kuantitas);
        }
    }


    public data_Adapter(List<record> recordsList) {
        this.recordList = recordsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        record record = recordList.get(position);
        holder.nama.setText(record.getNama());
        holder.barang.setText(record.getBarang());
        holder.harga_satu.setText(record.getHarga_satu());
        holder.kuantitas.setText(record.getKuantitas());
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }
}