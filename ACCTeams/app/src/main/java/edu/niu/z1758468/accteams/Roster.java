//////////////////////////////////////////////////////////////////////////////////////////
// CSCI 322         Program: 2     Spring 2016
// Name: Abe Rodriguez
// Date Due: 3/4/2016
// Purpose: This application demonstrates the Intent and widget features. The app contains
//          a few Intent functions and widgets.
/////////////////////////////////////////////////////////////////////////////////////////

package edu.niu.z1758468.accteams;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class Roster extends Activity {


    private Button teamHistBtn;
    private TextView teamName, rosterList;
    //private ScrollView rosterinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);

        // Retreiving info passed from intent.
        Bundle extras = getIntent().getExtras();
        String school = extras.getString("school");
        Integer num = extras.getInt("position");

        // Connecting
        teamHistBtn = (Button)findViewById(R.id.returnBtn);
        teamName = (TextView)findViewById(R.id.teamName);
        //rosterinfo = (ScrollView)findViewById(R.id.rosterSV);
        rosterList = (TextView)findViewById(R.id.rosterList);
        teamName.setText(school);

        // sets team name and team history
        teamName.setText(school);
        rosterList.setText(TeamInfo.teamHistory[num]);

        // teamHistBtn button listener
        teamHistBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                    finish();   // returm to mainActivity
            }// End of inClick
        });// End of setOnClickListener
    }// End of onCreate




}
