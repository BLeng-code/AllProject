package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.util.AttributeSet;

public class PaintEffectView extends PaintView {
    public PaintEffectView(Context context) {
        super(context);
    }

    public PaintEffectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintEffectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);


        Path path = new Path();
        int x = zeroX + 50, y = zeroY + 50;

        path.moveTo(x, y);
        path.lineTo(x + 100, y + 200);
        path.lineTo(x + 210, y);
        path.lineTo(x + 350, y + 200);
        path.lineTo(x + 480, y);
        canvas.drawPath(path, paint);
        paint.setTextSize(30);
        canvas.drawText("默认", x + 480, y, paint);

        CornerPathEffect cornerPathEffect = new CornerPathEffect(50);
        paint.setPathEffect(cornerPathEffect);
        path = new Path();
        y = y + 100;
        path.moveTo(x, y);
        path.lineTo(x + 100, y + 200);
        path.lineTo(x + 210, y);
        path.lineTo(x + 350, y + 200);
        path.lineTo(x + 480, y);
        canvas.drawPath(path, paint);
        canvas.drawText("CornerPathEffect", x + 480, y, paint);

        DiscretePathEffect discretePathEffect = new DiscretePathEffect(50, 10);
        paint.setPathEffect(discretePathEffect);
        path = new Path();
        y = y + 100;
        path.moveTo(x, y);
        path.lineTo(x + 100, y + 200);
        path.lineTo(x + 210, y);
        path.lineTo(x + 350, y + 200);
        path.lineTo(x + 480, y);
        canvas.drawPath(path, paint);
        canvas.drawText("DiscretePathEffect", x + 480, y, paint);


        float[] intevals = {20, 30};
        DashPathEffect dashPathEffect = new DashPathEffect(intevals, 10);
        paint.setPathEffect(dashPathEffect);
        path = new Path();
        y = y + 100;
        path.moveTo(x, y);
        path.lineTo(x + 100, y + 200);
        path.lineTo(x + 210, y);
        path.lineTo(x + 350, y + 200);
        path.lineTo(x + 480, y);
        canvas.drawPath(path, paint);
        canvas.drawText("DashPathEffect", x + 480, y, paint);

        Path path1 = new Path();
        path1.addCircle(0, 0, 3, Path.Direction.CW);
        PathDashPathEffect pathDashPathEffect = new PathDashPathEffect(path1, 12, 10, PathDashPathEffect.Style.TRANSLATE);
        paint.setPathEffect(pathDashPathEffect);
        path = new Path();
        y = y + 100;
        path.moveTo(x, y);
        path.lineTo(x + 100, y + 200);
        path.lineTo(x + 210, y);
        path.lineTo(x + 350, y + 200);
        path.lineTo(x + 480, y);
        canvas.drawPath(path, paint);
        canvas.drawText("PathDashPathEffect", x + 480, y, paint);

        SumPathEffect sumPathEffect = new SumPathEffect(dashPathEffect, discretePathEffect);
        paint.setPathEffect(sumPathEffect);
        path = new Path();
        y = y + 100;
        path.moveTo(x, y);
        path.lineTo(x + 100, y + 200);
        path.lineTo(x + 210, y);
        path.lineTo(x + 350, y + 200);
        path.lineTo(x + 480, y);
        canvas.drawPath(path, paint);
        canvas.drawText("SumPathEffect", x + 480, y, paint);


        ComposePathEffect composePathEffect = new ComposePathEffect(dashPathEffect, discretePathEffect);
        paint.setPathEffect(composePathEffect);
        path = new Path();
        y = y + 100;
        path.moveTo(x, y);
        path.lineTo(x + 100, y + 200);
        path.lineTo(x + 210, y);
        path.lineTo(x + 350, y + 200);
        path.lineTo(x + 480, y);
        canvas.drawPath(path, paint);
        canvas.drawText("ComposePathEffect", x + 480, y, paint);

    }
}
