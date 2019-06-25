package com.example.hellogaf;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hellogaf.Adapters.UserListAdapters;
import com.example.hellogaf.Models.UserModels;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinner;
    private ArrayAdapter<String> mSpinnerAdapter;
    private List<String> mDataSource;
    RecyclerView mUsersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mUsersList = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager usersListLayoutManager = new LinearLayoutManager(this);
        mUsersList.setLayoutManager(usersListLayoutManager);

        List<UserModels> userList = new ArrayList<>();
        userList.add(new UserModels("Andrei", "Marinescu"));
        userList.add(new UserModels("John", "Snow"));
        userList.add(new UserModels("Harry", "Potter"));
        userList.add(new UserModels("Sansa", "Stark"));
        userList.add(new UserModels("Mihai", "Popescu"));
        userList.add(new UserModels("Sofia", "Mann"));
        userList.add(new UserModels("Andrei", "Marinescu"));
        userList.add(new UserModels("John", "Snow"));
        userList.add(new UserModels("Harry", "Potter"));
        userList.add(new UserModels("Sansa", "Stark"));
        userList.add(new UserModels("Mihai", "Popescu"));
        userList.add(new UserModels("Sofia", "Mann"));
        userList.add(new UserModels("Andrei", "Marinescu"));
        userList.add(new UserModels("John", "Snow"));
        userList.add(new UserModels("Harry", "Potter"));
        userList.add(new UserModels("Sansa", "Stark"));
        userList.add(new UserModels("Mihai", "Popescu"));
        userList.add(new UserModels("Sofia", "Mann"));

        UserListAdapters listAdapter = new UserListAdapters(userList);
        mUsersList.setAdapter(listAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
