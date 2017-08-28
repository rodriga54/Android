//////////////////////////////////////////////////////////////////////////////////////////
// CSCI 322         Program: 2     Spring 2016
// Name: Abe Rodriguez
// Date Due: 3/4/2016
// Purpose: This application demonstrates the Intent and widget features. Button in MainActivity
//          uses the Intent class to navigate from one activity to another.
/////////////////////////////////////////////////////////////////////////////////////////

package edu.niu.z1758468.accteams;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private ImageView teamLogo;
    private Spinner teamSpin;
    private Button rosterbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamLogo = (ImageView)findViewById(R.id.logoImageView);
        teamSpin = (Spinner)findViewById(R.id.teamSpinner);
        rosterbtn = (Button)findViewById(R.id.rosterBtn);

        // Spinner click listener set the team logo selected.
        teamSpin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        teamLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {}});

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("North Carolina");
        categories.add("Duke");
        categories.add("Clemson");
        categories.add("Miami");
        categories.add("Norte Dame");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // attaching data adapter to spinner
        teamSpin.setAdapter(dataAdapter);
    }// End of OnCreate

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // set image resource
        teamLogo.setImageResource(TeamInfo.id[position]);

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    // OnClick goRoster() use to start the intent
    public void goRoster (View view)
    {
        // set variables with content
        String name = teamSpin.getSelectedItem().toString();
        Integer num = teamSpin.getSelectedItemPosition();

        Intent school = new Intent(MainActivity.this, Roster.class);

        // Passing variable to second activity
        school.putExtra("school", name);
        school.putExtra("position", num);

        startActivity(school); // Starting Intent activity
    }
}
