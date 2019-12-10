package com.baidu.myview.views;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;

public class DrawCircleView extends DrawShapeView {
    public DrawCircleView(Context context) {
        super(context);
    }

    public DrawCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        paint.setColor(Color.rgb(200,64,71));
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint.setMaskFilter(new BlurMaskFilter(40, BlurMaskFilter.Blur.INNER));
        canvas.drawCircle(200,200,150, paint);

        paint.reset();
        Shader shader = new RadialGradient(200,200, 110,
                Color.rgb(206,77, 42),
                Color.rgb(177,65,34),
                Shader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setColor(Color.rgb(206,77,42));
        canvas.drawCircle(200,200,110, paint);
    }
}
