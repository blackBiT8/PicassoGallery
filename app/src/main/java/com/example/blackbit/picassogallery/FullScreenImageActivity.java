package com.example.blackbit.picassogallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class FullScreenImageActivity extends AppCompatActivity {

    private Utils utils;
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;
    private ArrayList<String> paths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        viewPager = (ViewPager) findViewById(R.id.pager);

        utils = new Utils(getApplicationContext());

        paths = utils.getFilePaths();

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);


        adapter = new FullScreenImageAdapter(FullScreenImageActivity.this,
                utils.getFilePaths());


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //Toast.makeText(MyApplication.getContext(), String.valueOf(position) + " - " + paths.get(position), Toast.LENGTH_SHORT).show();
                Log.i("POSITION>>>>", String.valueOf(position) + " - " + paths.get(position));
                MyApplication.selectedImage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(position);

        //Toast.makeText(MyApplication.getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_full_screen_image_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.btn_detalhe_produto_mfsia){

        }


        return super.onOptionsItemSelected(item);
    }
}