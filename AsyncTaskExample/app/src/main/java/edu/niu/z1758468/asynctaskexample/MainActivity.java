package edu.niu.z1758468.asynctaskexample;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    // Variables
    private Button downloadBtn;
    private ProgressBar progressBar;
    private TextView downloadProgressTV, callBackTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create
        downloadBtn = (Button)findViewById(R.id.downloadButton);
        progressBar = (ProgressBar)findViewById(R.id.downloadProgressBar);
        downloadProgressTV = (TextView)findViewById(R.id.downloadPercentTextView);
        callBackTV = (TextView)findViewById(R.id.callbackTextView);
    }// End of onCreate

    public void clearDisplay(View view)
    {
        callBackTV.setText(" ");;
    }// End of clearDisplay

    public void startDownload (View view)
    {
        downloadBtn.setEnabled(false);
        new PerformAsyncTask().execute();
    }// End of startDownload

    //inner asynce task class
    private class PerformAsyncTask extends AsyncTask<Void, Integer, Void>
    {
        int progressStatus;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

            callBackTV.setText(callBackTV.getText() + "\n Invoke on PreExecute");
            progressStatus = 0;

            downloadProgressTV.setText("Downloading 0%");

            callBackTV.setText(callBackTV.getText()+ " \n Completed the onPreExecute");
            callBackTV.setText(callBackTV.getText()+ " \n Invoke doInBackground");
            callBackTV.setText(callBackTV.getText()+ " \n Performing Background Work...");
        }// End of onPReExecute

        @Override
        protected Void doInBackground(Void... params)
        {
            while(progressStatus < 100)
            {
                progressStatus += 2;
                publishProgress(progressStatus);
                SystemClock.sleep(300);
            }
            return null;
        }// End if doInBackground

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            downloadProgressTV.setText("Downloading..." + values[0] + "%");
        }// End of onProgressUpdate

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);

            callBackTV.setText(callBackTV.getText()+ "\n Completed Backgroud Work");
            callBackTV.setText(callBackTV.getText()+ "\n onPostExecute Invoked");
            downloadProgressTV.setText("Download Complete");
            downloadBtn.setEnabled(true);
        }// End of onPostExecute
    }// End of PerformAsyncTask class
}// End of MainActivity
