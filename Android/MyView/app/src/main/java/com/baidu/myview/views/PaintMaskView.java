package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.baidu.myview.R;

public class PaintMaskView extends PaintView {
    public PaintMaskView(Context context) {
        super(context);
    }

    public PaintMaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintMaskView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        int x = zeroX + 50, y = zeroY + 50;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        canvas.drawBitmap(bitmap, x, y, paint);
        paint.setTextSize(30);
        canvas.drawText("默认", x + bitmap.getWidth() + 50, y + bitmap.getHeight(), paint);

        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL);
        paint.setMaskFilter(blurMaskFilter);
        y = y + 200;
        canvas.drawBitmap(bitmap, x, y, paint);
        paint.setMaskFilter(null);
        canvas.drawText("NORMAL 内外都模糊", x + bitmap.getWidth() + 50, y + bitmap.getHeight(), paint);

        blurMaskFilter = new BlurMaskFilter(10, BlurMaskFilter.Blur.INNER);
        paint.setMaskFilter(blurMaskFilter);
        y = y + 200;
        canvas.drawBitmap(bitmap, x, y, paint);
        paint.setMaskFilter(null);
        canvas.drawText("INNER 内部模糊，外部不绘制", x + bitmap.getWidth() + 50, y + bitmap.getHeight(), paint);


        blurMaskFilter = new BlurMaskFilter(10, BlurMaskFilter.Blur.SOLID);
        paint.setMaskFilter(blurMaskFilter);
        y = y + 200;
        canvas.drawBitmap(bitmap, x, y, paint);
        paint.setMaskFilter(null);
        canvas.drawText("SOLID 内部正常，外部模糊", x + bitmap.getWidth() + 50, y + bitmap.getHeight(), paint);


        blurMaskFilter = new BlurMaskFilter(10, BlurMaskFilter.Blur.OUTER);
        paint.setMaskFilter(blurMaskFilter);
        y = y + 200;
        canvas.drawBitmap(bitmap, x, y, paint);
        paint.setMaskFilter(null);
        canvas.drawText("OUTER 内部不绘制，外部模糊", x + bitmap.getWidth() + 50, y + bitmap.getHeight(), paint);

    }
}
