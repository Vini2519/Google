package com.BmCollege.app.Syllabus;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.BmCollege.app.R;

/**
 * Created by Vineet Jain on 27-02-2017.
 */

public class SyllabusFirebaseViewHolder extends RecyclerView.ViewHolder {

    public TextView text,file_url;
    public ImageView image;

    public SyllabusFirebaseViewHolder(View itemView) {
        super(itemView);

        text=(TextView)itemView.findViewById(R.id.text);
        image=(ImageView)itemView.findViewById(R.id.image);
        file_url=(TextView)itemView.findViewById(R.id.file_url);

    }
}
