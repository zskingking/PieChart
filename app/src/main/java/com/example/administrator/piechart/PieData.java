package com.example.administrator.piechart;

/**
 * Created by Administrator on 2018/10/24.
 */

public class PieData {

    private String title;
    private float percentage;

    public PieData(String title,float percentage){
        this.title = title;
        this.percentage = percentage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
