package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;

import com.baidu.myview.R;

public class PaintColorView extends PaintView {
    public PaintColorView(Context context) {
        super(context);
    }

    public PaintColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);

//        int radius = 300, x = zeroX + 400, y = zeroY + 400;
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        paint.setColor(Color.parseColor("#125612"));
//        paint.setARGB(100, 100, 100, 100);
//
//        int star = Color.parseColor("#63ffff");
//        int end = Color.parseColor("#ff5841");
//        LinearGradient linearGradient = new LinearGradient(x - 100, y, x + 100, y, star, end, Shader.TileMode.CLAMP);
//
//        paint.setShader(linearGradient);
//        canvas.drawCircle(x, y, radius, paint);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.b);
        Matrix matrix = new Matrix();
        matrix.setScale(0.3f, 0.3f);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Paint paint = new Paint();
        ColorFilter colorFilter = new LightingColorFilter(0x00ffff, 0x000000);
        colorFilter = new PorterDuffColorFilter(0x00ffffff, PorterDuff.Mode.SRC_OVER);
        paint.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
