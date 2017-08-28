package edu.niu.z1758468.jsonexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private List<State> stateList = new ArrayList<>();
    private StateArrayAdapter stateArrayAdapter;
    private ListView stateListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stateListView = (ListView)findViewById(R.id.stateListView);
        stateArrayAdapter = new StateArrayAdapter(this, stateList);
        stateListView .setAdapter(stateArrayAdapter);
    }// End of onCreate

    // Handle the button clicked
    public void getData(View view)
    {
        String urlString = getString(R.string.web_url);

        try
        {
            URL url = new URL(urlString);
            StateTask stateTask = new StateTask ();
            stateTask.execute(url);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }// End of getData

    // inner AsyncTask Class
    private class StateTask extends AsyncTask<URL, String, JSONObject>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject)
        {
            super.onPostExecute(jsonObject);
            convertJSONtoArrayList(jsonObject);
            stateArrayAdapter.notifyDataSetChanged();
            stateListView.smoothScrollToPosition(0);
        }

        @Override
        protected void onProgressUpdate(String... values)
        {
            Toast.makeText(MainActivity.this, values[0], Toast.LENGTH_LONG).show();
        }

        @Override
        protected JSONObject doInBackground(URL... params)
        {
            HttpURLConnection connection = null;
            try
            {
                connection = (HttpURLConnection)params[0].openConnection();
                int response = connection.getResponseCode();

                if (response == HttpURLConnection.HTTP_OK)
                {
                    StringBuilder builder = new StringBuilder();
                    try
                    {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String line;
                        while ((line = reader.readLine()) != null)
                        {
                         builder.append(line);
                        }
                    }
                    catch (IOException e)
                    {
                        publishProgress("Read Error");
                        e.printStackTrace();
                    }
                    return new JSONObject(builder.toString());
                }// end of if
                else
                {
                    publishProgress("Connection Error");
                }
            }// end of outer try
            catch (Exception e)
            {
                publishProgress("Connection Error 2nd catch block");
                e.printStackTrace();
            }
            finally
            {
             connection.disconnect();
            }
            return null;
        }// End of doInBackground
    }

    private void convertJSONtoArrayList (JSONObject states)
    {
        stateList.clear();

        try
        {
            JSONArray list = states.getJSONArray("places");

            for (int i = 0; i< list.length(); i++)
            {
                JSONObject stateObj = list.getJSONObject(i);

                stateList.add(new State(stateObj.getString("Place"), states.getInt("Number")));

            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }// End of convertJSONtoArrayList

}// End of MainActivity
