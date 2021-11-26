package com.example.week7databaselab;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.week7databaselab.databaseClasses.databaseManager;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class TaskListAdapter extends ArrayAdapter<Contact> {

    ArrayList<Contact> contacts;

    public TaskListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contact> objects) {
        super(context, resource, objects);
        contacts = objects;
    }

    @Override
    public View getView(int Position, View ConvertView, ViewGroup parent){

        View row = ConvertView;

        Context context = getContext();

        if(row == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(R.layout.task_list_item,parent,false);
        }

        Contact contactData = contacts.get(Position);
        final TextView name = row.findViewById(R.id.name);
        final TextView city = row.findViewById(R.id.city);

        name.setText(contactData.getFirst_name());
        city.setText(contactData.getSurname());
        return row;

    }


}

