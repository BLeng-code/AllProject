package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.RequiresApi;

public class DrawRectView extends DrawShapeView {
    public DrawRectView(Context context) {
        super(context);
    }

    public DrawRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        canvas.drawRect(200, 200, 500, 500, paint);
        canvas.drawRoundRect(600, 200, 900, 500,20, 20, paint);

        Rect rect = new Rect();
        rect.left = 200;
        rect.top = 600;
        rect.right = 500;
        rect.bottom = 900;
        paint.setColor(Color.RED);
        canvas.drawRect(rect, paint);

        RectF rectF = new RectF();
        rectF.left = 200;
        rectF.top = 1000;
        rectF.right = 500;
        rectF.bottom = 1300;
        canvas.drawRect(rectF, paint);
        rectF.left = 600;
        rectF.right = 900;
        canvas.drawRoundRect(rectF,20, 20, paint);

        paint.setStyle(Paint.Style.STROKE);
        RectF rectA = new RectF();
        rectA.left = 200;
        rectA.top = 1020;
        rectA.right = 400;
        rectA.bottom = 1220;

        RectF rectB = new RectF();
        rectB.left = 250;
        rectB.top = 1070;
        rectB.right = 350;
        rectB.bottom = 1170;
        // 该方法部分手机不存在
        // canvas.drawDoubleRoundRect(rectA, 20, 20, rectB, 20, 20, paint);

    }
}
