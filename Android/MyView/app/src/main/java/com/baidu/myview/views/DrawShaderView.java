package com.baidu.myview.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;

import com.baidu.myview.R;

public class DrawShaderView extends BaseView {
    public DrawShaderView(Context context) {
        super(context);
    }

    public DrawShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        Paint paint = new Paint();
        RectF rectF = new RectF();

        Bitmap rect = BitmapFactory.decodeResource(getResources(), R.drawable.rect);
        Bitmap circle = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        BitmapShader bShader = new BitmapShader(rect, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        BitmapShader cShader = new BitmapShader(circle, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);


//        ComposeShader composeShader = new ComposeShader(bShader, cShader, PorterDuff.Mode.DST);
//        paint.setShader(composeShader);

//        rectF.left = 0;
//        rectF.top = 0;
//        rectF.right = rectF.left + rect.getWidth();
//        rectF.bottom = rectF.top + rect.getHeight();
//        canvas.drawRect(rectF, paint);
        ;

        canvas.save();
        Matrix matrix = new Matrix();
        matrix.setTranslate(200, 200);
        canvas.concat(matrix);
        canvas.drawBitmap(rect, 0, 0, paint);
        Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN);
        paint.setXfermode(xfermode);
//        Matrix matrix = new Matrix();
//        matrix.setScale(0.5f,0.5f);
        circle = Bitmap.createBitmap(circle, 0,0, circle.getWidth(), circle.getHeight(),matrix, false);
        canvas.drawBitmap(circle, 0, 0, paint);
        canvas.restore();
        canvas.drawText();
    }
}
