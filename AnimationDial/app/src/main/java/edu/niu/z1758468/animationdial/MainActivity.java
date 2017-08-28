package edu.niu.z1758468.animationdial;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    private Thread animationThread;
    private DialView dialView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Create DialView
        dialView = new DialView(this);
        setContentView(dialView);

        animationThread = new Thread(runAnimation);

        animationThread.start();

    }// End of onCreate


    private Runnable runAnimation = new Runnable()
    {
    private static final int DELAY = 200;
        @Override
        public void run()
        {
            while(true)
            {
                try
                {
                    Thread.sleep(DELAY);
                    threadHandler.sendEmptyMessage(0);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }// End of while
        }// End of run
    };// End of runAnimation Runnable

    private Handler threadHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            dialView.update();
        }
    };

    @Override
    protected void onPause()
    {
        super.onPause();
        threadHandler.removeCallbacks(runAnimation);
    }



}// End of MainActivity
