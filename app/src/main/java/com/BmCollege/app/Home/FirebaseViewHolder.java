package com.BmCollege.app.Home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.BmCollege.app.R;

/**
 * Created by Vineet Jain on 13-02-2017.
 */

public class FirebaseViewHolder extends RecyclerView.ViewHolder {

    public TextView title, file_url;
    public ImageView image;

    public FirebaseViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        file_url = (TextView) itemView.findViewById(R.id.file_url);
        image = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
