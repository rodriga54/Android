package edu.niu.z1758468.drawoncanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

/**
 * Created by Z1758468 on 4/5/2016.
 */
public class FractalView extends View
{
    private float x1, y1, x2, y2;
    private int level, fractalColor;
    private Fractal fractal;

    public FractalView (Context context)
    {
        super(context);
        setLevel(1);
        setFractalColor(Color.rgb(0, 4, 255));
        fractal = new Fractal ();
    }// end of Constructor

    public void setLevel (int newLevel)
    {
        level = newLevel;
    }// End of setColor

    public void setFractalColor(int newColor)
    {
        fractalColor = newColor;
    }//End of setFractalColor

    protected void onDraw (Canvas canvas)
    {
        // Starting coordinates
        x1 = canvas.getWidth()/3;
        y1 = canvas.getHeight()/4;

        // Ending Coordinates
        x2 = canvas.getWidth() - x1;
        y2 = y1;

        // Fill Canvas with white
        canvas.drawRGB(255,255,255);

        //
        fractal.drawCCurve(canvas, x1, y1, x2, y2, level, fractalColor);

    }// End of onDraw
}// End of FractalView
