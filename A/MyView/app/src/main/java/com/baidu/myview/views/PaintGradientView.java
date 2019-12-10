package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;

public class PaintGradientView extends PaintView {
    public PaintGradientView(Context context) {
        super(context);
    }

    public PaintGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        int x = zeroX, y = zeroY, radius = 150, xInterval = 175, yInterval = 175, textSize = 30;

        x = x + xInterval;
        y = y + yInterval;
        LinearGradient linearGradient = new LinearGradient(x - 100, y, x + 100, y, Color.RED, Color.BLACK, Shader.TileMode.CLAMP);
        paint.setShader(linearGradient);
        canvas.drawCircle(x, y, radius, paint);
        paint.setTextSize(textSize);
        canvas.drawText("LinearGradient  CLAMP", x - 100, y + radius + 50, paint);

        x = x + 2 * xInterval;
        linearGradient = new LinearGradient(x - 100, y, x + 100, y, Color.RED, Color.BLACK, Shader.TileMode.MIRROR);
        paint.setShader(linearGradient);
        canvas.drawCircle(x, y, radius, paint);
        paint.setTextSize(textSize);
        canvas.drawText("LinearGradient  MIRROR", x - 100, y + radius + 50, paint);

        x = x - 2 * xInterval;
        y = y + 2 * yInterval;
        linearGradient = new LinearGradient(x - 100, y, x + 100, y, Color.RED, Color.BLACK, Shader.TileMode.REPEAT);
        paint.setShader(linearGradient);
        canvas.drawCircle(x, y, radius, paint);
        paint.setTextSize(textSize);
        canvas.drawText("LinearGradient  REPEAT", x - 100, y + radius + 50, paint);

        x = x + 2 * xInterval;
//        y = y + 2 * yInterval;
        RadialGradient radialGradient = new RadialGradient(x, y, radius - 50, Color.RED, Color.BLACK, Shader.TileMode.CLAMP);
        paint.setShader(radialGradient);
        canvas.drawCircle(x, y, radius, paint);
        paint.setTextSize(textSize);
        canvas.drawText("RadialGradient  CLAMP", x - 100, y + radius + 50, paint);

        x = x - 2 * xInterval;
        y = y + 2 * yInterval;
        SweepGradient sweepGradient = new SweepGradient(x, y, Color.RED, Color.BLACK);
        paint.setShader(sweepGradient);
        canvas.drawCircle(x, y, radius, paint);
        paint.setTextSize(textSize);
        canvas.drawText("SweepGradient", x - 100, y + radius + 50, paint);

    }
}
