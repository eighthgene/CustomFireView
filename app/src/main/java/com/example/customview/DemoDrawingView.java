package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DemoDrawingView extends View {

    private final Paint paint = new Paint();

    public DemoDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        paint.setColor(Color.GREEN);

        final int size = getWidth() / 4;
        for (int x = 0; x < width; x += size) {
            for (int y = 0; y < height; y += size) {
                paint.setColor(0x00ffffff & (1257823419 * x + 2118746214 * y) | 0xff000000);
                canvas.drawRect(x, y, x + size, y + size, paint);
            }
        }

    }
}
