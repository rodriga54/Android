package edu.niu.z1758468.exam1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Triangle extends Activity {

private EditText base, height;
    double result, baseNum, heightNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        base = (EditText)findViewById(R.id.baseET);
        height = (EditText)findViewById(R.id.heightET);

    }

    public void onReturn(View view)
    {
        // Get numbers from text fields.
        if (base.getText().toString().matches("") || height.getText().toString().matches(""))
        {
            Toast.makeText(view.getContext(), "Please enter a number", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            baseNum = Double.parseDouble(base.getText().toString());
            heightNum = Double.parseDouble(height.getText().toString());
            result = (.50 * baseNum) * heightNum;

            Intent results = getIntent();
            // Passing variable to second activity
            results.putExtra("Result", result);
            ((Activity) view.getContext()).setResult(RESULT_OK, results);
            finish();
        }

    }
}
