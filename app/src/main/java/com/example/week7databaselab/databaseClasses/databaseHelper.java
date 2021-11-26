package com.example.week7databaselab.databaseClasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseHelper extends SQLiteOpenHelper
{

    // These are the names of the columns the table will contain. Could make these private
    // and use getters so that other classes can access them, but, as they are "final", this removes
    // the security risk that encapsulation (privacy/ getters/ setters) protects against

    public static final String KEY_ROWID = "_id";
    public static final String KEY_FIRSTNAME = "first_name";
    public static final String KEY_SURNAME = "surname";
    public static final String KEY_CITY = "city";

    public static final String DATABASE_NAME = "Contacts";
    public static final String DATABASE_TABLE = "Contact_Details";
    public static final int DATABASE_VERSION = 1;

    // This is the string containing the SQL database create statement
    private static final String DATABASE_CREATE =
            "create table " + DATABASE_TABLE  +
                    " (_id integer primary key autoincrement, " +
                    "first_name text not null, " +
                    "surname text not null, "  +
                    "city text not null);";


    // constructor for your dB helper class. This code is standard. You’ve set up the parameter values for the constructor already…database name,etc

    public databaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {

        // The “Database_create” string below needs to contain the SQL statement needed to create the dB
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion)
    {
        // If you want to change the structure of your database, e.g.

    }
}


