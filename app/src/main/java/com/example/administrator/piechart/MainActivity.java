package com.example.administrator.piechart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyPieChartView myPieChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPieChartView = (MyPieChartView) findViewById(R.id.pieChart);
        List<PieData> pieDataList = new ArrayList<>();
        pieDataList.add(new PieData("Java", (float) 0.174));
        pieDataList.add(new PieData("C", (float) 0.154));
        pieDataList.add(new PieData("python", (float) 0.076));
        pieDataList.add(new PieData("C++", (float) 0.073));
        pieDataList.add(new PieData("C#", (float) 0.032));
        pieDataList.add(new PieData("PHP", (float) 0.027));
        pieDataList.add(new PieData("JavaScript", (float) 0.021));
        pieDataList.add(new PieData("其他", (float) 0.443));
        Log.i("zs","size="+pieDataList.size());
        myPieChartView.setData(pieDataList);
    }
}
