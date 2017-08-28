package edu.niu.z1758468.calcappweek2;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {

    // Instance variables
    EditText num1ET, num2ET;
    TextView results;
    Integer num1, num2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the editText and TextView objects to the screen
        num1ET = (EditText)findViewById(R.id.num1);
        num2ET = (EditText)findViewById(R.id.num2);
        results = (TextView)findViewById(R.id.results);

        // The Addition button in action.
        final Button addBtn = (Button)findViewById(R.id.add);
        // The Minus button in action.
        final Button minusBtn = (Button)findViewById(R.id.minus);
        // The Multiply button in action.
        final Button multBtn = (Button)findViewById(R.id.multi);
        // The Divide button in action.
        final Button divideBtn = (Button)findViewById(R.id.divide);


        View.OnClickListener operation = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Check to see if text fields are empty.
                if (num1ET.getText().toString().matches("") || num2ET.getText().toString().matches(""))
                {
                    Toast.makeText(v.getContext(), "You have not entered in a valid number.", Toast.LENGTH_LONG).show();
                    return;
                }
                // Get numbers from text fields.
                num1 = Integer.parseInt(num1ET.getText().toString());
                num2 = Integer.parseInt(num2ET.getText().toString());

                // Addition
                if (v == addBtn)
                {
                    // Calculate
                    result = num1 + num2;
                }
                // Substraction
                if (v == minusBtn)
                {
                    // Calculate
                    result = num1 - num2;
                }
                // Multiplication
                if (v == multBtn)
                {
                    // Calculate
                    result = num1 * num2;
                }
                // Division
                if (v == divideBtn )
                {
                    // Check both fields for zeros
                    if (num1ET.getText().toString().matches("0") || num2ET.getText().toString().matches("0"))
                    {
                        Toast.makeText(v.getContext(), "Error: Cannot divide by zero.", Toast.LENGTH_LONG).show();
                        return;
                    }
                    // Calculate
                    result = num1 / num2;
                }
                // Displays the results.
                results.setText(result.toString());
            }

        };
        // Set the listeners for each button.
        addBtn.setOnClickListener(operation);
        minusBtn.setOnClickListener(operation);
        multBtn.setOnClickListener(operation);
        divideBtn.setOnClickListener(operation);

        // Clear the data from text fields.
        Button clearBtn = (Button)findViewById(R.id.clearButton);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1ET.setText("");
                num2ET.setText("");
            }
        });

    }
}
