package com.example.week7databaselab.databaseClasses;

import static com.example.week7databaselab.databaseClasses.databaseHelper.DATABASE_TABLE;
import static com.example.week7databaselab.databaseClasses.databaseHelper.KEY_FIRSTNAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.week7databaselab.Contact;
import com.example.week7databaselab.Message;

import java.util.ArrayList;

public class databaseManager
{
    databaseHelper helper;

    public databaseManager(Context context)
    {
        helper = new databaseHelper(context);
    }

    //---insert a contact person into the database---
    public long insertPerson(String firstName, String surname, String city)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues initialValues = new ContentValues();
        initialValues.put(databaseHelper.KEY_FIRSTNAME, firstName);
        initialValues.put(databaseHelper.KEY_SURNAME, surname);
        initialValues.put(databaseHelper.KEY_CITY, city);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---deletes a particular contact person---
    public boolean deletePerson(long rowId)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        // delete statement.  If any rows deleted (i.e. >0), returns true
        return db.delete(DATABASE_TABLE, databaseHelper.KEY_ROWID +
                "=" + rowId, null) > 0;
    }

    /**
     * Returns a cursor with all the rows in the database
     * @return Cursor
     * @throws SQLException
     */
    public ArrayList<Contact> getAllPersons() throws SQLException
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor mCursor = db.query(true, DATABASE_TABLE, new String[] {
                        databaseHelper.KEY_ROWID, databaseHelper.KEY_FIRSTNAME, databaseHelper.KEY_SURNAME, databaseHelper.KEY_CITY },
                null, null, null, null, null, null);
        /**
         * return and array list populated by the cursor
         *  - the cursor is the result of the query
         */
        ArrayList<Contact> contacts = new ArrayList<>();
        if (mCursor != null)
        {
            mCursor.moveToFirst();
            while (!mCursor.isAfterLast()) {

                String firstName = mCursor.getString(mCursor.getColumnIndex(databaseHelper.KEY_FIRSTNAME));
                String surName = mCursor.getString(mCursor.getColumnIndex(databaseHelper.KEY_SURNAME));
                String City = mCursor.getString(mCursor.getColumnIndex(databaseHelper.KEY_CITY));
                Contact contact = new Contact(firstName,surName,City);
                contacts.add(contact);
                mCursor.moveToNext();
            }
        }
        
        //return message
        return contacts;
    }
   

    
    /**
     * return a contact by name
     * @param name
     * @return Cursor
     */
    public Cursor getPersonByName(String name)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor mCursor = db.query(true, DATABASE_TABLE, new String[] {
                        databaseHelper.KEY_ROWID, databaseHelper.KEY_FIRSTNAME, databaseHelper.KEY_SURNAME, databaseHelper.KEY_CITY },
                KEY_FIRSTNAME + "='" + name + "'", null, null, null, null, null);
        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a contact person---
    public boolean updatePerson(long rowId, String firstName,
                                String surname, String city)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(databaseHelper.KEY_FIRSTNAME, firstName);
        args.put(databaseHelper.KEY_SURNAME, surname);
        args.put(databaseHelper.KEY_CITY, city);
        return db.update(DATABASE_TABLE, args,
                databaseHelper.KEY_ROWID + "=" + rowId, null) > 0;
    }

    static class databaseHelper extends SQLiteOpenHelper
    {

        private static final String KEY_ROWID = "_id";
        private static final String KEY_FIRSTNAME = "first_name";
        private static final String KEY_SURNAME = "surname";
        private static final String KEY_CITY = "city";

        private static final String DATABASE_NAME = "Contacts";
        private static final String DATABASE_TABLE = "Contact_Details";
        private static final int DATABASE_VERSION = 1;

        /**
         * create table contact_details
         */
        private static final String DATABASE_CREATE = "create table "
                + DATABASE_TABLE + " (" + KEY_ROWID
                + " integer primary key autoincrement, " + KEY_FIRSTNAME
                + " text not null, " + KEY_SURNAME + " text not null, "
                + KEY_CITY + " text not null);";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+DATABASE_TABLE;
        private final Context context;

        public databaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
        }


        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }

        }
    }




}



