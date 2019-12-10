package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;

public class DrawPathLineView extends DrawPathView {
    public DrawPathLineView(Context context) {
        super(context);
    }

    public DrawPathLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPathLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        Color color = new Color();
        LinearGradient linearGradient = new LinearGradient(0, 0, 1000, 0, Color.rgb(186,174, 220),Color.rgb(175,156,222), Shader.TileMode.CLAMP);
        paint.setShader(linearGradient);

        Path path = new Path();
        int x = zeroX + 200, y = zeroY + 200;
        path.moveTo(x, y);
        path.cubicTo(zeroX, y + 150, x + 200, y + 450,x, y+ 600);
        x = x + 200;
        path.lineTo(x, y + 600);
        path.cubicTo(x + 200, y + 450,zeroX + 200, y + 150, x, y);
        canvas.drawPath(path, paint);
        canvas.drawPoint(zeroX, y + 150, paint);
        canvas.drawPoint(x + 200, y + 450, paint);

    }
}
