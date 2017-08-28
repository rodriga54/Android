package edu.niu.z1758468.exam1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    static final int REQUEST_CODE = 1;
    private RadioButton shapeButton;
    private RadioGroup shapeRG;
    private TextView area;
    String shape;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            shapeRG = (RadioGroup)findViewById(R.id.shapeRadioGroup);
            area = (TextView)findViewById(R.id.areaTextView);

        shapeRG.setOnCheckedChangeListener (shapeListiner);

        }// End of onCreate

       private RadioGroup.OnCheckedChangeListener  shapeListiner = new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.triangleRadioButton:
                        break;
                    case R.id.circleRadioButton:
                        break;
                    case R.id.ellipseRadioButton:
                        break;
                }
            }
        };

        public void goCalculate (View view)
        {
            // set variables with content
            // get selected radio button from radioGroup
            int selectedId = shapeRG.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            shapeButton = (RadioButton) findViewById(selectedId);
            if (selectedId == -1)
            {
                Toast.makeText(view.getContext(), "Please Make a Selection. ", Toast.LENGTH_LONG).show();
                return;
            }

            Toast.makeText(MainActivity.this,
                    shapeButton.getText(), Toast.LENGTH_SHORT).show();
                    shape = shapeButton.getText().toString();
            // Get numbers from text fields.

                if (shape.equals("Triangle")) {
                    Intent intent = new Intent(MainActivity.this, Triangle.class);
                    startActivityForResult(intent, REQUEST_CODE);

                } else if (shape.equals("Circle")) {
                    Intent intent = new Intent(MainActivity.this, Circle.class);
                    startActivityForResult(intent, REQUEST_CODE);

                } else if (shape.equals("Ellipse")) {
                    Intent intent = new Intent(MainActivity.this, Ellipse.class);
                    startActivityForResult(intent, REQUEST_CODE);
                }
        }// End of goCalculate

        @Override
        protected void onActivityResult (int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            double answer;
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
            {
                // Displays the results in 3 decimal format.
                DecimalFormat df = new DecimalFormat("#,##0.000");
                answer = data.getDoubleExtra("Result", 0.000);
                area.setText("Your Answers is:  " + df.format(answer));
            }//End of if statement
        }


}//End of Main
