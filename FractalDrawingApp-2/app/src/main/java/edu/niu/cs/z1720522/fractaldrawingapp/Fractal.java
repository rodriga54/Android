package edu.niu.cs.z1720522.fractaldrawingapp;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by z1720522 on 4/5/2016.
 */
public class Fractal
{
    //Recursive method
    public void drawCCure(Canvas canvas, float x1, float y1, float x2, float y2, int level, int lineColor)
    {
        //Create a Paint object
        Paint paint = new Paint();
        paint.setColor(lineColor);
        paint.setStrokeWidth(1); //Thin paint stroke

        //Check the level to see if we have to do another recursive call
        //If == 0, all we are doing is drawing a straight line
        if (level == 0)
        {
            canvas.drawLine(x1, y1, x2, y2, paint);
        }

        //Recursion step
        else
        {
            //Draw 2 lines by using a recursive call (draw a triangle)
            //Finds the midpoint
            float xn = (x1 + x2) / 2 + (y1 - y2) / 2;
            float yn = (x2 - x1) / 2 + (y1 + y2) / 2;

            //Recursively draw the above two lines
            drawCCure(canvas, x1, y1, xn, yn, level - 1, lineColor);

            //Draw the other line for the other part of the triangle
            drawCCure(canvas, xn, yn, x2, y2, level - 1, lineColor);
        }

    } //End of drawCCurve
} //End of Fractal
