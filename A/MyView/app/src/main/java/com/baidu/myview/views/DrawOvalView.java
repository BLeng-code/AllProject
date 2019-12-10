package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

public class DrawOvalView extends DrawShapeView {
    public DrawOvalView(Context context) {
        super(context);
    }

    public DrawOvalView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawOvalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        canvas.drawOval(200, 200, 400, 300, paint);
    }
}
