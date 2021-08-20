package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
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
    private ProgressBar progress;
List<dogbreedmodel> dogbreedmodelList=new ArrayList<>();


String URL="https://api.thedogapi.com/";




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        MenuItem searchitem = menu.findItem(R.id.search);
        getSupportActionBar().setTitle("pawsome");
        SearchView searchView = (SearchView) searchitem.getActionView();

        searchView.setInputType(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adap.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
uploadbutton=findViewById(R.id.uploadbutton);
        progress=findViewById(R.id.idPBLoading);
       // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
       recyclerView=findViewById(R.id.recv);
       Layoutmanager=new LinearLayoutManager(this);
       recyclerView.setLayoutManager(Layoutmanager);
       adap=new adaptor(dogbreedmodelList,this);
        progress.setVisibility(View.VISIBLE);
       recyclerView.setAdapter(adap);



       Retrofit retrofit=new Retrofit.Builder()
               .baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();

       Retrofitapi api=retrofit.create(Retrofitapi.class);

       Call<List<dogbreedmodel>> call=api.getthem();

       call.enqueue(new Callback<List<dogbreedmodel>>() {
           @Override
           public void onResponse(Call<List<dogbreedmodel>> call, Response<List<dogbreedmodel>> response) {
               progress.setVisibility(View.GONE);
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