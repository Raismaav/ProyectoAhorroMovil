package com.example.proyectoahorromovil.Fragments.Awards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectoahorromovil.R;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context contextAward;
    private List<CardAward> dataAward;

    public RecyclerViewAdapter(Context contextAward, List<CardAward> dataAward) {
        this.contextAward = contextAward;
        this.dataAward = dataAward;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int indice) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(contextAward);
        view = inflater.inflate(R.layout.card_view_recycler, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.imageView.setImageResource(dataAward.get(position).getThumbail());
        holder.title.setText(dataAward.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataAward.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.idCardTxt);
            imageView = itemView.findViewById(R.id.idCardImg);
            cardView = itemView.findViewById(R.id.idCard);
        }
    }
}
