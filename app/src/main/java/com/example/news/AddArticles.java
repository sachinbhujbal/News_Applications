package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.core.Context;

public class AddArticles extends AppCompatActivity {
    Context context;
   String title,author,content,img_url,tags;
   EditText title1,author1,pub_date1,content1,img_url1,tags1;

   int pub_date;
   Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_articles);

        title1=findViewById(R.id.edit_text_title);
        author1=findViewById(R.id.edit_text_author);
        pub_date1=findViewById(R.id.edit_text_pub_date);
        content1=findViewById(R.id.edit_text_content);
        img_url1=findViewById(R.id.edit_text_image_url);
        tags1=findViewById(R.id.edit_text_tags);

        title=title1.getText().toString();
        author=author1.getText().toString();
//        pub_date= Integer.parseInt(pub_date1.getText().toString());
        content=content1.getText().toString();
        img_url=img_url1.getText().toString();
        tags=tags1.getText().toString();
    }
    public void adapter(View view){
        Intent intent=new Intent(AddArticles.this,Article_recycler.class);
        startActivity(intent);

    }
}