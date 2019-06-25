package com.example.hellogaf.Fragments;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.hellogaf.R;

import java.util.Vector;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    Vector<String> web1;
    Vector<Integer> imageId1;
    Vector<Bitmap> images;
    int[] favourite = new int[20];
    public CustomList(Activity context,
                      Vector<String> web1, Vector<Bitmap> imageId, int[]favourite) {
        super(context, R.layout.list_single, web1);
        this.context = context;
        this.web1 = web1;
        this.images = imageId;
        this.favourite = favourite;

    }
    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = rowView.findViewById(R.id.txt);

        ImageView imageView = rowView.findViewById(R.id.img);
        ToggleButton toggleButton = rowView.findViewById(R.id.button6);
        if (favourite[+position] == -1) {
            //toggleButton.setSelected(true);
            toggleButton.toggle();

        }
        else {
            toggleButton.setSelected(false);
        }
        toggleButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                favourite[+position] = (-1) * favourite[+position];
                //Toast.makeText(getContext(), web1.get(+position) + " checked" + favourite[+position], Toast.LENGTH_LONG).show();
            }
        });
        txtTitle.setText(web1.get(position));
        //Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), imageId1.get(position));
        imageView.setImageBitmap(images.get(position));
        //imageView.setImageResource(imageId1.get(position));
        return rowView;
    }
}