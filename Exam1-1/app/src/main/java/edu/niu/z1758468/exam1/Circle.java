package edu.niu.z1758468.exam1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Circle extends Activity {

    private EditText radius;
    double result, radiusNum, pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        radius = (EditText)findViewById(R.id.radiusET);
    }// end of onCreate

    public void onReturn(View view)
    {
        // Get numbers from text fields.
        if (radius.getText().toString().matches("") || radius.getText().toString().matches("0"))
        {
            Toast.makeText(view.getContext(), "Please enter a number", Toast.LENGTH_LONG).show();
            return;
        }
        else {

            radiusNum = Double.parseDouble(radius.getText().toString());
            pi = 3.14159;
            result = pi * (Math.pow(radiusNum, 2));

            Intent results = getIntent();
            // Passing variable to second activity
            results.putExtra("Result", result);
            ((Activity) view.getContext()).setResult(RESULT_OK, results);
            finish();
            }
    }
}
