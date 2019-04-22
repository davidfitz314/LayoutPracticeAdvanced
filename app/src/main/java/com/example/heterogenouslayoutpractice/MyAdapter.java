package com.example.heterogenouslayoutpractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class MyAdapter extends RecyclerView.Adapter {
    private ArrayList<Object> mObjects;
    private LayoutInflater mInflater;

    private final int mTitle = 0, mCat = 1;

    MyAdapter(Context context, ArrayList<Object> objectsIn){
        this.mObjects = objectsIn;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView;
        //switch between object types for populating and passing to correct view holder
        switch (i){
            case mTitle:
                itemView = mInflater.inflate(R.layout.titles, viewGroup, false);
                return new TitlesHolder(itemView);
            case mCat:
                itemView = mInflater.inflate(R.layout.recycler_single_object, viewGroup, false);
                return new thingsHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //switch between view holders to populate data
        switch (viewHolder.getItemViewType()){
            case mTitle:
                TitlesHolder headers = (TitlesHolder) viewHolder;
                TextView head = headers.getmTitle();
                String title =(String) mObjects.get(i);
                head.setText(title);
                break;
            case mCat:
                thingsHolder things = (thingsHolder) viewHolder;
                TextView name = things.getmName();
                TextView cost= things.getmCost();
                TextView date = things.getmDate();
                Things myThings = (Things) mObjects.get(i);
                name.setText(myThings.getmName());
                cost.setText(myThings.getmCost());
                date.setText(myThings.getmDate());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mObjects.get(position) instanceof String){
            return mTitle;
        } else if (mObjects.get(position) instanceof Things){
            return mCat;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mObjects.size();
    }
}
