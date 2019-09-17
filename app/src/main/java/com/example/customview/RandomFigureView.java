package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class RandomFigureView extends View {

    private final Paint paint = new Paint();

    public RandomFigureView(Context context, @Nullable AttributeSet attrs) {
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

        float segmentSize = contentSize / 3;

        Path path = new Path();
        path.moveTo(segmentSize, 0);
        path.lineTo(2 * segmentSize, 0);
        path.lineTo(2 * segmentSize, segmentSize);
        path.lineTo(3 * segmentSize, segmentSize);
        path.lineTo(3 * segmentSize, 3 * segmentSize);
        path.lineTo(2 * segmentSize, 3 * segmentSize);
        path.lineTo(2 * segmentSize, 2 * segmentSize);
        path.lineTo(segmentSize, 2 * segmentSize);
        path.lineTo(segmentSize, 3 * segmentSize);
        path.lineTo(0, 3 * segmentSize);
        path.lineTo(0, segmentSize);
        path.lineTo(segmentSize, segmentSize);
        path.lineTo(segmentSize, 0);

        path.offset(centerX - 1.5f * segmentSize, centerY - 1.5f * segmentSize);

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(20);

        canvas.drawPath(path, paint);

    }
}
