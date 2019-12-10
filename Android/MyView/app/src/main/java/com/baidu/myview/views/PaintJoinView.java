package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

public class PaintJoinView extends PaintView {
    public PaintJoinView(Context context) {
        super(context);
    }

    public PaintJoinView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintJoinView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeWidth(50);
        paint.setStyle(Paint.Style.STROKE);


        int x = zeroX + 20, y = zeroY + 50, size = 300;
        paint.setStrokeJoin(Paint.Join.ROUND);

        Path path = new Path();
        path.moveTo(x, y);
        path.lineTo(x + size, y);
        path.lineTo(x + size, y + size);
        canvas.drawPath(path, paint);
        paint.setStrokeWidth(0);
        paint.setTextSize(50);
        paint.setColor(Color.BLACK);
        canvas.drawText("圆角", x + size - 200, y + size / 2, paint);

        x = x + size + 100;
        path = new Path();
        path.moveTo(x, y);
        path.lineTo(x + size, y);
        path.lineTo(x + size, y + size);
        paint.setStrokeWidth(50);
        paint.setColor(Color.BLUE);
        paint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(path, paint);
        paint.setStrokeWidth(0);
        paint.setTextSize(50);
        paint.setColor(Color.BLACK);
        canvas.drawText("平角", x + size - 200, y + size / 2, paint);

        x = zeroX + 20;
        y = y + size + 100;
        path = new Path();
        path.moveTo(x, y);
        path.lineTo(x + size, y);
        path.lineTo(x + size, y + size);
        paint.setStrokeWidth(50);
        paint.setColor(Color.RED);
        paint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(path, paint);
        paint.setStrokeWidth(0);
        paint.setTextSize(50);
        paint.setColor(Color.BLACK);
        canvas.drawText("尖角", x + size - 200, y + size / 2, paint);

    }
}
