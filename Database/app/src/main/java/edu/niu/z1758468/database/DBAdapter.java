package edu.niu.z1758468.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.CaptureResult;
import android.util.Log;

/**
 * Created by aberodriguez on 4/21/16.
 */
public class DBAdapter
{
    private static final String TAG = "DBAdater";

    private static final String KEY_ROWID  = "_id",
                                KEY_NAME = "name",
                                KEY_STUDENTNUM = "studentnum";

    private static final String [] ALL_KEYS = new String[] {KEY_ROWID, KEY_NAME, KEY_STUDENTNUM };

    public static final int COL_ROWID  = 0,
                            COL_NAME = 1,
                            COL_STUDENTNUM = 2;

    private static final String DATABASE_NAME = "MyDB",
                                DATABASE_TABLE = "mainTable";

    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_SQL = "CREATE TABLE " + DATABASE_TABLE
                                            + "(" + KEY_ROWID + " integer primary key autoincrement, "
                                            + KEY_NAME + " text not null, "
                                            + KEY_STUDENTNUM + " integer not null " + ");";

    private static final String DROP_SQL = "DROP TABLE " + DATABASE_TABLE + ";";

    private DBHelper myDBHelper;

    private SQLiteDatabase DB;


    public DBAdapter (Context context)
    {
        myDBHelper = new DBHelper(context);
    }// End of Constructor

    public DBAdapter open()
    {
    DB = myDBHelper.getWritableDatabase();
        return this;
    }//End of open

    public void close()
    {
        myDBHelper.close();
    }//End of Close

    public void dropTable (){ DB.execSQL(DROP_SQL);}
    public void createTable (){ DB.execSQL(CREATE_SQL);}

    public long insertRow (String name, int studNum)
    {
        ContentValues rowValues = new ContentValues();
        rowValues.put(KEY_NAME, name);
        rowValues.put(KEY_STUDENTNUM, studNum);

        return DB.insert(DATABASE_TABLE, null, rowValues);
    }// End of insertRow

    public boolean deleteRow (long rowID)
    {
        String where = KEY_ROWID + "=" + rowID;
        return DB.delete(DATABASE_TABLE, where, null) != 0;
    }// End of deleteRow

    public void deleteAllRow ()
    {
        Cursor cursor = getAllRows();
        long rowID = cursor.getColumnIndexOrThrow(KEY_ROWID);

        boolean result = cursor.moveToFirst();
        while (result)
        {
            deleteRow(cursor.getInt((int)rowID));
            result = cursor.moveToNext();
        }

    }// End of deleteAllRow

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

    public Cursor getRow (long rowID)
    {
        String where = KEY_ROWID + "=" + rowID;
        Cursor cursor = DB.query(true, DATABASE_TABLE, ALL_KEYS, where, null, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        return cursor;
    }// End of getRow

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


}// end of DBAdapter
