package com.example.hellogaf.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hellogaf.R;
import com.example.hellogaf.DataStorage.DataStorageHelper;


import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class Login extends AppCompatActivity {

    Button save, complete;

    protected void onStart() {
        super.onStart();
        Log.d("GAF", "Login onStart()");
    }

    protected  void onStop() {
        super.onStop();
        Log.d("GAF", "Login onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("GAF", "Login onDestroy()");
    }
    protected void onResume() {
        super.onResume();
        Log.d("GAF", "Login onResume()");
    }
    protected void onPause() {
        super.onPause();
        Log.d("GAF", "Login onPause()");
    }

    protected void onActivityResult(
            int requestCode,
            int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int code = resultCode;
        Log.d("GAF", "Login onActivityResult()" + resultCode);

    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("GAF", "Login onSaveInstanceState()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.hellogaf.R.layout.activity_booking);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText email = findViewById(R.id.email_input);
        final EditText password = findViewById(R.id.password_input);
        password.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        final Button submit = findViewById(R.id.submit_btn);
        save = findViewById(R.id.save);
        complete = findViewById(R.id.complete);

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String Email = email.getText().toString();
                String pass = password.getText().toString();
                String save_string = Email + " " + pass;
                DataStorageHelper.saveValueInSharedPrefs(Login.this,
                        "email", save_string);

            }
        });

        String save_string = DataStorageHelper.readValueInSharedPrefs(Login.this,
                "email");
        final String[] arrOfStr = save_string.split(" ", 2);
        email.setText(arrOfStr[0]);
        complete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String save_string = DataStorageHelper.readValueInSharedPrefs(Login.this,
                        "email");
                final String[] arrOfStr = save_string.split(" ", 2);
                email.setText(arrOfStr[0]);
                password.setText(arrOfStr[1]);

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress = email.getText().toString();
                String userPassword = password.getText().toString();
                boolean isValidP = false;
                boolean isValidE = false;
                if (emailAddress.equals("")) {
                    email.setError("E-mail is required");
                    isValidE = false;
                }
                if (userPassword.equals("")) {
                    password.setError("Wrong password");
                    isValidP = false;
                }

//                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches())
//                    isValidE = false;

                if (!arrOfStr[0].equals(NULL)) {
                    if (emailAddress.compareTo(arrOfStr[0]) == 0) {
                        isValidE = true;
                    }
                }
                if (!arrOfStr[1].equals(NULL)) {
                    if (userPassword.compareTo(arrOfStr[1]) == 0) {
                        isValidP = true;
                    }
                }
                if (!isValidE) {
                    Toast.makeText(
                            Login.this,
                            "Not a valid e-mail",
                            Toast.LENGTH_LONG).show();
                }
                if (!isValidP) {
                    Toast.makeText(
                            Login.this,
                            "Wrong password",
                            Toast.LENGTH_LONG).show();
                }
                if (isValidE && isValidP) {
                    Toast.makeText(
                            Login.this,
                            "Welcome back " + emailAddress,
                            Toast.LENGTH_LONG).show();
                    Intent redirectIntent = new Intent(Login.this, DrawerActivity.class);
                    redirectIntent.putExtra("username", "Geo");
                    if(redirectIntent.resolveActivity((getPackageManager()))!= null)
                        startActivityForResult(redirectIntent, 200);
                }

            }
        });
    }
}