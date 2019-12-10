package com.baidu.myview.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.baidu.myview.views.BaseView;

public class DrawPiePracticeView extends BaseView {
    public DrawPiePracticeView(Context context) {
        super(context);
    }

    public DrawPiePracticeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPiePracticeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int radius = 500, interval = 10;
        int left = zeroX + 50, top = zeroY + 50, right = left + radius, bottom = top + radius;
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        RectF rectF = new RectF();
        rectF.left = left;
        rectF.right = right;
        rectF.top = top;
        rectF.bottom = bottom;

        paint.setColor(Color.BLUE);
        canvas.drawArc(rectF, 315, 75,true, paint);
        paint.setColor(Color.GREEN);
        canvas.drawArc(rectF, 31, 75,true, paint);
        paint.setColor(Color.GRAY);
        canvas.drawArc(rectF, 107, 45,true, paint);
        paint.setColor(Color.DKGRAY);
        canvas.drawArc(rectF, 154, 26,true, paint);

        rectF.left -= interval;
        rectF.top -= interval;
        rectF.right -= interval;
        rectF.bottom -= interval;
        paint.setColor(Color.RED);
        canvas.drawArc(rectF, 180, 135,true, paint);
    }


}
