package com.alisafarzadeh.rejimghazaei.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alisafarzadeh.rejimghazaei.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyRecycler extends RecyclerView.Adapter<MyRecycler.MyHolder> {
    List<Article> articles;
    Context context;

    public MyRecycler(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrecycler,null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvcontent.setText(articles.get(position).getContent());
        holder.tvtitle.setText(articles.get(position).getTitle());
        Glide.with(context).load(articles.get(position).getImg()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView tvtitle,tvcontent;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            tvcontent = itemView.findViewById(R.id.textView2);
            tvtitle = itemView.findViewById(R.id.textView);
        }
    }
}
