//////////////////////////////////////////////////////////////////////////////////////////
// CSCI 322         Program: 4     Spring 2016
// Name: Abe Rodriguez
// Date Due: 5/5/2016
// Purpose: This application demonstrates a standard task checklist that when a task is
//          checked the task in now completed. When the user completes the tasks, then
//          the user may delete all the tasks store to the database.
//////////////////////////////////////////////////////////////////////////////////////////

package edu.niu.z1758468.tasklist;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import static edu.niu.z1758468.tasklist.TaskItems.*;

public class MainActivity extends AppCompatActivity {

    TaskItems DB;
    ListView listView;
    EditText taskET;
    CheckBox taskCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskET = (EditText) findViewById(R.id.taskET);
        taskCB = (CheckBox)findViewById(R.id.taskCB);

        DB = new TaskItems(this);
        DB.open();
        populateListView();
    }// End of onCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DB.close();
    }

    //////////////////////////////////////////////////////////////////
    //Function:  addTask(View view)
    //Arguement: Takes 1 View as arguement.
    //Returns:   None
    //Purpuse:	 When the user clicks the add button it then adds a task to.
    //			 database and then displays it in a listView.
    ///////////////////////////////////////////////////////////////////
    public void addTask(View view) {

        if (!TextUtils.isEmpty(taskET.getText().toString()))
        {
            DB.insertRow(taskET.getText().toString());
        }
        populateListView();
    }// End of addTasks

    //////////////////////////////////////////////////////////////////
    //Function:  deleteAllTasks(View view)
    //Arguement: Takes 1 View as arguement.
    //Returns:   None
    //Purpuse:	 When the user clicks the delete button it then prompts
    //			 user to confirm all tasks will be deleted.
    ///////////////////////////////////////////////////////////////////
    public void deleteAllTasks(View view)
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

        // Setting Dialog Title
        alertDialog.setTitle("Confirm Delete...");

        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want delete this?");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.ic_warning_24dp);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                DB.dropTable(); // Drops the table all data will be deleted.
                DB.createTable(); // Recreates the table.

                // Write your code here to invoke YES event
                Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                populateListView();
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event
                Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();

    }// End of deletAllTasks

    //////////////////////////////////////////////////////////////////
    //Function:  populateListView()
    //Arguement: Takes no arguement.
    //Returns:   None
    //Purpuse:	 gets all rows of data that is stored in the database
    //			 and then displays them in a lostview.
    ///////////////////////////////////////////////////////////////////
    private void populateListView() {

        Cursor cursor = DB.getAllRows();
        //TextView task = (TextView) findViewById(R.id.taskTV);

        String[] fromFile = new String[]{ TaskItems.KEY_TASK};
        int[] toViewIDs = new int[] {R.id.taskTV};

        startManagingCursor(cursor);
       // SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(this, R.layout.itemtask, cursor, fromFile, toViewIDs);
        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.itemtask, cursor, fromFile, toViewIDs,0);

        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(myCursorAdapter);
    }

//    public void clearAll(View view) {
//        displayText("Clicked clear button");
//        DB.deleteAllRow();
//    }

//    private class ViewHolder {
//        TextView taskTV;
//        CheckBox name;
//    }

//
//    private class MyAdapter extends ArrayAdapter<TaskItems> {
//        Context context;
//        List<TaskItems> taskList = new ArrayList<TaskItems>();
////
////        //Constructor
////        //
////        //c is the current context
////        //resourceId is the resource ID for a layout file to use when instantiating views
////        //objects are the objects to represent in the ListView
////
//        public MyAdapter(Context c, int resourceId, List<TaskItems> objects) {
//            super(c, resourceId, objects);
//            //taskList = objects;
//            //context = c;
//        }//end constructor


//        //getView
//        //Get a View that displays the data at a specified position in the data set
//        //
//        //position is the position of the item within the adapter's data set
//        //convertView is the old view
//        //parent is the parent that the view will be attached to
////
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            CheckBox isDoneCB = null;
//
//            ViewHolder holder;
//
//            if (convertView == null) {
//                //Get a layout inflater so that the layout can be inflated in the ListView
//                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
//
//                //Use the custom layout for a task item for each task item in the ListView
//                convertView = inflater.inflate(R.layout.itemtask, parent, false);
//
//                holder = new ViewHolder();
//                holder.taskTV = (TextView) convertView.findViewById(R.id.taskTV);
//                convertView.setTag(holder);
//
//                //Connect to the checkbox on the custom layout
//                isDoneCB = (CheckBox) convertView.findViewById(R.id.taskCB);
//                isDoneCB.setText(taskET.getText());
//                //Store the checkbox state with the view
//                convertView.setTag(isDoneCB);
//
//                //Listen for changes to the checkbox
//                isDoneCB.setOnClickListener(new View.OnClickListener() {
//                    //When the checkbox is clicked
//                    @Override
//                    public void onClick(View v) {
//                        //Create a named checkbox from the clicked checkbox
//                        CheckBox checkBox = (CheckBox) v;
//
//                        //Get the item that was selected
//                        TaskItems changeItem = (TaskItems) checkBox.getTag();
//
//                        //Set the is_done property for the specific grocery item
//                        //A checked box indicates the grocery item has been purchased
//                        if (checkBox.isChecked()) {
//                            changeItem.set_isDone(1);
//                            changeItem.getAllRows();
//                            checkBox.setText(taskET.getText());
//                        } else {
//                            changeItem.set_isDone(0);
//                        }
//
//                        //Update the specific item in the database
//                        DB.updateItem(changeItem);
//                        //DB.getRow();
//                    }
//                });//end of onClickListener for checkbox
//            } else {
//                isDoneCB = (CheckBox) convertView.getTag();
//            }
//
//            //Get the item that was selected from the ListView
//            TaskItems current = taskList.get(position);
//
//            //Set the information for the checkbox from the grocery item in the ListView
//            isDoneCB.setText(current.getDescription());
//            isDoneCB.setChecked(current.get_isDone() == 1 ? true : false);
//            isDoneCB.setTag(current);
//
//            //Return the item
//            return convertView;
//        }//end of getView
//
//
//    }//end MyAdapter


}// End of MainActivity
