package com.example.news;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView text_title,text_source;
    ImageView img_headline;
    CardView cardView;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        text_title=(TextView) itemView.findViewById(R.id.text_title);
        text_source=(TextView) itemView.findViewById(R.id.text_source);
        img_headline=(ImageView) itemView.findViewById(R.id.image_headline);
        cardView=(CardView) itemView.findViewById(R.id.main_cardview);
    }
}
