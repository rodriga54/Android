package edu.niu.z1758468.week5app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private String createMessage, startMessage, resumeMessage,
                   pauseMessage, stopMessage, restartMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // making the connection to the view
        createMessage = (String)getResources().getText(R.string.createMsg);
        startMessage = (String)getResources().getText(R.string.startMsg);
        resumeMessage = (String)getResources().getText(R.string.resumeMsg);
        pauseMessage = (String)getResources().getText(R.string.pauseMsg);
        stopMessage = (String)getResources().getText(R.string.stopMsg);
        restartMessage = (String)getResources().getText(R.string.restartMsg);

        Toast.makeText(this, createMessage, Toast.LENGTH_LONG).show();
        Log.d("MainActivity", createMessage);
    }// End of onCreate

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, startMessage, Toast.LENGTH_LONG).show();
        Log.d("MainActivity", startMessage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, resumeMessage, Toast.LENGTH_LONG).show();
        Log.d("MainActivity", resumeMessage);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, pauseMessage, Toast.LENGTH_LONG).show();
        Log.d("MainActivity", pauseMessage);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, stopMessage, Toast.LENGTH_LONG).show();
        Log.d("MainActivity", stopMessage);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, restartMessage, Toast.LENGTH_LONG).show();
        Log.d("MainActivity", restartMessage);
    }
}
