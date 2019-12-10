package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;

public class DrawPathShapeView extends DrawPathView {
    public DrawPathShapeView(Context context) {
        super(context);
    }

    public DrawPathShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPathShapeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();

        Path path = new Path();
        path.addRoundRect(100, 100, 500, 500, 50, 500, Path.Direction.CCW);
        canvas.drawPath(path, paint);

//        int mul = 3;
//        int x = 500, y = 500;
//        float radius = 100 * mul;
//        RectF rectF = new RectF();
//        rectF.left = x - radius;
//        rectF.top = y - radius;
//        rectF.right = x + radius;
//        rectF.bottom = y + radius;
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(10);
//        canvas.drawRect(rectF, paint);
//        canvas.drawPoint(x, y, paint);
//
//
//        float startAngle = 180;
//        float sweepAngle = 180;
//
//        int save = canvas.saveLayer(null,null, Canvas.ALL_SAVE_FLAG);
//        canvas.save();
//        canvas.rotate(250, x, y);
//        Path path = new Path();
//        Shader shader = new LinearGradient(
//                x, y - radius,
//                (int) (x + Math.sin(startAngle / 180 * Math.PI)),
//                (int) (y + Math.cos(startAngle / 180 * Math.PI)),
//                Color.WHITE,
//                Color.RED,
//                Shader.TileMode.CLAMP
//        );
//        paint.setShader(shader);
//        path.addArc(rectF, startAngle, sweepAngle);
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawPath(path, paint);
//
//        float times = 3;
//
//        rectF.top = rectF.top + radius * (1 -1/times);
//        rectF.bottom = rectF.bottom - radius * (1 - 1/times);
//
//        paint.reset();
//        path.reset();
//        path.addArc(rectF, startAngle, sweepAngle);
//        Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.XOR);
//        paint.setColor(Color.RED);
//        paint.setXfermode(xfermode);
//        canvas.drawPath(path, paint);
//
//
//
//        canvas.restoreToCount(save);


//        rectF = new RectF();
//        path.computeBounds(rectF, true);
//        paint.reset();
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawRect(rectF, paint);

//        int x1 = 400, y1 = 500, x2 = 700, y2 = 500, radius = 300;
//        int arrow = 15;
//
//        paint.setColor(Color.BLACK);
//        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
//        path.addCircle(x1, y1, radius, Path.Direction.CW);
//        path.addCircle(x2, y2, radius, Path.Direction.CW);
//        canvas.drawPath(path, paint);
//
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawCircle(x1, y1, radius, paint);
//
//        paint.setColor(Color.GREEN);
//        canvas.drawCircle(x2, y2, radius, paint);
//
//        paint.setColor(Color.RED);
//        paint.setStrokeWidth(4);
//        drawCircle(x1, y1, radius, arrow, canvas, paint, Path.Direction.CW);
//
//        paint.setColor(Color.GREEN);
//        drawCircle(x2, y2, radius, arrow, canvas, paint, Path.Direction.CW);
//
//        paint.setColor(Color.parseColor("#aaaaaa"));
//        paint.setStrokeWidth(20);
//        int px1 = (x1 + x2) / 2, py1 = y1;
//        canvas.drawPoint(px1, py1, paint);
//        paint.setStrokeWidth(5);
//        canvas.drawLine(px1, py1, px1 + 500, 100, paint);
//
//        paint.setColor(Color.RED);
//        paint.setStrokeWidth(20);
//        px1 = x1 - 150;
//        py1 = y1;
//        canvas.drawPoint(px1, py1, paint);
//        paint.setStrokeWidth(5);
//        canvas.drawLine(px1, py1, px1 + 800, py1 + 230, paint);
//
//        px1 = x1- radius;
//        py1 = y1 + radius - 100;
//        paint.setColor(Color.GREEN);
//        paint.setStrokeWidth(20);
//        canvas.drawPoint(px1, py1, paint);
//        paint.setStrokeWidth(5);
//        canvas.drawLine(px1, py1, px1 + 900, py1, paint);
    }

    private void drawCircle(int x, int y, int radius, int arrow, Canvas canvas, Paint paint, Path.Direction direction) {
        if (direction == Path.Direction.CCW) {
            canvas.drawLine(x - radius, y, x - radius - arrow, y - arrow, paint);
            canvas.drawLine(x - radius, y, x - radius + arrow, y - arrow, paint);
            canvas.drawLine(x, y + radius, x - arrow, y + radius - arrow, paint);
            canvas.drawLine(x, y + radius, x - arrow, y + radius + arrow, paint);
            canvas.drawLine(x + radius, y, x + radius - arrow, y + arrow, paint);
            canvas.drawLine(x + radius, y, x + radius + arrow, y + arrow, paint);
            canvas.drawLine(x, y - radius, x + arrow, y - radius - arrow, paint);
            canvas.drawLine(x, y - radius, x + arrow, y - radius + arrow, paint);
        }
        if (direction == Path.Direction.CW) {
            canvas.drawLine(x - radius, y, x - radius - arrow, y + arrow, paint);
            canvas.drawLine(x - radius, y, x - radius + arrow, y + arrow, paint);
            canvas.drawLine(x, y - radius, x - arrow, y - radius - arrow, paint);
            canvas.drawLine(x, y - radius, x - arrow, y - radius + arrow, paint);
            canvas.drawLine(x + radius, y, x + radius - arrow, y - arrow, paint);
            canvas.drawLine(x + radius, y, x + radius + arrow, y - arrow, paint);
            canvas.drawLine(x, y + radius, x + arrow, y + radius - arrow, paint);
            canvas.drawLine(x, y + radius, x + arrow, y + radius + arrow, paint);
        }
    }

}
