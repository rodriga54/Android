//////////////////////////////////////////////////////////////////////////////////////////
// CSCI 322         Program: 3     Spring 2016
// Name: Abe Rodriguez
// Date Due: 4/1/2016
// Purpose: This application demonstrates a SplashActivity to run before the MainActivity
// 			and in the MainActivity will show 6 button images that will play a specific
//          sound associated with the button image. Button selected will play sound and if
//   		button is selected again and sound is still playing then it will pause sound and
//			if selected once more it will resume where it left off. If another button was
//			selected while current one is playing it will stop and reset the one that is
//			currently playing and start the one that was selected.
/////////////////////////////////////////////////////////////////////////////////////////
package edu.niu.z1758468.supermario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashMario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_mario);

        // Create a task
        // create and start an intent
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashMario.this, MainActivity.class));
            }
        };// End of TimerTask

        // create a timer and set the timer to 5000
        Timer timer = new Timer();
        timer.schedule(task, 5000);
    }
}
