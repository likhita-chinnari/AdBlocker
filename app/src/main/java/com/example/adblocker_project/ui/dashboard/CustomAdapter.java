package com.example.adblocker_project.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adblocker_project.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<String> personNames;
    RecyclerView.ViewHolder MyViewHolder;
    public CustomAdapter(ArrayList<String> personNames) {
        this.personNames = personNames;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the item Layout
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margin, padding and layout parameters
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomAdapter.MyViewHolder holder,
                                 final int position) {
        holder.name.setText(personNames.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(holder.itemView.getContext(), personNames.get(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return personNames.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;  // init the item view's
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = itemView.findViewById(R.id.name);
        }
    }
}