package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

public class DrawPathShapeInnerView extends DrawPathView {
    public DrawPathShapeInnerView(Context context) {
        super(context);
    }

    public DrawPathShapeInnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPathShapeInnerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x = zeroX + 400, y = zeroY + 400, radius = 200;

        Paint paint = new Paint();
        Path path = new Path();
        path.addCircle(x, y, radius, Path.Direction.CCW);
//        path.addRect(zeroX + 100, zeroY + 100, zeroX + 600, zeroY + 600, Path.Direction.CCW);
        path.setFillType(Path.FillType.EVEN_ODD);
        path.addRect(x, y, x + 300 , y + 300, Path.Direction.CCW);
        RectF rectF = new RectF();
        path.computeBounds(rectF , true);
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rectF, paint);
    }
}
