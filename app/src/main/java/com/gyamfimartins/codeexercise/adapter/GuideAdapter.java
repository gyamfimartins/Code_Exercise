package com.gyamfimartins.codeexercise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gyamfimartins.codeexercise.R;
import com.gyamfimartins.codeexercise.model.Data;

import java.util.ArrayList;
import java.util.List;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.GuideViewHolder> {
     private List<Data> guideLists = new ArrayList<>();
     private Context context;
    @NonNull
    @Override
    public GuideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row,parent,false);
        return new GuideViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GuideViewHolder holder, int position) {
        Data data = guideLists.get(position);
        String name = data.getName();
        String endDate = data.getEndDate();
        String location = data.getVenue().getCity() + " | " + data.getVenue().getState();
        String icon = data.getIcon();

        holder.tvName.setText(name);
        holder.tvEndDate.setText(endDate);
        holder.tvLocation.setText(location);

        Glide.with(context)
                .load(icon)
                .thumbnail(0.5f)
                .into(holder.ivIcon);
    }

    public void getguideList(List<Data> guideLists, Context context){
        this.guideLists = guideLists;
        this.context =context;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return guideLists.size();
    }

    class GuideViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvName,tvLocation,tvEndDate;
        public GuideViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvEndDate = itemView.findViewById(R.id.tvEndDate);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }
}
