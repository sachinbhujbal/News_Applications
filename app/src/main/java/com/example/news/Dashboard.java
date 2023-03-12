package com.example.news;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class Dashboard extends AppCompatActivity {

    MaterialCardView add,edit,delete,category,start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        add=findViewById(R.id.addArticles);
        edit=findViewById(R.id.editArticles);
        delete=findViewById(R.id.deleteArticles);
        category=findViewById(R.id.categoriesArticles);
        start=findViewById(R.id.startArticles);
        Objects.requireNonNull(getSupportActionBar()).hide();



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,MainActivity.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,AddArticles.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(Dashboard.this);
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