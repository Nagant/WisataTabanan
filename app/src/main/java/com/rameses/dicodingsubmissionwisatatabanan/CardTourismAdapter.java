package com.rameses.dicodingsubmissionwisatatabanan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardTourismAdapter extends RecyclerView.Adapter<CardTourismAdapter.CardViewHolder> {
    private ArrayList<Tourism> listToursim;
    private ListTourismAdapter.OnItemClickCallback onItemClickCallback;

    void setOnItemClickCallback(ListTourismAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    CardTourismAdapter(ArrayList<Tourism> listTourism) {
        this.listToursim = listTourism;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_tourism, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        Tourism tourism = listToursim.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tourism.getTourism_photo())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvNumbering.setText("Lokasi " + (position + 1));
        holder.tvName.setText(tourism.getTourism_name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listToursim.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listToursim.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvNumbering, tvName;

       CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvNumbering = itemView.findViewById(R.id.tv_item_numbering);
            tvName = itemView.findViewById(R.id.tv_item_name);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Tourism data);
    }
}
