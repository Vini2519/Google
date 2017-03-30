package com.BmCollege.app.Gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.BmCollege.app.R;

/**
 * Created by Vineet Jain on 12/29/2016.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    public Integer[] images={
            R.drawable.gallery_one,
            R.drawable.gallery_two,
            R.drawable.gfh,
            R.drawable.gallery_four,
            R.drawable.gallery_five,
            R.drawable.gallery_six,
            R.drawable.gallery_seven,
            R.drawable.fests,
            R.drawable.myclass,
            R.drawable.secb,
    };

    public ImageAdapter(Context c){
        context=c;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new GridView.LayoutParams(240,240));
        return imageView;
    }
}
