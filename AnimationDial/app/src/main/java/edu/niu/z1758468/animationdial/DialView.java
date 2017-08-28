package edu.niu.z1758468.animationdial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by aberodriguez on 4/19/16.
 */
public class DialView extends View
{
    private float angle;
    private Paint paint;

    public DialView(Context context)
    {
        super(context);
        // Set the angle 0
        angle = 0;

        // create the paint object
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(75);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        // Set the background color
        canvas.drawRGB(248, 232, 198);

        // Create variables
        // Calculate canvas width and height
        int canvasWidth = getMeasuredWidth();
        int canvasHeight = getMeasuredHeight();
        int radius;

        // Check for landscape and set the radius
        if (canvasWidth > canvasHeight)
        {
         radius = canvasHeight / 2;
        }
        else
        {
            radius = canvasWidth /2;
        }
        angle +=1;
        if (angle > 360)
        {
            angle = 0;
        }

        // Draw the line
        float radians = (float)(angle *(180 / Math.PI)),
                startX = canvasWidth /2,
                startY = canvasHeight / 2,
                stopX = (float)(startX + radius * Math.sin(radians)),
                stopY = (float)(startY - radius * Math.cos(radians));

        paint.setColor(Color.rgb(132, 175, 166));
        canvas.drawLine(startX, startY, stopX, stopY, paint);

    }//

    public void update()
    {
        invalidate();
    }// End of update


}// End of DialView
