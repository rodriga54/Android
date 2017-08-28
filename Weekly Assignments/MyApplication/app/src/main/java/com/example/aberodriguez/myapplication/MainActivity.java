package com.example.aberodriguez.myapplication;

import android.app.Activity;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    // instance variables
    private TextView hello;

    private boolean isHello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Connect TextView from the screen with JAVA textView
        hello = (TextView)findViewById(R.id.messageTextView);

        //
        isHello = true;

        // Create button object and connect to the screen button.
        Button changerbtn = (Button)findViewById(R.id.Toggle);

        // set an anonymous onclickListner
        changerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // toggle between the two messages.
                if(isHello)
                {
                    hello.setText(R.string.goodbyeString);
                    isHello = false;
                }
                else
                {
                    hello.setText(R.string.helloString);
                    isHello = true;

                }
            }
        });


    }
}
