package com.example.responsi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi.DataRS;
import com.example.responsi.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {

    private ArrayList<DataRS> dataItems = new ArrayList<>();
    private Context context;

    public AdapterList(Context context, List<DataRS> dataItems) {
        this.context = context;
        this.dataItems = (ArrayList<DataRS>) dataItems;
    }

    public void setData(ArrayList<DataRS> items){
        dataItems.clear();
        dataItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public AdapterList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.ViewHolder holder, int position) {
        holder.tvRS.setText(dataItems.get(position).getNama());
        holder.tvAlamat.setText(dataItems.get(position).getAlamat());
        holder.bMaps.setOnClickListener(view -> {
            String address = String.format("geo: 0, 0?q= %s", dataItems.get(position).getNama());
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
            intent.setPackage("com.google.android.apps.maps");
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRS, tvAlamat;
        private Button bMaps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRS = itemView.findViewById(R.id.tv_rs);
            tvAlamat = itemView.findViewById(R.id.tv_allalamat);
            bMaps = itemView.findViewById(R.id.btn_maps);
        }
    }
}

