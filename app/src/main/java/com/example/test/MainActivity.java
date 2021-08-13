package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {
Button uploadbutton;
RecyclerView recyclerView;
LinearLayoutManager Layoutmanager;
adaptor adap;
List<dogbreedmodel> dogbreedmodelList=new ArrayList<>();


String URL="https://api.thedogapi.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
uploadbutton=findViewById(R.id.uploadbutton);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
       recyclerView=findViewById(R.id.recv);
       Layoutmanager=new LinearLayoutManager(this);
       recyclerView.setLayoutManager(Layoutmanager);
       adap=new adaptor(dogbreedmodelList,this);

       recyclerView.setAdapter(adap);



       Retrofit retrofit=new Retrofit.Builder()
               .baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();

       Retrofitapi api=retrofit.create(Retrofitapi.class);

       Call<List<dogbreedmodel>> call=api.getthem();

       call.enqueue(new Callback<List<dogbreedmodel>>() {
           @Override
           public void onResponse(Call<List<dogbreedmodel>> call, Response<List<dogbreedmodel>> response) {
               List<dogbreedmodel> data =response.body();
               if (response.isSuccessful() && response.body()!=null){
                dogbreedmodelList.addAll(response.body());
                adap.notifyDataSetChanged();
              }


           }

           @Override
           public void onFailure(Call<List<dogbreedmodel>> call, Throwable t) {
               Toast.makeText(MainActivity.this,"failed",Toast.LENGTH_SHORT).show();
           }
       });


       uploadbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(MainActivity.this,Uploading.class);
               startActivity(i);
           }
       });
    }
}