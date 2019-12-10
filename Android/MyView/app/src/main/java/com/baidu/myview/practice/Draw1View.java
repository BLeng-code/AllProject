package com.baidu.myview.practice;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

public class Draw1View extends View {
    public Draw1View(Context context) {
        super(context);
    }

    public Draw1View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Draw1View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Draw1View(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(5);
        int width = 241, height = 259, littleHeight = 21;
        int x = 100, y = 100;
        int mul = 3;
        paint.setColor(Color.rgb(128, 128, 128));
        RectF rectF = new RectF();
        rectF.left = x;
        rectF.top = y;
        rectF.right = x + width * mul;
        rectF.bottom = y + height * mul;
        canvas.drawRect(rectF, paint);

        rectF.bottom = y + littleHeight * mul;
        Shader shader = new LinearGradient(x,
                y,
                x,
                y + littleHeight,
                Color.rgb(238, 238, 238),
                Color.rgb(181, 181, 181), Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawRect(rectF, paint);

        float radius = 6 * mul, marginLeft = 8 * mul, marginTop = 5 * mul;

        paint.reset();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.rgb(222, 123, 115));
        canvas.drawCircle(x + marginLeft + radius, y + marginTop + radius, radius, paint);

        paint.setColor(Color.rgb(248, 226, 152));
        canvas.drawCircle(x + 2 * (marginLeft + radius) + radius, y + marginTop + radius, radius, paint);


        paint.setColor(Color.rgb(174, 212, 134));
        canvas.drawCircle(x + 3 * (marginLeft + radius) + 2 *radius, y + marginTop + radius, radius, paint);

        paint.setColor(Color.rgb(97, 71, 62));
        paint.setTextSize(11 * mul);
//        canvas.drawText("Paint",
//                x + mul * width / 2 - 5 * (11 * mul) / 2,
//                y + mul * littleHeight / 2 + (11 * mul) / 2,
//                paint);


        int marginRight = 4 * mul;
        marginTop = 4 * mul;
        int arrowWidth = 14 * mul, interval = 2 * mul;
        Path path = new Path();
        int arrowRightTopX = (int) (rectF.right - marginRight);
        int arrowRightTopY = (int) (rectF.top + marginTop);
        path.moveTo(arrowRightTopX, arrowRightTopY);
        path.lineTo(arrowRightTopX, arrowRightTopY + arrowWidth / 2);
        path.lineTo(arrowRightTopX - 3 * mul, arrowRightTopY + 5 * mul);
        path.lineTo(arrowRightTopX - 5 * mul, arrowRightTopY + 7 * mul);
        path.lineTo(arrowRightTopX - 7 * mul, arrowRightTopY + 5 * mul);
        path.lineTo(arrowRightTopX - 5 * mul, arrowRightTopY + 2 * mul);
        path.lineTo(arrowRightTopX - arrowWidth / 2, arrowRightTopY);
        paint.setColor(Color.rgb(156, 156, 156));
//        canvas.drawPath(path, paint);

        int arrowLeftBottomX = arrowRightTopX - arrowWidth;
        int arrwoLeftBottomY = arrowRightTopY + arrowWidth;
        path.reset();
        path.moveTo(arrowLeftBottomX, arrwoLeftBottomY);
        path.lineTo(arrowLeftBottomX + 7 * mul, arrwoLeftBottomY);
        path.lineTo(arrowLeftBottomX + 5 * mul, arrwoLeftBottomY - 2 * mul);
        path.lineTo(arrowLeftBottomX + 7 * mul, arrwoLeftBottomY - 5 * mul);
        path.lineTo(arrowLeftBottomX + 5 * mul, arrwoLeftBottomY - 7 * mul);
        path.lineTo(arrowLeftBottomX + 3 * mul, arrwoLeftBottomY - 5 * mul);
        path.lineTo(arrowLeftBottomX, arrwoLeftBottomY - 7 * mul);
//        canvas.drawPath(path, paint);

        int circleX = x + mul * width / 2, circleY = y + mul * height / 2 + 14 * mul, circleR = 100 * mul;
        shader = new LinearGradient(circleX, circleY - circleR,
                circleX, circleY + circleR,
                Color.rgb(254, 254, 254),
                Color.rgb(162, 162, 162),
                Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(circleX, circleY, circleR, paint);
        circleR = circleR - 14 * mul;
        shader = new LinearGradient(circleX, circleY - circleR,
                circleX, circleY + circleR,
                Color.rgb(156, 156, 156),
                Color.rgb(242, 242, 242),
                Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(circleX, circleY, circleR, paint);
        circleR = circleR - 4 * mul;
        paint.reset();
        paint.setColor(Color.rgb(207,77,42));

        canvas.drawCircle(circleX, circleY, circleR, paint);

        circleR = circleR - 4 * mul;
        shader = new RadialGradient(circleX, circleY, circleR,
                Color.TRANSPARENT,
                Color.rgb(150, 65, 40),
                Shader.TileMode.CLAMP);
        paint.reset();
        paint.setMaskFilter(new BlurMaskFilter(100, BlurMaskFilter.Blur.INNER));
        paint.setShader(shader);
        paint.setColor(Color.rgb(207,77,42));
        canvas.drawCircle(circleX, circleY, circleR, paint);



        // 画弧形
//        int save = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
//        canvas.save();
//        canvas.rotate(0, circleX, circleY);
//
//        shader = new LinearGradient(
//                circleX,
//                circleY - circleR,
//                circleX,
//                circleY,
//                Color.WHITE,
//                Color.rgb(143,62,46),
//                Shader.TileMode.CLAMP
//        );
//        path.reset();
//        paint.reset();
//        rectF.left = circleX - circleR;
//        rectF.top = circleY - circleR;
//        rectF.right = circleX + circleR;
//        rectF.bottom = circleY + circleR;
//        paint.setShader(shader);
//        path.addArc(rectF, 180, 180);
//        canvas.drawPath(path, paint);
//        canvas.drawArc(rectF, 180,180, false, paint);
//
//        float times = 4;
//
//        rectF.top = rectF.top + circleR * (1 -1/times);
//        rectF.bottom = rectF.bottom - circleR * (1 - 1/times);
//
//        paint.reset();
//        path.reset();
//        path.addArc(rectF, 180, 180);
//        Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.XOR);
//        paint.setXfermode(xfermode);
//        canvas.drawPath(path, paint);
//        shader = new RadialGradient(circleX, circleY, circleR,
//                Color.rgb(207, 77, 42),
//                Color.rgb(122, 42, 2),
//                Shader.TileMode.CLAMP);
//        paint.setShader(shader);
//        canvas.drawArc(rectF, 180, 360, false, paint);
//
//        canvas.restoreToCount(save);

    }


}
