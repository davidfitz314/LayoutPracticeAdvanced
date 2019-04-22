package com.example.heterogenouslayoutpractice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class thingsHolder extends RecyclerView.ViewHolder {
    private TextView mName;
    private TextView mCost;
    private TextView mDate;
    public thingsHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.nameView);
        mCost = itemView.findViewById(R.id.costView);
        mDate = itemView.findViewById(R.id.dateView);
    }

    public void setmName(TextView mName) {
        this.mName = mName;
    }

    public void setmCost(TextView mCost) {
        this.mCost = mCost;
    }

    public void setmDate(TextView mDate) {
        this.mDate = mDate;
    }

    public TextView getmCost() {
        return mCost;
    }

    public TextView getmDate() {
        return mDate;
    }

    public TextView getmName() {
        return mName;
    }
}
