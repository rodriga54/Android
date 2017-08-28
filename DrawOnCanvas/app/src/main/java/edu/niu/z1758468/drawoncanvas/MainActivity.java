package edu.niu.z1758468.drawoncanvas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int MIN_LEVEL = 1,
                     MAX_LEVEL = 14;

    private TextView levelTV;
    private Integer levelNum;
    private RelativeLayout relativeLayout;
    private FractalView fractalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        levelTV = (TextView)findViewById(R.id.levelTV);
        relativeLayout = (RelativeLayout)findViewById(R.id.screen);

        fractalView = new FractalView(this);
        relativeLayout.addView(fractalView, 0);

        levelNum = MIN_LEVEL;
    }// End of onCreate

    public void drawFractal(View view)
    {
        fractalView.setLevel(levelNum);
        fractalView.invalidate();
    }

    public void stepUp(View view)
    {
        if (levelNum < MAX_LEVEL)
        {
            levelNum ++;
            levelTV.setText(levelNum.toString());
        }
    }

    public void stepDown(View view)
    {
        if (levelNum > MIN_LEVEL)
        {
            levelNum --;
            levelTV.setText(levelNum.toString());
        }
    }

}// End of Main
