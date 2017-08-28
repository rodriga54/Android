package edu.niu.z1758468.exam1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Ellipse extends AppCompatActivity {

    private EditText minor, major;
    double min, maj, pi, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellipse);

        minor = (EditText)findViewById(R.id.minorET);
        major = (EditText)findViewById(R.id.majorET);

    }// End of onCreate

    public void onReturn(View view)
    {
        // Get numbers from text fields.
        if (minor.getText().toString().matches("") || major.getText().toString().matches(""))
        {
            Toast.makeText(view.getContext(), "Please enter a number", Toast.LENGTH_LONG).show();
            return;
        }
        else {

            min = Double.parseDouble(minor.getText().toString());
            maj = Double.parseDouble(major.getText().toString());
            pi = 3.14159;
            result = pi * min * maj;

            Intent results = getIntent();
            // Passing variable to second activity
            results.putExtra("Result", result);
            ((Activity) view.getContext()).setResult(RESULT_OK, results);
            finish();
        }
    }
}
