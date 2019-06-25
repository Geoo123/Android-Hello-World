package com.example.hellogaf.curs9;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hellogaf.R;

public class DataStorageActivity extends AppCompatActivity {

    Button mSavepref, mReadprefs;
    EditText mEmail;
    Button mWriteFile, mReadFile;
    Button bt5, bt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSavepref = findViewById(R.id.save_btn);
        mReadprefs = findViewById(R.id.read_btn);
        mEmail = findViewById(R.id.editText);
        mWriteFile = findViewById(R.id.writefile);
        mReadFile = findViewById(R.id.readfile);
        bt5 = findViewById(R.id.btn);
        bt6 = findViewById(R.id.btn1);

        ProjectModel project = new ProjectModel("project 1", "aaaa", 500);
        TaskModel task1 = new TaskModel("Create Project", "BoilerPlate", 2, 0);
        TaskModel task2 = new TaskModel("Build Project", "Grandle", 2, 0);

        RoomDB dbInstance = RoomDB.getInstance(DataStorageActivity.this);
                dbInstance.insertProject(project);
                dbInstance.insertTask(task1);
                dbInstance.insertTask(task2);

        bt5.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                ProjectAndAllTasksModel project = RoomDB.getInstance(DataStorageActivity.this).loadProject(1);

            }
        });

        mWriteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                DataStorageHelper.writeToFile(DataStorageActivity.this, "file.txt", email);
            }
        });

        mReadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = DataStorageHelper.readFromFile(DataStorageActivity.this, "file.txt");
                Toast.makeText(getApplicationContext(), email, Toast.LENGTH_LONG).show();
            }
        });
        mSavepref.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                DataStorageHelper.saveValueInSharedPrefs(DataStorageActivity.this,
                        "email", email);

            }
        });

        mReadprefs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //String email = mEmail.getText().toString();
                String email = DataStorageHelper.readValueInSharedPrefs(DataStorageActivity.this,
                        "email");
                Toast.makeText(getApplicationContext(), email, Toast.LENGTH_LONG).show();

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
