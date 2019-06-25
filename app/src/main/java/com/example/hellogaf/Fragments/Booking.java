package com.example.hellogaf.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hellogaf.R;
import com.example.hellogaf.curs9.DataStorageActivity;
import com.example.hellogaf.curs9.DataStorageHelper;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class Booking extends AppCompatActivity {

    private Spinner mSpinner;
    private ArrayAdapter<String> mSpinnerAdapter;
    private List<String> mDataSource;
    Button save, complete;

    protected void onStart() {
        super.onStart();
        Log.d("GAF", "Activity 1 onStart()");
    }

    protected  void onStop() {
        super.onStop();
        Log.d("GAF", "Activity 1 onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("GAF", "Activity 1 onDestroy()");
    }
    protected void onResume() {
        super.onResume();
        Log.d("GAF", "Activity 1 onResume()");
    }
    protected void onPause() {
        super.onPause();
        Log.d("GAF", "Activity 1 onPause()");
    }

    protected void onActivityResult(
            int requestCode,
            int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int code = resultCode;
        Log.d("GAF", "Activity 1 onActivityResult()" + resultCode);

    }
    protected void onSaveIstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("GAF", "Activity 1 onsaveIstanceState()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.hellogaf.R.layout.activity_booking);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText email = findViewById(R.id.email_input);
        final EditText phone = findViewById(R.id.phone_input);
        phone.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        //final CheckBox tc = findViewById(R.id.check);
        final Button submit = findViewById(R.id.submit_btn);
        Button save = findViewById(R.id.save);
        Button complete = findViewById(R.id.complete);

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String Email = email.getText().toString();
                String pass = phone.getText().toString();
                String save_string = Email + " " + pass;
                DataStorageHelper.saveValueInSharedPrefs(Booking.this,
                        "email", save_string);

            }
        });

        String save_string = DataStorageHelper.readValueInSharedPrefs(Booking.this,
                "email");
        final String[] arrOfStr = save_string.split(" ", 2);
        //Toast.makeText(getApplicationContext(), save_string, Toast.LENGTH_LONG).show();
        email.setText(arrOfStr[0]);
        complete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //String email = mEmail.getText().toString();
                String save_string = DataStorageHelper.readValueInSharedPrefs(Booking.this,
                        "email");
                final String[] arrOfStr = save_string.split(" ", 2);
                //Toast.makeText(getApplicationContext(), save_string, Toast.LENGTH_LONG).show();
                email.setText(arrOfStr[0]);
                phone.setText(arrOfStr[1]);

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress = email.getText().toString();
                String phoneNumber = phone.getText().toString();
                //boolean isAccepted = tc.isChecked();
                boolean isValidP = false;
                boolean isValidE = false;
                if (emailAddress.equals("")) {
                    email.setError("E-mail is required");
                    isValidE = false;
                }
                if (phoneNumber.equals("")) {
                    phone.setError("Wrong password");
                    isValidP = false;
                }
                //if (!isAccepted) {
                //    isValidP = false;
                //    isValidE = false;
                //}


                if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches() == false)
                    isValidE = false;

                //if (android.util.Patterns.PHONE.matcher(phoneNumber).matches() == false) {
                //    isValidP = false;
                //}
                if (arrOfStr[0] != NULL) {
                    Toast.makeText(
                            Booking.this,
                            arrOfStr[0],
                            Toast.LENGTH_LONG).show();
                    if (emailAddress.compareTo(arrOfStr[0]) == 0) {
                        isValidE = true;
                    }
                }
                if (arrOfStr[1] != NULL) {
                    Toast.makeText(
                                  Booking.this,
                                    arrOfStr[1],
                                    Toast.LENGTH_LONG).show();
                    if (phoneNumber.compareTo(arrOfStr[1]) == 0) {
                        isValidP = true;
                    }
                }
                if (!isValidE) {
                    Toast.makeText(
                            Booking.this,
                            "Not a valid e-mail",
                            Toast.LENGTH_LONG).show();
                }
                if (!isValidP) {
                    //String aux = phoneNumber + " " + arrOfStr[1];
                    //Toast.makeText(
                    //        Booking.this,
                    //        aux,
                    //        Toast.LENGTH_LONG).show();
                    Toast.makeText(
                            Booking.this,
                            "Wrong password",
                            Toast.LENGTH_LONG).show();
                }
                if (isValidE && isValidP) {
                    Toast.makeText(
                            Booking.this,
                            "Welcome back " + emailAddress,
                            Toast.LENGTH_LONG).show();
                    Intent redirectIntent = new Intent(Booking.this, DrawerActivity.class);
                    redirectIntent.putExtra("username", "Geo");
                    if(redirectIntent.resolveActivity((getPackageManager()))!= null)
                        startActivityForResult(redirectIntent, 200);
                }

            }
        });


    }
//



    /*@Override
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
    }*/




}