package edu.niu.z1758468.database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    DBAdapter myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DBAdapter(this);
        myDB.open();
        myDB.createTable();

    }// End of onCreate

    @Override
    protected void onDestroy ()
    {
        super.onDestroy();
        myDB.close();

    }

    private void displayText (String message)
    {
        TextView dbContents = (TextView)findViewById(R.id.dbTV);
        dbContents.setText(message);
    }

    public void addData (View view)
    {
        long newID = myDB.insertRow("Abe", 322);
        displayText("Clicked add button - " + newID);
    }
    public void clearAll (View view)
    {
        displayText("Clicked clear button");
        myDB.deleteAllRow();
    }

    public void display (View view)
    {
        displayText("Clicked display button.");
        Cursor cursor = myDB.getAllRows();

        if (cursor.moveToFirst())
        {
            String message = "";
            boolean isData = cursor.moveToFirst();
            while (isData)
            {
                int id = cursor.getInt(DBAdapter.COL_ROWID),
                 studNum = cursor.getInt(DBAdapter.COL_STUDENTNUM);
               String name = cursor.getString(DBAdapter.COL_NAME);

                message += " ID: " + id + ", Name: " + name + ", Number: " + studNum + "\n";

                isData = cursor.moveToNext();

            }

            displayText(message);
        }
    }

}// end of MainActivity
