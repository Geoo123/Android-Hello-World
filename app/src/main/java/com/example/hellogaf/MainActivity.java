package com.example.hellogaf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hellogaf.Adapters.UserListAdapters;
import com.example.hellogaf.Models.UserModels;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mUsersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        mUsersList = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager usersListLayoutManager = new LinearLayoutManager(this);
        mUsersList.setLayoutManager(usersListLayoutManager);

        List<UserModels> userList = new ArrayList<>();
        userList.add(new UserModels("Andrei", "9/10", "Excellent trip"));
        userList.add(new UserModels("John", "8.5/10", "Nice vacation"));
        userList.add(new UserModels("Harry", "7/10", "..."));
        userList.add(new UserModels("Sansa", "6.6/10", "Meh"));
        userList.add(new UserModels("Mihai", "9.2/10", "Great experience"));
        userList.add(new UserModels("Sofia", "9.8/10", "I totally recommend it"));
        userList.add(new UserModels("Andrei", "9/10", "Excellent trip"));
        userList.add(new UserModels("John", "8.5/10", "Nice vacation"));
        userList.add(new UserModels("Harry", "7/10", "..."));
        userList.add(new UserModels("Sansa", "6.6/10", "Meh"));
        userList.add(new UserModels("Mihai", "9.2/10", "Great experience"));
        userList.add(new UserModels("Sofia", "9.8/10", "I totally recommend it"));

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
