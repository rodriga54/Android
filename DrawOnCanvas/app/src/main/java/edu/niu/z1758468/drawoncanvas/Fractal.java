package edu.niu.z1758468.drawoncanvas;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Z1758468 on 4/5/2016.
 */
public class Fractal
{
public void drawCCurve(Canvas canvas, float x1, float y1, float x2, float y2, int level, int lineColor)
{
    Paint paint = new Paint();
    paint.setColor(lineColor);
    paint.setStrokeWidth(1);

    // if statement for recursion
    if (level == 0)
    {
        canvas.drawLine(x1,y1,x2,y2, paint);
    }
    // recursive call
    else
    {
        float xn = (x1 + x2)/ 2 + (y1 - y2)/2;
        float yn = (x2 - x1)/ 2 + (y1 + y2)/2;

        drawCCurve(canvas, x1, y1, xn, yn, level - 1, lineColor);
        drawCCurve(canvas, xn, yn, x2, y2, level - 1, lineColor);
    }

}// End of drawCCurve
}// End of Class Fractal
