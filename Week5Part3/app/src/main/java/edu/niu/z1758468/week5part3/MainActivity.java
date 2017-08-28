package edu.niu.z1758468.week5part3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button nameBtn;
    private TextView nameTV;
    static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameBtn = (Button)findViewById(R.id.getNameBtn);
        nameTV = (TextView)findViewById(R.id.nameView);

    }// End of OnCreate

    public void getName ()
    {
        Intent nameIntent = new Intent(MainActivity.this, GetName.class);

        startActivityForResult(nameIntent, REQUEST_CODE);
    }// End of getName

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String returnName;
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            returnName = data.getStringExtra("name");
            nameTV.setText("Hello " + returnName);
        }// End of if statement
    }
}// End of MainActivity
