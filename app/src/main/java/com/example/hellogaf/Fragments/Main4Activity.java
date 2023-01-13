package com.example.hellogaf.Fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.hellogaf.R;

public class Main4Activity extends AppCompatActivity {

    CityBreak mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFragment = new CityBreak();

        Bundle fragmentData = new Bundle();
        fragmentData.putString("foo", "bar");

        mFragment.setArguments(fragmentData);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame_holder, mFragment);
        ft.commit();


    }

}
