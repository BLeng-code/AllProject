package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

public class PaintView extends BaseView {
    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        Paint paint = new Paint();
//        canvas.drawCircle(200, 200, 150, paint);
//
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawCircle(600,200,150, paint);
//
//        paint.setColor(Color.RED);
//        canvas.drawCircle(200, 600, 150, paint);
//
//        paint.setAntiAlias(true);
//        canvas.drawCircle(600, 600, 150, paint);
//
//        paint.setStrokeWidth(10);
//        canvas.drawCircle(200, 1000, 150, paint);
//
//        setLayerType(LAYER_TYPE_SOFTWARE, null);
//        paint.setShadowLayer(5, 10,10, Color.BLACK);
//        canvas.drawCircle(600, 1000, 150, paint);
//
//        paint.setShadowLayer(0,0,0,0);
//        paint.setStyle(Paint.Style.FILL);
//        paint.setAntiAlias(false);
//        canvas.drawCircle(200, 1400, 150, paint);
//
//        paint.setAntiAlias(true);
//        canvas.drawCircle(510, 1400, 150, paint);
//
//        paint.setStrokeCap(Paint.Cap.ROUND);
//        canvas.drawCircle(200, 1800, 100, paint);


    }
}
