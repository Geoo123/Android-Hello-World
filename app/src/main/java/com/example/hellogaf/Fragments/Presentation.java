package com.example.hellogaf.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellogaf.R;

import java.io.FileNotFoundException;

public class Presentation extends AppCompatActivity {

    ImageView im1;
    TextView text1, text2, text3, text4, text5, text6;
    String str;
    String name, dest, price, date, rating, type;
    String id;
    Integer id2;
    String[] arrOfStr;
    Bitmap bitmap;

    public Bitmap StringToBitMap(String encodedString){
        try {
            byte [] encodeByte=Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap=BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        im1 = findViewById(R.id.image_trip);
        text1 = findViewById(R.id.name_of_trip);
        text2 = findViewById(R.id.trip_destination);
        text3 = findViewById(R.id.duration);
        text4 = findViewById(R.id.price);
        text5 = findViewById(R.id.rating);
        text6 = findViewById(R.id.type);



        Bundle bundle = getIntent().getExtras();
        str = bundle.getString("key1");
        if(getIntent().hasExtra("key2")) {
            id = bundle.getString("key2");
            Uri myUri = Uri.parse(id);
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(myUri));

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else
            if (getIntent().hasExtra("key3")) {
                id2 = bundle.getInt("key3");
                bitmap = BitmapFactory.decodeResource(getResources(), id2);
            }
        arrOfStr = str.split("\n", 6);
        /*Toast.makeText(
                Presentation.this,
                str + " " + arrOfStr[0] + " " + arrOfStr[1] + " " + arrOfStr[2] + " " + id,
                Toast.LENGTH_LONG).show();
        */
        //Bitmap bitmap = StringToBitMap(id);
        im1.setImageBitmap(bitmap);

        name = arrOfStr[0];
        dest = "Destination: " + arrOfStr[1];
        date = "Duration: " + arrOfStr[2];
        price = "Price: " + arrOfStr[3];
        rating = "Rating: " + arrOfStr[4];
        type = arrOfStr[5];

        text1.setText(name);
        text2.setText(dest);
        text3.setText(date);
        text4.setText(price);
        text5.setText(rating);
        text6.setText(type);


        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
