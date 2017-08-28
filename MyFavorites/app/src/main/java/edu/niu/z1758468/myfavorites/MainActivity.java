package edu.niu.z1758468.myfavorites;

import android.app.Activity;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity
{

    private LinearLayout teamLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamLogo = (LinearLayout)findViewById(R.id.images);

        fillTeam();
    }// End of OnCreate

    private void fillTeam ()
    {
        ImageButton imgButton;

        for (int cnt = 0; cnt< TeamInfo.description.length; cnt++)
        {
            imgButton= new ImageButton(this);
            Teams character = new Teams(TeamInfo.description[cnt], TeamInfo.id[cnt]);
            imgButton.setContentDescription(character.getTeamDescrip());

            imgButton.setImageDrawable(ResourcesCompat.getDrawable(getResources(), character.getTeamId(), null));

            imgButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String description = (String)v.getContentDescription();
                    Toast.makeText(v.getContext(), description, Toast.LENGTH_LONG).show();
                }
            });

            teamLogo.addView(imgButton);

        }// End of for loop

    }// End of fillGallery

}// End of MainActivity
