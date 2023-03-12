package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Article_recycler extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_recycler);
        recyclerView=findViewById(R.id.recycler_main);
        AddArticles addArticles=new AddArticles();

        List<Item>items=new ArrayList<Item>();
        items.add(new Item(addArticles.title, addArticles.author,addArticles.pub_date,addArticles.content,
                addArticles.img_url,addArticles.tags));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ArticleAdapter(getApplicationContext(),items));


    }
}