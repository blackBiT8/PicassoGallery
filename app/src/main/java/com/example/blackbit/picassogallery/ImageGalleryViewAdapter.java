package com.example.blackbit.picassogallery;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ImageGalleryViewAdapter extends BaseAdapter {

    private Activity _activity;
    private ArrayList<String> _filePaths = new ArrayList<String>();
    private int imageWidth;

    public ImageGalleryViewAdapter(Activity activity, ArrayList<String> filePaths,
                                   int imageWidth) {
        this._activity = activity;
        this._filePaths = filePaths;
        this.imageWidth = imageWidth;
    }

    @Override
    public int getCount() {
        return this._filePaths.size();
    }

    @Override
    public Object getItem(int position) {
        return this._filePaths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(_activity);
        } else {
            imageView = (ImageView) convertView;
        }

        // get screen dimensions
//        Bitmap image = decodeFile(_filePaths.get(position), imageWidth,
//                imageWidth);

        Picasso.with(_activity)
                .load(new File(_filePaths.get(position)))
                .placeholder(R.drawable.ic_place_holder)
                .resize(imageWidth, imageWidth)
                .centerCrop()
                .into(imageView);

//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setLayoutParams(new GridView.LayoutParams(imageWidth, imageWidth));
//        imageView.setImageBitmap(image);
//
//         image view click listener
//        imageView.setOnClickListener(new OnImageClickListener(position));

        return imageView;
    }

//    class OnImageClickListener implements OnClickListener {
//
//        int _postion;
//
//        // constructor
//        public OnImageClickListener(int position) {
//            this._postion = position;
//        }
//
//        @Override
//        public void onClick(View v) {
//            // on selecting grid view image
//            // launch full screen activity
//            Intent i = new Intent(_activity, FullScreenImageActivity.class);
//            i.putExtra("position", _postion);
//            //MyApplication.selectedImage = _filePaths.get(_postion).toString().substring(_filePaths.get(_postion).toString().lastIndexOf("/")+1);
//            _activity.startActivity(i);
//        }
//
//    }

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
            int scale = 30;
            while (o.outWidth / scale / 2 >= REQUIRED_WIDTH
                    && o.outHeight / scale / 2 >= REQUIRED_HIGHT)
                scale *= 2;

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;

            Log.i("SCALE>>>>", String.valueOf(scale));

            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}