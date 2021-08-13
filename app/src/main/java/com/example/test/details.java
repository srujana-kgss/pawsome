package com.example.test;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;

import android.support.annotation.ColorRes;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class details extends AppCompatActivity {




    String name,origin,temperament,lifespan,breedfor,breedgrp,referenceid,id;
    TextView Name;
    TextView Origin;
    TextView Temperament;
    TextView Lifespan;
    TextView Breedfor;
    TextView Breedgrp;
    ImageView image;




    // "https://cdn2.thedogapi.com/images/" + referenceid + ".jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Name = findViewById(R.id.name);
        Origin = findViewById(R.id.origin);
        Temperament = findViewById(R.id.temperament);
        Lifespan = findViewById(R.id.lifespan);
        Breedfor = findViewById(R.id.breedfor);
        Breedgrp = findViewById(R.id.breedgrp);
        image = findViewById(R.id.iv2);


        name = getIntent().getStringExtra("name");
        origin = getIntent().getStringExtra("origin");
        temperament = getIntent().getStringExtra("temperament");
        lifespan = getIntent().getStringExtra("lifespan");
        breedfor = getIntent().getStringExtra("breedfor");
        breedgrp = getIntent().getStringExtra("breedgrp");
        referenceid = getIntent().getStringExtra("referenceid");
        id = getIntent().getStringExtra("id");


        Picasso.get().load("https://cdn2.thedogapi.com/images/" + referenceid + ".jpg").into(image);
        Name.setText("NAME:" + name);
        Origin.setText("ORIGIN:" + origin);
        Temperament.setText("TEMPERAMENT:" + temperament);
        Lifespan.setText("LIFESPAN:" + lifespan);
        Breedgrp.setText("BREEDGROUP:" + breedgrp);
        Breedfor.setText("BREEDFOR:" + breedfor);






    }
}

