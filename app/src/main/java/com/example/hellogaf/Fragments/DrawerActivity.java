package com.example.hellogaf.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellogaf.Fragments.hello_fragment;
import com.example.hellogaf.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.Vector;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    String trip_name, destination, start_date, end_date;
    ListView list;
    Bitmap bitmap;
    Uri myUri;
    String price, rating, path, type;
    int[] favorite = new int[20];
    int pret;
    Vector<String> web1 = new Vector<String>(20);
    Vector<String> web2 = new Vector<String>(20);
    Vector<Bitmap> images = new Vector<>(20);
    Vector<String> paths = new Vector<>(20);
    Vector<Integer> ids = new Vector<>(20);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        //Button b = findViewById(R.id.button);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        web1.add("Summer 2018" + "\n" + "London" + "\n" + "19/08/2018 - 24/08/2018" + "\n" + "3000€" + "\n" + "3.0/5.0" + "\n" + "City Break");
        web2.add("Summer 2018" + "\n\n" + "London" +"\n\n" + "3.0/5.0");
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.london);
        images.add(bitmap);
        ids.add(R.drawable.london);
        paths.add(null);
        favorite[images.indexOf(bitmap)] = 1;

        web1.add("Summer 2017" + "\n" + "Lisbon" + "\n" + "17/07/2017 - 20/07/2017" + "\n" + "2000€" + "\n" + "2.5/5.0" + "\n" + "City Break");
        web2.add("Summer 2017" + "\n\n" + "Lisbon" +"\n\n" + "2.5/5.0");
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lisbon);
        images.add(bitmap);
        ids.add(R.drawable.lisbon);
        paths.add(null);
        favorite[images.indexOf(bitmap)] = 1;

        /*web1.add("Winter 2017" + "\n" + "Italy" + "\n" + "06/12/2017 - 10/12/2017" + "\n" + "2500€" + "\n" + "3.5/5.0");
        web2.add("Winter 2017" + "\n\n" + "Italy" +"\n\n" + "3.5/5.0");
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.italy);
        images.add(bitmap);
        ids.add(R.drawable.italy);
        paths.add(null);
        favorite[images.indexOf(bitmap)] = 1;
*/
        /*web1.add("Summer 2016" + "\n" + "Turkey" + "\n" + "25/06/2016 - 30/06/2016" + "\n" + "1500€" + "\n" + "4.5/5.0");
        web2.add("Summer 2016" + "\n\n" + "Turkey" +"\n\n" + "4.5/5.0");
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.turkey);
        images.add(bitmap);
        ids.add(R.drawable.turkey);
        paths.add(null);
        favorite[images.indexOf(bitmap)] = 1;

        web1.add("Spring 2015" + "\n" + "USA" + "\n" + "08/04/2015 - 15/04/2015" + "\n" + "4500€" + "\n" + "5.0/5.0");
        web2.add("Spring 2015" + "\n\n" + "USA" +"\n\n" + "5.0/5.0");
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ussa);
        images.add(bitmap);
        ids.add(R.drawable.ussa);
        paths.add(null);
        favorite[images.indexOf(bitmap)] = 1;*/

        Bundle bundle = getIntent().getExtras();
        if (getIntent().hasExtra("key1")) {
            trip_name = bundle.getString("key1");
        }
        if (getIntent().hasExtra("key2")) {
            destination = bundle.getString("key2");
        }
        if (getIntent().hasExtra("key3")) {
            start_date = bundle.getString("key3");
        }
        if (getIntent().hasExtra("key4")) {
            end_date = bundle.getString("key4");
        }
        if (getIntent().hasExtra("key5")) {
            pret = bundle.getInt("key5");
            pret *= 100;
            price = pret + "€";
        }
        if (getIntent().hasExtra("key6")) {
            rating = bundle.getString("key6");
        }
        if (getIntent().hasExtra("type")) {
            type = bundle.getString("type");
        }
        if (getIntent().hasExtra("path")) {
            path = bundle.getString("path");
            myUri = Uri.parse(path);
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(myUri));

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (trip_name != null) {
            String str = trip_name + "\n" + destination + "\n" + start_date + " - " + end_date +
                    "\n" + price + "\n" + rating + "/5.0" + "\n" + type;
            web1.add(str);
            web2.add(trip_name + "\n\n" + destination + "\n\n" + rating + "/5.0");
            images.add(bitmap);
            ids.add(0);
            paths.add(path);
            favorite[images.indexOf(bitmap)] = 1;
        }
        CustomList adapter = new
                CustomList(DrawerActivity.this, web2, images, favorite);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Bundle bundle = new Bundle();
                if (paths.get(+position) != null) {
                    bundle.putString("key2", paths.get(+position));
                }
                else
                    if (ids.get(+position) != 0) {
                        bundle.putInt("key3", ids.get(+position));
                    }
                bundle.putString("key1", web1.get(+position));
                Intent redirectIntent = new Intent(DrawerActivity.this, Presentation.class);
                redirectIntent.putExtras(bundle);
                redirectIntent.putExtra("username", "Geo");
                if(redirectIntent.resolveActivity((getPackageManager()))!= null)
                    startActivityForResult(redirectIntent, 200);

            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirectIntent = new Intent(DrawerActivity.this, Start.class);
                if(redirectIntent.resolveActivity((getPackageManager()))!= null) {
                    startActivityForResult(redirectIntent, 200);
                }
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        /*b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(205);
                finish();
            }
        });*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            CustomList adapter = new
                    CustomList(DrawerActivity.this, web2, images, favorite);
            list = findViewById(R.id.list);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Bundle bundle = new Bundle();
                    if (paths.get(+position) != null) {
                        bundle.putString("key2", paths.get(+position));
                    }
                    else
                    if (ids.get(+position) != 0) {
                        bundle.putInt("key3", ids.get(+position));
                    }
                    bundle.putString("key1", web1.get(+position));
                    Intent redirectIntent = new Intent(DrawerActivity.this, Presentation.class);
                    redirectIntent.putExtras(bundle);
                    redirectIntent.putExtra("username", "Geo");
                    if(redirectIntent.resolveActivity((getPackageManager()))!= null)
                        startActivityForResult(redirectIntent, 200);

                }
            });
        } else if (id == R.id.nav_gallery) {
            Intent redirectIntent = new Intent(this, TabbedActivity.class);
            redirectIntent.putExtra("username", "Geo");
            if(redirectIntent.resolveActivity((getPackageManager()))!= null)
                startActivityForResult(redirectIntent, 200);

        } else if (id == R.id.nav_slideshow) {
            /*FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.home_container, new hello_fragment2());
            ft.commit();*/
            //Bundle bundle = new Bundle();
            //bundle.putIntArray("key1");
            /*Intent redirectIntent = new Intent(this, List.class);
            redirectIntent.putExtra("username", "Geo");
            if(redirectIntent.resolveActivity((getPackageManager()))!= null)
                startActivityForResult(redirectIntent, 200);
            */
            int i;
            Vector<String> copy = new Vector<>(20);
            Vector<Bitmap> copy_im = new Vector<>(20);
            for (i = 0; i < web2.size(); i++) {
                if (favorite[i] == -1) {
                    copy.add(web2.get(i));
                    copy_im.add(images.get(i));
                }
            }
            CustomList2 adapter = new
                    CustomList2(DrawerActivity.this, copy, copy_im);
            list=(ListView)findViewById(R.id.list);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Toast.makeText(DrawerActivity.this, "You Clicked at " +web1.get(position), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if (id == R.id.nav_tools) {
            Intent redirectIntent = new Intent(this, AboutUs.class);
            redirectIntent.putExtra("username", "Geo");
            if(redirectIntent.resolveActivity((getPackageManager()))!= null)
                startActivityForResult(redirectIntent, 200);
        }

        else if (id == R.id.nav_share) {

            Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 0);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("image/*");
                shareIntent.putExtra(Intent.EXTRA_STREAM, targetUri);
                startActivity(Intent.createChooser(shareIntent, "Share Image!"));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
