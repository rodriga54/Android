package edu.niu.z1758468.week5part3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetName extends AppCompatActivity {


    private Button returnBtn;
    private EditText nameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);

        returnBtn = (Button)findViewById(R.id.returnNameButton);
        nameET  = (EditText)findViewById(R.id.nameEditText);
    }// End of OnCreate

    public void returnName (View view)
    {
        String nameInput;
        nameInput = nameET.getText().toString();

        Intent intent;
        intent = getIntent();
        intent.putExtra("name", nameInput);

        ((Activity)view.getContext()).setResult(RESULT_OK, intent);

        finish();
    }// End of returnName
}// End of MainActivity
