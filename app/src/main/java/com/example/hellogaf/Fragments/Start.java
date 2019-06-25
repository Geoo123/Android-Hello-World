package com.example.hellogaf.Fragments;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellogaf.R;
import com.example.hellogaf.curs5.Main3Activity;
import com.example.hellogaf.curs6.cardview;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;

import static com.example.hellogaf.curs6.cardview.REQUEST_CAMERA_PERMISSIONS;
import static com.example.hellogaf.curs6.cardview.REQUEST_IMAGE_CAPTURE;

public class Start extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Start";
    private TextView mDisplayDate, mDisplayDate1;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    RadioButton bt1, bt2, bt3;
    String type;
    EditText t1, t2;
    SeekBar seekBar;
    String rating;
    RatingBar ratingBar;
    int prog;
    Button bt4, bt5;
    Bitmap bitmap;
    Bitmap imageBitmap;
    Uri targetUri;
    String path;

    private void captureImage() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        }
    }

    public String createImageFromBitmap(Bitmap bitmap) {
        String fileName = "myImage";//no .png or .jpg needed
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            FileOutputStream fo = openFileOutput(fileName, Context.MODE_PRIVATE);
            fo.write(bytes.toByteArray());
            // remember close file output
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
            fileName = null;
        }
        return fileName;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            Toast.makeText(
                    Start.this,
                    imageBitmap.toString(),
                    Toast.LENGTH_LONG).show();

        }
        else*/
        if (resultCode == RESULT_OK) {
            targetUri = data.getData();
            path = targetUri.toString();
            /*Toast.makeText(
                    Start.this,
                    path,
                    Toast.LENGTH_LONG).show();
            */
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CAMERA_PERMISSIONS:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    captureImage();
                } else {
                    // TOAST.
                }
                return;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mDisplayDate = (TextView) findViewById(R.id.tvDate);
        mDisplayDate1 = (TextView) findViewById(R.id.tvDate1);
        t1 = findViewById(R.id.trip_name);
        t2 = findViewById(R.id.destination);
        bt4 = findViewById(R.id.button4);
        //bt5 = findViewById(R.id.button5);

        bt1 = findViewById(R.id.b1);
        bt2 = findViewById(R.id.b2);
        bt3 = findViewById(R.id.b3);

        ratingBar = findViewById(R.id.rating);


        seekBar = findViewById(R.id.seek);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                prog = progress;
                //Toast.makeText(getApplicationContext(), "seekbar progress: " + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

        /*bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Start.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Start.this,
                            new String[]{Manifest.permission.CAMERA},
                            REQUEST_CAMERA_PERMISSIONS);
                } else {
                    captureImage();
                }
            }
        });*/
        Button button = findViewById(R.id.the_button);
        button.setOnClickListener(this);
        /*button.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    Toast.makeText(Start.this, "View touch", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });*/

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Start.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy: " + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Start.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener1,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy: " + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                mDisplayDate1.setText(date);
            }
        };
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

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

    /*protected void onActivityResult(
            int requestCode,
            int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int code = resultCode;
        Log.d("GAF", "Activity 1 onActivityResult()" + resultCode);

    }*/
    protected void onSaveIstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("GAF", "Activity 1 onsaveIstanceState()");
    }

    @Override
    public void onClick(View v) {
        if (bt1.isChecked()) {
            type = bt1.getText().toString();

        } else
            if (bt2.isChecked()) {
                type = bt2.getText().toString();
            }
            else if (bt3.isChecked()) {
                type = bt3.getText().toString();
            }
            Bundle bundle = new Bundle();
            bundle.putString("key1", t1.getText().toString());
            bundle.putString("key2", t2.getText().toString());
            bundle.putString("key3", mDisplayDate.getText().toString());
            bundle.putString("key4", mDisplayDate1.getText().toString());
            bundle.putInt("key5", prog);
            rating = String.valueOf(ratingBar.getRating());
            bundle.putString("key6", rating);
            bundle.putString("path", path);
            bundle.putString("type", type);

            Intent redirectIntent = new Intent(this, DrawerActivity.class);
            redirectIntent.putExtras(bundle);
            if(redirectIntent.resolveActivity((getPackageManager()))!= null) {
                startActivityForResult(redirectIntent, 200);
            }


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
