package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.news.models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    NewsHeadlines newsHeadlines;
    TextView txt_title,txt_author,txt_time,txt_details,txt_content;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //getting news headlines in this objects.
        newsHeadlines= (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title=findViewById(R.id.news_title);
        txt_author=findViewById(R.id.author_details);
        txt_time=findViewById(R.id.time_details);
        txt_details=findViewById(R.id.text_details);
        txt_content=findViewById(R.id.text_details_content);
        img_news=findViewById(R.id.details_image);

        txt_title.setText(newsHeadlines.getTitle());
        txt_author.setText(newsHeadlines.getAuthor());
        txt_time.setText(newsHeadlines.getPublishedAt());
        txt_details.setText(newsHeadlines.getDescription());
        txt_content.setText(newsHeadlines.getContent());
        Picasso.get().load(newsHeadlines.getUrlToImage()).into(img_news);
    }




}