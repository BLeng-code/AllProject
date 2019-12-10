package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BaseView extends View {

    protected String TAG = BaseView.class.getSimpleName();

    protected int zeroX = 200;
    protected int zeroY = 200;
    protected int xLength = 800;
    protected int yLength = 1200;
    protected int textSize = 50;
    protected int interval = 100;


    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i(TAG, "onLayout " + left + " " + top + " " + right + " " + bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i(TAG, "onMeasure");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw");
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLUE);
        int x = zeroX, y = zeroY, arrow = 20;

        canvas.drawLine(zeroX, zeroY, zeroX + xLength, zeroY, paint);
        canvas.drawLine(zeroX + xLength, zeroY, zeroX + xLength - arrow, zeroY - arrow, paint);
        canvas.drawLine(zeroX + xLength, zeroY, zeroX + xLength - arrow, zeroY + arrow, paint);

        canvas.drawLine(zeroX, zeroY, zeroX, zeroY + yLength, paint);
        canvas.drawLine(zeroX, zeroY + yLength, zeroX - arrow, zeroY + yLength - arrow, paint);
        canvas.drawLine(zeroX, zeroY + yLength, zeroX + arrow, zeroY + yLength - arrow, paint);

        drawScale(zeroX, zeroY, canvas, paint);
    }

    private void drawScale(int x, int y, Canvas canvas, Paint paint) {
        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        canvas.drawPoint(x, y, paint);
        for (int i = x + interval; i < zeroX + xLength; i = i + interval) {
            canvas.drawPoint(i, y, paint);
        }

        for (int i = y + interval; i < zeroY + yLength; i = i + interval) {
            canvas.drawPoint(x, i, paint);
        }

        paint.setTextSize(textSize);
        canvas.drawText("X轴", x + 200, y - 30, paint);
        canvas.drawText("Y轴", x - 100, y + 200, paint);
    }
}
