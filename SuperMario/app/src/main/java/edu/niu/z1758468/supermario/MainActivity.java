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

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static edu.niu.z1758468.supermario.R.id.bulletBtn;
import static edu.niu.z1758468.supermario.R.id.cancel_action;
import static edu.niu.z1758468.supermario.R.id.coinBtn;
import static edu.niu.z1758468.supermario.R.id.fireballBtn;
import static edu.niu.z1758468.supermario.R.id.oneupBtn;
import static edu.niu.z1758468.supermario.R.id.powerupBtn;
import static edu.niu.z1758468.supermario.R.id.starBtn;

public class MainActivity extends AppCompatActivity {
    // Declaring initial variables.
    private Button oneup, powerup, fireball, coin,
            bullet, star ;
    private MediaPlayer oneupMP, powerupMP, fireballMP, coinMP,
            bulletMP, starMP, pauseMP, playerMP;
    private View mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting buttons to the view
        oneup = (Button) findViewById(oneupBtn);
        powerup = (Button) findViewById(R.id.powerupBtn);
        star = (Button) findViewById(R.id.starBtn);
        fireball = (Button) findViewById(R.id.fireballBtn);
        coin = (Button) findViewById(R.id.coinBtn);
        bullet = (Button) findViewById(R.id.bulletBtn);

        // Creating a new instance of MediaPlayer per sound/button
        oneupMP = new MediaPlayer();
        oneupMP = MediaPlayer.create(this, R.raw.oneup);
        powerupMP = new MediaPlayer();
        powerupMP = MediaPlayer.create(this, R.raw.powerup);
        starMP = new MediaPlayer();
        starMP = MediaPlayer.create(this, R.raw.star);
        fireballMP = new MediaPlayer();
        fireballMP = MediaPlayer.create(this, R.raw.fireball);
        coinMP = new MediaPlayer();
        coinMP = MediaPlayer.create(this, R.raw.coin);
        bulletMP = new MediaPlayer();
        bulletMP = MediaPlayer.create(this, R.raw.bullet);
        pauseMP = new MediaPlayer();
        pauseMP = MediaPlayer.create(this, R.raw.pause);

