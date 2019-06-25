package com.example.hellogaf.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hellogaf.R;

import java.util.Vector;

public class List<P> extends AppCompatActivity {

    ListView list;
    ImageView aux;
    Vector<String> web = new Vector<>(5);
    /*{
            "Australia - 2019",
            "Greece - 2018",
            "Dubai - 2018",
            "Oman - 2016",
            "Carribean Sea - 2015",
            "Italy - 2010",
            "Jamaica - 2010"
    };*/
    Vector<Integer> imageId = new Vector<>(5);
    /*{
            R.drawable.a1,
            R.drawable.greece,
            R.drawable.dubai,
            R.drawable.oman,
            R.drawable.carribean,
            R.drawable.italy,
            R.drawable.jamaica

    };*/
    Vector<Integer> imageId1 = new Vector<Integer>(20);
    Vector<Bitmap> images = new Vector<>(20);
    int[] favourite = new int[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        web.add("Australia - 2019");
        web.add("Greece - 2018");
        favourite[0] = 1;
        favourite[1] = 1;
        /*web.add("Dubai - 2018");
        web.add("Oman - 2016");
        web.add("Carribean Sea - 2015");
        web.add("Italy - 2010");
        web.add("Jamaica - 2010");
*/
        imageId.add(R.drawable.a1);
        imageId.add(R.drawable.greece);
        imageId.add(R.drawable.dubai);
        imageId.add(R.drawable.oman);
        imageId.add(R.drawable.carribean);
        imageId.add(R.drawable.italy);
        imageId.add(R.drawable.jamaica);

        /*LayoutInflater inflater = List.this.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        aux = rowView.findViewById(R.id.img);
        aux.setImageResource(R.drawable.a1);
        images.add(aux);
        aux.setImageResource(R.drawable.greece);
        images.add(aux);*/
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
        images.add(bitmap);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.greece);
        images.add(bitmap);

        CustomList adapter = new
                CustomList(List.this, web, images, favourite);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(List.this, "You Clicked at " +web.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }

}