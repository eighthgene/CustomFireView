package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class OptimizedCustomView extends View {
    private final Paint paint = new Paint();
    private final Path path = new Path();

    public OptimizedCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(20);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        int centerX = w / 2;
        int centerY = h / 2;
        int padding = 50;
        int minSide = Math.min(w, h);
        int contentSize = minSide - 2 * padding;

        float segmentSize = contentSize / 3f;

        path.reset();

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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }
}
