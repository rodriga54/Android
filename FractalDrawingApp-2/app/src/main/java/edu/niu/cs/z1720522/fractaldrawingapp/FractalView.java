package edu.niu.cs.z1720522.fractaldrawingapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

/**
 * Created by z1720522 on 4/5/2016.
 */
public class FractalView extends View
{
    private float x1, y1, x2, y2;
    private int level, fractalColor;
    private Fractal fractal;

    //x1 is starting point
    //x2 is ending point
    public FractalView(Context context)
    {
        super(context);

        //Allows us to set the level
        setLevel(1);
        setFractalColor(Color.rgb(5, 255, 172));
        fractal = new Fractal();
    } //End of FractalView

    public void setLevel(int newLevel)
    {
        level = newLevel;
    } //End of setLevel

    public void setFractalColor(int newColor)
    {
        fractalColor = newColor;
    } //End of setFractalColor

    protected void onDraw(Canvas canvas)
    {
        //Make sure the drawing fits on the screen by getting the canvas width and height

        //Start coordinates
        x1 = canvas.getWidth() / 3;
        y1 = canvas.getHeight() / 4;

        //End coordinates
        x2 = canvas.getWidth() - x1;
        y2 = y1;

        //Make sure the background for the canvas is always the same color
        canvas.drawRGB(255, 255, 255); //White

        //Draw the fractal
        fractal.drawCCure(canvas, x1, y1, x2, y2, level, fractalColor);

    } //End of onDraw

} //End FractalView
