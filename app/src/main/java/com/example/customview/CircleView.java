package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CircleView extends View {

    private final Paint paint = new Paint();

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int centerY = height / 2;
        int padding = 50;
        int minSide = Math.min(width, height);
        int contentSize = minSide - 2 * padding;
        int overlap = 300;
        int radius = (contentSize + overlap) / 4;
        int dist = 2 * radius - overlap;

        float x1 = centerX - dist / 2;
        float x2 = centerX + dist / 2;
        float x3 = centerX;

        float d = dist / 2 / (float) Math.sqrt(3f);
        float y1 = centerY + d;
        float y2 = y1;
        float y3 = centerY - 2 * d;

        paint.setColor(Color.YELLOW & 0x7fffffff);
        canvas.drawCircle(x1, y1, radius, paint);
        paint.setColor(Color.MAGENTA & 0x7fffffff);
        canvas.drawCircle(x2, y2, radius, paint);
        paint.setColor(Color.BLUE & 0x7fffffff);
        canvas.drawCircle(x3, y3, radius, paint);
    }
}
