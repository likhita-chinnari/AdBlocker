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

public class CustomAdapter extends RecyclerView.Adapter {

    ArrayList<String> personNames;
    DashboardFragment context;
    RecyclerView.ViewHolder MyViewHolder;
    public CustomAdapter(DashboardFragment context, ArrayList personNames) {
        this.context = context;
        this.personNames = personNames;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    // ---------------------------method needs to be fixed---------------------------------------
    //-------------------------------------------------------------------------------------------

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        holder.name.setText(personNames.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, personNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------

    @Override
    public int getItemCount() {
        return personNames.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;// init the item view's
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
        }


    }
}
