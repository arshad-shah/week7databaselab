package com.example.week7databaselab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week7databaselab.databaseClasses.databaseManager;

public class MainActivity extends AppCompatActivity {
    databaseManager helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new databaseManager(this);

        final EditText firstName = findViewById(R.id.firstName);
        final EditText LastName = findViewById(R.id.LastName);
        final EditText City = findViewById(R.id.City);
        final Button insert = findViewById(R.id.insert);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long insert = helper.insertPerson(firstName.getText().toString(), LastName.getText().toString(), City.getText().toString());
                if(insert <=0){
                    Toast.makeText(MainActivity.this, "Insert failed", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Insert successful", Toast.LENGTH_LONG).show();
                    Intent navigateToReminderActivity = new Intent(MainActivity.this, TaskActivity.class);
                    startActivity(navigateToReminderActivity);
                }


            }
        });
    }
}