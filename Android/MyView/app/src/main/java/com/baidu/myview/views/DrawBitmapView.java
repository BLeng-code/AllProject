package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.baidu.myview.R;

public class DrawBitmapView extends BaseView {


    public DrawBitmapView(Context context) {
        super(context);
    }

    public DrawBitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawBitmapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);

        canvas.drawBitmap(bitmap, zeroX + 100, zeroY + 100, paint);
        paint.setTextSize(200);
        canvas.drawText("文字", zeroX + 100, zeroY + 450, paint);

    }
}
