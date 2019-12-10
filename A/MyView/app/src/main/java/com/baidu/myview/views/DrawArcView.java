package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

public class DrawArcView extends DrawShapeView {
    public DrawArcView(Context context) {
        super(context);
    }

    public DrawArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        canvas.drawArc(200, 200, 400, 400,0, 50, false, paint);

        canvas.drawArc(400,200,600,400,0, 90, true, paint);
    }
}
