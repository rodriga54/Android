package edu.niu.z1758468.bouncingball;

/**
 * Created by aberodriguez on 4/19/16.
 */
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball
{
    private final int RADIUS = 15, REVERSE = -1;

    private int x, y, velX, velY;

    public Ball()
    {
        x = 100;
        y = 100;
        velX = 10;
        velY = 10;
    }//end of Ball constructor

    public void move(int leftWall, int topWall, int rightWall, int bottomWall)
    {
        x += velX;
        y += velY;

        if( y > bottomWall - RADIUS )
        {
            y = bottomWall - RADIUS;
            velY *= REVERSE;
        }
        else if( y < topWall + RADIUS )
        {
            y = topWall + RADIUS;
            velY *= REVERSE;
        }


        if( x > rightWall - RADIUS )
        {
            x = rightWall - RADIUS;
            velX *= REVERSE;
        }
        else if( x < leftWall + RADIUS )
        {
            x = leftWall + RADIUS;
            velX *= REVERSE;
        }
    }//end of move


    public void draw( Canvas canvas )
    {
        Paint paint = new Paint();
        paint.setColor(Color.rgb(211,216,156));
        canvas.drawCircle(x, y, RADIUS,paint);
    }//end of draw
}//end of Ball class


