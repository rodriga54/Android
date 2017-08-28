package edu.niu.cs.z1720522.fractaldrawingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Symbolic constants
    final static int MINIMUM_LEVEL = 1;
    final static int MAXIMUM_LEVEL = 14;

    //Setup objects to get items from the screen
    private TextView levelTV;
    private Integer levelNum;
    private RelativeLayout relativeLayout;
    private FractalView fractalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout)findViewById(R.id.screen);
        levelTV = (TextView)findViewById(R.id.levelTextView);

        fractalView = new FractalView(this);

        //Add to our relative layout
        relativeLayout.addView(fractalView, 0);

        //Initialize the levelNum starting point
        levelNum = MINIMUM_LEVEL;

    } //End of onCreate

    public void drawFractal(View view)
    {
        //Setup level number for our fractal view
        fractalView.setLevel(levelNum);
        fractalView.invalidate();
    } //End of drawFractal

    public void stepUp(View view)
    {
        //Do not allow us to go past the maximum
        if(levelNum < MAXIMUM_LEVEL)
        {
            //User is clicking the '+' sign
            levelNum++;

            //Put the new number in out text view
            levelTV.setText(levelNum.toString());
        }
    }

    //- button
    private void stepDown(View view)
    {
        if (levelNum > MINIMUM_LEVEL)
        {

            //User is clicking the '-' sign
            levelNum--;

            //Put the new number in out text view
            levelTV.setText(levelNum.toString());
        }
    }

} //End of MainActivity
