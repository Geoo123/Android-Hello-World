package com.example.hellogaf.MainActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hellogaf.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    Button mRedirect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRedirect = findViewById(R.id.redirectBtn);
        mRedirect.setOnClickListener(this);
    }

    protected void onStart() {
        super.onStart();
        Log.d("GAF", "Activity 2 onStart()");
    }

    protected  void onStop() {
        super.onStop();
        Log.d("GAF", "Activity 2 onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("GAF", "Activity 2 onDestroy()");
    }
    protected void onResume() {
        super.onResume();
        Log.d("GAF", "Activity 2 onResume()");
    }
    protected void onPause() {
        super.onPause();
        Log.d("GAF", "Activity 2 onPause()");
    }

    protected void onActivityResult(
        int requestCode,
        int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int code = resultCode;
        Log.d("GAF", "Activity 2 onActivityResult()" + resultCode);

    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("GAF", "Activity 2 onSaveInstanceState()");
    }

    @Override
    public void onClick(View v) {
        Intent redirectIntent = new Intent(this, Main3Activity.class);
        redirectIntent.putExtra("username", "Geo");
        if(redirectIntent.resolveActivity((getPackageManager()))!= null)
            startActivityForResult(redirectIntent, 200);

    }
}
