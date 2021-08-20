package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class adaptor extends RecyclerView.Adapter<adaptor.Viewholder> implements Filterable {

  List<dogbreedmodel> dogbreedmodelList;
//for seraching
     List<dogbreedmodel> searchlist;


  Context context;

    public adaptor(List<dogbreedmodel> dogbreedmodelList, Context context) {
        this.dogbreedmodelList = dogbreedmodelList;
        this.context = context;
        searchlist=new ArrayList<>(dogbreedmodelList);

    }

    @NonNull

    @Override
    public adaptor.Viewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv,parent,false);
        return new Viewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull  adaptor.Viewholder holder, int position) {
    holder.textView.setText(dogbreedmodelList.get(position).getName());
    Picasso.get().load("https://cdn2.thedogapi.com/images/"+dogbreedmodelList.get(position).getReference_image_id()+".jpg").into(holder.imageView);
    holder.imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i =new Intent(context,details.class);
            i.putExtra("name",dogbreedmodelList.get(position).getName());
            i.putExtra("origin",dogbreedmodelList.get(position).getOrigin());
            i.putExtra("temperament",dogbreedmodelList.get(position).getTemperament());
            i.putExtra("breedgrp",dogbreedmodelList.get(position).getBreed_group());
            i.putExtra("breedfor",dogbreedmodelList.get(position).getBred_for());
            i.putExtra("lifespan",dogbreedmodelList.get(position).getLife_span());
            i.putExtra("referenceid",dogbreedmodelList.get(position).getReference_image_id());
            i.putExtra("id",dogbreedmodelList.get(position).getId());
            context.startActivity(i);


        }
    });

    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    @Override
    public int getItemCount() {
        return dogbreedmodelList.size();
    }
    private  Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<dogbreedmodel> filteredlist = new ArrayList<>();
            if(constraint==null||constraint.length()==0){
                filteredlist.addAll(searchlist);
            }else {
                String filterpattern = constraint.toString().toLowerCase().trim();
                for(dogbreedmodel item  :searchlist ){
                    if(item.getName().toLowerCase().contains(filterpattern))
                    {
                        filteredlist.add(item);
                    }
                }
            }
            FilterResults filterResults =new FilterResults();
            filterResults.values=filteredlist;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
          dogbreedmodelList.clear();
          dogbreedmodelList.addAll((List)results.values);
          notifyDataSetChanged();
        }
    };




    public class Viewholder extends RecyclerView.ViewHolder {
      TextView textView;
      ImageView imageView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv);
            imageView=itemView.findViewById(R.id.iv);

        }
    }


}
