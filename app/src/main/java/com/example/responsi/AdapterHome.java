package com.example.responsi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi.R;

import java.util.ArrayList;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {

    private ArrayList<ContentItem> contentItems = new ArrayList<>();
    private Context context;

    public AdapterHome(Context context) {
    }


    public void setData(ArrayList<ContentItem> items){
        contentItems.clear();
        contentItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public AdapterHome.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHome.ViewHolder holder, int position) {
        holder.tvDate.setText(contentItems.get(position).getTanggal());
        holder.tvConf.setText(String.valueOf(contentItems.get(position).getConfirmationDiisolasi()));
        holder.tvSembuh.setText(String.valueOf(contentItems.get(position).getConfirmationSelesai()));
        holder.tvDead.setText(String.valueOf(contentItems.get(position).getConfirmationMeninggal()));
    }

    @Override
    public int getItemCount() {
        return contentItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate, tvConf, tvSembuh, tvDead;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvConf = itemView.findViewById(R.id.tv_allconf);
            tvSembuh = itemView.findViewById(R.id.tv_allsembuh);
            tvDead = itemView.findViewById(R.id.tv_alldead);
        }
    }
}