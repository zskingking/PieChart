package com.example.administrator.piechart;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */

public class MyPieChartView extends View {
    private String TAG = "pie";

    private List<String> mColors;

    private Paint mPiePaint;//饼图画笔
    private Paint mSquarePaint;//矩形画笔
    private Paint mTextPaint;//文字画笔

    private float mRadius;//饼图半径
    private float mBorderLength;//矩形边长
    private float mTextSize;//文字大小
    private int mTextColor;//文字颜色

    private int mWidth;//宽
    private int mHeight;//高

    private List<PieData> mData;

    public MyPieChartView(Context context) {
        super(context);
    }

    public MyPieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyPieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PieChart);
        mRadius = typedArray.getDimension(R.styleable.PieChart_radius,150);
        mBorderLength = typedArray.getDimension(R.styleable.PieChart_border_length,25);
        mTextColor = typedArray.getColor(R.styleable.PieChart_textColor,R.color.black);
        mTextSize = typedArray.getDimension(R.styleable.PieChart_textSize,30);
        typedArray.recycle();
        init();
    }

    private void init(){
        mColors = new PieColor().colors;
        mPiePaint = new Paint();
        mPiePaint.setAntiAlias(true);
        mPiePaint.setStyle(Paint.Style.FILL);
        mPiePaint.setStrokeWidth(mRadius);
        mSquarePaint = new Paint();
        mSquarePaint.setAntiAlias(true);
        mSquarePaint.setStyle(Paint.Style.FILL);
        mSquarePaint.setStrokeWidth(mBorderLength);
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mWidth = resolveSize(600,widthMeasureSpec);
        mHeight = resolveSize(400,heightMeasureSpec);
        setMeasuredDimension(mWidth,mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPie(canvas);
        drawSquare(canvas);
    }

    //绘制饼图
    private void drawPie(Canvas canvas){
        float currentAngle = 0;//当前角度
        for(int i=0;i<mData.size();i++){
            PieData pieData = mData.get(i);
            mPiePaint.setColor(Color.parseColor(mColors.get(i)));
            int centerX = mHeight/2;
            int centerY = mHeight/2;
            RectF rectF = new RectF(centerX-mRadius,centerY-mRadius,centerX+mRadius,centerY+mRadius);
            canvas.drawArc(rectF,currentAngle,pieData.getPercentage()*360,true,mPiePaint);
            currentAngle += pieData.getPercentage()*360;
            Log.i(TAG,"mDataSize="+mData.size());
        }
    }

    //绘制矩形和文字
    private void drawSquare(Canvas canvas){
        int padding = mHeight/30;
        int currentX = mHeight;
        int currentY = padding + 50;
        for(int i=0;i<mData.size();i++){
            if(i%10==0){
                if(i!=0) {
                    currentX = currentX + (int) mBorderLength + padding;
                }
                currentY = padding + 50;
            }else {
                currentY += padding+mBorderLength;
            }
            PieData pieData = mData.get(i);
            mSquarePaint.setColor(Color.parseColor(mColors.get(i)));
            Rect rect = new Rect(currentX,currentY,currentX+(int)mBorderLength,currentY+(int)mBorderLength);
            canvas.drawRect(rect,mSquarePaint);
            DecimalFormat fNum  =   new DecimalFormat("##0.0");
            String  percentage =fNum.format( pieData.getPercentage()*100);
            String title = pieData.getTitle() +" ("+ percentage +"%)";
            canvas.drawText(title,currentX+(int)mBorderLength+padding,
                    currentY+(int)mBorderLength,mTextPaint);
            Log.i(TAG,"percentage"+pieData.getPercentage()+"");
        }
    }

    public void setData(List<PieData> data){
        mData = data;
        postInvalidate();
    }

}
