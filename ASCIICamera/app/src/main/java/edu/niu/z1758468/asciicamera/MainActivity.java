package edu.niu.z1758468.asciicamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{

    private static final int CAPTURECODE = 100;
    private Bitmap capturedPhoto;
    private TextView asciiImage;
    private Button asciiBtn, cameraBtn;
    private ProgressBar asciiPB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asciiImage = (TextView)findViewById(R.id.artTextView);
        // connect the conversion button and disable it
        asciiBtn = (Button)findViewById(R.id.asciiButton);
        asciiBtn.setEnabled(false);

        cameraBtn = (Button)findViewById(R.id.cameraButton);

        // COnnect on progressbar and hide it from view
        asciiPB = (ProgressBar)findViewById(R.id.asciiProgressBar);
        asciiPB.setAlpha(0);


    }// End of onCreate


    public void toCamera (View view)
    {
        asciiImage.setText("");

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAPTURECODE);
    }// End of toCamera

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView photoPre = (ImageView)findViewById(R.id.cameraImageView);

        if (requestCode == CAPTURECODE)
        {
            if (resultCode == RESULT_OK)
            {
                Bundle extras = data.getExtras();
                capturedPhoto = (Bitmap)extras.get("data");
                photoPre.setImageBitmap(capturedPhoto);
                asciiBtn.setEnabled(true);
            }
            else if (resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this, "Result Canceled", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this, "Image was not captured", Toast.LENGTH_LONG).show();
            }
        }
    }// End of onActivityResult

    public void toAscii (View view)
    {
        new PerformAsyncTask().execute();
    }// end of toAscii

    // inner AsyncTask Class
    private class PerformAsyncTask extends AsyncTask<Void, Void, Void>
    {
        String asciiArtWork;
        @Override
        protected Void doInBackground(Void... params)
        {
            int width = capturedPhoto.getWidth(),
                height = capturedPhoto.getHeight(),
                scaleWidth = 2,
                scaleHeight = 2;

            for (int y =0; y < height/scaleHeight; y++)
            {
                for(int x =0; x < width/scaleWidth; x++)
                {
                    int pixel = capturedPhoto.getPixel(x * scaleWidth, y * scaleHeight);

                    int redVal = Color.red(pixel),
                        greenVal = Color.green(pixel),
                        blueVal = Color.blue(pixel);

                    int grayVal = (redVal+greenVal+blueVal)/3;
                    if( grayVal < 35 )
                        asciiArtWork += "MM";
                    else if( grayVal <= 52 )
                        asciiArtWork += "$$";
                    else if( grayVal <= 69 )
                        asciiArtWork += "##";
                    else if( grayVal <= 86 )
                        asciiArtWork += "%%";
                    else if( grayVal <= 103 )
                        asciiArtWork += "**";
                    else if( grayVal <= 120 )
                        asciiArtWork += "++";
                    else if( grayVal <= 137 )
                        asciiArtWork += "vV";
                    else if( grayVal <= 154 )
                        asciiArtWork += "-;";
                    else if( grayVal <= 171 )
                        asciiArtWork += "--";
                    else if( grayVal <= 188 )
                        asciiArtWork += ";;";
                    else if( grayVal <= 205 )
                        asciiArtWork += "::";
                    else if( grayVal <= 222 )
                        asciiArtWork += "..";
                    else
                        asciiArtWork += "  ";

                }
                asciiArtWork += "\n";
            }
            return null;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            asciiBtn.setEnabled(false);
            cameraBtn.setEnabled(false);

            //ProgressBar set to visiable
            asciiPB.setAlpha(1);

            asciiArtWork = "\n";

        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            cameraBtn.setEnabled(true);
            asciiBtn.setEnabled(false);
            asciiPB.setAlpha(0);

            asciiImage.setText(asciiArtWork);

        }
    }// End of PerformAsyncTask



}// End of MainActivity
