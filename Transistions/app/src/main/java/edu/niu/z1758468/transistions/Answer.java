package edu.niu.z1758468.transistions;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Answer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Button questionBtn = (Button)findViewById(R.id.imageButton2);

        questionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //overridePendingTransition(R.anim.question_on, R.anim.answer_off);

            }
        });

    }// End of onCreate

}
