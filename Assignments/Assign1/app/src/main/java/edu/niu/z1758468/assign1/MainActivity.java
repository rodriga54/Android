//////////////////////////////////////////////////////////////////////////////////////////
// CSCI 322         Program 1     Spring 2016
// Name: Abe Rodriguez
// Date Due: 2/12/2016
// Purpose: Quadratic Equation Calculator determines the discriminant to determine the
//          real and imaginary numbers and then determines x-intercepts if any.
/////////////////////////////////////////////////////////////////////////////////////////

package edu.niu.z1758468.assign1;

import android.app.Activity;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    // Instance variables
    EditText aET, bET, cET;
    TextView x1TV, x2TV;
    boolean check;
    double numA, numB, numC, temp1, x1, x2, Discriminant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the editText and TextView objects to the screen
        aET = (EditText)findViewById(R.id.aET);
        bET = (EditText)findViewById(R.id.bET);
        cET = (EditText)findViewById(R.id.cET);
        x1TV = (TextView)findViewById(R.id.results1);
        x2TV = (TextView)findViewById(R.id.results2);

        // The Calculation button in action.
        final Button calcBtn = (Button)findViewById(R.id.calculate);


        View.OnClickListener operation = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (aET.getText().toString().matches("") || aET.getText().toString().matches("0"))
                {
                    Toast.makeText(v.getContext(), "The value for 'a' CANNOT be zero or blank.", Toast.LENGTH_LONG).show();
                    return;
                }
                // Check to see if text fields are empty.
                if (bET.getText().toString().matches("") || cET.getText().toString().matches(""))
                {
                    Toast.makeText(v.getContext(), "You have not entered a number.", Toast.LENGTH_LONG).show();
                    return;
                }
                // Get numbers from text fields.
                numA = Double.parseDouble(aET.getText().toString());
                numB = Double.parseDouble(bET.getText().toString());
                numC = Double.parseDouble(cET.getText().toString());

                // Discriminant Formula
                Discriminant = numB * numB - 4 * numA * numC;

                // if the calcBth has been press then
                if (v == calcBtn)
                {	// If Discriminant is positive than we have 2 real numbers ( 2 x-intercepts).
                    if ( Discriminant > 0)
                    {
                        // Calculations
                        temp1 = Math.sqrt(numB * numB - (Discriminant));

                        x1 = (-numB + Math.sqrt(numB * numB - 4 * numA * numC)) / (2 * numA);
                        x2 = (-numB - Math.sqrt(numB * numB - 4 * numA * numC)) / (2 * numA);
                    }
                    // If Discriminant is equal to 1 than we only have 1 real number ( 1 x-intercepts).
                    if (Discriminant == 0)
                    {
                        x1 = -numB / (2 * numA);
                        x2 = -numB / (2 * numA);
                    }
                    // If Discriminant is Negative than we have 2 imaginary numbers ( no x-intercepts).
                    if (Discriminant < 0)
                    {
                        Toast.makeText(v.getContext(), "Imaginary Numbers.", Toast.LENGTH_LONG).show();
                        return;
                    }
                }

                // Displays the results in 2 decimal format.
                DecimalFormat df = new DecimalFormat("#,##0.00");
                x1TV.setText(df.format(x1));
                x2TV.setText(df.format(x2));
            }

        };
        // Set the listeners for each button.
        calcBtn.setOnClickListener(operation);

        // Clear the data from text fields.
        Button clearBtn = (Button)findViewById(R.id.clear);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aET.setText("");
                bET.setText("");
                cET.setText("");
            }
        });

    }
}