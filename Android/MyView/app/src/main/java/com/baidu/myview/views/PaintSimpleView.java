package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

public class PaintSimpleView extends PaintView {
    public PaintSimpleView(Context context) {
        super(context);
    }

    public PaintSimpleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintSimpleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        int x = zeroX + 200, y = zeroY + 200, radius = 150;


        canvas.drawCircle(x, y, radius, paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(textSize);
        canvas.drawText("默认", x - textSize, y + textSize / 2, paint);

        x = x + 200 + radius;
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x, y, radius, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(textSize);
        canvas.drawText("描边", x - textSize, y + textSize / 2, paint);

        x =zeroX + 200;
        y = y + 200 + radius;
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(x, y, radius, paint);
        paint.setStrokeWidth(0);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x, y, radius, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(textSize);
        paint.setStrokeWidth(0);
        canvas.drawText("粗描边", x - textSize - textSize / 2, y + textSize / 2, paint);


        x = x + 200 + radius;
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x, y, radius, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(textSize);
        canvas.drawText("抗锯齿", x - textSize - textSize / 2, y + textSize / 2, paint);

    }
}
