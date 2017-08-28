package edu.niu.z1758468.week5app;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private LinearLayout gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery = (LinearLayout)findViewById(R.id.images);

        fillGallery ();

    }//end of onCreate

    private void fillGallery ()
    {
        ImageButton imgButton;

        for (int cnt = 0; cnt< CharacterInfo.description.length; cnt++)
        {
            imgButton= new ImageButton(this);
            Characters character = new Characters(CharacterInfo.description[cnt], CharacterInfo.id[cnt]);
            imgButton.setContentDescription(character.getCharacterDescrip());

            imgButton.setImageDrawable(ResourcesCompat.getDrawable(getResources(), character.getCharacterId(), null));

            imgButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String description = (String)v.getContentDescription();
                    Toast.makeText(v.getContext(), description, Toast.LENGTH_LONG).show();
                }
            });

            gallery.addView(imgButton);

        }// End of for loop

    }// End of fillGallery


}// end of MainActivity
