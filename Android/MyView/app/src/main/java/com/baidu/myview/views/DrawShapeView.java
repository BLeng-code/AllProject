package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * @author          lengbo
 * @date            19-10-14
 * @name            DrawShapeView.java
 * @description     绘制基本图形
 * */
public class DrawShapeView extends DrawView {
    public DrawShapeView(Context context) {
        super(context);
        TAG = DrawShapeView.class.getSimpleName();
    }

    public DrawShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TAG = DrawShapeView.class.getSimpleName();
    }

    public DrawShapeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TAG = DrawShapeView.class.getSimpleName();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        // 默认填充
//        Paint paint = new Paint();
//        canvas.drawRect(20, 20, 200, 200, paint);
//
//        // 设置描边
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawRect(220, 20, 400, 200, paint);
//
//        // 设置描边和填充
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawRect(420, 20, 600, 200, paint);
//
//        // 设置描边宽度
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(20);
//        canvas.drawRect(620, 20, 800, 200, paint);
//
//        // 设置颜色
//        paint.setColor(Color.RED);
//        canvas.drawRect(830, 20, 1000, 200, paint);
//
//        // 绘制圆角矩形
//        canvas.drawRoundRect(20, 320, 200, 500,20,20, paint);
//
//        // 绘制圆形
//        canvas.drawCircle(400, 400, 100, paint);
//
//        // 绘制椭圆
//        paint.setStrokeWidth(2);
//        canvas.drawOval(600,320,800,500,paint);
//
//        // 绘制弧形
//        canvas.drawArc(820, 320, 1000, 500, 0, 90, false, paint);
//
//        // 绘制扇形
//        canvas.drawArc(20, 520, 200, 700, 0, 90, true, paint);
//
//        // 绘制直线
//        canvas.drawLine(220,520,400,700, paint);
//
//        // 绘制点
//        paint.setStrokeWidth(30);
//        canvas.drawPoint(420, 620, paint);
    }
}
