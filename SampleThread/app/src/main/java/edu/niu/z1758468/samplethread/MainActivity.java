package edu.niu.z1758468.samplethread;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import android.os.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private TextView counterTV;
    private Integer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = 0;
        // Setting up the connection to the View Controller.
        counterTV = (TextView)findViewById(R.id.counterTV);

        Thread thread =new Thread(countRunUp);
        thread.start();
    }// End of onCreate

    @Override
    protected void onStart() {
        super.onStart();
        counter = 0;
    }// End of onStart

    private Runnable countRunUp = new Runnable() {
        @Override
        public void run() {
            while(true)
            {
                counter ++;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadHandle.sendEmptyMessage(0);
            }
        }
    };// End of countRunUp

    public Handler threadHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            counterTV.setText(counter.toString());
        }
    };


}// End of MainActivity
