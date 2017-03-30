package com.BmCollege.app.Gallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.BmCollege.app.R;

public class Gallery_full_image extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_full_image);
        Intent i=getIntent();

        int position=i.getExtras().getInt("id");
        ImageAdapter adapter=new ImageAdapter(this);

        ImageView fullimage=(ImageView)findViewById(R.id.fullimage);
        fullimage.setImageResource(adapter.images[position]);


    }
}
