package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewholder> {
    Context context;
    View view;
    List<Item>items;

    public ArticleAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ArticleViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new ArticleViewholder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,
//                false));
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        ArticleViewholder viewholder=new ArticleViewholder(view);
        return  viewholder;

    }

//    @Override
//    public void onBindViewHolder(@NonNull ArticleViewholder.ViewHolder holder, int position) {
//        ArticleViewholder viewholder=new ArticleViewholder(view);
//        holder.title.setText(items.get(position).getTitle());
//        holder.author.setText(items.get(position).getAuthor());
//        holder.date.setText(items.get(position).getDate());
//        holder.content.setText(items.get(position).getContent());
//        holder.imageView.setImageResource(Integer.parseInt(items.get(position).getImg_url()));
//        holder.tag.setText(items.get(position).getTag());
//
//        Glide.with(holder.itemView.getContext())
//                .load(viewholder.imageView)
//                .load(holder.imageView);
//    }

//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
//        return new RecyclerView.ViewHolder(view);
//    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewholder holder, int position) {
        ArticleViewholder viewholder=new ArticleViewholder(view);
        holder.title.setText(items.get(position).getTitle());
        holder.author.setText(items.get(position).getAuthor());
        holder.date.setText(items.get(position).getDate());
        holder.content.setText(items.get(position).getContent());
        holder.imageView.setImageResource(Integer.parseInt(items.get(position).getImg_url()));
        holder.tag.setText(items.get(position).getTag());

        Glide.with(holder.itemView.getContext())
                .load(viewholder.imageView)
                .load(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
}
