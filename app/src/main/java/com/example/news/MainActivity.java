package com.example.news;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.news.models.NewsApiResponce;
import com.example.news.models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListner, View.OnClickListener {
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ProgressDialog progressDialog;
    Button b1,b2,b3,b4,b5,b6,b7;
    SearchView news_Search_View;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Fetching News Articles.....");
        progressDialog.show();

        b1=findViewById(R.id.btn_business);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.btn_entertainment);
        b2.setOnClickListener(this);
        b3=findViewById(R.id.btn_general);
        b3.setOnClickListener(this);
        b4=findViewById(R.id.btn_health);
        b4.setOnClickListener(this);
        b5=findViewById(R.id.btn_science);
        b5.setOnClickListener(this);
        b6=findViewById(R.id.btn_sports);
        b6.setOnClickListener(this);
        b7=findViewById(R.id.btn_technology);
        b7.setOnClickListener(this);

        news_Search_View=(SearchView) findViewById(R.id.search_view);
        news_Search_View.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching News Articles of "+query);
                progressDialog.show();
                RequestManager manager=new RequestManager(MainActivity.this);
                manager.getNewsHeadlines(listner,"general",query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        RequestManager manager=new RequestManager(this);
        manager.getNewsHeadlines(listner,"general",null);

    }
    private final OnFetchDataListner<NewsApiResponce> listner=new OnFetchDataListner <NewsApiResponce>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            if(list.isEmpty()){
                Toast.makeText(MainActivity.this, "No Data Found !!!", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
            else{
                showNews(list);
                progressDialog.dismiss();
            }
        }
        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "Not Found Sorry !!!", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView=(RecyclerView) findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        customAdapter=new CustomAdapter(this,list,this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void OnNewsClicked(NewsHeadlines newsHeadlines) {
        startActivity(new Intent(MainActivity.this,DetailsActivity.class)
                .putExtra("data",newsHeadlines));
    }

    @Override
    public void onClick(View view) {
        Button button=(Button) view;
        String category=button.getText().toString();
        progressDialog.setTitle("Fetching News Articlas of "+category);
        progressDialog.show();
        RequestManager manager=new RequestManager(this);
        manager.getNewsHeadlines(listner,category,null);

    }

    @Override
    public void onBackPressed() {



        AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
        alertdialog.setTitle("Exit App !!");
        alertdialog.setMessage("Do You Want To Exit App?");
        alertdialog.setCancelable(false);
        alertdialog.setIcon(R.drawable.main_img);

        alertdialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();

                    }
                });

        alertdialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = alertdialog.create();
        alert11.show();
    }
}
