package edu.niu.z1758468.shippingcalculatorweek3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity
{


    // Data Members
    private ShipItem itemShipped;
    private EditText weightET;
    private TextView baseCostTv, addedCostTV, totalCostTV;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the shipping object
        itemShipped = new ShipItem();

        // connect the object to app view.
        weightET = (EditText)findViewById(R.id.weightET);
        baseCostTv = (TextView)findViewById(R.id.baseCostTV);
        addedCostTV = (TextView)findViewById(R.id.AddCostTV);
        totalCostTV = (TextView)findViewById(R.id.totalTV);
    }




    weightET.add
    //private TextWatcher weightTextWatcher =  new TextWatcher ()



}
