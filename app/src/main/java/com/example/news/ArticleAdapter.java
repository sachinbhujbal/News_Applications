package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewholder> {
    Context context;
    List<Item>items;

    public ArticleAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ArticleViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewholder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewholder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.author.setText(items.get(position).getAuthor());
        holder.date.setText(items.get(position).getDate());
        holder.content.setText(items.get(position).getContent());
        holder.imageView.setImageResource(Integer.parseInt(items.get(position).getImg_url()));
        holder.tag.setText(items.get(position).getTag());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
}
