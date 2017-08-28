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
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

/**
 * Created by aberodriguez on 5/1/16.
 */
public class TaskItems
{
    private static final String TAG = "DBAdapter";
    public static final String KEY_ID = "_id",
                                KEY_TASK = "Task";
    public static final String [] ALL_KEYS = new String[] {KEY_ID, KEY_TASK};

    public static final int COL_ID  = 0,
                            COL_TASK = 1;

    public static final String DATABASE_NAME = "listDB",
                                DATABASE_TABLE = "taskTable";

    public static final int DATABASE_VERSION = 1;

    private static final String CREATE_SQL = "CREATE TABLE " + DATABASE_TABLE
                                            + "(" + KEY_ID + " integer primary key autoincrement, "
                                            + KEY_TASK + " text not null);";

    private static final String DROP_SQL = "DROP TABLE " + DATABASE_TABLE + ";";



    private DBHelper myDBHelper;

    private SQLiteDatabase DB;

    public TaskItems (Context context)
    {
        myDBHelper = new DBHelper(context);
    }// End of Constructor

    public TaskItems open()
    {
        DB = myDBHelper.getWritableDatabase();
        return this;
    }//End of open

    public void close()
    {
        myDBHelper.close();
    }//End of close

    public void dropTable (){ DB.execSQL(DROP_SQL);}// Drop Table
    public void createTable (){ DB.execSQL(CREATE_SQL);}// Create Table

    //////////////////////////////////////////////////////////////////
    //Function:  insertRow (String task)
    //Arguement: Takes a String as arguement.
    //Returns:   Long
    //Purpuse:	 Method is called when the user wants to add a task to
    //			 the database.
    ///////////////////////////////////////////////////////////////////
    public long insertRow (String task)
    {
        ContentValues rowValues = new ContentValues();
        rowValues.put(KEY_TASK, task);

        return DB.insert(DATABASE_TABLE, null, rowValues);
    }// End of insertRow

    public boolean deleteRow (long rowID)
    {
        String where = KEY_ID + "=" + rowID;
        return DB.delete(DATABASE_TABLE, where, null) != 0;
    }// End of deleteRow

    //////////////////////////////////////////////////////////////////
    //Function:  getAllRows()
    //Arguement: Takes No arguement.
    //Returns:   Cursor
    //Purpuse:	 Method is called when all rows in table are returned.
    ///////////////////////////////////////////////////////////////////
    public Cursor getAllRows()
    {
        String where = null;
        Cursor cursor = DB.query(true, DATABASE_TABLE, ALL_KEYS, where, null, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        return cursor;
    }// end of getAllRows

    //////////////////////////////////////////////////////////////////
    //Function:  DBHelper class
    //Arguement: N/A
    //Returns:   N/A
    //Purpuse:	 Class is the database helper.
    ///////////////////////////////////////////////////////////////////
    private static class DBHelper extends SQLiteOpenHelper
    {

        public DBHelper (Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Database is beign upgraded" + oldVersion + "to" + newVersion + ", which will destroy the old data!");
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }// End of DBHelper
}// end of TaskItme class
