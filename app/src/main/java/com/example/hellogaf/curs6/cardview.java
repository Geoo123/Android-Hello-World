package com.example.hellogaf.curs6;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellogaf.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;

import static android.app.Activity.RESULT_OK;

public class cardview extends AppCompatActivity {
    Button mBtnMinus;
    Button mBtnPlus;
    ImageView mBattery;
    Button mClickMe, b3;
    TextView text1;
    int currentLevvel = 0;
    private Uri mImageUri;

    public static final int REQUEST_CAMERA_PERMISSIONS = 101;
    public static final int REQUEST_IMAGE_CAPTURE = 102;



    private File createTemporaryFile(String part, String ext) throws Exception
    {
        File tempDir= Environment.getExternalStorageDirectory();
        tempDir=new File(tempDir.getAbsolutePath()+"/.temp/");
        if(!tempDir.exists())
        {
            tempDir.mkdirs();
        }
        return File.createTempFile(part, ext, tempDir);
    }

    private void captureImage() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            //File photo;
            //try
            //{
                // place where to store camera taken picture
            //    photo = this.createTemporaryFile("picture", ".jpg");
            //    mImageUri = Uri.fromFile(photo);
            //    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
            //    photo.delete();
            //}
            //catch(Exception e)
            //{
               
            //}


        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mBattery.setImageBitmap(imageBitmap);
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("image/*");
            String imagePath = Environment.getExternalStorageDirectory()
                    + "/myImage.jpg";

            File imageFileToShare = new File(imagePath);
            //text1.setText(mImageUri.toString());

            //Uri uri = Uri.fromFile(imageFileToShare);
            //shareIntent.putExtra(Intent.EXTRA_STREAM, mImageUri);

            //startActivity(Intent.createChooser(shareIntent, "Share Image!"));
        }
        else
        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                mBattery.setImageBitmap(bitmap);
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("image/*");
                //File imageFileToShare = new File(String.valueOf(textTargetUri));


                //Uri uri = Uri.fromFile(imageFileToShare);


                //shareIntent.putExtra(Intent.EXTRA_STREAM, targetUri);
                //startActivity(Intent.createChooser(shareIntent, "Share Image!"));
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
        setContentView(R.layout.activity_cardview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mClickMe = findViewById(R.id.cardview_btn);
        b3 = findViewById(R.id.button3);
        text1 = findViewById(R.id.text1);
        mClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*final Calendar  calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog mDatePicker = new DatePickerDialog(cardview.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    }
                                                }, year, month, day);
                mDatePicker.show();*/
                if(ContextCompat.checkSelfPermission(cardview.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(cardview.this,
                            new String[]{Manifest.permission.CAMERA},
                            REQUEST_CAMERA_PERMISSIONS);
                } else {
                    captureImage();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        mBattery = findViewById(R.id.cardview_battery);
        /*mBtnMinus = findViewById(R.id.battery_minus);
        mBtnPlus = findViewById(R.id.battery_plus);

        mBtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentLevvel >= 1) {
                    currentLevvel--;
                    mBattery.getDrawable().setLevel(currentLevvel);
                }
            }
        });

        mBtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentLevvel <= 5) {
                    currentLevvel++;
                    mBattery.getDrawable().setLevel(currentLevvel);
                }
            }
        });*/

    }

}
