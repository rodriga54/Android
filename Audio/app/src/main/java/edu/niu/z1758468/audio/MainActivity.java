package edu.niu.z1758468.audio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button drumsbtn, ukuleleBtn;
    private MediaPlayer drumsMP, ukuleleMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drumsbtn = (Button)findViewById(R.id.drumsBtn);
        ukuleleBtn = (Button)findViewById(R.id.ukuleleBtn);

        drumsMP = new MediaPlayer();
        drumsMP = MediaPlayer.create(this, R.raw.drums);

        ukuleleMP = new MediaPlayer();
        ukuleleMP = MediaPlayer.create(this, R.raw.ukulele);

    }// End of onCreate

    public void onDrums (View view)
    {
        // if drums mp3 are playing then pause and text should be changed.
        if (drumsMP.isPlaying())
        {
            drumsMP.pause();
            drumsbtn.setText("Playing Drums Song ");
        }
        // Drums are not playing.
        // if the Ukulele is playing , pause it and change the button for ukulele
        // start drums mp3
        // change text on drum button to pause.
        else
        {
            if (ukuleleMP.isPlaying())
            {
                ukuleleMP.pause();
                ukuleleBtn.setText ("Playing Ukulele Song");
            }
            drumsMP.start();
            drumsbtn.setText("Pause");
        }
    }// End of onDrums

    public void onUkulele (View view)
    {
        // if drums mp3 are playing then pause and text should be changed.
        if (ukuleleMP.isPlaying())
        {
            ukuleleMP.pause();
            ukuleleBtn.setText("Playing Drums Song ");
        }
        // Drums are not playing.
        // if the Ukulele is playing , pause it and change the button for ukulele
        // start drums mp3
        // change text on drum button to pause.
        else
        {
            if (drumsMP.isPlaying())
            {
                drumsMP.pause();
                drumsbtn.setText("Playing Ukulele Song");
            }
            ukuleleMP.start();
            ukuleleBtn.setText("Pause");
        }
    }// End of onUkulele
}
