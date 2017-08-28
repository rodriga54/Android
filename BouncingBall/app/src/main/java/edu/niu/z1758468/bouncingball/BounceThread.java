package edu.niu.z1758468.bouncingball;

import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceHolder;

/**
 * Created by aberodriguez on 4/19/16.
 */
public class BounceThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private AnimationArena animationArena;
    private boolean isRunning;

    public BounceThread (SurfaceHolder sh)
    {
        isRunning = true;
        surfaceHolder = sh;
        animationArena = new AnimationArena();

    }// End of BounceThread Constructor

    public void run()
    {
        try
        {
            while (isRunning)
            {
                Canvas canvas = surfaceHolder.lockCanvas();
                animationArena.update(canvas.getWidth(), canvas.getHeight());
                animationArena.draw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
    }// End of Run

    public void endBounce()
    {
        isRunning = false;
    }// End of endBounce
}// End of BounceThread
