package com.example.week7databaselab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.week7databaselab.databaseClasses.databaseManager;

import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity {
    databaseManager helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        //instantiate adapter
        helper = new databaseManager(this);
        //task list adapter connected to list view
        final TaskListAdapter adapter = new TaskListAdapter(this, R.layout.task_list_item, helper.getAllPersons());
        final ListView listView = findViewById(R.id.tasks);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact clickedItem = (Contact) adapterView.getItemAtPosition(i);
                Intent navigateToReminderActivity = new Intent(TaskActivity.this, TaskDetails.class);
                navigateToReminderActivity.putExtra("name", clickedItem.getFirst_name());
                startActivity(navigateToReminderActivity);
            }
        });

    }
}