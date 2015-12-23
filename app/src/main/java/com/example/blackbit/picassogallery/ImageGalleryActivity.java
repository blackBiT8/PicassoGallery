package com.example.blackbit.picassogallery;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageGalleryActivity extends AppCompatActivity {

    private Utils utils;
    private ArrayList<String> imagePaths = new ArrayList<String>();
    private ImageGalleryViewAdapter adapter;
    private GridView gridView;
    private int columnWidth;
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cria TabHost
        TabHost tabHostProdutoDados;
        tabHostProdutoDados = (TabHost) findViewById(R.id.tabHostProdutoPesquisa);
        tabHostProdutoDados.setup();

        // Cria Tab Dados
        TabHost.TabSpec ts1 = tabHostProdutoDados.newTabSpec("paper1");
        ts1.setIndicator("Dados");
        ts1.setContent(R.id.tab_pesquisa_produto_app_i);
        tabHostProdutoDados.addTab(ts1);

        // Cria Tab Preços
        TabHost.TabSpec ts2 = tabHostProdutoDados.newTabSpec("paper2");
        ts2.setIndicator("Preços");
        ts2.setContent(R.id.tab_lista_produto_app_i);
        tabHostProdutoDados.addTab(ts2);

        // Variavel local recebe TabHost
        tabHost = tabHostProdutoDados;

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equals("paper1")) {
                    loadGalleryOld();
                } else if (tabId.equals("paper2")) {
                    loadGalleryNew();
                }
            }
        });

//        gridView = (GridView) findViewById(R.id.paper1);
//
//        MyApplication.PHOTO_ALBUM = "/storage/extSdCard/paper1";
//
//        utils = new Utils(this);
//
//        // Initilizing Grid View
//        InitilizeGridLayout();
//
//        // loading all image paths from SD card
//        imagePaths = utils.getFilePaths();
//
//        // Gridview adapter
//        adapter = new ImageGalleryViewAdapter(ImageGalleryActivity.this, imagePaths,
//                columnWidth);
//
//        // setting grid view adapter
//        gridView.setAdapter(adapter);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent a = new Intent(ImageGalleryActivity.this, FullScreenImageActivity.class);
//                a.putExtra("position", i);
//                //MyApplication.selectedImage = _filePaths.get(_postion).toString().substring(_filePaths.get(_postion).toString().lastIndexOf("/")+1);
//                startActivity(a);
////                MyApplication.selectedImage = i;
////                Toast.makeText(MyApplication.getContext(), String.valueOf(i) + " - " + imagePaths.get(i), Toast.LENGTH_SHORT).show();
////                Log.i("INT i>>>>>", String.valueOf(i) + " - Selected>>>" + String.valueOf(MyApplication.selectedImage));
//            }
//        });

    }


    private void loadGalleryOld(){
        gridView = (GridView) findViewById(R.id.paper1);

        MyApplication.PHOTO_ALBUM = "/storage/extSdCard/paper1";

        utils = new Utils(this);

        // Initilizing Grid View
        InitilizeGridLayout();

        // loading all image paths from SD card
        imagePaths = utils.getFilePaths();

        // Gridview adapter
        adapter = new ImageGalleryViewAdapter(ImageGalleryActivity.this, imagePaths,
                columnWidth);

        // setting grid view adapter
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent a = new Intent(ImageGalleryActivity.this, FullScreenImageActivity.class);
                a.putExtra("position", i);
                //MyApplication.selectedImage = _filePaths.get(_postion).toString().substring(_filePaths.get(_postion).toString().lastIndexOf("/")+1);
                startActivity(a);
//                MyApplication.selectedImage = i;
//                Toast.makeText(MyApplication.getContext(), String.valueOf(i) + " - " + imagePaths.get(i), Toast.LENGTH_SHORT).show();
//                Log.i("INT i>>>>>", String.valueOf(i) + " - Selected>>>" + String.valueOf(MyApplication.selectedImage));
            }
        });
    }

    private void loadGalleryNew(){
        gridView = (GridView) findViewById(R.id.paper2);

        MyApplication.PHOTO_ALBUM = "/storage/extSdCard/paper2";

        utils = new Utils(this);

        // Initilizing Grid View
        InitilizeGridLayout();

        // loading all image paths from SD card
        imagePaths = utils.getFilePaths();

        // Gridview adapter
        adapter = new ImageGalleryViewAdapter(ImageGalleryActivity.this, imagePaths,
                columnWidth);

        // setting grid view adapter
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent a = new Intent(ImageGalleryActivity.this, FullScreenImageActivity.class);
                a.putExtra("position", i);
                //MyApplication.selectedImage = _filePaths.get(_postion).toString().substring(_filePaths.get(_postion).toString().lastIndexOf("/")+1);
                startActivity(a);
//                MyApplication.selectedImage = i;
//                Toast.makeText(MyApplication.getContext(), String.valueOf(i) + " - " + imagePaths.get(i), Toast.LENGTH_SHORT).show();
//                Log.i("INT i>>>>>", String.valueOf(i) + " - Selected>>>" + String.valueOf(MyApplication.selectedImage));
            }
        });
    }



    private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                MyApplication.GRID_PADDING, r.getDisplayMetrics());

        columnWidth = (int) ((utils.getScreenWidth() - ((MyApplication.NUM_OF_COLUMNS + 1) * padding)) / MyApplication.NUM_OF_COLUMNS);

        Log.i("DADOS>>>>>>>: ", "Disp Metrics: " + r.getDisplayMetrics() + " ColumWidth: " + columnWidth + " Padding: " + padding);

        gridView.setNumColumns(MyApplication.NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding((int) padding, (int) padding, (int) padding,
                (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }
}
