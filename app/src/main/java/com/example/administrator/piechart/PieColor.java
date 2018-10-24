package com.example.administrator.piechart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */

public class PieColor {

    private String pie_green = "#f95a2f";
    private String pie_red = "#36bb98";
    private String pie_orange = "#f39f03";
    private String pie_blue = "#54b1e4";
    private String pie_grey = "#757676";
    private String pie_yellow = "#ffe93f";
    private String pie_pink = "#ea5777";
    private String pie_violet = "#c11dbe";
    private String pie_light_blue = "#4debed";
    private String pie_light_green = "#7dcc3c";

    public List<String> colors;

    public PieColor(){
        colors = new ArrayList<>();
        colors.add(pie_green);
        colors.add(pie_red);
        colors.add(pie_orange);
        colors.add(pie_blue);
        colors.add(pie_grey);
        colors.add(pie_yellow);
        colors.add(pie_pink);
        colors.add(pie_light_blue);
        colors.add(pie_light_green);
        colors.add(pie_violet);
    }
}
