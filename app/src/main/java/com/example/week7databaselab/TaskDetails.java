package com.example.week7databaselab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        final TextView nameToTextView = findViewById(R.id.personName);

        nameToTextView.setText(name);
    }
}