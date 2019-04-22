package com.example.heterogenouslayoutpractice;

public class Things {
    private String mName;
    private String mCost;
    private String mDate;
    Things(String nameIn, String costIn, String dateIn){
        this.mName = nameIn;
        this.mCost = costIn;
        this.mDate = dateIn;
    }

    public String getmName() {
        return mName;
    }

    public String getmCost() {
        return mCost;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public void setmCost(String mCost) {
        this.mCost = mCost;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
