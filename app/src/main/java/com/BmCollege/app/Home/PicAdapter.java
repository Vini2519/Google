package com.BmCollege.app.Home;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.BmCollege.app.R;

/**
 * Created by hejunlin on 2016/8/25.
 */
public class PicAdapter extends PagerAdapter {

    private int mSize;
    private Fragment mActivity;
    private float mImageCorner = -1F;
    private int[] ResIds = new int[] {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
    };

    public PicAdapter(Home_Fragment activity) {
        mActivity = activity;
        mSize = 5;
    }

    public PicAdapter(int count) {
        mSize = count;
    }

    @Override
    public int getCount() {
        return mSize;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mActivity.getContext()).inflate(R.layout.recommend_page_item, container, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.image);
        imageView.setImageResource(ResIds[position]);
        Bitmap image = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        Bitmap newimage = getRoundCornerImage(image,50);
        ImageView imageView2 = new ImageView(view.getContext());
        imageView2.setImageBitmap(newimage);
        container.addView(view);
        return view;
    }


    public Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels) {
        Bitmap roundConcerImage = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(roundConcerImage);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, roundPixels, roundPixels, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, null, rect, paint);
        return roundConcerImage;
    }
    
}
