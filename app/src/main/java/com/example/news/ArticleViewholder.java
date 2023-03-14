package com.example.news;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewholder extends RecyclerView.ViewHolder {
//    EditText author,date,content,tag;
//    ImageView imageView;

    public TextView title;
    public  TextView author;
    public  TextView content;
    public TextView date;
    public  TextView tag;

    public ImageView imageView;


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
