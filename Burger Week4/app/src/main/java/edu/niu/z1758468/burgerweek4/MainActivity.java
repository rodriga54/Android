package edu.niu.z1758468.burgerweek4;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    // Instance Variables
    private RadioGroup pattyRG, cheeseRG;
    private CheckBox baconCB;
    private SeekBar sauceSB;
    private TextView caloriesTV;

    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the burger object
        burger = new Burger();

        // Connect variables to View
        pattyRG = (RadioGroup) findViewById(R.id.pattyRadioGroup);
        cheeseRG = (RadioGroup) findViewById(R.id.cheeseRadioGroup);
        baconCB = (CheckBox) findViewById(R.id.baconCheckBox);
        sauceSB = (SeekBar) findViewById(R.id.sauceSeekBar);
        caloriesTV = (TextView) findViewById(R.id.caloriesTextView);

        // Set up the Listeners
        pattyRG. setOnCheckedChangeListener(pattyListener);
        cheeseRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.noCheeseradioButton:
                        burger.setCheesCalories(0);
                        break;
                    case R.id.cheddarRdioButton:
                        burger.setCheesCalories(Burger.CHEDDAR);
                        break;
                    case R.id.MozzRadioButton:
                        burger.setCheesCalories(Burger.MOZZ);
                        break;
                }
                // Display the initial Calorie count.
                displayCalories();
            }
        }); // end of setOnCheckChangedListener for the cheese

        baconCB.setOnClickListener(baconListener);
        sauceSB.setOnSeekBarChangeListener(sauceListener);

    }// End of onCreate

    private RadioGroup.OnCheckedChangeListener pattyListener = new RadioGroup.OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            switch (checkedId)
            {
                case R.id.beefRadioButton:
                    burger.setPattyCalories(Burger.BEEF);
                    break;
                case R.id.turkeyRadioButton:
                    burger.setPattyCalories(Burger.TURKEY);
                    break;
                case R.id.VeggieRadioButton:
                    burger.setPattyCalories(Burger.VEGGIE);
                    break;
            }
            // Display the initial Calorie count.
            displayCalories();
        }
    };// end of setOnCheckChangedListener for the patty

    private View.OnClickListener baconListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (((CheckBox)v).isChecked())
            {
                burger.setBaconCalories(true);
            }
            else
            {
                burger.setBaconCalories(false);
            }
        }
    };


            private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
                {
                    burger.setSauceCalories (seekBar.getProgress());
                    // Display the initial Calorie count.
                    displayCalories();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar)
                {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar)
                {

                }
            };

    private void displayCalories() {
        caloriesTV.setText("Calories: " + burger.getTotalCalories());
    }

}// End of MainActivity
