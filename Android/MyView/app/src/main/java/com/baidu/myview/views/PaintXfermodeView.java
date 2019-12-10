package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;

import com.baidu.myview.R;

public class PaintXfermodeView extends PaintView {

    public PaintXfermodeView(Context context) {
        super(context);
    }

    public PaintXfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintXfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        Paint paint = new Paint();
        Bitmap rect = BitmapFactory.decodeResource(getResources(), R.drawable.rect);
        Bitmap circle = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
//        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(rect,0,0, paint);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(circle,0,0, paint);
//        canvas.restoreToCount(saved);
    }
}
