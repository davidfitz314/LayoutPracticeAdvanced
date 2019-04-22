package com.example.heterogenouslayoutpractice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TitlesHolder extends RecyclerView.ViewHolder {
    private TextView mTitle;

    public TitlesHolder(@NonNull View itemView) {
        super(itemView);
        mTitle = itemView.findViewById(R.id.headerTitleView);
    }

    public void setmTitle(TextView mTitle) {
        this.mTitle = mTitle;
    }

    public TextView getmTitle() {
        return mTitle;
    }
}
