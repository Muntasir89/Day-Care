package com.example.daycare.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daycare.Model.NewsModel;
import com.example.daycare.Model.StuModel;
import com.example.daycare.R;

import java.util.List;

public class NewsAda extends RecyclerView.Adapter<NewsAda.NewsViewHolder> {
    Context context;
    List<NewsModel> NewsList;
    public NewsAda(Context cntxt, List<NewsModel>list){
        context = cntxt;
        NewsList = list;
    }
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.Accost.setText(NewsList.get(position).getAccost());
        holder.Date.setText(NewsList.get(position).getDate());
        holder.Details.setText(NewsList.get(position).getDetails());
    }

    @Override
    public int getItemCount() {
        return NewsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView Accost, Date, Details;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            Accost = itemView.findViewById(R.id.Accost);
            Date = itemView.findViewById(R.id.Date);
            Details = itemView.findViewById(R.id.Details);
        }
    }
}
