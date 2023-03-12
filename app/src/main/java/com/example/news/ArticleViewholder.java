package com.example.news;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewholder extends RecyclerView.ViewHolder {
    EditText title,author,date,content,tag;
    ImageView imageView;


    public ArticleViewholder(@NonNull View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.text_title);
        author=itemView.findViewById(R.id.text_author);
        date=itemView.findViewById(R.id.text_date);
        content=itemView.findViewById(R.id.text_content);
        tag=itemView.findViewById(R.id.text_tags);
        imageView=itemView.findViewById(R.id.image_headline);


    }
}
