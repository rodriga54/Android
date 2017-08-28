package edu.niu.z1758468.assign0;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    // instance variables
    private TextView messageTV;

    private boolean isHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect TextView from the screen with JAVA textView
        messageTV = (TextView)findViewById(R.id.messagTextView);

        // Set instance to True
        isHello = true;

        // Create button object and connect to the screen button.
        Button changerbtn = (Button)findViewById(R.id.switchButton);

        // set an anonymous onclickListner
        changerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // toggle between the two messages.
                if (isHello) {
                    messageTV.setText(R.string.goodbyeString);
                    isHello = false;
                } else {
                    messageTV.setText(R.string.helloString);
                    isHello = true;
                }
            }
        });
    }
}