        //set the onClickListener for the oneup
        oneup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if Mediaplayer is playing
                // Then call stopPlaying()
                if (oneupMP.isPlaying()) {
                    oneupMP.pause();
                    pauseMP.start();
                    stopPlaying(v);
                }
                // Start MediaPlayer and reset the rest of the MediaPlayers.
                // Call the reconnect function.
                else {
                    oneupMP.start();
                    powerupMP.reset();
                    starMP.reset();
                    fireballMP.reset();
                    coinMP.reset();
                    bulletMP.reset();
                    reconnect(v);
                }
            }
        });

        //set the onClickListener for the powerup
        powerup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if Mediaplayer is playing 
                // Then call stopPlaying()
                if (powerupMP.isPlaying()) {
                    powerupMP.pause();
                    pauseMP.start();
                    stopPlaying(v);
                }
                // Start MediaPlayer and reset the rest of the MediaPlayers.
                // Call the reconnect function.
                else {
                    powerupMP.start();
                    starMP.reset();
                    oneupMP.reset();
                    fireballMP.reset();
                    coinMP.reset();
                    bulletMP.reset();
                    reconnect(v);
                }
            }
        });
        //set the onClickListener for the star
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if Mediaplayer is playing
                // Then call stopPlaying()
                if (starMP.isPlaying()) {
                    pauseMP.start();
                    starMP.pause();
                    stopPlaying(v);
                }
                // Start MediaPlayer and reset the rest of the MediaPlayers.
                // Call the reconnect function.
                else {
                    starMP.start();
                    powerupMP.reset();
                    oneupMP.reset();
                    fireballMP.reset();
                    coinMP.reset();
                    bulletMP.reset();
                    reconnect(v);
                }
            }
        });

        // set on onclick listener for the fireball
        fireball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if Mediaplayer is playing
                // Then call stopPlaying()
                if (fireballMP.isPlaying()) {
                    fireballMP.pause();
                    pauseMP.start();
                    stopPlaying(v);
                }
                // Start MediaPlayer and reset the rest of the MediaPlayers.
                // Call the reconnect function.
                else {
                    fireballMP.start();
                    powerupMP.reset();
                    oneupMP.reset();
                    starMP.reset();
                    coinMP.reset();
                    bulletMP.reset();
                    reconnect(v);
                }
            }
        });

        //set the onclicklistener for the coin
        coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if Mediaplayer is playing
                // Then call stopPlaying()
                if (coinMP.isPlaying()) {
                    coinMP.pause();
                    pauseMP.start();
                    stopPlaying(v);
                }
                // Start MediaPlayer and reset the rest of the MediaPlayers.
                // Call the reconnect function.
                else {
                    coinMP.start();
                    powerupMP.reset();
                    oneupMP.reset();
                    fireballMP.reset();
                    starMP.reset();
                    bulletMP.reset();
                    reconnect(v);
                }
            }
        });

        //set the onClickListener for the bullet
        bullet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if Mediaplayer is playing
                // Then call stopPlaying()
                if (bulletMP.isPlaying()) {
                    bulletMP.pause();
                    pauseMP.start();
                    stopPlaying(v);
                }
                // Start MediaPlayer and reset the rest of the MediaPlayers.
                // Call the reconnect function.
                else {
                    bulletMP.start();
                    powerupMP.reset();
                    oneupMP.reset();
                    fireballMP.reset();
                    coinMP.reset();
                    starMP.reset();
                    reconnect(v);
                }
            }
        });
    }

        //////////////////////////////////////////////////////////////////
        //Function:  stopPlaying (View playerMP)
        //Arguement: Takes 1 View as arguement.
        //Returns:   None
        //Purpuse:	 if playerMP is not Null then pause audio.
        //			 It calls the reconnect() to create instance of MediaPlayer.
        ///////////////////////////////////////////////////////////////////
    public void stopPlaying (View playerMP)
    {
        // if not Null then pause sound passed to function.
        if (playerMP != null) {
            pauseMP.start();
        }
        reconnect(playerMP);
    }
    /////////////////////////////////////////////////////////////////
    //Function:  reconnect (View view)
    //Arguement: Takes 1 View as arguement.
    //Returns:   None
    //Purpuse:	 recreates new instances of the MediaPlayer
    /////////////////////////////////////////////////////////////////
    public void reconnect(View view)
    {
        switch (view.getId())
        {
            case oneupBtn:
                powerupMP = new MediaPlayer();
                powerupMP = MediaPlayer.create(this, R.raw.powerup);
                starMP = new MediaPlayer();
                starMP = MediaPlayer.create(this, R.raw.star);
                fireballMP = new MediaPlayer();
                fireballMP = MediaPlayer.create(this, R.raw.fireball);
                coinMP = new MediaPlayer();
                coinMP = MediaPlayer.create(this, R.raw.coin);
                bulletMP = new MediaPlayer();
                bulletMP = MediaPlayer.create(this, R.raw.bullet);
                break;

            case powerupBtn:
                oneupMP = new MediaPlayer();
                oneupMP = MediaPlayer.create(this, R.raw.oneup);
                starMP = new MediaPlayer();
                starMP = MediaPlayer.create(this, R.raw.star);
                fireballMP = new MediaPlayer();
                fireballMP = MediaPlayer.create(this, R.raw.fireball);
                coinMP = new MediaPlayer();
                coinMP = MediaPlayer.create(this, R.raw.coin);
                bulletMP = new MediaPlayer();
                bulletMP = MediaPlayer.create(this, R.raw.bullet);
                break;

            case starBtn:
                oneupMP = new MediaPlayer();
                oneupMP = MediaPlayer.create(this, R.raw.oneup);
                powerupMP = new MediaPlayer();
                powerupMP = MediaPlayer.create(this, R.raw.powerup);
                fireballMP = new MediaPlayer();
                fireballMP = MediaPlayer.create(this, R.raw.fireball);
                coinMP = new MediaPlayer();
                coinMP = MediaPlayer.create(this, R.raw.coin);
                bulletMP = new MediaPlayer();
                bulletMP = MediaPlayer.create(this, R.raw.bullet);
                break;

            case fireballBtn:
                oneupMP = new MediaPlayer();
                oneupMP = MediaPlayer.create(this, R.raw.oneup);
                starMP = new MediaPlayer();
                starMP = MediaPlayer.create(this, R.raw.star);
                powerupMP = new MediaPlayer();
                powerupMP = MediaPlayer.create(this, R.raw.powerup);
                coinMP = new MediaPlayer();
                coinMP = MediaPlayer.create(this, R.raw.coin);
                bulletMP = new MediaPlayer();
                bulletMP = MediaPlayer.create(this, R.raw.bullet);
                break;

            case coinBtn:
                oneupMP = new MediaPlayer();
                oneupMP = MediaPlayer.create(this, R.raw.oneup);
                starMP = new MediaPlayer();
                starMP = MediaPlayer.create(this, R.raw.star);
                fireballMP = new MediaPlayer();
                fireballMP = MediaPlayer.create(this, R.raw.fireball);
                powerupMP = new MediaPlayer();
                powerupMP = MediaPlayer.create(this, R.raw.powerup);
                bulletMP = new MediaPlayer();
                bulletMP = MediaPlayer.create(this, R.raw.bullet);
                break;

            case bulletBtn:
                oneupMP = new MediaPlayer();
                oneupMP = MediaPlayer.create(this, R.raw.oneup);
                powerupMP = new MediaPlayer();
                powerupMP = MediaPlayer.create(this, R.raw.powerup);
                starMP = new MediaPlayer();
                starMP = MediaPlayer.create(this, R.raw.star);
                fireballMP = new MediaPlayer();
                fireballMP = MediaPlayer.create(this, R.raw.fireball);
                coinMP = new MediaPlayer();
                coinMP = MediaPlayer.create(this, R.raw.coin);
                break;
        }// End of Switch
    }// End of reconnect()
}// End of Main
