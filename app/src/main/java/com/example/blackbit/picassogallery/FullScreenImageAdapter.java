package com.example.blackbit.picassogallery;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FullScreenImageAdapter extends PagerAdapter {

    private Activity _activity;
    private ArrayList<String> _imagePaths;
    private LayoutInflater inflater;
    private TextView mImageId;

    // constructor
    public FullScreenImageAdapter(Activity activity,
                                  ArrayList<String> imagePaths) {
        this._activity = activity;
        this._imagePaths = imagePaths;
    }

    @Override
    public int getCount() {
        return this._imagePaths.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imgDisplay;
        //Button btnClose, btnGetId;

        inflater = (LayoutInflater) _activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_full_screen_image, container,
                false);

        imgDisplay = (ImageView) viewLayout.findViewById(R.id.imgDisplay);
//        btnClose = (Button) viewLayout.findViewById(R.id.btnClose);
//        btnGetId = (Button) viewLayout.findViewById(R.id.btnGetID);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        //options.inSampleSize = 1;
        //Bitmap bitmap = BitmapFactory.decodeFile(_imagePaths.get(position), options);
        Bitmap bitmap = decodeFile(_imagePaths.get(position), 300, 300);

        imgDisplay.setImageBitmap(bitmap);

//        Picasso.with(_activity)
//                .load(new File(_imagePaths.get(position)))
//                .fit().centerInside()
//                .into(imgDisplay);

        // close button click event
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                _activity.finish();
//            }
//        });

//        btnGetId.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                //MyApplication.selectedImage = ;
////                Intent dados = new Intent(MyApplication.getContext(), ProdutoDadosActivity.class);
////                dados.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                MyApplication.getContext().startActivity(dados);
//
//                Toast.makeText(MyApplication.getContext(), _imagePaths.get(MyApplication.selectedImage).substring(_imagePaths.get(MyApplication.selectedImage).lastIndexOf("/") + 1), Toast.LENGTH_SHORT).show();
//            }
//        });

        ((ViewPager) container).addView(viewLayout);

        //MyApplication.selectedImage = String.valueOf(position);



        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

    /*
 * Resizing image size
 */
    public static Bitmap decodeFile(String filePath, int WIDTH, int HIGHT) {
        try {

            File f = new File(filePath);

            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);

            final int REQUIRED_WIDTH = WIDTH;
            final int REQUIRED_HIGHT = HIGHT;
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_WIDTH
                    && o.outHeight / scale / 2 >= REQUIRED_HIGHT)
                scale *= 2;

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;

            Log.i("SCALE-FULL>>>>", String.valueOf(scale) + "  FILEPATH>>>" + filePath.toString());

            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}