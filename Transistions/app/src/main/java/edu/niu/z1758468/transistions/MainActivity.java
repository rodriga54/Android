package edu.niu.z1758468.transistions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton answerBtn = (ImageButton)findViewById(R.id.imageButton2);

        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showAnswer = new Intent(MainActivity.this, Answer.class);
                startActivity(showAnswer);
                overridePendingTransition(R.anim.answer_on, R.anim.question_off);
            }
        });

    }//end of onCreate


}
