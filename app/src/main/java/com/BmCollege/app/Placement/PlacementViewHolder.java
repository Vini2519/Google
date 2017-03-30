package com.BmCollege.app.Placement;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.BmCollege.app.R;

/**
 * Created by Vineet Jain on 21-02-2017.
 */

public class PlacementViewHolder extends RecyclerView.ViewHolder {

    public TextView title, place_link;
    public ImageView img;

    public PlacementViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.place_title);
        place_link = (TextView) itemView.findViewById(R.id.place_link);
        img = (ImageView) itemView.findViewById(R.id.place_img);
    }
}
