package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

public class PaintCapView extends PaintView {
    public PaintCapView(Context context) {
        super(context);
    }

    public PaintCapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintCapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeCap(Paint.Cap.ROUND);
        int x = zeroX + 100, y = zeroY + 100, size = 600;


        paint.setStrokeWidth(100);
        paint.setColor(Color.BLACK);
        canvas.drawLine(x, y, x, y + size, paint);

        paint.setStrokeCap(Paint.Cap.BUTT);
        x += 300;
        canvas.drawLine(x, y, x, y + size, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        x += 300;
        canvas.drawLine(x, y, x, y + size, paint);

        x = zeroX + 100;
        y = zeroY + 100;
        paint.setStrokeWidth(0);
        paint.setColor(Color.RED);
        canvas.drawLine(x, y, x + 600, y, paint);
        canvas.drawLine(x, size + y, x + 600, y + size, paint);


    }
}
